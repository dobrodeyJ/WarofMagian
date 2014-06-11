package Atacks;


public class Air extends Atack {
	public Air(String nameImage) {
		super(nameImage);
	}

	@Override
	public void initPosition(int posX, int posY, KeyPress direction) {
		setDirection(direction);
		switch(direction) {
			case LEFT : {setPosition(posX - 20, posY + 10);	break;}
			case RIGHT: {setPosition(posX + 25, posY + 10);	break;}
			case UP   : {setPosition(posX + 2,  posY - 25);	break;}
			case DOWN : {setPosition(posX + 2,  posY + 40);	break;}
		}
		animate();
	}
	
	@Override
	public void move() {
		switch(direction) {
			case LEFT:  {setPositionX(getPositionX() - getStep());	break;}
			case RIGHT: {setPositionX(getPositionX() + getStep());	break;}
			case DOWN:  {setPositionY(getPositionY() + getStep());	break;}
			case UP:    {setPositionY(getPositionY() - getStep());	break;}
		}
	}
}
