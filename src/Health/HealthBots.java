package Health;

import javax.swing.ImageIcon;

public class HealthBots extends Health {
	
	public HealthBots(int health) {
		super(health,"resource//healthBots//health");
	}
	@Override
	protected void animate() {
		switch(countHealth) {
			case 3: {image = new ImageIcon(nameImage + "_full.png").getImage();break;}
			case 2: {image = new ImageIcon(nameImage + "2.png").getImage();	   break;}
			case 1: {image = new ImageIcon(nameImage + "1.png").getImage();    break;}
			case 0: {image = new ImageIcon(nameImage + "_null.png").getImage();break;}
		}
	}
}
