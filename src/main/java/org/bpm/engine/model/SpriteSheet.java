package org.bpm.engine.model;

import java.awt.image.BufferedImage;

public class SpriteSheet {

public BufferedImage spriteSheet;

public SpriteSheet(BufferedImage ss){
	this.spriteSheet = ss;
}

public Sprite grabSprite(int x, int y, int width, int height){
	BufferedImage bsprite = spriteSheet.getSubimage(x, y, width, height);
	Sprite sprite = new Sprite(bsprite);
	return sprite;
}
}