package Health;

import java.awt.Image;

public abstract class Health {
	protected int countHealth;
	protected Image image;
	private int positionX,positionY;
	protected String nameImage;
	protected boolean lives;
	
	public Health(int countHealth, String nameImage) {
		this.countHealth = countHealth;
		this.nameImage = nameImage;
		lives = true;
		animate();
	}
	
	public void setHealth(int countHealth) {
		this.countHealth = countHealth;
	}
	
	public int getHealth() {
		return countHealth;
	}
	
	public Image getImage() {
		return image;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public void  setPosition(int posX, int posY) {
		setPositionX(posX);
		setPositionY(posY);
	}
	
	public boolean isLives() {
		return lives;
	}
	
	public  void minusHealth() {
		if(isLives()) {
			if(countHealth == 1)
				lives = false;
			countHealth--;
		}
			animate();
	}

	
	public void plusHealth() {
		countHealth++;
		animate();
	}
	
	protected abstract void animate();
}
