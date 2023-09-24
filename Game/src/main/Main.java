package main;

import java.util.Scanner;

import Templates.Investor;
import Templates.Project;
import Templates.Solution;
import Templates.TableauDeBord;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution.computeClosestToZero2(5526);
		System.err.println("1*********************************************");
		Solution.findNode();
		System.err.println("2*********************************************");
		Solution.largestNumber();
		System.err.println("3*********************************************");
		Solution.nextPosition();
		System.err.println("4*********************************************");
		Solution.ascii();
		System.err.println("5*********************************************");
		Solution.parentesis();
		System.err.println("6*********************************************");
		Solution.reverseString();
		System.err.println("7*********************************************");
		Solution.reverseInteger();
		System.err.println("8*********************************************");
		Solution.search();
		System.err.println("9*********************************************");
		Solution.sortPackages();
		System.err.println("10*********************************************");
		Solution.billet();
		System.err.println("11*********************************************");
		Solution.handleQueue();
		System.err.println("12*********************************************");
		Solution.merge();
		System.err.println("13*********************************************");
		Solution.removeElement();
		
		 Scanner scanner = new Scanner(System.in);
		
		 System.out.println( "Entrez votre capital � investir" );
	        int capital = Integer.parseInt(scanner.nextLine());
	        
	        Investor myInvestor = new Templates.Investor(capital);
	        
	        TableauDeBord monTableau = new TableauDeBord(myInvestor);
	        
	        monTableau.investissementSimulation(24, 20, 6, 10, 48);
	        
	     
	}

}
