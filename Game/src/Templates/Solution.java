package Templates;

import java.awt.peer.SystemTrayPeer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.naming.NamingException;

class Node {

	int value;
	Node left;
	Node right;
	
	Node(int value, Node left, Node right) {
		// TODO Auto-generated constructor stub
		this.value = value;
		this.left = left;
		this.right = right;
	}
}


class Dance{
	int position;
	int stage;
	
	Dance(int position, int stage){
		this.position=position;
		this.stage=stage;
	}
	
}

class LimitedQueue {
	private int limit;
	private Queue<Object> myQueue;
	
	public LimitedQueue(int n) {
		// TODO Auto-generated constructor stub
		this.limit=n;
		myQueue = new ArrayDeque<Object>();
	}
	
	public void add(Object o) {
		// TODO Auto-generated method stub
		if(size()<getLimit()){
			myQueue.add(o);
		}else{
			remove();
			myQueue.add(o);
		}
	}
	
	private Object remove() {
		// TODO Auto-generated method stub
		//if(!myQueue.isEmpty()){
			return myQueue.poll();
		//}
			
	}
	
	private int getLimit() {
		return limit;
	}
	
	private int size() {
		// TODO Auto-generated method stub
		return myQueue.size();
	}
	
}

public class Solution {

	        // Write your code here
	        // To debug: System.err.println("Debug messages...");
	        
		 /**Find the temperature closest to zero among a list of temperatures
		  * if the list is empty, return O
		  * if two temperatures are found to be closest to zero (ex. -5 & 5) return the positive temperature
		  * 

			*
			*Result is correct with a simple data set: {7 5 9 1 4} -> 1
			Problem solving+70 pts
			It works with -273 alone
			Problem solving+20 pts
			It works with 5526 alone
			Problem solving+20 pts
			It works when inputs contains only negative numbers: : {-15 -7 -9 -14 -12} -> -7
			Problem solving+35 pts
			It works with two negative temperatures that are equal: {-10 -10} -> -10
			Problem solving+35 pts
			The solution displays 0 if no temperature
			Problem solving+35 pts
			When two temperatures are as close to 0, then the positive wins: {15 -7 9 14 7 12} -> 7
			Problem solving+85 pts
		  */
		 	
	 public static int computeClosestToZero2(int... ts) {
		 int resultNeg = Integer.MIN_VALUE+1;
		 int resultPos = Integer.MAX_VALUE;
		 int result = 0;
		 if(ts.length>0){
			 for(int item:ts){
				 System.err.println("item = "+item);
				 if(item<0){
					 
					 resultNeg = Math.max(item, resultNeg);
				 }
				 if(item>0){
					 resultPos = Math.min(item, resultPos);
				 }
			 }
			 result = (Math.abs(resultNeg)<resultPos)?resultNeg:resultPos;
		 }
		  
		 System.err.println("result ="+result);
		return result;
		 
	 }
	 
	 
	 /***
	  * a node is -> left node - number - right node 
	  * find if a number exist in the node
	  * @return
	  */
	
	
	private static boolean result = false;
	private static boolean findNode(Node n, int number){
		 if (number == n.value){
			 Solution.result = true;
			 System.err.println(n.value + " -> " +Solution.result);
			 return Solution.result;
		 }
		
		 if((n.left != null)){
			 findNode(n.left, number);
			 if(Solution.result)
				 return true;
		 }
		 if(n.right != null){
			 findNode(n.right, number);
			 if(Solution.result)
				 return true;
		 }
		 System.err.println(n.value + " -> " +Solution.result);
		 return Solution.result;
		
	}
	
	static Node n10 = new Node(43, null, null);
	static Node n9 = new Node(52, null, null);
	static Node n8 = new Node(-9, null, null);
	static Node n7 = new Node(29, null, null);
	static Node n6 = new Node(1, null, null);
	static Node n5 = new Node(5, null, n10);
	static Node n4 = new Node(6, n8, n9);
	static Node n3 = new Node(8, n6, n7);
	static Node n2 = new Node(13, n4, n5);
	static Node n1 = new Node(9, n2, n3);
	
