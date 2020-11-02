public class Movie {

	public static final int REGULAR = 0; // 普通片
	public static final int NEW_RELEASE = 1; // 新片
	public static final int CHILDRENS = 2; // 儿童片

	private String title; // 影片标题
	private Price price; // 影片价格状态

	public Movie(String title, int priceCode) {
		this.title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return price.getPriceCode();
	}

	public void setPriceCode(int arg) {
		switch (arg) {
		case REGULAR:
			price = new RegularPrice();
			break;
		case CHILDRENS:
			price = new ChildrensPrice();
			break;
		case NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public String getTitle() {
		return title;
	};

	/** 租赁费用 */
	public double getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}

	/** 积分 */
	public int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}
}
