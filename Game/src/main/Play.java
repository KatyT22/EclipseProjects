package main;

import java.util.Arrays;

import exoCodingGame.Animal;
import exoCodingGame.CodingGame;
import exoCodingGame.Dog;
import exoCodingGame.Cat;
import exoCodingGame.Ghost;
import exoCodingGame.Node;
import exoCodingGame.Point;
import exoCodingGame.RecursiveSearch;
import exoCodingGame.Tabulation;
import exoCodingGame.TwoFer;
import exoCodingGame.Welcome;

public class Play {

	public Play() {
		// TODO Auto-generated constructor stub
	}
	public static State state = State.RESTART;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(state);
		
		
		Game game = new Game();
		KeyInput keyinput = new KeyInput(game);
		
		Counter runnable = new Counter();
		/*Thread t1 = new Thread(runnable);
		t1.start();*/
		
		
	       CodingGame exo = new CodingGame ();
	       
	       Point p = new Point('e', 2.5);
	       
	       System.out.println("\nreponse exo 1 : "+exo.calc(102));
	       System.out.println("\nreponse exo 2 : "+exo.calcSalaire(250, 10));
	       System.out.println("\nreponse exo 3 : "+p.getNom()+"; "+p.getValue());
	       System.out.println("\nreponse exo 4 : "+exo.reverse("free"));
	       Ghost g1 = new Ghost();
	       Ghost g2 = new Ghost();
	       System.out.println("\nreponse exo 4.4 :  g1 -> "+ g1.getColor()+"; g2 -> "+g2.getColor());
	       
	       TwoFer tf = new TwoFer();
	       System.out.println("\nreponse exo 4.5 : "+tf.twofer("badrada"));
	       
	       
	       //for static use class name directly
	       System.out.println("\nreponse exo 4.6 : "+Welcome.greet("xdfs"));
	       
	       Dog a = new Dog("Sam");
	       Cat b = new Cat("Pat");
	       System.out.println("\nreponse test1 capgemini : dog a = "+a.getName()+" & dog b = "+b.getName());
	       
	       RecursiveSearch rc = new RecursiveSearch();
	       
	       int [] tab = {5, 10, -2, 85, 45, 12, 1, 53, 23, 10, 0, 3, 36, 54, 78, -9, 78, -89, -20, 13, -8, -5, -3, 78, 45, 50};
	       Arrays.sort(tab);
	       
	       int [] tab2 = null;
	       int num1 = 5;
	       int num2 = 45;
	       int num3 = -2;
	       int num4 = 50;
	       int num5 = 45;
	       int num6 = 98;
	       System.out.println("\nreponse test2 capgemini : find num1: "+num1+" in tab => "+ rc.find(tab, num1));
	       System.out.println("\nreponse test2 capgemini : find num2: "+num2+" in tab => "+ rc.find(tab, num2));
	       System.out.println("\nreponse test2 capgemini : find num3: "+num3+" in tab => "+ rc.find(tab, num3));
	       System.out.println("\nreponse test2 capgemini : find num4: "+num4+" in tab => "+ rc.find(tab, num4));
	       System.out.println("\nreponse test2 capgemini : find num5: "+num5+" in tab => "+ rc.find(tab, num5));
	       System.out.println("\nreponse test2 capgemini : find num5: "+num6+" in tab => "+ rc.find(tab, num6));
	       
	       System.out.println("\nreponse test2 capgemini : find num1: "+num1+" in tab2 => "+ rc.find(tab2, num1));
	       
	       System.out.println("\nreponse test2 capgemini : countMultiple num5: "+num5+" in tab => "+ rc.countMultiple(tab, num5));
	       
	       Arrays.toString(tab);
	       /*for(int i : tab){*/
	    	   
	    	   System.out.println("\nSorted tab : "+Arrays.toString(tab));
	       /*}*/
	    	   
	    	   System.out.println("res = "+Arrays.toString(rc.sumPair(tab, num6))+"; k = "+num6);
	    	   
	    	   System.out.println("Begin Node "+Node.beginNode.getValue());
	    	   System.out.println("Found node -> value "+Node.beginNode.findNode(1).getValue()+" - Node "+Node.beginNode.findNode(1)) ;
	    	   
	    	   Tabulation t = new Tabulation();
	    	   
	    	   System.out.println("Transformation : \n"+t.transform("I love bananas."));
	    	   
	        
	}

}
