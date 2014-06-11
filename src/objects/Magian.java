package objects;

import java.awt.Point;

import Atacks.FireBall;

public class Magian extends Player { 
	public Magian(int posX, int posY) {
		super(posX, posY, "resource//Players//heroes1//hero");
		int step = 5;
		setStep(step);
		this.atack = new FireBall(); 
	}
	
	public Magian(Point p) {
		super(p, "resource//Players//heroes1//hero");
		int step = 5;
		setStep(step);
	}
}