	public static void findNode(){
		findNode(n1, 43);
	}
	
	/**
	 * Return the largest number from the array, the array always contains one number.
	 * @param ts
	 * @return
	 */
	private static int largestNumber(int... ts){
		Arrays.sort(ts);
		return ts[ts.length-1];
	}
	
	static int [] tab = {5, 10, -2, 85, 45, 12, 1, 53, 23, 10, 0, 3, 36, 54, 78, -9, 78, -89, -20, 13, -8, -5, -3, 78, 45, 50};
	public static void largestNumber(){
		int number = largestNumber(tab);
		System.err.println("result -> " +number);		
	}
	 
	 /**
	  * find position after n movements
	  * 
Introduction


This dance asks every performer to follow a precise sequence of steps:

� Stage 0 : First, get away from obstacles by setting up your starting point at position 0

� Stage 1 : Take one step forward (+1 step)

� Stage 2 : Take two steps backward (-2 steps)

� To follow, the steps as well as the direction you will have to take in your next move will each time be obtained thanks to a specific calculation:
 the number of steps you took on the previous stage minus the number of steps you took on the penultimate stage.

That is, on stage 3, a dancer will have to take 3 steps backwards (-2 - 1).

At stage 3, the dancer is at position -4.

    stage(n) = stage(n-1) - stage(n-2)

    pos(n) = pos(n-1) + stage(n)

    At stage 4, the dancer is at position -5.
    at stage 5, the dancer is in position -3

	  */
	
	private static int nextPosition(int stage){
		
		Dance[] myDance = {new Dance(1, 1), new Dance(-1, 2), new Dance(-4, 3), new Dance(-5, 4), new Dance(-3, 5), new Dance(0, 6)}; 
		
		int pos = 0;
		if(stage>0)
			pos = myDance[((stage%6==0)?6:stage%6)-1].position;
		
		System.err.println("stage ->"+stage+": position ->"+ pos);
		return pos;
		
	}
	
	public static void nextPosition(){
		for(int i=0; i<17; i++)
			nextPosition(i);
	}
	/**
	 * Ascii
	 * 

Line 1: the width L of a letter represented in ASCII art. All letters are the same width.

Line 2: the height H of a letter represented in ASCII art. All letters are the same height.

Line 3: The line of text T, composed of N ASCII characters.

Following lines: the string of characters ABCDEFGHIJKLMNOPQRSTUVWXYZ? Represented in ASCII art.
Output
The text T in ASCII art.
The characters a to z are shown in ASCII art by their equivalent in upper case.
The characters that are not in the intervals [a-z] or [A-Z] will be shown as a question mark in ASCII art.
Constraints
0 < L < 30
0 < H < 30
0 < N < 200

	 */
	
