package src;

import objects.Player;
import objects.Teleports;

public class Teleport {
	private int indexX;
	private int indexY;
	private Map map;
	private Teleports teleport;
	private Player player;
	
	public Teleport(Map map, Player player) {
		this.map = map;
		this.player = player;
	}
	
	private void searchPortal() {
		for(int row = 0; row < map.getHeight(); row++)
			for(int col = 0; col < map.getWidth(); col++){
				if(map.getValues(row, col) == teleport.getId()) { 
					indexX = row; 
					indexY = col;
				}
			}
	}
	
	private void searchEmpty() {
		if(map.getValues(indexX - 1, indexY) == 0)
			changePositionPlayer(indexX - 1, indexY);
		else if(map.getValues(indexX + 1, indexY) == 0)
			changePositionPlayer(indexX + 1, indexY);
		else if(map.getValues(indexX, indexY - 1) == 0)
			changePositionPlayer(indexX, indexY - 1);
		else if(map.getValues(indexX, indexY + 1) == 0)
			changePositionPlayer(indexX, indexY + 1);
	}	
	private void  changePositionPlayer(int row, int col) {
		int size = map.getSize();
		player.setPosition(size * col + 12,size * row + 5);
	}
	
	public void teleportation(Teleports portal) {
		this.teleport = portal;
		searchPortal();
		searchEmpty();
		
	}
}
