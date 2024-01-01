package org.bpm.engine.util;

/*
 * OpenSimplex Noise sample class.
 */

import org.apache.commons.math3.*;
import org.apache.commons.math3.util.Precision;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OpenSimplexNoiseTest
{
	private static final int WIDTH = 100;
	private static final int HEIGHT = 100;
	private static final double FEATURE_SIZE = 5;

	public static void main(String[] args)
		throws IOException {
		
		OpenSimplexNoise noise = new OpenSimplexNoise();
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < HEIGHT; y++)
		{
			for (int x = 0; x < WIDTH; x++)
			{
				double value = noise.eval(x / FEATURE_SIZE, y / FEATURE_SIZE, 0.0);
				
				int rgb = 0x010101 * (int)((value + 1) * 127.5);
				
			//	System.out.println("value = " + Math.round((value + 1)));
				
				double dvalue = Precision.round(value, 1);
				System.out.println("dvalue = " + (dvalue + 1));
				
				image.setRGB(x, y, rgb);
			}
		}
		ImageIO.write(image, "png", new File("noise.png"));
	}
}