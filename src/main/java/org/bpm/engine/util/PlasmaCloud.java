package org.bpm.engine.util;

import java.awt.*;

public class PlasmaCloud { 
	
	static int count = 0;

    // centered at (x, y), of given size, using given standard deviation for computing the
    // displacement, and with upper left, upper right, lower lower, and lower right hues c1, c2, c3, c4
    public static void plasma(double x,  double y,  double size, double stddev,
                              double c1, double c2, double c3,   double c4) {

        // base case
        if (size <= 0.001) return;
        
        count++;
        // calculate new color of midpoint using random displacement
        double displacement = StdRandom.gaussian(0, stddev);
        double cM = (c1 + c2 + c3 + c4) / 4.0 + displacement;

        // draw a colored square
        Color color = Color.getHSBColor((float) cM, 0.8f, 0.8f);
        StdDraw.setPenColor(color);
        StdDraw.filledSquare(x, y, size);
        
        
        double cT = (c1 + c2) / 2.0;    // top
        double cB = (c3 + c4) / 2.0;    // bottom
        double cL = (c1 + c3) / 2.0;    // left
        double cR = (c2 + c4) / 2.0;    // right
        
        System.out.println("cT =" + cT);
        System.out.println("cB = " + cB);
        System.out.println("cL =" + cL);
        System.out.println("cR = " + cR);
       
        

        plasma(x - size/2, y - size/2, size/2, stddev/2, cL, cM, c3, cB);
        plasma(x + size/2, y - size/2, size/2, stddev/2, cM, cR, cB, c4);
        plasma(x - size/2, y + size/2, size/2, stddev/2, c1, cT, cL, cM);
        plasma(x + size/2, y + size/2, size/2, stddev/2, cT, c2, cM, cR);
    }



    public static void main(String[] args) {
//
        // choose intial corner colors at random betwen 0 and 1
        double c1 = StdRandom.uniform();
        double c2 = StdRandom.uniform();
        double c3 = StdRandom.uniform();
        double c4 = StdRandom.uniform();

        // controls variation in color
        double stddev = 1.0;
        plasma(0.1, 0.1, 0.04, stddev, c1, c2, c3, c4);
        System.out.println("count = " + count);
    }
}
