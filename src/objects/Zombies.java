package objects;

import java.awt.Dimension;
import Health.HealthBots;

public class Zombies extends Bot {
	private int hp = 3;
	public Zombies(int posX, int posY) {
		super(posX, posY, "resource//Bots//Zombies//zombie");
		setStep(2);
		setSize(new Dimension(25,32));
		health = new HealthBots(hp);
	}
}
