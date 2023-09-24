package exoCodingGame;

public class Node {

	int value;
	Node left;
	Node right;
	
	public Node(int value, Node left, Node right) {
		// TODO Auto-generated constructor stub
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public Node(){
		
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
	
	public static Node beginNode = n1;
	
	public int getValue(){
		return this.value;
	}
	
	public Node findNode(int v){
		Node tmpNode = null; 
		
		if(this.value != v){
			
			
			if(this.left != null){
				tmpNode = this.left.findNode(v);
				
			}	
			if(tmpNode == null){
				if(this.right != null){
				tmpNode = this.right.findNode(v);
					
				}
			}
		
		}else
		{
			tmpNode = this;
			
		}
		
		return tmpNode;
	}

}