	public static void ascii(){
		
		 //Read inputs.
        Scanner scanner = new Scanner(System.in);
        
        int L = 4/*Integer.parseInt(scanner.nextLine())*/;
        int H = 5/*Integer.parseInt(scanner.nextLine())*/;
        String T = "CHERI"/*scanner.nextLine().toUpperCase()*/;
        String myWord = "";
        //Define index for non alphabetic chars.
        final int unknownCharIndex = 'Z' - 'A' + 1;
        
        for (int i = 0; i < H; i++)
        {
            //String asciiLine = scanner.nextLine();
        	String asciiLine1 = " #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ###  ## ";
	        String asciiLine2 = "# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   # # # ";
	        String asciiLine3 = "### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   #  ";
	        String asciiLine4 = "# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       ";
	        String asciiLine5 = "# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #  ";
	        
	        String [] tab = {asciiLine1, asciiLine2, asciiLine3, asciiLine4, asciiLine5};
            //parcours caract�re par carcat�re du 1er au dernier caract�re du mot dans T
            for (int j = 0; j < T.length(); j++)
            {
                //Get ASCII index of current char. //position de la lettre dans l'alphabet
                int charIndex = T.charAt(j) - 'A';
                boolean isLetter = Character.isLetter(T.charAt(j));
                int letterIndex = isLetter ? charIndex : unknownCharIndex;
                System.out.print("letterIndex -> "+letterIndex);
                //Get ASCII line of current char.
                String asciiPart = tab[i].substring(letterIndex * L, (letterIndex + 1) * L);
                
                //Print ASCII line part.
                System.out.print(asciiPart);
                myWord = myWord+asciiPart;
            }
            System.out.println();
            myWord = myWord+"\n";
        }
        System.out.println(myWord);
        
        String s = "CHAT";
        for(int i=0; i<5;i++){
	        String asciiLine1 = " #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ###";
	        String asciiLine2 = "# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   #";
	        String asciiLine3 = "### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ##";
	        String asciiLine4 = "# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #";
	        String asciiLine5 = "# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  # ";
	        
	        String [] tab = {asciiLine1, asciiLine2, asciiLine3, asciiLine4, asciiLine5};
			int c = s.charAt(0)-'A';
			String asciiPart = tab[i].substring(c * 4, (c + 1) * 4);
			System.out.print(asciiPart);
			int h = s.charAt(1)-'A';
			asciiPart = tab[i].substring(h * 4, (h + 1) * 4);
			System.out.print(asciiPart);
			int a = s.charAt(2)-'A';
			asciiPart = tab[i].substring(a * 4, (a + 1) * 4);
			System.out.print(asciiPart);
			int t = s.charAt(3)-'A';
			asciiPart = tab[i].substring(t * 4, (t + 1) * 4);
			System.out.print(asciiPart);
			System.out.println();
        }
		
    }
	

	/**
	 * Dire si l'expression donn�e en entr� est bien parenthes�.
	 * Une expression est bien parenth�s�e si les parenth�ses (), les crochets [] et les accolades {} sont bien appair�s.
	 * L'expression de contient pas d'espace.
	 * @param first
	 * @param second
	 * @return
	 */
	private static boolean paire(char first, char second){
		switch(first){
		case '(':
			if (second ==')')
				return true;
		break;
		case '[':
			if (second ==']')
				return true;
			break;
		case '{':
			if (second =='}')
				return true;
			break;
		default:
			break;
		}
		return false;
	}
		
	private static boolean parentesis(String expression){
		
		Stack<Object> bacASable = new Stack<>();
		
		
		for(int i=0; i<expression.length(); i++){
			
			if(!bacASable.isEmpty() && paire((char) bacASable.peek(),expression.charAt(i)))
				bacASable.pop();
			else
				bacASable.push(expression.charAt(i));
			
		}
		return bacASable.isEmpty()?true:false;
	}
	
	public static void parentesis(){
		String exp = "(()[]){}";
		System.out.println("parentesis(\""+exp+"\") -> "+parentesis(exp));
	}
	
	/**
	 * reverse string
	 * @param s
	 * @return
	 */
	private static String reverse(String s){
		String newS = "";
		for(int i=s.length()-1; i>=0; i--)
		{
			newS=newS+s.charAt(i);
		}
		return newS;
	}
	
	public static void reverseString(){
		String exp="je t'aime mon Gillou";
		System.out.println("reverse(\""+exp+"\") -> "+reverse(exp));
	}
	
	private static List<Integer> reverse(List<Integer> tab){
		Collections.reverse(tab);
		return tab;
	}
	
	public static void reverseInteger(){
		List l = new ArrayList<>();
		l.add(5);
		l.add(9);
		l.add(52);
		System.out.println("reverseInteger before"+l.toString());
		reverse(l);
		System.out.println("reverseInteger after"+l.toString());
	}
	
