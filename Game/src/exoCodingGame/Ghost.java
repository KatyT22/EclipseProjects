package exoCodingGame;

import java.util.Random;

public class Ghost {
	
	// Déclarations possible
	 char [] c1 = new char [5];
	 char [] c2 = {'h', 'e', 'l', 'l', 'o'};
	 char [] c3 = new char [] {'h', 'e', 'l', 'l', 'o'};
	 String [] s1 = new String [4];
	 String [] s2 = {"blue", "red", "orange", "black"};
	 
	
	/*String [] colorTab = {"white", "purple", "red", "yellow"};
	Random rand = new Random();
	
	int index = rand.nextInt(colorTab.length);
	
	
	

	public Ghost() {
		// TODO Auto-generated constructor stub
	}
	
	
	private Object color;

	public Object getColor() {
		color = colorTab[index];
	    return color;
	}*/
	
	
	/*
	 * Another method
	 */
	//public class Ghost {

    String [] colorTab = {"white", "yellow", "purple", "red"};
    
    int index = (int) (Math.random() * colorTab.length);

    private Object color;

    public Object getColor() {
        color = colorTab[index];
        return color;
    }
}
	


