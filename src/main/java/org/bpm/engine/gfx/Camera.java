package org.bpm.engine.gfx;

public class Camera {
	private int x, y;
	private int xb, yb;
	

	public Camera(int x, int y, int xb, int yb) {
		super();
		this.x = x;
		this.y = y;
		this.xb = xb;
		this.yb = yb;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getXb() {
		return xb;
	}

	public void setXb(int xb) {
		this.xb = xb;
	}

	public int getYb() {
		return yb;
	}

	public void setYb(int yb) {
		this.yb = yb;
	}
	
	
}
