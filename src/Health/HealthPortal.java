package Health;

import javax.swing.ImageIcon;

public class HealthPortal extends Health {
	private final int POSX = 550;
	private final int POSY = 12;
	public HealthPortal() {
		super(12,"resource//health//health");
		setPosition(POSX, POSY);
	}

	@Override
	protected void animate() {
		switch(countHealth) {
		case 12 : { image = new ImageIcon(nameImage + "_full.png").getImage();   break;}
		case 11 : { image = new ImageIcon(nameImage + "19.png").getImage(); 	 break;}
		case 10 : { image = new ImageIcon(nameImage + "17.png").getImage();      break;}
		case 9  : { image = new ImageIcon(nameImage + "15.png").getImage();      break;}
		case 8  : { image = new ImageIcon(nameImage + "14.png").getImage();      break;}
		case 7  : { image = new ImageIcon(nameImage + "13.png").getImage();      break;}
		case 6  : { image = new ImageIcon(nameImage + "11.png").getImage();      break;}
		case 5  : { image = new ImageIcon(nameImage + "9.png").getImage(); 	     break;}
		case 4  : { image = new ImageIcon(nameImage + "7.png").getImage();       break;}
		case 3  : { image = new ImageIcon(nameImage + "5.png").getImage();       break;}
		case 2  : { image = new ImageIcon(nameImage + "3.png").getImage();       break;}
		case 1  : { image = new ImageIcon(nameImage + "1.png").getImage();       break;}
		case 0  : { image = new ImageIcon(nameImage + "_null").getImage();       break;}}	
	}
}
