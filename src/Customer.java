import java.util.ArrayList;

class Customer {

	private String name; // 客户名
	private ArrayList<Rental> rentals = new ArrayList<Rental>(); // 客户的租赁

	public Customer(String name) {
		this.name = name;
	};

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	};

	public String statement() {
		String result = "Rental Record for " + getName() + "\n";

		// 显示每个租赁的详情
		for (Rental each : rentals)
			result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";

		// 显示客户的总费用和获得的积分
		result += "Amount owed is " + getTotalCharge() + "\n";
		result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
		return result;
	}

	/** 计算总费用 */
	private double getTotalCharge() {
		double result = 0;
		for (Rental rental : rentals)
			result += rental.getCharge();
		return result;
	}

	/** 计算积分 */
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		for (Rental rental : rentals)
			result += rental.getFrequentRenterPoints();
		return result;
	}

	public String htmlStatement() {
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";

		// show figures for each rental
		for (Rental each : rentals)
			result += each.getMovie().getTitle() + ": " + each.getCharge() + "<BR>\n";

		// add footer lines
		result += "<P>You owe <EM>" + getTotalCharge() + "</EM><P>\n";
		result += "On this rental you earned <EM>" + getTotalFrequentRenterPoints() + "</EM> frequent renter points<P>";
		return result;
	}
}
