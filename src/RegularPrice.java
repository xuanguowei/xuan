/** 普通影片价格类 */
public class RegularPrice extends Price {

	public int getPriceCode() {
		return Movie.REGULAR;
	}

	public double getCharge(int daysRented) {
		double result = 2; // 租期不超过2天，收2元
		if (daysRented > 2) // 租期超过2天，每超1天多收1.5元
			result += (daysRented - 2) * 1.5;
		return result;
	}
}
