package main;

import java.awt.Graphics;

public interface Entity {
	//Contains everything that should happen with each update
	public void tick();
	/*Contains everything that causes the 
	objects to be drawn on the playing field 
	at the correct position*/
	public void render(Graphics g);
}
