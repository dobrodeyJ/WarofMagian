package objects;

import java.awt.Point;

public class Archer extends Player {
	
	public Archer(int posX, int posY) {
		super(posX, posY, "");
		int step = 5;
		setStep(step);
	}
	public Archer(Point p) {
		super(p, "");
		int step = 5;
		setStep(step);
	}
}
