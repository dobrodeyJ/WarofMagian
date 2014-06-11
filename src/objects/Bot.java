package objects;


public class Bot extends WorldObjects{
	private int countMove;
	public Bot(int posX, int posY, String nameImage) {
		super(posX, posY, nameImage);
		countMove = 0;
	}
	public int  getCountMove() {
		return countMove;
	}
	
	@Override
	public void move() {
		super.move();
		health.setPosition(getPositionX() - 5, getPositionY() - 4);
		if(countMove == 24)
			countMove = 0;
		else
			countMove++;
	}
}
