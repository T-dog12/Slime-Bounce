package SpriteSheetMoveMent;

import java.awt.image.BufferedImage;

//learnt from: https://www.youtube.com/watch?v=jedilHUPO7c

public class SpriteSheet {
	
	private BufferedImage spriteS;
	
	public SpriteSheet(BufferedImage spriteS) {
		this.spriteS = spriteS;
	}
	public BufferedImage grabImage(int col, int row, int wid, int width, int height, int pixles) {
		BufferedImage sprite = spriteS.getSubimage((col*pixles)- pixles, (row* pixles) - pixles, width, height);
		
		return sprite;
	}
	
}
