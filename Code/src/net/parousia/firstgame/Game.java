package net.parousia.firstgame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static int width  = 300;
	public static int height = width * 9 / 16;
	public static int scale  = 3;
	
	public Dimension size = new Dimension(width * scale, height * scale);
	private Thread thread;
	private JFrame frame;
	private static boolean isRunning = false;
	public static String name = "First Platformer";
	
	
	public Game(){
		frame = new JFrame();
		setPreferredSize(size);
	}
	
	public synchronized void start(){
		isRunning = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop (){
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(name);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();
	}
	
	public void update(){
		
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.dispose();
		bs.show();
		
	}
	
	public void run(){
		while(isRunning){
			update();
			render();
		}
	}
}
