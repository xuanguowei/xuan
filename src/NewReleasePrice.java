/** 新影片价格类 */
public class NewReleasePrice extends Price {

	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	public double getCharge(int daysRented) {
		return daysRented * 3; // 每天收3元
	}

	/** 积分 */
	public int getFrequentRenterPoints(int daysRented) {
		return (daysRented > 1) ? 2 : 1; // 租赁新片且租期超过1天，获得额外1个积分
	}
}
