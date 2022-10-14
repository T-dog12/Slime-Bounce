package SpriteSheetMoveMent;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

// learnt from: https://www.youtube.com/watch?v=jedilHUPO7c

public class BufferImageLoader {
	public BufferedImage image;
	
	public BufferedImage loadImage(String path) throws IOException {
		
		image = ImageIO.read(getClass().getResource(path));
		
		return image;
		
	}
}
