package org.bpm.engine.model;

import org.bpm.engine.core.GameEngine2;

import java.awt.*;
import java.util.ArrayList;

public class InventoryManager {
	
	
	public void render(Graphics2D g, int size, ArrayList<Item> inventory) {
		g.setColor(Color.darkGray);
		g.fillRect(200, 200, 400, 400);
		
		g.setColor(Color.white);
		g.drawString("INVENTORY", 210, 210);
		
		if (size > 0) {
			
			for (int m = 0; m < inventory.size(); m++) {
				g.draw3DRect(210 + (m* 10), 210 + (m * 10), 200, 100, true);
				if (inventory.get(m).getName() == "PLANT") {
					g.drawImage(GameEngine2.plant, 215 + (m*10), 215 + (m*10), 60, 60, null);
				}
			}			
		}
	}



	

}
