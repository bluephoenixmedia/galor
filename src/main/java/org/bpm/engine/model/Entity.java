package org.bpm.engine.model;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.awt.*;


/**
 * An entity represents any element that appears in the game. The
 * entity is responsible for resolving collisions and movement
 * based on a set of properties defined either by subclass or externally.
 * 
 * Note that doubles are used for positions. This may seem strange
 * given that pixels locations are integers. However, using double means
 * that an entity can move a partial pixel. It doesn't of course mean that
 * they will be display half way through a pixel but allows us not lose
 * accuracy as we move.
 * 
 * @author Kevin Glass
 */

public abstract class Entity {



	/** The current x location of this entity */ 
	protected double x;
	
	/** The current y location of this entity */
	protected double y;
	
	protected double xd, yd;
	
	protected Image currentImage;
	
	protected boolean blockMovement;
	
	protected boolean canGather;
	
	public boolean activeTile;
	
	public enum Facing {LEFT, RIGHT, DOWN, UP};
	
	protected Vector2D position;
	protected int newX;
	protected int newY;
		
	/** The current speed of this entity horizontally (pixels/sec) */
	protected double dx;
	
	/** The current speed of this entity vertically (pixels/sec) */
	protected double dy;
	
	/** The rectangle used for this entity during collisions  resolution */
	public Rectangle me = new Rectangle();
	
	public Facing facing = Facing.DOWN;

	/**
	 * Construct a entity based on a sprite image and a location.
	 * @param x The initial x location of this entity
	 * @param y The initial y location of this entity
	 */
	public Entity(int x,int y, boolean blockMovement, Facing facing) {
		this.x = x;
		this.y = y;
		this.blockMovement = blockMovement;
		this.facing = facing;
	}
	
	public Entity() {
		
	}

	/**
	 * Request that this entity move itself based on a certain ammount
	 * of time passing.
	 * 
	 * @param delta The ammount of time that has passed in milliseconds
	 */
	public void move(long delta) {
		// update the location of the entity based on move speeds
		x += (delta * dx) / 1000;
		y += (delta * dy) / 1000;
	}

	/**
	 * Set the horizontal speed of this entity
	 * 
	 * @param dx The horizontal speed of this entity (pixels/sec)
	 */
	public void setHorizontalMovement(double dx) {
		this.dx = dx;
	}

	/**
	 * Set the vertical speed of this entity
	 * 
	 * @param dx The vertical speed of this entity (pixels/sec)
	 */
	public void setVerticalMovement(double dy) {
		this.dy = dy;
	}

	/**
	 * Get the horizontal speed of this entity
	 * 
	 * @return The horizontal speed of this entity (pixels/sec)
	 */
	public double getHorizontalMovement() {
		return dx;
	}

	/**
	 * Get the vertical speed of this entity
	 * 
	 * @return The vertical speed of this entity (pixels/sec)
	 */
	public double getVerticalMovement() {
		return dy;
	}


	/**
	 * Do the logic associated with this entity. This method
	 * will be called periodically based on game events
	 */
	public void doLogic() {
	}

	/**
	 * Get the x location of this entity
	 * 
	 * @return The x location of this entity
	 */
	public int getX() {
		return (int) x;
	}

	/**
	 * Get the y location of this entity
	 * 
	 * @return The y location of this entity
	 */
	public int getY() {
		return (int) y;
	}

	/**
	 * Check if this entity collised with another.
	 * 
	 * @param other The other entity to check collision against
	 * @return True if the entities collide with each other
	*/
	public boolean collidesWith(Entity other) {

		return me.intersects(other.me);
	} 

	/**
	 * Notification that this entity collided with another.
	 * 
	 * @param other The entity with which this entity collided.
	 */
	public abstract void collidedWith(Entity other);
	
	public Image getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(Image currentImage) {
		this.currentImage = currentImage;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean isBlockMovement() {
		return blockMovement;
	}

	public void setBlockMovement(boolean blockMovement) {
		this.blockMovement = blockMovement;
	}

	public boolean isActiveTile() {
		return activeTile;
	}

	public void setActiveTile(boolean activeTile) {
		this.activeTile = activeTile;
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public Facing getFacing() {
		return facing;
	}

	public void setFacing(Facing facing) {
		this.facing = facing;
	}

	public boolean isCanGather() {
		return canGather;
	}

	public void setCanGather(boolean canGather) {
		this.canGather = canGather;
	}
	
	public Vector2D getPosition() {
		return position;
	}

}
