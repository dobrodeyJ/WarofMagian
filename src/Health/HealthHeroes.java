package Health;

import javax.swing.ImageIcon;

public class HealthHeroes extends Health {
	private final int POSX = 50;
    private final int POSY = 12;
	private int countDamege;
    
	public HealthHeroes(int health) {
		super(health,"resource//health//health");
		setPosition(POSX, POSY);
	}
	@Override
	protected void animate() {
		switch(countHealth) {
			case 20 : { image = new ImageIcon(nameImage + "_full.png").getImage();    break;}
			case 19 : { image = new ImageIcon(nameImage + "19.png").getImage(); 	  break;}
			case 18 : { image = new ImageIcon(nameImage + "18.png").getImage();       break;}
			case 17 : { image = new ImageIcon(nameImage + "17.png").getImage();       break;}
			case 16 : { image = new ImageIcon(nameImage + "16.png").getImage();       break;}
			case 15 : { image = new ImageIcon(nameImage + "15.png").getImage();       break;}
			case 14 : { image = new ImageIcon(nameImage + "14.png").getImage();       break;}
			case 13 : { image = new ImageIcon(nameImage + "13.png").getImage(); 	  break;}
			case 12 : { image = new ImageIcon(nameImage + "12.png").getImage();       break;}
			case 11 : { image = new ImageIcon(nameImage + "11.png").getImage();       break;}
			case 10 : { image = new ImageIcon(nameImage + "10.png").getImage();       break;}
			case 9 :  { image = new ImageIcon(nameImage +  "9.png").getImage();       break;}
			case 8 :  { image = new ImageIcon(nameImage +  "8.png").getImage();       break;}
			case 7 :  { image = new ImageIcon(nameImage +  "7.png").getImage(); 	  break;}
			case 6 :  { image = new ImageIcon(nameImage +  "6.png").getImage();       break;}
			case 5 :  { image = new ImageIcon(nameImage +  "5.png").getImage();       break;}
			case 4 :  { image = new ImageIcon(nameImage +  "4.png").getImage();       break;}
			case 3 :  { image = new ImageIcon(nameImage +  "3.png").getImage();       break;}
			case 2 :  { image = new ImageIcon(nameImage +  "2.png").getImage();       break;}
			case 1 :  { image = new ImageIcon(nameImage +  "1.png").getImage(); 	  break;}
			case 0 :  { image = new ImageIcon(nameImage +  "_null.png").getImage();   break;}
		}	
	}
	@Override
	public void minusHealth() {
		if(isLives()) {
			if(countDamege % 5 == 0) {
				if(countHealth == 1)
					lives = false;
				countHealth--;
			}
			countDamege++;
		}
			animate();
	}
}
