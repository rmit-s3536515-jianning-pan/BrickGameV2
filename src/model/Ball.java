package model;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;

import controller.GameEngine;

public class Ball {
	private int x;
	private int y;
	private int xa = FixedData.BALL_ACCELEARTION;
	private int ya = -FixedData.BALL_ACCELEARTION;
	private GameEngine engine;
	
	
	public Ball(GameEngine engine) {
		
		this.engine = engine;
		
		x = engine.getPaddle().getX()+FixedData.RAQ_WIDTH/2 - FixedData.BALL_LENGTH/2;
		y = engine.getPaddle().getY()-FixedData.BALL_LENGTH;
		
	}
	
	public void move() {
		if (x + xa < 0)
			xa = FixedData.BALL_ACCELEARTION;
		if (x + xa > FixedData.WIDTH - FixedData.BALL_LENGTH)
			xa = -FixedData.BALL_ACCELEARTION;
		if (y + ya < 0)
			ya = FixedData.BALL_ACCELEARTION;
		if (y + ya > FixedData.HEIGHT - FixedData.BALL_LENGTH)
				engine.gameOver();
//		if(collision()) {
//			y = engine.getPaddle().getY()-FixedData.BALL_LENGTH;
//		}
		collision();
		x = x + xa;
		y = y + ya;
	}
	
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,FixedData.BALL_LENGTH,FixedData.BALL_LENGTH);
	}
	
	public boolean collision() {
		boolean isCollided = false;
		if(!engine.getPaddle().getBounds().intersects(getBounds())) {
			isCollided = false;
			
		}
		else if(engine.getPaddle().getBounds().intersects(getBounds())) {
			ya = -FixedData.BALL_ACCELEARTION;
			y = engine.getPaddle().getY()-FixedData.BALL_LENGTH;
			isCollided = true;
			
		}

		return isCollided;
		
	}
	
	
	public int getX() {
		return x;
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
	public int getXa() {
		return xa;
	}
	public void setXa(int xa) {
		this.xa = xa;
	}
	public int getYa() {
		return ya;
	}
	public void setYa(int xy) {
		this.ya = xy;
	}
	
	
}
