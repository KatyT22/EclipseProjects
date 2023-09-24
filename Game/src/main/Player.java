package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends GameObject implements Entity {

	private BufferedImage hero;
	private double velX;
	private double velY;
	
	public Player(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			hero = loader.loadImage("superhero.png");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if(x <= 0){
			x = 0;
		}
		
		if(x >= Game.WIDTH-64){
			x = 640-64;
		}
		
		if(y <= 0){
			y = 0;
		}
		
		if(y >= Game.HEIGHT-64){
			y = (int) Game.HEIGHT-64;
		}
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(hero,  x,  y,  null);
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int) x, (int) y, 64, 64);
	}
	
	public void setVelX(double velX){
		this.velX = velX;
	}
	
	public void setVelY(double velY){
		this.velY = velY;
	}

}
