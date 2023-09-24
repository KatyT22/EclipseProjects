package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	Game game;

	//Constructor
	public KeyInput(Game game) {
		// TODO Auto-generated constructor stub
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e){
        game.keyPressed(e);
    }

    public void keyReleased(KeyEvent e){
        game.keyReleased(e);
    }

}
