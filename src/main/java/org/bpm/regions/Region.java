package org.bpm.regions;

import org.bpm.engine.model.Tile;

import java.util.ArrayList;

public class Region {
	
	public int regionX = 0, regionY = 0;

	public static boolean playerInitSet = false;
	
	public static int regionStartX = 0;
	
	public static int regionStartY = 0;

	public String type = "";
	
	public int regionID = 0;
	
	public ArrayList<Tile> region = new ArrayList<Tile>();
	
	public static ArrayList<Tile> generate(int size, int tileWidth, int tileHeight, int playerStartX, int playerStartY, String regionType) {
		ArrayList<Tile> region = new ArrayList<Tile>();
		return region;
	}
	
	
	public int getRegionStartX() {
		return regionStartX;
	}


	public static void setRegionStartX(int x) {
		regionStartX = x;
	}


	public int getRegionStartY() {
		return regionStartY;
	}


	public static void setRegionStartY(int y) {
		regionStartY = y;
	}


	public boolean isPlayerInitSet() {
		return playerInitSet;
	}

	public void setPlayerInitSet(boolean playerInitSet) {
		this.playerInitSet = playerInitSet;
	}
	
	public int getRegionX() {
		return regionX;
	}

	public void setRegionX(int regionX) {
		this.regionX = regionX;
	}

	public int getRegionY() {
		return regionY;
	}

	public void setRegionY(int regionY) {
		this.regionY = regionY;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRegionID() {
		return regionID;
	}

	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}

	public ArrayList<Tile> getRegion() {
		return region;
	}

	public void setRegion(ArrayList<Tile> region) {
		this.region = region;
	}
}
