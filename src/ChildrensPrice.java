/** 儿童影片价格类 */
public class ChildrensPrice extends Price {
	
	public int getPriceCode() {
		return Movie.CHILDRENS;
	}

	public double getCharge(int daysRented) {
		double result = 1.5; // 租期不超过3天，收1.5元
		if (daysRented > 3) // 租期超过3天，每超1天多收1.5元
			result += (daysRented - 3) * 1.5;
		return result;
	}
}
