import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        // double totalAmount = 0;
        // int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Прокат " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // frequentRenterPoints += each.getFrequentRenterPoints();

            // Вывод результатов для каждого проката
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            // totalAmount += each.getCharge();
        }

        // Добавление колонтитула
        result += "Сумма задолженности: " + String.valueOf(getTotalCharge()) + "\n";
        result += "Вы заработали" + String.valueOf(getTotalFrequentRenterPoints()) + " бонусных очков";
        return result;
    }

    // private double amountFor(Rental aRental) {
    //     return aRental.getCharge();
    // }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;

        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
