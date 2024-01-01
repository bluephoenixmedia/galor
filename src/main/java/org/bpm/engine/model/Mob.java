package org.bpm.engine.model;

import java.util.Random;

public class Mob extends Entity {
	
	private int randomWalkTime = 0;
	private int xa, ya;
	private int ticktime;
	private Random random = new Random();
	public Mob(int x, int y, boolean blockMovement, Facing facing) {
		super(x, y, false, facing);
		// TODO Auto-generated constructor stub
	}
	
	public Mob() {
		
	}
	
	@Override
	public void collidedWith(Entity other) {
		// TODO Auto-generated method stub

	}
	public void tick() {
		super.tick();

		if (randomWalkTime == 0) {
			//int xd = level.player.x - x;
			//int yd = level.player.y - y;
			//if (xd * xd + yd * yd < 50 * 50) {
				xa = -1;
				ya = +1;
				//if (xd < 0) xa = -1;
				//if (xd > 0) xa = +1;
				//if (yd < 0) ya = -1;
				//if (yd > 0) ya = +1;
			}
		

		int speed = ticktime & 1;
		
		if (random.nextInt(200) == 0) {
			randomWalkTime = 60;
			xa = (random.nextInt(3) - 1) * random.nextInt(2);
			ya = (random.nextInt(3) - 1) * random.nextInt(2);
		}
		if (randomWalkTime > 0) randomWalkTime--;
	}
	


	public void moveRandomly() {
		
		
		
	}

}
