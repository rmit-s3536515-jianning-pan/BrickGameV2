package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.FixedData;
import model.Paddle;

public class PlayerKeyListener implements KeyListener{

	private Paddle paddle;
	
	
	public PlayerKeyListener(Paddle paddle) {
		super();
		this.paddle = paddle;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			paddle.setXa(-FixedData.RAQ_ACC);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddle.setXa(FixedData.RAQ_ACC);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		paddle.setXa(0);
	}

}
