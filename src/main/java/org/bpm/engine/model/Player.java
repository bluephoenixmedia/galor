package org.bpm.engine.model;

import java.util.ArrayList;




public class Player extends Entity {
	
	public  ArrayList<Item> inventory;
	
	public int gridX;
	
	public int gridY;

	public void setGridY(int gridY) {
		this.gridY = gridY;
	}

	public Player(int x, int y, ArrayList<Item> inventory, boolean blockMovement) {
		super(x, y, false, Facing.DOWN);
		this.inventory = inventory;
		// TODO Auto-generated constructor stub
	}
	
	public void move() {
	//	position.setX(position.getX() + newX);
	//	position.setY(position.getY() + newY);
	}
	
	public Player() {
		//position.setX(x);
		//.setY(y);
	}
	
	@Override
	public void collidedWith(Entity other) {
		// TODO Auto-generated method stub

	}

	public int getGridX() {
		return gridX;
	}

	public void setGridX(int gridX) {
		this.gridX = gridX;
	}

	public int getGridY() {
		return gridY;
	}

}
