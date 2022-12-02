
public class Child extends Parent {
	String books;
	public Child() {
		this("Books");
		System.out.println("DC of Child");
	}
	public Child(String books) {
		System.out.println("PC of child");
		this.books = books;
	}

}
