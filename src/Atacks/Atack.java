package Atacks;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Atack {
	private int positionX;
	private int positionY;
	private boolean atack;
	private Image img;
	private int step;
	private String nameImage;
	private int width, height;
	protected KeyPress direction = KeyPress.RIGHT;
	
	public Atack(String nameImage) {
		this.nameImage = nameImage;
		setAtack(false);
	}
	
	public void setPosition(int posX, int posY) {
		setPositionX(posX);
		setPositionY(posY);
	}
	
	public abstract void move();
	
	public abstract void initPosition(int posX, int posY, KeyPress direction);
	
	public void setStep(int step) {
		this.step = step;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public boolean isAtack() {
		return atack;
	}

	public void setAtack(boolean atack) {
		this.atack = atack;
	}
	
	public int getPositionY() {
		return positionY;
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public int getStep() {
		return step;
	}

	public KeyPress getDirection() {
		return direction;
	}

	public void setDirection(KeyPress direction) {
		this.direction = direction;
	}

	public Image getImg() {
		return img;
	}
	public void animate() {
		if(isAtack()) 
			img = new ImageIcon(nameImage).getImage();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
