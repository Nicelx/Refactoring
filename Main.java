 public class Main {
         public static void main(String[] args) {

            var customer = new Customer("Vasiliy");
            var customer2 = new Customer("Adam");

            var movie1 = new Movie("Avengers", 1);
            var movie2 = new Movie("Venom", 1);
            var movie3 = new Movie("Spider Mane", 1);

            var rental = new Rental(movie1, 2);
            var rental2 = new Rental(movie2, 3);
            var rental3 = new Rental(movie3, 5);

            
            customer.addRental(rental);
            customer2.addRental(rental2);
            customer2.addRental(rental3);

            System.out.println(customer.statement());
            System.out.println(customer2.statement());
            // System.out.println(customer2.htmlStatement());
         }
     }