package src;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Map {
	private int [][]map;
	private final int WIDTH = 21;
	private final int HEIGHT = 12;
	private final int SIZE = 50;
	private Scanner scn;
	
	public Map() {
		map = new int[HEIGHT][WIDTH];
		loadMap();
		readMap();
	}

	private void loadMap() {
		try{
			int randomMap = new Random().nextInt(6) + 1;	
		    scn = new Scanner(new File("files//"+ randomMap +".txt"));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ошибка открития файла");
		}
	}
	private void readMap() {
		try {
		for(int i = 0; i < HEIGHT; i++)
			for(int j = 0; j < WIDTH; j++)
				map[i][j] = scn.nextInt();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "При считании даних возникла ошибка","Виход за розмер карти",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	public int[][] getMap() {
		return this.map;
	}
	
	public int getValues(int row, int col) {
		return this.map[row][col];
	}
	public void setValues(int row, int col, int values) {
		map[row][col] = values;
	}

	public int getSize() {
		return SIZE;
	}
}
