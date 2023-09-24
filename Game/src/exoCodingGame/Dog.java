package exoCodingGame;

public class Dog implements Animal {
	
	String name;	
	
	public Dog(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
