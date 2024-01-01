package org.bpm.engine.model;

import java.awt.*;
import java.io.Serializable;

public class Tile extends Entity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2689631816635059642L;
	
	
	public int tileId;
	public String type;
	public double noiseValue;
	public Color noiseColor;
	public boolean startingTile;
	
	
	
	public boolean isStartingTile() {
		return startingTile;
	}


	public void setStartingTile(boolean startingTile) {
		this.startingTile = startingTile;
	}


	public int getTileId() {
		return tileId;
	}


	public void setTileId(int tileId) {
		this.tileId = tileId;
	}

	
	public Color getNoiseColor() {
		return noiseColor;
	}


	public void setNoiseColor(Color noiseColor) {
		this.noiseColor = noiseColor;
	}


	public double getNoiseValue() {
		return noiseValue;
	}


	public void setNoiseValue(double noiseValue) {
		this.noiseValue = noiseValue;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public void collidedWith(Entity other) {
		// TODO Auto-generated method stub

	}
	
	
	public Tile(int x, int y, boolean blockMovement) {
		super(x, y, blockMovement, null);
		// TODO Auto-generated constructor stub
	}
	
	
}
