public abstract class Price {
	public abstract int getPriceCode();

	/** 租赁费用 */
	public abstract double getCharge(int daysRented);

	/** 积分 */
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
}
