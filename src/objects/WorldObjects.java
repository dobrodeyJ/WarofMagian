package objects;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import Atacks.KeyPress;
import Health.Health;

import src.MyRectangle;

public class WorldObjects  {
	protected MyRectangle objectRect;
	protected Point position;
	protected Dimension size;
	protected int step;
	protected Image img;
	protected int width, height;
	protected int changeImage = 1;
	protected String nameImage;
	protected boolean left, right,up,down;
	protected KeyPress keyPress;
	protected Health health;
	protected boolean lives;
	
	public WorldObjects(int posX, int posY, String nameImage) {
		this.position = new Point(posX,posY);
		this.nameImage = nameImage;
		lives = true;
		toStand();
		animate();
	}
	public WorldObjects(Point p, String nameImage) {
		this.position = p;
		this.nameImage = nameImage;
		lives = true;
		toStand();
		animate();
	}
	public void setSize(Dimension size) {
		this.size = size;
		this.width =  (int)size.getWidth(); 
		this.height = (int)size.getHeight();
	}
	private void toStand() {
		left = right = up = down = false;
	}
	
	public void setPosition(double posX, double posY) {
		position.setLocation(posX, posY);
	}
	
	public void setPosition(Point point) {
		position.setLocation(point);
	}
	
	public void setStep(int step) {
		this.step = step;
	}
	public int getPositionX() {
		return (int)this.position.getX();
	}
	public int getPositionY() {
		return (int)this.position.getY();
	}
	public Point getPosition() {
		return position;
	}
	public int getStep() {
		return this.step;
	}
	public Image getImage() {
		return img;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}

	public boolean isRight() {
		return right;
	}
	public boolean isLeft() {
		return left;
	}
	public boolean isUp() {
		return up;
	}
	public boolean isDown() {
		return down;
	}
	
	
	public void toRight() {
		right = true;
		left = up = down = false;
		keyPress = KeyPress.RIGHT;
	}
	
	public void toLeft() {
		left = true;
		right = up = down = false;
		keyPress = KeyPress.LEFT;
	}
	
	public void toUp() {
		up = true;
		left = right = down = false;
		keyPress = KeyPress.UP;
	}
	
	public void toDown() {
		down = true;
		left = right = up = false;
		keyPress = KeyPress.DOWN;
	}
	public  boolean isLive() {
		return lives;
	}
	
	protected void dead() {
		lives = false;
	}
	
	public void  damage() {
		health.minusHealth();
		if(!health.isLives())
			lives = false;
	}
	
	public Health getHealth() {
		return this.health;
	}
	
	
	public void move() {
		if(isRight()) 
			setPosition(position.getX() + step, position.getY());
		else if(isLeft()) 
			setPosition(position.getX() - step, position.getY());
		else if(isUp()) 
			setPosition(position.getX(), position.getY() - step);
		else if(isDown()) 
			setPosition(position.getX(), position.getY() + step);
		animate();
	}
	
	public  void animate() {
		if(isRight()) 
			loadImage("_right");
		else if(isLeft()) 
			loadImage("_left");
		else if(isUp()) 
			loadImage("_up");
		else if(isDown()) 
			loadImage("_down");
		else
			img = new ImageIcon(nameImage + "_down2.png").getImage();
	}
	
	private void  loadImage(String s) {
		if(changeImage == 12)
			changeImage = 1;
		switch(changeImage) {
			case 1 : {img = new ImageIcon(nameImage + s + "1.png").getImage(); break;}
			case 4 : {img = new ImageIcon(nameImage + s + "2.png").getImage(); break;}
			case 7 : {img = new ImageIcon(nameImage + s + "3.png").getImage(); break;}
			case 11 : {img = new ImageIcon(nameImage + s + "2.png").getImage(); break;}
		}
		changeImage++;
	}
	protected KeyPress getKeyPress() {
		return keyPress;
	}
	
}
