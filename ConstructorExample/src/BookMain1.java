
public class BookMain1 {
	public static void main(String[] args) {
		BookMyMovie m1 = new BookMyMovie(104, 5);
		BookMyMovie m2 = new BookMyMovie(102, 4);
		BookMyMovie m3 = new BookMyMovie(103, 8);
		System.out.println(m1.calculateTicketAmount());
		System.out.println(m2.calculateTicketAmount());
		System.out.println(m3.calculateTicketAmount());
	}
}

