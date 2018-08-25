package model;

import java.awt.Rectangle;

public class Paddle {

	private int x = FixedData.RAQ_X;
	private int y = FixedData.RAQ_Y;
	private int xa = 0;
	
	
	
	
	
	
	public Paddle() {
		super();
		
	}
	
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,FixedData.RAQ_WIDTH,FixedData.RAQ_HEIGHT);
	}
	
	public void move() {
		if(x+xa >0 && x+xa <FixedData.WIDTH-FixedData.RAQ_WIDTH) {
			x = x+xa;
		}
	}

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getXa() {
		return xa;
	}


	public void setXa(int xa) {
		this.xa = xa;
	}
	
	public int getY() {
		return y;
	}
	
	
	
	

	
	
	
}
