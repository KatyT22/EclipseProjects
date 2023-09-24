package main;

import java.awt.Rectangle;

public class GameObject {

	public int x, y;
	
	public GameObject(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	
	//return the respective coordinate
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	//set a new value to x and y
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	/*This method returns the area that the object covers 
	on the playing field, so that you can determine 
	if two objects collide with each other or no*/
	public Rectangle getBounds(int x, int y){
		return new Rectangle(x, y, 64, 64);
	}

}
