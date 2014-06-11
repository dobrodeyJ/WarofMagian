package objects;

import java.awt.Dimension;
import java.awt.Point;

import Atacks.Atack;
import Health.HealthHeroes;

import src.MyRectangle;

public class Player extends WorldObjects  {
	protected Atack atack;
	private int hp = 20;
	
	public Player(Point p, String nameImage) {
		super(p,nameImage);
		super.setSize(new Dimension(25, 40));
		objectRect = new MyRectangle(size);
		this.health = new HealthHeroes(hp);
	}

	public Player(int posX, int posY, String nameImage) {
		super(posX, posY, nameImage);
		super.setSize(new Dimension(25, 40));
		objectRect = new MyRectangle(size);
		this.health = new HealthHeroes(hp);
	}

	public void isAtack() {
		atack.setAtack(true);
		atack.initPosition(this.getPositionX(), this.getPositionY(), getKeyPress());
	}
	
	public Atack getAtack() {
		return atack;
	}
	
	@Override
	public void toRight() {
		super.toRight();
	}
	@Override
	public void toLeft() {
		super.toLeft();
	}
	@Override
	public void toDown() {
		super.toDown();
	}
	@Override
	public void toUp() {
		super.toUp();
	}
	
	public void setLeft(boolean left) {
		this.left = left;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public void setDown(boolean down) {
		this.down = down;
	}

}
