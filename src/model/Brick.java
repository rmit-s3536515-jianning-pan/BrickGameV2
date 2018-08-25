package model;

import java.awt.Rectangle;

import controller.GameEngine;

public class Brick {
	private int x;
	private int y;
	private GameEngine engine;
	
	public Brick(int x, int y,GameEngine engine) {
		
		this.x = x;
		this.y = y;
		this.engine = engine;
	}

	public void update() {
		collision();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,FixedData.BRICK_WIDTH,FixedData.BRICK_HEIGHT);
	}
	public int getX() {
		return x;
	}

	public void collision() {
		if(engine.getBall().getBounds().intersects(getBounds())) {
			
			
			engine.getBall().setYa(FixedData.BALL_ACCELEARTION);
			engine.getBall().setY(y + FixedData.BRICK_HEIGHT);
			engine.removeBrick(x,y);
			
			
		}
	}
	
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
