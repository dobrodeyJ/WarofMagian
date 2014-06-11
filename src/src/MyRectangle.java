package src;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class MyRectangle extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyRectangle(MyRectangle rect) {
		super(rect);
	}
	
	public MyRectangle(Point p) {
		super(p);
	}
	
	public MyRectangle(Dimension d) {
		super(d);
	}
	
	public MyRectangle(Point p,Dimension d) {
		super(p, d);
	}
	
	public MyRectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	public MyRectangle(int width, int height) {
		super(width, height);
	}
	
	public double getTop() {
		return this.getY();
	}
	public double getLeft() {
		return this.getX();
	}
	public double getBottom() {
		return this.getY() + this.getHeight();
	}
	public double getRight() {
		return this.getX() + this.getWidth();
	}
	
}
