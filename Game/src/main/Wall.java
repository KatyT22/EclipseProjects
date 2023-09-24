package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Wall extends GameObject implements Entity {

	private BufferedImage wall;
	private double velY = 1;
	
	Random random;
	int rand;
	
	public Wall(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			wall = loader.loadImage("brickwall.png");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		random = new Random();
		rand = random.nextInt(10);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		y = y+(int)velY;
		
		if(y >= Game.HEIGHT){
			y = 0;
			rand = random.nextInt(10);
			setVelY(velY + 0.5);
			Counter.count++;
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

		for (int i = 0; i < Game.FACTOR; i++){
			if(i != rand && i != rand+1){
				g.drawImage(wall, x + 64 * i, y, null);
			}
		}
	}
	
	public void setVelY(double velY){
		this.velY = velY;
	}
	
	/*We create an ArrayList that we fill with rectangles. 
	 * Each rectangle is a "part of the wall" 
	 * (total 10 pieces - 2 holes) By creating 
	 * margins we can easily see if a wall collides with 
	 * the player = Game Over, using the built-in function 
	 * "intersect" that investigates whether 
	 * two rectangles intersect.*/
	
	private ArrayList<Rectangle> getRectangleWall(){
		ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
		for (int i = 0; i < Game.FACTOR; i++){
			if(i != rand && i != rand+1){
				rectangles.add(getBounds(64 * i, y));
			}
		}
		return rectangles;
	}
	
	public boolean collision(Rectangle rectanglePlayer){
		for(Rectangle rec : getRectangleWall()) {                       
            if (rectanglePlayer.intersects(rec)) {                      
                return true;
            }
        }
		return false;
	}
}
