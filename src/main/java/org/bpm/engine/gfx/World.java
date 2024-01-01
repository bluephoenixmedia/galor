package org.bpm.engine.gfx;

import org.bpm.engine.core.GameEngine2;
import org.bpm.engine.model.GameConstants;
import org.bpm.engine.model.Player;
import org.bpm.engine.model.Tile;
import org.apache.commons.math3.util.Precision;
import org.bpm.regions.Region;
import org.spongepowered.noise.module.source.Voronoi;

import java.awt.Color;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;


public class World implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7802073328255443042L;

	//public enum TimeOfDay {MORNING, NOON, EVENING, NIGHT};
	
	public enum WorldType {OVERWORLD, BASEREGION, REGIONDETAIL};
	
	public static ArrayList<Region> regions = new ArrayList<Region>();

	public static boolean treesExist = false;

	public WorldType worldType = null;
	
	public boolean playerInitSet = false;
	
	public static boolean overWorldActive = true;
	
	
	public int worldStartX = 0;
	public int worldStartY = 0;
		
	public int currentPlayerX = 0;
	public int currentPlayerY = 0;

	public int getWorldStartX() {
		return worldStartX;
	}



	public void setWorldStartX(int worldStartX) {
		this.worldStartX = worldStartX;
	}



	public int getWorldStartY() {
		return worldStartY;
	}



	public void setWorldStartY(int worldStartY) {
		this.worldStartY = worldStartY;
	}

//	public static int map[][]= {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},	
//			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

