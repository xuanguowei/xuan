public class Test {

	public static void main(String[] args) {
		
		Movie movie1 = new Movie("Beautiful Mind", 0);
		Movie movie2 = new Movie("Brave Heart", 1);
		Movie movie3 = new Movie("Tom & Jerry", 2);
		
		Customer customer = new Customer("WJF");
		customer.addRental(new Rental(movie1, 2));
		customer.addRental(new Rental(movie2, 2));
		customer.addRental(new Rental(movie3, 4));
		
		System.out.println(customer.statement());
	}

}
