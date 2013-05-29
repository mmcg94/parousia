package net.parousia.firstgame;

import java.applet.*;
import javax.swing.*;
import java.awt.*;

public class Component extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	public static Dimension size = new Dimension(700,550);
	public static String name = "First Platformer";
	public static boolean isRunning = false;
	
	public Component(){
		setPreferredSize(size);
	}
	
	public void start(){
		//define objects etc
		
		//game loop
		isRunning = true;
		new Thread(this).start();
	}
	
	public void stop (){
		
	}
	
	public static void main(String args[]) {
		Component component = new Component();
		
		JFrame frame = new JFrame();
		frame.add(component);
		frame.pack();
		frame.setTitle(name);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public void run(){
		while(isRunning){
			System.out.println("Hey");
		}
	}
}
