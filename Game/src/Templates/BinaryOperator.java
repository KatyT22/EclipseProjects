package Templates;

public class BinaryOperator {

	public BinaryOperator() {

	}
	

	private int op1;
	private int op2;
	
	public int getOp1() {
		return op1;
	}
	public void setOp1(int op1) {
		this.op1 = op1;
	}


	public int getOp2() {
		return op2;
	}


	public void setOp2(int op2) {
		this.op2 = op2;
	}

	int shift(int op1, int op2){
		int result = op1>>op2;
		return result;
	}
	
	

}
