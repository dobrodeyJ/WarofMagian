package Portals;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Health.Health;
import Health.HealthPortal;

import objects.Bot;


public abstract class Portal {
	private int  positionX, positionY;
	private Image img;
	private String nameImage;
	protected ArrayList<Bot> bots;
	protected Health health;
	
	public Portal() {
		health = new HealthPortal();
	}
	
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public void setPosition(int posX, int posY) {
		setPositionX(posX);
		setPositionY(posY);
	}
	public Health getHealth() {
		return health;
	}


	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public void setNameImage(String nameImage) {
		this.nameImage = nameImage;
	}
	
	protected void anymate() {
		img = new ImageIcon(nameImage).getImage();
	}
	public ArrayList<Bot> getBots() {
		return bots;
	}
	public boolean isLives() {
		return health.isLives();
	}
	public abstract void start();

}
