package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Ball;
import model.Brick;
import model.FixedData;
import model.Paddle;
import view.RenderInterface;
import view.SimpleGameView;

public class GameEngine extends JPanel implements Runnable {
	
	
	private Thread t;
	private Paddle paddle;
	private Ball ball;
	private Brick[][] brick;
	
	private RenderInterface renderview;
	private boolean running = true;
	public GameEngine() {
		paddle = new Paddle();
		this.addKeyListener(new PlayerKeyListener(paddle));
		this.setFocusable(true);
		ball = new Ball(this);
		initBrick();
		renderview = new SimpleGameView(this);
		
		
	}
	
	public Brick[][] getBrick() {
		return brick;
	}
	
	
	public Brick getSingleBrick(int x, int y) {
		return brick[x][y];
	}
	
	public Ball getBall() {
		return ball;
	}
	
	

	private void initBrick() {
			brick = new Brick[FixedData.BRICK_ROW][FixedData.BRICK_COL];
		
		
		for(int i =0; i<FixedData.BRICK_ROW;i++) {
			
			
			for(int j =0; j<FixedData.BRICK_COL; j++) {
				
				brick[i][j] = new Brick(j*FixedData.BRICK_WIDTH,i*FixedData.BRICK_HEIGHT,this);
//				brick.add(new Brick(j*FixedData.BRICK_WIDTH,i*FixedData.BRICK_HEIGHT));
				
			}
		}
	}
	
	public void gameOver() {
		running = false;
		JOptionPane.showMessageDialog(this, "Game over!", "Game over" , JOptionPane.NO_OPTION);
		System.exit(ABORT);
	}
	
	public Paddle getPaddle() {
		return paddle;
	}



	public void start() {
		t = new Thread(this);
		t.start();
	}
	
	public void update() {
		ball.move();
		paddle.move();
		
		for(int i =0; i<FixedData.BRICK_ROW;i++) {
			
			
			for(int j =0; j<FixedData.BRICK_COL; j++) {
				
				if(brick[i][j]==null) continue;
				brick[i][j].update();
//				brick.add(new Brick(j*FixedData.BRICK_WIDTH,i*FixedData.BRICK_HEIGHT));
				
			}
		}
		
	}
	public void removeBrick(int x,int y) {
		for(int i =0; i<FixedData.BRICK_ROW;i++) {
			
			
			for(int j =0; j<FixedData.BRICK_COL; j++) {
				if(i==(y/FixedData.BRICK_HEIGHT) && j==x/(FixedData.BRICK_WIDTH))
				brick[i][j] = null;
//				brick.add(new Brick(j*FixedData.BRICK_WIDTH,i*FixedData.BRICK_HEIGHT));
				
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		renderview.render(g2d);
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long lastTime = System.nanoTime();
		final int FPS = 60;
		long fpstime = 0;
		int fpsCount = 0;
		final long OPTIMAL_TIME = 1000000000 / FPS;

		while(running) {
			long now = System.nanoTime();
			long elapsed = now - lastTime;
			lastTime = now;
			
			double delta = elapsed / (double)OPTIMAL_TIME;
			
			fpstime +=elapsed;
			fpsCount++;
			
			if(fpstime >=1000000000) {
				System.out.println("FPS : " + fpsCount);
				fpstime = 0;
				fpsCount = 0;
				
			}
			
			update();
			this.repaint();
			
			try {
				Thread.sleep((lastTime - System.nanoTime() + OPTIMAL_TIME)/ 1000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!running) {
				System.exit(ABORT);
			}
			
				
					
		}
		
		
	}

}
