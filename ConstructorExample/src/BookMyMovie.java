
public class BookMyMovie {
	private int movieId;
	private int noOfTickets;
	private double discount;
	private double totalAmount;

	public BookMyMovie(int movieId, int noOfTickets) {
		super();
		this.movieId = movieId;
		this.noOfTickets = noOfTickets;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void calculateDiscount() {
		if (getNoOfTickets() < 5) {
			this.setDiscount(0);
		}
		if ((getMovieId() == 101 || getMovieId() == 103) && (getNoOfTickets() >= 5 && getNoOfTickets() < 10)) {
			this.setDiscount(15);
		}
		if ((getMovieId() == 101 || getMovieId() == 103) && (getNoOfTickets() >= 10 && getNoOfTickets() <= 15)) {
			this.setDiscount(20);
		}
		if ((getMovieId() == 102) && (getNoOfTickets() >= 10 && getNoOfTickets() <= 15)) {
			this.setDiscount(10);
		}
		if ((getMovieId() == 102) && (getNoOfTickets() >= 10 && getNoOfTickets() <= 15)) {
			this.setDiscount(15);
		}
	}

	public String calculateTicketAmount() {
		if(getMovieId() != 101 && getMovieId() != 102 && getMovieId()!=103) {
			return "Sorry! Invalid Movie ID! Please check the Movie ID and enter once again.";
		}
		calculateDiscount();
		int baseFare = 0;
		if (this.getMovieId() == 101) {
			baseFare = 120;
		} else if (this.getMovieId() == 102) {
			baseFare = 170;
		} else if (this.getMovieId() == 103) {
			baseFare = 150;
		}
		double amount = baseFare * noOfTickets - (baseFare * noOfTickets * (discount / 100));
		return "(For BookMyMovie " + getMovieId() + "): Total amount for booking: " + amount;
	}

}