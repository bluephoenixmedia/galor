package org.bpm.regions;

import org.bpm.engine.core.GameEngine2;
import org.bpm.engine.model.GameConstants;
import org.bpm.engine.model.Tile;
import org.bpm.engine.util.OpenSimplexNoise;
import org.apache.commons.math3.util.Precision;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BaseGrassRegion extends Region {
	


	public static ArrayList<Tile> generate(int size, int tileWidth, int tileHeight, int playerStartX, int playerStartY, String regionType) {
		
		double FEATURE_SIZE = 5;
		
		int tilex = 0;
		int tiley = 0;
		int tileCount = 0;

		ArrayList<Tile> tiles = new ArrayList<Tile>();	
		
		long generatedLong = new Random().nextLong();

		OpenSimplexNoise noise = new OpenSimplexNoise(generatedLong);
		
		for (int col= 0; col < size; col++) {
			
			tilex = 0;
			tileCount++;
			
			for (int row = 0; row < size; row++) {
				
				tileCount++;

				double value = noise.eval(col / FEATURE_SIZE, row / FEATURE_SIZE, 1.0);
				

				double test = Precision.round((value + 1), 2);

				if (test <= .1) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("WATER");
					tile.setCurrentImage(GameEngine2.water);
					tile.setNoiseValue(test);
					tile.setNoiseColor(GameConstants.blue1);
					tile.setTileId(tileCount);
					tiles.add(tile);
				} else if ((test > .1 && test <= .2)) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("WATER");
					tile.setCurrentImage(GameEngine2.water);
					tile.setNoiseValue(test);
					tile.setNoiseColor(GameConstants.blue2);
					tile.setTileId(tileCount);
					tiles.add(tile);
					
				} else if ((test > .2 && test <= .3)) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("WATER");
					tile.setCurrentImage(GameEngine2.water);
					tile.setNoiseValue(test);
					tile.setNoiseColor(GameConstants.blue3);
					tile.setTileId(tileCount);
					tiles.add(tile);
				} else if ((test > .3 && test <= .4)) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("WATER");
					tile.setCurrentImage(GameEngine2.grass);
					tile.setNoiseValue(test);
					tile.setNoiseColor(GameConstants.blue4);
					tile.setTileId(tileCount);
					tiles.add(tile);
				} else if ((test > .4 && test <= .5)) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("grass");
					tile.setCurrentImage(GameEngine2.grass2);
					tile.setNoiseValue(test);
					tile.setNoiseColor(GameConstants.green1);
					tile.setTileId(tileCount);
					if (!playerInitSet && (tilex >= GameConstants.WORLD_START_REGION && (tilex <= GameConstants.WORLD_START_REGION + (GameConstants.WORLD_SIZE * 5))) && (tiley >= GameConstants.WORLD_START_REGION && (tiley <= GameConstants.WORLD_START_REGION + (GameConstants.WORLD_SIZE * 5)))) {
						tile.setStartingTile(true);
						System.out.println("FOUND A START!");
						setRegionStartX(tilex);
						setRegionStartY(tiley);
						playerInitSet = true;
					}
					tiles.add(tile);
				} else if ((test > .5 && test <= .6)) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("grass");
					tile.setCurrentImage(GameEngine2.grass3);
					tile.setNoiseValue(test);
					tile.setNoiseColor(GameConstants.green2);
					tile.setTileId(tileCount);
					tiles.add(tile);
				} else if ((test > .6 && test <= .7)) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("CAMP");
					tile.setCurrentImage(GameEngine2.grass4);
					tile.setNoiseValue(test);
					tile.setNoiseColor(GameConstants.green3);
					tile.setTileId(tileCount);
					tiles.add(tile);
					
				} else if ((test > .7 && test <= .8)) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("GRASS");
				    tile.setCurrentImage(GameEngine2.grass2);
					tile.setNoiseValue(test);
					tile.setNoiseColor(GameConstants.green4);
					tile.setTileId(tileCount);
					tiles.add(tile);
				} else if ((test > .8 && test <= .9)) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("GRASS");
					tile.setCurrentImage(GameEngine2.grass4);
					tile.setNoiseValue(test);
					tile.setNoiseColor(GameConstants.green5);
					tile.setTileId(tileCount);
					tiles.add(tile);
				} else if ((test > .9 && test <= 1)) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("test");
					tile.setCurrentImage(GameEngine2.grass);
					tile.setNoiseValue(test);
					tile.setNoiseColor(GameConstants.gray1);
					tile.setTileId(tileCount);
					tiles.add(tile);
				} else if ((test > 1 && test <= 1.2)) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("TREE");
					tile.setCurrentImage(GameEngine2.grass);
					tile.setNoiseValue(test);
					tile.setNoiseColor(Color.YELLOW);
					tile.setTileId(tileCount);
					tiles.add(tile);
				}else if ((test > 1.2 && test <= 1.3)) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("TREE");
					tile.setCurrentImage(GameEngine2.grass3);
					tile.setNoiseValue(test);
					tile.setNoiseColor(GameConstants.gray3);
					tile.setTileId(tileCount);
					tiles.add(tile);
				} else if ((test > 1.3 && test <= 1.4)) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("TREE");
					tile.setCurrentImage(GameEngine2.tree2);
					tile.setNoiseValue(test);
					tile.setNoiseColor(Color.red);
					tile.setTileId(tileCount);
					tiles.add(tile);
				} else if ((test > 1.4 && test <= 1.5)) {
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("TREE");
					tile.setCurrentImage(GameEngine2.grass2);
					tile.setNoiseValue(test);
					tile.setNoiseColor(GameConstants.gray5);
					tile.setTileId(tileCount);
					tiles.add(tile);
				} else if (test > 1.5) {
					
					Tile tile = new Tile(tilex, -tiley, false);
					tile.setType("GRASS");
					tile.setCurrentImage(GameEngine2.grass);
					tile.setNoiseValue(test);
					tile.setNoiseColor(GameConstants.gray5);
					tile.setTileId(tileCount);
					tiles.add(tile);
				}

				tilex +=tileWidth;
			}

			tiley +=tileHeight;
		}

		return tiles;
		
	}
	
	
}
