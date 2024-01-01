package org.bpm.engine.model;

import java.awt.*;

public class GameConstants {

	
	public static final String NAME = "Galor's Quest";
	
	
	/* Set the size of all tiles, could be used later for zooming */
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	
	/*Base Height of the screen*/
	public static final int HEIGHT = tileWidth * 9;
	
	/*Base Width of the screen*/
	public static final int WIDTH = tileHeight * 10;
	
	/*Multiplier used for screen dims*/
	public static final int SCALE = 6;
	
	
	
	/*These two numbers act as the boundary for the player for collisions at the edge of the world
	 * have to compensate for the tile size
	 */
	public static final int TRUE_HEIGHT = (HEIGHT * SCALE) - 32;
	public static final int TRUE_WIDTH = (WIDTH * SCALE)  - 32;
	
	/*Starting coordinates for player*/
	//public static final int PLAYER_START_X = (tileWidth * 9) + (tileWidth / 2);
	//public static final int PLAYER_START_Y = (tileHeight * 10 )+ (tileHeight / 2);
	
	
	
	/* Determines the grid size of the world (x by y)*/
	public static final int WORLD_SIZE = 200;
	
	public static final int WORLD_START_REGION = (WORLD_SIZE * tileWidth) / 3;
	
	/* Determines the baseline random number used to generate random elements*/
	public static final int RANDOM_INDEX = 1000;
	
	/* Determines the catalyst for a random entry(index - entropy) */
	public static final int ENTROPY = 15;
	
	/* How far ahead to look for collisions on entities */
	public static final int COLLISION_BUFFER = 24;
	
	/* Set the size of the player sprite */
	public static final int playerWidth = 32;
	public static final int playerHeight = 32;
	
	public static final int cameraX = 1500;
	public static final int cameray = 1200;

	
	/* Set a variable to half of the word * tile size */
	public static final int halfWorld = (GameConstants.WORLD_SIZE * tileWidth) / 2;
	
	/*Determine where the world ends and compensate for player scrolling and boundaries */
	public static final int yBounds = (halfWorld - (tileWidth * 6) - 10);
	public static final int xBounds = (halfWorld - (tileWidth * 8) - 10);
	
	
	public static final Color gray1 = new Color(100, 100, 100);
	public static final Color gray2 = new Color(120, 120, 120);
	public static final Color gray3 = new Color(140, 140, 140);
	public static final Color gray4 = new Color(160, 160, 160);
	public static final Color gray5 = new Color(180, 180, 180);
	public static final Color gray6 = new Color(200, 200, 200);
	public static final Color gray7 = new Color(220, 220, 220);
	public static final Color gray8 = new Color(240, 240, 240);
	public static final Color gray9 = new Color(255, 255, 255);
	
	public static final Color blue1 = new Color(4, 35, 62);
	public static final Color blue2 = new Color(35, 62, 168);
	public static final Color blue3 = new Color(66, 87, 172);
	public static final Color blue4 = new Color(99, 117, 188);
	
	public static final Color green1 = new Color(40, 131, 12);
	public static final Color green2 = new Color(51, 168, 16);
	public static final Color green3 = new Color(121, 196, 98);
	public static final Color green4 = new Color(196, 226, 187);
	public static final Color green5 = new Color(219, 247, 210);
	
