package exoCodingGame;

import java.util.Arrays;

public class RecursiveSearch {

	public RecursiveSearch() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean find(int [] ints, int k){
		boolean res = false;
		int index = 0;
		
		if(ints != null){
			res = this.find2(ints, k, index);
		}
		
		return res;
	}
	
	private boolean find2(int [] ints, int k, int index){
		boolean res = false;
		
		if(index < ints.length){
			if(ints[index] != k){
				
				index+=1;
				res = this.find2(ints, k, index);
			}else{
				
				return true;
				
			}
		}
		
		
		return res;
	}
	
	
	public int countMultiple(int [] ints, int k){
		int res = 0;
		int index = 0;
		
		if(ints != null){
			res = this.countMultiple2(ints, k, index, res);
		}
		
		return res;
	}
	
	private int countMultiple2(int [] ints, int k, int index, int res){
		
		if(index < ints.length){
			if(ints[index] != k){
				index+=1;
				res = this.countMultiple2(ints, k, index, res);
			}else{
				res+=1;
				index+=1;
				res = this.countMultiple2(ints, k, index, res);
			}
		}
		return res;
	}
	
	
	public int [] sumPair(int [] ints, int k){
		
		int [] res = new int[2];
		
		for(int i=0; i<ints.length; i++){
			for (int j=i; j<ints.length; j++){
				if(i!=j){
					if(ints[i]+ints[j] == k){
						
						res[1]=ints[i];
						res[0]=ints[j];
						
						return res;
					}
				}
			}
		}
	
		
		return res;
	}
	

}
