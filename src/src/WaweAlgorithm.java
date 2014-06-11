package src;

import java.util.Random;

import objects.Bot;
import objects.Player;

public class WaweAlgorithm {
	private Player player;
	private Map map;
	private int iterator;
	private int maxIterator;
	private int[][]copy;
	
	public WaweAlgorithm(Player player, Map map) {
		this.player = player;
		this.map = map;
		maxIterator = (map.getWidth() * map.getHeight()) / 2;
	}
	
	private int[][] refreshMap() {
		int [][]copy = new int[map.getHeight()][map.getWidth()];
		for(int row = 0; row < map.getHeight(); row++)
			for(int col = 0; col < map.getWidth(); col++) {
				if(map.getValues(row, col) == 100 || 
				   map.getValues(row, col) == 700 || 
				   map.getValues(row, col) == 800)
					copy[row][col] = 0;
				else
					copy[row][col] = map.getValues(row, col);
			}
		return copy;
	}
	
	public void startWay() {
        iterator = 1;
        int posX = player.getPositionX() / map.getSize();
        int posY = player.getPositionY() / map.getSize();
        copy = refreshMap();
        copy[posY][posX] = iterator;
                while(iterator < maxIterator) {
                        for(int row = 0; row < map.getHeight(); row++)
                                for(int col = 0; col < map.getWidth(); col++) {
                                        if(copy[row][col] == iterator) {
                                        	if(row + 1 < this.map.getHeight())
                                        			if(copy[row + 1][col] == 0) 
                                        				copy[row + 1][col] = iterator + 1;
                                        	if(row - 1 > 0)
                                        			if(copy[row - 1][col] == 0) 
                                        				copy[row - 1][col] = iterator + 1;
                                        	if(col - 1 > 0)
                                        			if(copy[row][col - 1] == 0) 
                                        				copy[row][col - 1] = iterator + 1;
                                        	if(col + 1 < this.map.getWidth())
                                        			if(copy[row][col + 1] == 0) 
                                        				copy[row][col + 1] = iterator + 1;
                                        }
                                }
                                iterator++;
                }
	}
	
	public void next(Bot bot) {
	  int row = bot.getPositionX()  / map.getSize();
	  int col = bot.getPositionY() / map.getSize(); 
      if(col + 1 < map.getHeight()){
          if(copy[col + 1][row] < copy[col][row])
                  bot.toDown();
      }
      if(col - 1 > 0) {
          if(copy[col - 1][row] < copy[col][row])
                  bot.toUp();
      }
      if(row - 1 > 0) {
          if(copy[col][row - 1] < copy[col][row])
                  bot.toLeft();
      }
      if(row + 1 < map.getWidth()){
          if(copy[col][row + 1] < copy[col][row])
                  bot.toRight();
      }
	}
	public int getCopyValues(int row, int col) {
		return copy[row][col];
	}
}
