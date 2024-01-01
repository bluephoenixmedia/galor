package org.bpm.engine.util;

import org.bpm.engine.gfx.Camera;
import org.bpm.engine.gfx.World;
import org.bpm.engine.model.GameConstants;
import org.bpm.engine.model.Player;
import org.bpm.engine.model.Tile;

import java.awt.*;
import java.util.ArrayList;

public class DebugUtil {
	
	
	
	public static int debugX = 1525, debugY = 0;
	
	public static <E> void drawDebugStatement(Graphics2D g, String message, Color color, int x, int y) {
		g.setColor(color);
		g.drawString(message, x, y);
	}
	
	public static void debugBlockers(Graphics2D g, ArrayList<Tile> world, int col, int xx, int yy, int pXc, int pYC) {
		if (world.get(col).isBlockMovement()) {
			g.setColor(Color.red);
			g.drawRect(xx, yy, GameConstants.tileWidth, GameConstants.tileHeight);
		} 
		//left
		g.setColor(Color.YELLOW);
		g.drawRect(pXc - GameConstants.COLLISION_BUFFER, pYC, GameConstants.playerWidth, GameConstants.playerHeight);
		//right
		g.setColor(Color.YELLOW);
		g.drawRect(pXc  + GameConstants.COLLISION_BUFFER, pYC, GameConstants.playerWidth, GameConstants.playerHeight);
		//up
		g.setColor(Color.YELLOW);
		g.drawRect(pXc, pYC - GameConstants.COLLISION_BUFFER, GameConstants.playerWidth, GameConstants.playerHeight);
		//down
		g.setColor(Color.YELLOW);
		g.drawRect(pXc, pYC + GameConstants.COLLISION_BUFFER, GameConstants.playerWidth, GameConstants.playerHeight);
		
	}
	
	
	

	
	public static void debugRender(Graphics2D g, int xx, int yy,  int pXC, int pYC, 
				ArrayList<Tile> world, int xscroll, int yscroll, Camera camera, Player player, World screen, boolean spacePressed, int currentTileId) {
		
		
		g.setColor(Color.red);
		g.drawRect(player.getGridX() - (GameConstants.tileWidth / 2), player.getGridY() - (GameConstants.tileHeight / 2), GameConstants.playerWidth, GameConstants.playerHeight);

		String xxS = "xx = " + xx;
		String yyS = "yy = " + yy;
		String ppXc = "pXC = " + pXC;
		String ppYc = "pYC = " + pYC;
		String xBoundww = "-yBounds = " + -GameConstants.yBounds;
		
		drawDebugStatement(g, xxS, Color.yellow, debugX, 30);
		drawDebugStatement(g, yyS, Color.yellow, debugX, 60);
		drawDebugStatement(g, xBoundww, Color.yellow, debugX, 90);
		drawDebugStatement(g, ppXc, Color.yellow, debugX, 120);
		drawDebugStatement(g, ppYc, Color.yellow, debugX, 150);

		g.setColor(Color.white);

		for (int l = 0; l <world.size(); l++) {
			
			int tileX = world.get(l).getX() + xscroll;
			int tileY = world.get(l).getY() + yscroll;
			
			if (world.get(l).isBlockMovement()) {
				
				Double noiseValue = world.get(l).getNoiseValue();
				g.setColor(world.get(l).getNoiseColor());
				g.drawString(noiseValue.toString(), tileX, tileY);
			}	else {
				
				Double noiseValue = world.get(l).getNoiseValue();
				g.setColor(world.get(l).getNoiseColor());
				g.drawString(noiseValue.toString(), tileX, tileY);	
			//	
			}
		}
		g.setColor(Color.orange);

		String camx = "Cam X = " +camera.getX();
		String camy = "Cam Y = " +camera.getY();
		String camxB = "Cam Xb = " +camera.getXb();
		String camyB = "Cam Yb = " +camera.getYb();
		
		
		String currentTile = "Current tile = " + currentTileId;
		
		if (player.inventory.size() > 0) {
			
			for (int m = 0; m < player.inventory.size(); m++) {
				String invTory = "Inventory " + m + ": = " + player.inventory.get(m).getName();
				g.drawString(invTory, 600, 280 + (m * 10));
			}			
		}


		int adjustTileX = world.get(currentTileId).getX() + xscroll;// - GameConstants.halfWorld);
		int adjustTileY = world.get(currentTileId).getY() + yscroll;// - GameConstants.halfWorld);
		
		
	
		String tilex = "Current tile x  + scroll = " + adjustTileX;
		String tiley = "Current tile y +  scroll = " + adjustTileY;
		String tileType = "Current tile type = " + world.get(currentTileId).getType();
		
		String xscrollText = "xscroll = " + xscroll;
		String yscrollText = "yscroll = " + yscroll;
		
		String pGridX = "Player's grid x = " + player.getGridX();
		String pGridY = "Player's grid y = " + player.getGridY();
		
		

		g.drawString(camx, debugX, 230);
		g.drawString(camy, debugX, 250);
		g.drawString(camxB, debugX, 270);
		g.drawString(camyB, debugX, 290);
		g.drawString(currentTile, debugX, 310);
		g.drawString(tilex, debugX, 330);
		g.drawString(tiley, debugX, 360);
		g.drawString(tileType, debugX, 390);
		g.drawString(xscrollText, debugX, 410);
		g.drawString(yscrollText, debugX, 430);
		g.drawString(pGridX, debugX, 450);
		g.drawString(pGridY, debugX, 470);
		
				
		//draw grids
		for (int b = 0; b < 1500; b+=100) {
			g.setColor(Color.white);
			g.drawRect(0, 0, b, 1200);
			
			g.drawRect(0, 0, 1500, b);
		}
	}

}
