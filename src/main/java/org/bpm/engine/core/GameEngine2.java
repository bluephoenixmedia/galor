package org.bpm.engine.core;


import org.bpm.engine.gfx.Camera;
import org.bpm.engine.gfx.World;
import org.bpm.engine.input.KeyInputHandler;
import org.bpm.engine.model.*;
import org.bpm.engine.model.Entity.Facing;
import org.bpm.engine.util.DebugUtil;
import org.bpm.regions.BaseGrassRegion;
import org.bpm.regions.Region;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 *	GameEngine provides a template game loop with a debuggable fps display
 */
public class GameEngine2 extends Canvas implements Runnable {//, ActionListener {
	
	private static final long serialVersionUID = 1L;


	/* These two variables are used for the world coordinates */
	private int xx = 0;
	private int yy = 0;
	
	/* The camera coordinates (forms a rectangle) */
	public int cammX = 0;
	public int cammY = 0;
	public int cammXW = 0;
	public int cammYH = 0;
	
	//not used yet but will be used for pausing
	public static boolean updateWorld = false;
	
	/* Turn off and on debugging */
	public static boolean DEBUG_ENABLED = false;
			
	
	//uhhh....another pause boolean...something
	public boolean PAUSED = false;
	
	/* Arraylist for the randomly generated world */
	private ArrayList<Tile> overWorld;

	/* regions will need multiple "world" so we need a list for that */
	//private ArrayList<World> worlds;
	
	
	/* boolean for the main thread for the game */
	private boolean running = false;
	
	//number of logic ticks
	private int tickCount = 0;
	
	// Elasped game time
	public int gameTime = 0;
	
	// Controls player speed - size of the tiles
	public static int SPEED = 32;
	
	/* Coordinates to keep track of the scrolling of the tiles when player moves */
	public int xscroll = 0;
	public int yscroll = 0;
	
	/* We place the player in the middle of the generated world so need to cut our dims in half*/
	public int halfWidth = (GameConstants.WIDTH * GameConstants.SCALE) / 2;
	public int halfHeight = (GameConstants.HEIGHT * GameConstants.SCALE) / 2;
	
	public static boolean playerInit = false;
	
	/* Initialize player tracking coordinates to the middle */
	public int pXC = GameConstants.tileWidth * 23;
	public int pYC = GameConstants.tileHeight * 19;
	

	// initialize our images...
	//TODO do this from tilesheet
	public static Image grass;
	public static Image grass2;
	public static Image grass3;
	public static Image grass4;
	public static Image plant;
	public static Image water;
	public static BufferedImage tree;
	public static BufferedImage tree2;
	public static BufferedImage tree3;
	public static BufferedImage tree4;
	public static BufferedImage tree5;
	public static BufferedImage town;
	public static BufferedImage mountain;
	public static BufferedImage mountain2;
	public static BufferedImage hills;
	public static BufferedImage mtnCamp;
	
	public static BufferedImage weeds;
	public static BufferedImage swamp;
	public static BufferedImage main_char;
	public static BufferedImage brush;
	
	public static Image wiz_front;
	public static Image wiz_back;
	public static Image wiz_right;
	public static Image wiz_left;
	
	public static Map<String, Sprite> spriteMap = new HashMap<String, Sprite>();
	public static Map<Integer, Sprite> spriteMap2 = new HashMap<Integer, Sprite>();
	
	/* our player */
	public Player player;
	
	public InventoryManager invManager; 
	
	public static int currentTileId;
	
	//old sprite key map
	private ArrayList<String> spriteKeyMap;
	
	public static boolean playerMoved = false;

	/** True if the left cursor key is currently pressed */
	public static boolean leftPressed = false;
	
	/** True if the right cursor key is currently pressed */
	public static boolean rightPressed = false;
	
	/** True if the left cursor key is currently pressed */
	public static boolean upPressed = false;
	
	/** True if the right cursor key is currently pressed */
	public static boolean downPressed = false;
	
	/** True if the right cursor key is currently pressed */
	public static boolean spacePressed = false;
	
	/** True if the right cursor key is currently pressed */
	public static boolean inventoryPressed = false;
	
	/** True if the right cursor key is currently pressed */
	public static boolean tabPressed = false;
	
	/** True if the right cursor key is currently pressed */
	public static boolean enterPressed = false;
	
	/** boolean for detecting collisions */ 
	public static boolean collision = false;
	
	public static boolean worldOffSet = false;
	
	/** The camera allows us to only draw what the player can see, saves memory*/ 
	private Camera camera;
	
	private World world;
	