//	private Random ran = new Random();

	//public World(TimeOfDay tod) {
	//	this.tod = tod;
	//}
	
	public void addRegion(Region region) {
		regions.add(region);
	}
	
	
	//public 
	
	
	public boolean isOverWorldActive() {
		return overWorldActive;
	}



	public void setOverWorldActive(boolean overWorldActive) {
		this.overWorldActive = overWorldActive;
	}

	
	public ArrayList<Tile> buildOverWorld(int size, int tileWidth, int tileheight, int playerStartX, int playerStartY) {

		double xPeriod =10, yPeriod = 10;

		int tilex = 0;
		int tiley = 0;
		int tileCount = 0;
		//boolean startSet = false;
		
		ArrayList<Tile> tiles = new ArrayList<Tile>();

		double rand = Math.random();
		
		int seed = (int) (rand * 1000);
		
		for (int col= 0; col < size; col++) {	

			tilex = 0;
			tileCount++;

			for (int row = 0; row < size; row++) {
				Voronoi module = new Voronoi();

				{

					module.setEnableDistance(true);
					module.setDisplacement(2);
					module.setFrequency(1);
					module.setSeed(seed);
					
					final double noise = module.get(row / xPeriod, col / yPeriod, 0) / 2;

					double test = Precision.round(noise, 2);
					tileCount++;

					//System.out.println("test = " + (test));
					
					if (test <= .1 ) {

						Tile tile = new Tile(tilex, tiley, true);
						tile.setType("WATER1");
						tile.setCurrentImage(GameEngine2.water);
						tile.setNoiseValue(test);
						tile.setNoiseColor(GameConstants.blue1);
						tile.setTileId(tileCount);

						tiles.add(tile);	

					} else if ((test > .1 && test <= .6)) {
						Tile tile = new Tile(tilex, tiley, true);
						tile.setType("WATER2");
						tile.setCurrentImage(GameEngine2.water);
						tile.setNoiseValue(test);
						tile.setNoiseColor(GameConstants.blue2);
						tile.setTileId(tileCount);

						tiles.add(tile);

					} else if ((test > .6 && test <= .62)) {
						Tile tile = new Tile(tilex, tiley, false);
						tile.setType("GRASS1");
						tile.setCurrentImage(GameEngine2.grass);
						tile.setNoiseValue(test);
						tile.setNoiseColor(GameConstants.green1);
						tile.setTileId(tileCount);
						tiles.add(tile);
						
						
					} else if ((test > .62 && test <= .65)) {
						Tile tile = new Tile(tilex, tiley, false);
						tile.setType("GRASS2");
						tile.setCurrentImage(GameEngine2.grass2);
						tile.setNoiseValue(test);
						tile.setNoiseColor(GameConstants.green2);
						tile.setTileId(tileCount);

						tiles.add(tile);
					} else if ((test > .65 && test <= .67)) {
						Tile tile = new Tile(tilex, tiley, false);
						tile.setType("GRASS3");
						tile.setCurrentImage(GameEngine2.grass3);
						tile.setNoiseValue(test);
						tile.setNoiseColor(GameConstants.green2);
						tile.setTileId(tileCount);

						tiles.add(tile);
					} else if ((test > .67 && test <= .7)) {
						Tile tile = new Tile(tilex, tiley, false);
						tile.setType("GRASS4");
						tile.setCurrentImage(GameEngine2.grass4);
						tile.setNoiseValue(test);
						tile.setNoiseColor(GameConstants.green2);
						tile.setTileId(tileCount);
						if (!playerInitSet && (tilex >= GameConstants.WORLD_START_REGION && (tilex <= GameConstants.WORLD_START_REGION + (GameConstants.WORLD_SIZE * 5))) && (tiley >= GameConstants.WORLD_START_REGION && (tiley <= GameConstants.WORLD_START_REGION + (GameConstants.WORLD_SIZE * 5)))) {
							tile.setStartingTile(true);
							System.out.println("FOUND A START!");
							setWorldStartX(tilex);
							setWorldStartY(tiley);
							playerInitSet = true;
							
							
						}
						tiles.add(tile);
						
						
					} else if ((test > .7 && test <= .8)) {
						Tile tile = new Tile(tilex, tiley, false);
						tile.setType("TREE");
						tile.setCurrentImage(GameEngine2.tree);
						tile.setNoiseValue(test);
						tile.setNoiseColor(GameConstants.green3);
						tile.setTileId(tileCount);
						
						

						tiles.add(tile);
					} else if ((test > .8 && test <= .9)) {
						Tile tile = new Tile(tilex, tiley, false);
						tile.setType("TREE2");
						tile.setCurrentImage(GameEngine2.tree3);
						tile.setNoiseValue(test);
						tile.setNoiseColor(GameConstants.green3);
						tile.setTileId(tileCount);

						tiles.add(tile);
					} else if ((test > .9 && test <= 1)) {
						Tile tile = new Tile(tilex, tiley, false);
						tile.setType("TREE");
						tile.setCurrentImage(GameEngine2.mountain2);
						tile.setNoiseValue(test);
						tile.setNoiseColor(GameConstants.green3);
						tile.setTileId(tileCount);

						tiles.add(tile);
					} else if ((test > 1 && test <= 1.2)) {
						Tile tile = new Tile(tilex, tiley, false);
						tile.setType("MOUNTAIN");
						tile.setCurrentImage(GameEngine2.hills);
						tile.setNoiseValue(test);
						tile.setNoiseColor(GameConstants.blue4);
						tile.setTileId(tileCount);

						tiles.add(tile);
					}else if (test > 1.2) {
						Tile tile = new Tile(tilex, tiley, false);
						tile.setType("MOUNTAIN");
						tile.setCurrentImage(GameEngine2.tree2);
						tile.setNoiseValue(test);
						tile.setNoiseColor(Color.MAGENTA);
						tile.setTileId(tileCount);

						tiles.add(tile);
					} else {
						Tile tile = new Tile(tilex, tiley, false);
						tile.setType("ELSE");
						tile.setCurrentImage(GameEngine2.water);
						tile.setNoiseValue(test);
						tile.setNoiseColor(Color.MAGENTA);
						tile.setTileId(tileCount);

						tiles.add(tile);

						
					}
				}

				tilex +=tileWidth;
			}
			tiley +=tileheight;
		}

		return tiles;
	}




	

	public WorldType getWorldType() {
		return worldType;
	}

	public void setWorldType(WorldType worldType) {
		this.worldType = worldType;
	}
	
	public int getCurrentTileId(int pXC, int pYC, ArrayList<Tile> world) {
		
		int currentTile = 0;
		
		for (int tNum = 0; tNum < world.size(); tNum++) {
		
			if (pXC == world.get(tNum).getX() && pYC == world.get(tNum).getY()) {
				currentTile = tNum;
				break;
			}
			
		}
		
		return currentTile;
		
	}
	
	public static ArrayList<Tile> getRegionByCoordinates(int x, int y, World world) {
		
		ArrayList<Tile> activeRegion = new ArrayList<Tile>();
		
		for(Region region : World.regions) {
			
			if(region.getRegionX() == x && region.getRegionY() == y) {
				
				activeRegion =  region.getRegion();
			}
			
		}
		
		return activeRegion;
		
		
	}

	public static void render(Graphics2D g, Camera camera, Player player, int pXC, int pYC, World screen, 
			ArrayList<Tile> world, int xx, int yy, int xscroll, int yscroll, 
			int cammX, int cammY, int cammXW, int cammYH) {
		
		player.me.setBounds(pXC, pYC, GameConstants.playerWidth, GameConstants.playerHeight);
		
		ArrayList<Tile> activeWorld = null;
		
		if (overWorldActive) {
			
			activeWorld = world;
		
		} else {
			
			activeWorld = getRegionByCoordinates(pXC, pYC, screen);
			
		}
//	   
		for (int col= 0; col < activeWorld.size();col++) {

			pXC = player.getX();
			
			pYC = player.getY();
	
			
			
			xx = activeWorld.get(col).getX() + xscroll;
			yy = activeWorld.get(col).getY() + yscroll;
			
			
			activeWorld.get(col).me.setBounds(xx, yy, GameConstants.tileWidth, GameConstants.tileHeight);
			cammX = camera.getX() - xscroll;
			cammY = camera.getY() - yscroll;
			cammXW = camera.getXb() - xscroll;
			cammYH = camera.getYb() - yscroll;


			if (activeWorld.get(col).getX() >= (cammX - 60) && activeWorld.get(col).getX() <= cammXW && activeWorld.get(col).getY()
					>= (cammY - 60) && activeWorld.get(col).getY() <= cammYH) {
				g.drawImage(activeWorld.get(col).getCurrentImage(),xx, yy, GameConstants.tileWidth, GameConstants.tileHeight, null);
	
			}
	
	
//				if (GameEngine2.DEBUG_ENABLED) {
//					DebugUtil.debugBlockers(g, world, col, xx, yy, pXC, pYC);
//				}		
			}
			
		


		g.drawImage(player.getCurrentImage(), pXC, pYC, GameConstants.playerWidth,GameConstants.playerHeight, null);


	}

}