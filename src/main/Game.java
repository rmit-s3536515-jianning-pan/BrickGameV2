package main;

import javax.swing.JFrame;

import controller.GameEngine;
import model.FixedData;

public class Game {

	public Game() {
		JFrame frame = new JFrame("Brick game version 2.0");
		frame.setSize(FixedData.WIDTH,FixedData.HEIGHT);
		GameEngine engine = new GameEngine();
		frame.add(engine);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		engine.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();
	}

}
