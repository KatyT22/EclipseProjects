package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Starter {

    Font fnt0 = new Font("Comics", Font.BOLD, 25);          
    public void render(Graphics g) {                        
        g.setFont(fnt0);                                    
        g.setColor(Color.BLACK);                            
        g.drawString("Press Enter to start", 205, 220);     
    }

}
