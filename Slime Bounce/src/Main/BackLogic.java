package Main;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

import SpriteSheetMoveMent.*;

public class BackLogic extends JPanel implements Runnable{

	// screen dimensions
	private final static int GAME_WIDTH = 1000;
	private final static int GAME_HEIGHT = 550;
	private final static Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	
	// parts of the slime's characteristics
	private int slimeX = 10;
	private int z = 1;
	private String nSlime = "/sSlime p5.PNG";
	
	// Variables that create the frame rate loop
	private int ns = 1000000000/10;
	private static long lastFPSCheck = 0;
	private static long currentFPS = 0;
	private static long totalFrames =0;
	
	
	
	private Thread gameThread;
	private Image image;
	private Graphics graphics;
	private BufferedImage spriteS;
	private BufferedImage slime;
	
	

	
	BackLogic(){
		// creates the initial slime image
		slime(1,1, nSlime);
		
		// makes the panels dimensions 
		this.setFocusable(true);
		this.setPreferredSize(SCREEN_SIZE);
		
		// make the game work
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void slime(int col, int row, String varation) {
		BufferImageLoader loader = new BufferImageLoader();
	
		try {
			spriteS = loader.loadImage(varation);
		}catch(IOException e) {
			
		}
		
		SpriteSheet ss = new SpriteSheet(spriteS);
		slime = ss.grabImage(col, row, 64, 64, 64, 64);
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	
	public void draw(Graphics g) {
		
		// Cycles through different variations of the bouncing slime
		slime(z, 1, nSlime);
			
		z++;
			
		if (z >4) {
			z=1;
		}
		
		slimeX+= 10;
		g.drawImage(slime, slimeX, 100, this);
		
		
		// draws FPS counter
		g.setColor(Color.WHITE);
		g.drawString(String.valueOf("FPS " +currentFPS), 2, 10);
	}
	
	@Override
	public void run() {
		
		// Learnt from: https://www.youtube.com/watch?v=IZQG8odBU5E
		while(true) {
			
			//FPS
			totalFrames ++;
			
			
			if (System.nanoTime() > lastFPSCheck + ns) {
				lastFPSCheck = System.nanoTime();
				currentFPS = totalFrames;
				totalFrames = 0;
				
				// updates the game's panel and movements
				repaint();
				
				
			
			}
			
		}
		
	}

}
