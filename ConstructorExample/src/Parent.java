
public class Parent {
	String name;
	public Parent()
	{
		this("John");
		System.out.println("DC of Parent");
	}

	public Parent(String name) {
		System.out.println("PC of Parent");
		this.name = name;
	}
	
	

}
