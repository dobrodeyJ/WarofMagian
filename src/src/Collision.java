package src;

public class Collision {
	public boolean collision(MyRectangle object, MyRectangle block) {
		if(((object.getLeft() > block.getLeft() && object.getLeft() < block.getRight())&&(object.getTop() > block.getTop() &&object.getTop() < block.getBottom()))||
				   ((object.getLeft() > block.getLeft() && object.getLeft() < block.getRight())&&(object.getBottom() > block.getTop() &&object.getBottom() < block.getBottom()))||
				   ((object.getRight() > block.getLeft() && object.getRight() < block.getRight())&&(object.getTop() > block.getTop() &&object.getTop() < block.getBottom()))||
				   ((object.getRight() > block.getLeft() && object.getRight() < block.getRight())&&(object.getBottom() > block.getTop() &&object.getBottom() < block.getBottom())))
				return true;
		return false;
	}

}