	public static final Color beige1 = new Color(219, 197, 124);
	
	
	public static final String[] spriteMapKey = {
	"LEFT_CORNER_WALL", 
	"BACK_WALL", 
	"BACK_WALL_DOORWAY",
	"RIGHT_CORNER_WALL",
	"MAIN_CHAR",
	"MAIN_CHAR_2",
	"MAIN_CHAR_GREEN",
	"MAIN_CHAR_MONK",
	"MOB_SKELETON",
	"MOB_ORC",
	"MAIN_CHAR_PRIEST",
	"MAIN_CHAR_HALFLING",
	"MAIN_CHAR_GREEN_ARMS",
	"MAIN_CHAR_GUNSLINGER",
	"MAIN_CHAR_CLERIC",
	"MOB_TROLL",
	//row 2
	"LEFT_WALL",
	"HOLE",
	"PEDASTAL",
	"RIGHT_WALL",
	"MOB_SNAKE",
	"MOB_DOG",
	"MOB_UNK1",
	"MOB_UNK2",
	"MOB_GOBLIN",
	"MOB_GHOST",
	"MOB_RAT",
	"MOB_BLACK_DRAGON",
	"MOB_BEHOLDER",
	"MOB_TURTLE",
	"MOB_WYVERN",
	"MOB_GIANT",
	//row 3
	"BOTTOM_LEFT_WALL",
	"BOTTOM_WALL_WINDOW",
	"BOTTOM_WALL_DOORWAY",
	"BOTTOM_RIGHT_WALL",
	"WALL_DOOR_CLOSED",
	"WALL_DOOR_OPEN",
	"LADDER",
	"LADDER_DOWN",
	"PIPE_TALL",
	"PIPE_SMALL",
	"BLUE_DRAGON",
	"RED_DRAGON",
	"GREEN_DRAGON",
	"WATER_LEFT_CORNER",
	"WATER_TOP",
	"WATER_RIGHT_CORNER",
	//row 4
	"LEFT_PILLAR",
	"RIGHT_PILLAR",
	"LEFT_GREY_PILLAR",
	"RIGHT_GREY_PILLAR",
	"STAIRS_DOWN",
	"STAIRS_UP",
	"SMALL_SIGN",
	"BIG_SIGN",
	"SMALL_BALL",
	"CHEST",
	"VINE_WALL_1",
	"VINE_WALL_2",
	"CRACKED_WALL",
	"WATER_LEFT",
	"WATER_MIDDLE",
	"WATER_RIGHT",
	//row 5
	"LEFT_TOP_BOTTOM_WALL",
	"MIDDLE_TOP_WALL",
	"TOP_WALL_GREY_DETAIL",
	"TOP_WALL_GREY_2",
	"BLUE_PARTICLE",
	"GREEN_PARTICLE",
	"SWORD",
	"AXE",
	"BOW",
	"ARROW",
	"CLUB",
	"ARROW_2",
	"RING",
	"WATER_LEFT_BOTTOM",
	"WATER_BOTTOM",
	"WATER_RIGHT_BOTTOM",
	// ROW 6
	"LEFT_TOP_BOTTOM_WALL",
	"MIDDLE_TOP_WALL",
	"TOP_WALL_GREY_DETAIL",
	"TOP_WALL_GREY_2",
	"PINE_TREE",
	"REG_TREE",
	"SMALL_TREES",
	"DIRT",
	"MUSHROOM",
	"FLOWER",
	"LEFT_SMALL_WALL",
	"RIGHT_SMALL_WALL",
	"LEFT_GATE_OPEN",
	"RIGHT_GATE_OPEN",
	"GATE_CLOSED",
	"SOLID_GATE_CLOSED",
	//ROW 7
	"TRAP_DOOR_CLOSED",
	"TRAP_DOOR_OPEN_1",
	"TRAP_DOOR_OPEN_2",
	"SMALL_UI_ARROW",
	"EMPTY_HEART",
	"HALF_HEART",
	"FULL_HEART",
	"EMPTY_METER",
	"HALF_METER",
	"FULL_METER",
	"PILLAR_2",
	"PILLAR_3",
	"THIN_PILLAR_LEFT",
	"THIN_PILLAR_RIGHT",
	"SPIDER_WEB",
	"WELL",
	//ROW 8
	"BULLS_EYE",
	"LARGE_UI_ARROW_END",
	"LARGE_UI_ARROW_90",
	"LARGE_UI_ARROW",
	"UI_EXCLAMATION",
	"HOUSE_TOWN",
	"CASTLE",
	"TEMPLE",
	"CROSS",
	"SHIELD",
	"FIRE",
	"HEADSTONE",
	"LEFT_SPIKE_PILLAR",
	"RIGHT_SPIKE_PILLAR",
	"LANTERN_ON",
	"LANTERN_OFF",
	//ROW 9
	"TARGET_1",
	"TARGET_2",
	"TARGET_OPEN",
	"TARGET_3",
	"LIGHT_PARTICLE",
	"SLASH",
	"SLASH_2",
	"SPELL_1",
	"SPELL_BLUE",
	"SPELL_GREEN",
	"SPELL_RED",
	"SPELL_YELLOW",
	"GREEN_POTION",
	"RED_POTION",
	"BLUE_POTION",
	"ORANGE_POTION",
	//row 10
	"NPC_1",
	"NPC_2",
	"NPC_3",
	"NPC_4",
	"NPC_5",
	"NPC_6",
	"NPC_7",
	"NPC_8",
	"NPC_9",
	"NPC_10",
	"NPC_11",
	"NPC_12",
	"NPC_13",
	"NPC_14",
	"NPC_15",
	"NPC_16"};
	
}
