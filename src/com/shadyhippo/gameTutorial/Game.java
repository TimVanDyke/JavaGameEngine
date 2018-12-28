package com.shadyhippo.gameTutorial;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

import com.shadyhippo.gameTutorial.entity.mob.Player;
import com.shadyhippo.gameTutorial.graphics.Screen;
import com.shadyhippo.gameTutorial.input.Keyboard;
import com.shadyhippo.gameTutorial.map.Map;
import com.shadyhippo.gameTutorial.map.RandomMap;
import com.shadyhippo.gameTutorial.map.SpawnMap;
//test
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static int width = 16 * 19;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	private String title = "ChernoTutorial";
	
	private Thread thread;
	private JFrame frame;
	
	private boolean running = false;
	private Keyboard key;
	private Map map;
	private Player player;
	private Screen screen;
	private int clock;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		
		frame = new JFrame();
		frame.setTitle(title);
		key = new Keyboard();
		map = new SpawnMap("/textures/map.png");
		player = new Player(256, 256, key);
		addKeyListener(key);
		clock = 0;
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0; 
		int updates = 0; 
		requestFocus();
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();		//capping updates at 60 / second
				updates++;
//				render();		//capping frames at 60 / second
//				frames++;
				clock++;
				if (clock == 60) clock = 0;
				delta--;
			}
//			update();			//uncapped updates 
//			updates++;
			render();			//uncapped framerate
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + " | FPS: " + frames + " | Updates: " + updates);
				updates = 0;
				frames = 0;
			}
		}
	}
	
	public void update() {
		key.update();
		player.update();
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		int spriteIndex = 1;
		
		if (clock < 60) spriteIndex = 4;
		if (clock < 45) spriteIndex = 3;
		if (clock < 30) spriteIndex = 2;
		if (clock < 15) spriteIndex = 1;
				
		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		map.renderMap(xScroll, yScroll, screen, spriteIndex);
		player.render(screen);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 20));
		g.drawString("" + player.x + ", " + player.y, height / 2, width / 2);
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(true);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
}
