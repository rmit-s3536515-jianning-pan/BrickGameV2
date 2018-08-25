package view;

import java.awt.Color;
import java.awt.Graphics2D;

import controller.GameEngine;
import model.Ball;
import model.Brick;
import model.FixedData;
import model.Paddle;

public class SimpleGameView implements RenderInterface {
	
//	private Ball ball;
//
//	private Brick[][] brick;
//
//	private Paddle paddle;
	private GameEngine engine;
	
//	public SimpleGameView(Ball ball ,Paddle paddle,Brick[][] brick) {
//		this.ball = ball;
//		this.paddle = paddle;
//		this.brick = brick;
//
//	}
	
	public SimpleGameView(GameEngine engine) {
		this.engine = engine;
	}
	
	
	@Override
	public void render(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
		//draw brick first 
		

		for(int i =0; i<engine.getBrick().length;i++) {
		
		
			for(int j =0; j<engine.getBrick()[i].length; j++) {
				if(engine.getSingleBrick(i, j)==null) {
					continue;
				}
				g2d.setColor(Color.BLACK);
				g2d.drawRect(engine.getSingleBrick(i, j).getX(), engine.getSingleBrick(i, j).getY(), FixedData.BRICK_WIDTH, FixedData.BRICK_HEIGHT);
				g2d.setColor(Color.WHITE);
				g2d.fillRect(engine.getSingleBrick(i, j).getX(), engine.getSingleBrick(i, j).getY(), FixedData.BRICK_WIDTH, FixedData.BRICK_HEIGHT);
				
			}
		}
		
		
		
		
		
		g2d.setColor(Color.red);
		g2d.fillRect(engine.getPaddle().getX(), engine.getPaddle().getY(), FixedData.RAQ_WIDTH,FixedData.RAQ_HEIGHT);
		
		g2d.setColor(Color.blue);
		g2d.fillOval(engine.getBall().getX(),engine.getBall().getY(),FixedData.BALL_LENGTH, FixedData.BALL_LENGTH);
		
		
		
//		for(Brick b : brick) {
//			g2d.setColor(Color.BLACK);
//			g2d.fillRect(b.getX(), b.getY(), FixedData.BRICK_WIDTH, FixedData.BRICK_HEIGHT);
//		}
	}	
}