	/**
	 * search in tab
	 * @param i
	 * @param tab
	 * @return
	 */
	private static int search(int i, int... tab){
		Arrays.sort(tab);
		Collections.reverseOrder();
		return Arrays.binarySearch(tab, i);
	}
	public static void search(){
		System.out.println("search : index ->"+search(5, new int[] {5, 10, -2, 85, 45, 12, 1, 53, 23, 10, 0, 3, 36, 54, 78, -9, 78, -89, -20, 13, -8, -5, -3, 78, 45, 50}));
	}
	
	/**
	 * Write the function that will dispatch the packages to the correct stack according to their volume and mass
	 * A package is Bulky if its volume (width x height x length) is greater than 1,000,000 cm3 or when one of its dimension is greater or equal to 150 cm.
	 * A package is heavy when  its mass is greater or equal to 20kg.
	 * Standard -> nor bulky nor heavy
	 * Special -> bulky or heavy
	 * Rejected -> bulky and heavy
	 * @param width
	 * @param height
	 * @param length
	 * @param mass
	 * @return
	 */
	private static String sortPackages(int width, int height, int length, int mass){
		boolean bulky = ((width*height*length)>1000000) || (width>=150) || (height >= 150) || (length>=150);
		boolean heavy = mass >= 20;
		return (bulky && heavy)?"REJECTED":((bulky || heavy)?"SPECIAL":"STANDARD");
	
	}
	public static void sortPackages(){
		int w= 15;
		int h=460;
		int l=75;
		int m= 20;
		System.out.println("sortPackages("+w+","+h+","+l+","+m+") -> "+sortPackages(w, h, l, m));
	}
	
	/**
	 * 
	 * @param somme
	 */
	
	private static void billet(int somme){
		int reste=0;
		int centaine=0;
		int cinquantaine=0;
		int vingtaine =0;
		int dizaine=0;
		int biUnite=0;
		
		if(somme>=100){
			reste = somme %100;
			centaine = (somme-reste)/100;
			somme= reste;
		}
		if(somme>=50){
			reste = somme %50;
			cinquantaine = (somme-reste)/50;
			somme= reste;
		}
		if(somme>=20){
			reste = somme %20;
			vingtaine = (somme-reste)/20;
			somme= reste;
		}
		if(somme>=10){
			reste = somme %10;
			dizaine = (somme-reste)/10;
			somme= reste;
		}
		if(somme<10)
			reste=somme%2;
		biUnite =(somme-reste)/2;
		
		System.out.print(centaine+"-"+cinquantaine+"-"+vingtaine+"-"+dizaine +"-"+biUnite);
	}
	
	public static void billet(){
		int n=543;
		System.out.println("billet("+n+")");
		billet(n);
	}
	
	public static void handleQueue(){
		LimitedQueue lq = new LimitedQueue(20);
		for(int i=0; i<25; i++){
			lq.add(i);
		}
		
	}
	
	/**
	 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 * @return
	 */
	  private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
	        for(int i=m; i<nums1.length; i++){
	            nums1[i]=nums2[i-m];           
	        }
	        Arrays.sort(nums1);
	        return nums1;
	    }
	  
	  public static void merge(){
		  int [] result = merge(new int[] {1,2,3,0,0,0,}, 3, new int[] {2,5,6}, 3);
		  
		  System.out.println("Merge->"+result.toString());
	  }
	  
	  private static int removeElement(int[] nums, int val) {
	        int finalSize=nums.length;
		  	for(int i=0; i<finalSize; i++){
	        	if(nums[i]==val){
	        		for(int j=i; j<finalSize-1; j++){
	        			nums[j]=nums[j+1];
	        		}
	        		i--;
	        		finalSize--;
	        	}
	        }
	        return finalSize;
	  }
	  
	  public static void removeElement(){
		  int result = removeElement(new int[]{4,6,4,4,8,9,7,254,63,47,5,4,2,1,3,4}, 4);
	  }
	
	/**
	 * Dire si deux chaines de caract�res on les m�mes caract�res
	 *  
	 */
	
	private static void tryEverything() throws NamingException{
		try{
			
		}catch (Exception e) {
			// TODO: handle exception
		
		}
	}
	
	
	
	
	
}