	/**
	 * Starter method to fire up the thread and initiate the game
	 */
	public void start() {
		running = true;
		new Thread(this).start();
	}
	
	/**
	 * Stops the game from running
	 */
	public void stop() {
		running = false;
	}
	
	/**
	 * Reset all game variables and re-initializes everything
	 */
	public void resetGame() {
	
	}
	
	/**
	 * Instantiates all initial values for objects / variables
	 */
	@SuppressWarnings("unchecked")
	private void init() {

		loadImages();
		
		
		//not used yet
		invManager = new InventoryManager();
		
		//not used yet
		ArrayList<Item> items = new ArrayList<Item>();
	
		//instantiate a new world
		world = new World();
		
		
		/*
		 * TODO: get save and load to work correctly
		try{
            FileInputStream readData = new FileInputStream("overworld.dat");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            world = (ArrayList<Tile>) readStream.readObject();
            
            readStream.close();

            //System.out.println(people2.toString());
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/
		
		
		//generate a random world
		try {
			//world = screen.buildSimplexRegion(GameConstants.WORLD_SIZE, GameConstants.tileWidth, GameConstants.tileHeight, pXC, pYC);
			
			//TODO: convert to constants?
			
			world = new World();
			
			camera = new Camera(0, 0, 1500, 1500);
	
			overWorld = world.buildOverWorld(GameConstants.WORLD_SIZE, GameConstants.tileWidth, GameConstants.tileHeight, pXC, pYC);
			//world = screen.buildSimplexRegion(GameConstants.WORLD_SIZE, GameConstants.tileWidth, GameConstants.tileHeight, pXC, pYC, "GRASS");
			
			BaseGrassRegion grassRegion = new BaseGrassRegion();
			
			grassRegion.setRegionX(pXC);
			grassRegion.setRegionY(pYC);
			
			
			ArrayList<Tile> regionTiles = BaseGrassRegion.generate(GameConstants.WORLD_SIZE, GameConstants.tileWidth, GameConstants.tileHeight, pXC, pYC, "GRASS");
			
			grassRegion.setRegion(regionTiles);
						
			world.addRegion((Region) grassRegion);
			
			player = new Player(pXC - (GameConstants.tileWidth  / 2), pYC - (GameConstants.tileWidth / 2), items, false);
			
			//we found a safe place to put the player in world generation, now we set their grid coordinates accordingly
			player.setGridX(world.getWorldStartX());
			player.setGridY(world.getWorldStartY());
			
			//set the player facing forward initially (not used currently)
			player.setCurrentImage(wiz_front);
			
			//the map starts at 0, 0 so we need to shift it so that the player start is drawn in the center of the screen
			xscroll = pXC - world.getWorldStartX();
			yscroll = pYC - world.getWorldStartY();
			
			//graphics draw increments Y moving down, whereas the coordinate system increments moving up, so we take the map start
			//and subtract the shift from above (making the gridY negative so it matches the coordinate system
			player.setGridX(pXC - xscroll);
			player.setGridY(-(pYC - yscroll));
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//save generated world
		/*
		 * 
		 * TODO: make this work
		try{
		    FileOutputStream writeData = new FileOutputStream("overworld.dat");
		    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

		    writeStream.writeObject(world);
		    writeStream.flush();
		    writeStream.close();

		}catch (IOException e) {
		    e.printStackTrace();
		}*/
		
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * The main loop for the game
	 */
	public void run() {
		
		// Last time in nano seconds
		long lastTime = System.nanoTime();
		
		//
		double unprocessed = 0;
		
		//Nano seconds per tick (game logic tick) 1000000000 is 1 second in nanoseconds 
		double nsPerTick = 1000000000.0 / 60;
		
		//
		int frames = 0;
		
		//counter for game ticks
		int ticks = 0;
		
		// Last time in milliseconds
		long lastTimer1 = System.currentTimeMillis();
		
		//initialize the vars / objects
		init();
		
		//the actual core game loop which processes all game logic per tick
		while (running) {
			
			// var to grab nano time
			long now = System.nanoTime();
			
			// calculate the difference between current time and previously captured nano time and divide
			// by nano seconds per tick
			unprocessed += (now - lastTime) / nsPerTick;
			
			//System.out.println("unprocessed = " + unprocessed);
			
			// set the now time again
			lastTime = now;
			
			// tell the game to render
			boolean shouldRender = true;
			
			//whenever unprocessed is greater then one, tick, works out to about 60 ticks per second on average
			while (unprocessed >= 1) {	
				//increment ticks
				ticks++;		
				//perform game logic
				tick();
				//reset unprocessed
				unprocessed -= 1;
				//render
				shouldRender = true;
			}
			
			// sleep for 2 milliseconds, adjusting this value changes the framerate
			// 1000 = 1 fps, 500 = 2fps, etc...30 roughly gets you 30 fps
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// increment frames and call rendering
			if (shouldRender) {
				frames++;
				render();
				playerMoved = false;
			}
			
			// this calculation works out to run every second that elapses, see above system out for example
			if (System.currentTimeMillis() - lastTimer1 > 1000) {
				// reset our frames and ticks
				lastTimer1 += 1000;
				
				gameTime += 1;
				/*
				if (DEBUG_ENABLED) {
					System.out.println(ticks + " ticks, " + frames + " fps");
				}*/
				
				frames = 0;
				ticks = 0;
			}
			

		}
	}

	
	/**
	 * tick controls game time and performs logic for each tick
	 */
	public void tick() {
		
		
		if (!PAUSED && !playerMoved) {
		
			tickCount++;
			
			//if left arrow is pressed
			if (leftPressed && !rightPressed && !collision) {
				
				playerMoved = true;
				
				player.setFacing(Facing.LEFT);
				
				// check for collision with other objects
				if (checkCollide("LEFT")) {
					
					//if they "move" left, the tiles should shift right
					xscroll += SPEED;
					//update the players grid location
					player.setGridX(player.getGridX() - SPEED);
			
				}	
				
				// set player image facing left
				player.setCurrentImage(wiz_left);
				
			}
			if (rightPressed && !leftPressed && !collision) {
				
				playerMoved = true;
				
				player.setFacing(Facing.RIGHT);
				
				if (checkCollide("RIGHT")) {
					
					
					xscroll-=SPEED;
					
					player.setGridX(player.getGridX() + SPEED);
				
					
				}
				player.setCurrentImage(wiz_right);
			}
			if (upPressed && !downPressed && !collision) {
				
				playerMoved = true;
				
				player.setFacing(Facing.UP);
				
				if (checkCollide("UP")) {
					
					yscroll += SPEED;
			
					player.setGridY(player.getGridY() + SPEED);
				
				}	
				player.setCurrentImage(wiz_back);
				
			}
			if (downPressed && !upPressed && !collision) {
				
				playerMoved = true;
				
				player.setFacing(Facing.DOWN);
				
				if (checkCollide("DOWN")) {
					
					yscroll -= SPEED;
			
					player.setGridY(player.getGridY() - SPEED);
				
					
				}	
				player.setCurrentImage(wiz_front);
			}
			if (spacePressed) {
				checkCollide("SPACE");
			}
			
			
			if (tabPressed) {
				drawMenu();
			}
			
			/*
			if (enterPressed) {
			//	world.get(index)
				//enter region
				
			}*/
			//set player position on the screen
			player.setX(pXC);
			player.setY(pYC);
	
			
		}
	
	}
	
	
	public void drawMenu() {
		PAUSED = true;	
	}
	
	
	
	/**
	 * checkCollide
	 * using the player coordinates on the screen, check collision based on movement (if the tile adjacent is a blocker)
	 * @param action - which action was taken
	 * @return - boolean 
	 */
	public boolean checkCollide(String action) {
		boolean move = true;
		for (int coll = 0; coll < overWorld.size(); coll++) {	
				Rectangle collTest = new Rectangle();
				
				if (action == "LEFT") {
					collTest.setBounds(pXC - GameConstants.COLLISION_BUFFER, pYC, GameConstants.playerWidth, GameConstants.playerHeight);
					move = updateMoveActive(collTest, coll, move);
				} else if(action == "RIGHT") {
					collTest.setBounds(pXC  + GameConstants.COLLISION_BUFFER, pYC, GameConstants.playerWidth, GameConstants.playerHeight);
					move = updateMoveActive(collTest, coll, move);	
				} else if(action == "UP") {
					collTest.setBounds(pXC, pYC - GameConstants.COLLISION_BUFFER, GameConstants.playerWidth, GameConstants.playerHeight);
					move = updateMoveActive(collTest, coll, move);
				} else if(action == "DOWN") {
					collTest.setBounds(pXC, pYC + GameConstants.COLLISION_BUFFER, GameConstants.playerWidth, GameConstants.playerHeight);
					move = updateMoveActive(collTest, coll, move);	
				}
				
				
			
		}
		
		return move;
		
	}
	
	public boolean updateMoveActive(Rectangle collTest, int coll, boolean move) {
		

		if (collTest.intersects(overWorld.get(coll).me) && overWorld.get(coll).isBlockMovement()) {
			if (DEBUG_ENABLED) {
				System.out.println("move blocked");
				System.out.println("colltest x= " + collTest.x);
				System.out.println("colltest y= " + collTest.y);
				System.out.println("colltest x2= " + (collTest.x + collTest.width));
				System.out.println("colltest y2= " + (collTest.y + collTest.height));
			}
			move = false;
		} 

		
		return move;
		
	}
	
	/**
	 * The main rendering method
	 */
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			requestFocus();
			addKeyListener(new KeyInputHandler());
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		g.fillRect(0, 0, getWidth(), getHeight());

		World.render(g, camera, player, pXC, pYC, world, overWorld, xx, yy, xscroll, yscroll, cammX, cammY, cammXW, cammYH);
		
		
		if (inventoryPressed) {
			invManager.render(g, player.inventory.size(), player.inventory);
		}
		currentTileId = world.getCurrentTileId(player.getGridX(), -player.getGridY(), overWorld);
		
		
		if (DEBUG_ENABLED) {
			DebugUtil.debugRender(g, xx, yy, pXC, pYC, overWorld, xscroll, yscroll, camera,  player, world,  spacePressed, currentTileId);			
		}
		
		g.dispose();
		bs.show();
	}
	
