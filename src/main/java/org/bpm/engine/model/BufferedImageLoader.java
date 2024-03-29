package org.bpm.engine.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class BufferedImageLoader {

public BufferedImage loadImage(String pathRelativeToThis) throws IOException{
	URL url = this.getClass().getResource(pathRelativeToThis);
    assert url != null;
    return ImageIO.read(url);
}
}