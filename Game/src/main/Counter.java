package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Counter  {

	/*Creates a new font with a counter 
	that all classes can access*/
	Font fnt0 = new Font("Comics", Font.BOLD, 20);
	public static int count = 0;

	// Draws the value of count 
    public void render(Graphics g) {                            
        g.setFont(fnt0);                                        
        g.setColor(Color.BLACK);
        
        //Draw count on position (x=10, y=30)                              
        g.drawString(Integer.toString(count), 10, 30);          
    }
     //If methods reset is used --> reset counter
    public void reset(){                                       
        this.count = 0;
    }

}
