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
        Enumeration rentals = _rentals.elements();
        String result = "Прокат " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // Вывод результатов для каждого проката
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // Добавление колонтитула
        result += "Сумма задолженности: " + String.valueOf(getTotalCharge()) + "\n";
        result += "Вы заработали" + String.valueOf(getTotalFrequentRenterPoints()) + " бонусных очков";
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<H1>Прокат <EM>" + getName() + "</EM></H1><P>\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }

        result += "<P>Сумма задолженности <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "Вы заработали <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> бонусных очков<P>";
        return result;
    }

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
