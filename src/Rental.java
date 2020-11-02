class Rental {

	private Movie movie; // 租赁的影片
	private int daysRented; // 租赁时长

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	/** 租赁费用 */
	public double getCharge() {
		return movie.getCharge(daysRented);
	}

	/** 积分 */
	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(daysRented);
	}
}
