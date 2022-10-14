package Main;

import java.awt.Color;

import javax.swing.*;

public class StartUp extends JFrame{

	StartUp(){
		
		// Creates the game and its functions 
		BackLogic panel = new BackLogic();
		this.add(panel);
		this.setTitle("Slime Bouncing");
		this.setResizable(false);
		this.setBackground(Color.black);
		// Stops code when window is closed
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// makes the panel fit in with in it
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		
		// Calls the class to build the window and manage the actions
		StartUp s = new StartUp();
	}
}
