package objects;

import java.awt.Point;

public class Warrior extends Player {
	
	public Warrior(int posX, int posY) {
		super(posX, posY, "");
		int step = 5;
		setStep(step);
	}
	
	public Warrior(Point p) {
		super(p, "");
		int step = 5;
		setStep(step);
	}
}