	private void gatherItem(int column) {
		
		Item item = new Item();
		item.setName(overWorld.get(column).getType());
		player.inventory.add(item);
		overWorld.get(column).setCanGather(false);
		overWorld.get(column).setBlockMovement(false);
		overWorld.get(column).setType("GRASS");
		overWorld.get(column).setCurrentImage(grass);
	}
	

	private void loadImages() {
		try {
			
			
			BufferedImageLoader loader = new BufferedImageLoader();
			BufferedImage spriteSheet = null;
			
			try {
				spriteSheet = loader.loadImage("/toen_tile.png");
				//spriteSheet = loader.loadImage("/miniroguelike-8x8.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
			SpriteSheet ss = new SpriteSheet(spriteSheet);
			
			int spriteWidth = 16;
			int spriteHeight = 16;
			int rowCounter = 44;
			int totalCount = 0;
			
			for (int sp = 0; sp < rowCounter; sp++) {
				
				for (int col = 0; col < 7; col++) {
					
					Sprite sprite;
					if (DEBUG_ENABLED) {
						System.out.println(totalCount + " = totalcount, coord = " + (spriteWidth * col) + ", " + (spriteWidth * sp) + ", " + spriteWidth + ", " + spriteHeight);
					}
					sprite = ss.grabSprite((spriteWidth * col), (spriteWidth * sp), spriteWidth, spriteHeight);
					spriteMap2.put(totalCount, sprite);
					totalCount++;
				}

			}
			
			grass = spriteMap2.get(0).getImage();//ImageIO.read(GameEngine2.class.getResource("/grass_tile.jpg"));
			grass2 = spriteMap2.get(1).getImage();
			grass3 = spriteMap2.get(2).getImage();
			grass4 = spriteMap2.get(3).getImage();
			tree = spriteMap2.get(4).getImage();
			tree2 = spriteMap2.get(5).getImage();
			tree3 = spriteMap2.get(6).getImage();
			tree4 = spriteMap2.get(43).getImage();
			tree5 = spriteMap2.get(42).getImage();
			swamp = spriteMap2.get(20).getImage();
			water = spriteMap2.get(171).getImage();
			//town = spriteMap2.get("HOUSE_TOWN").getImage();
			mountain = spriteMap2.get(11).getImage();
			mountain2 = spriteMap2.get(12).getImage();
			hills = spriteMap2.get(13).getImage();
			mtnCamp = spriteMap2.get(37).getImage();
			brush = spriteMap2.get(216).getImage();			
			
			weeds = spriteMap2.get(175).getImage();
			wiz_front = spriteMap2.get(90).getImage();
			wiz_back = spriteMap2.get(90).getImage();
			wiz_right = spriteMap2.get(90).getImage();
			wiz_left = spriteMap2.get(90).getImage();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		GameEngine2 game = new GameEngine2();
		game.setMinimumSize(new Dimension(GameConstants.WIDTH * GameConstants.SCALE, GameConstants.HEIGHT * GameConstants.SCALE));
		game.setMaximumSize(new Dimension(GameConstants.WIDTH * GameConstants.SCALE, GameConstants.HEIGHT * GameConstants.SCALE));
		game.setPreferredSize(new Dimension(GameConstants.WIDTH * GameConstants.SCALE, GameConstants.HEIGHT * GameConstants.SCALE));
		JFrame frame = new JFrame(GameConstants.NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.add(game, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
		
	}

}
