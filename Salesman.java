import java.util.Scanner;

class SalesAmountOutOfRangeException extends Exception {
    public SalesAmountOutOfRangeException(String message) {
        super(message);
    }
}

public class Salesman {
    private String name;
    private int salesmanCode;
    private double salesAmount;
    private double commission;

    public Salesman(String name, int salesmanCode, double salesAmount) throws SalesAmountOutOfRangeException {
        if (salesAmount < 0) {
            throw new SalesAmountOutOfRangeException("Sales amount cannot be negative");
        }
        this.name = name;
        this.salesmanCode = salesmanCode;
        this.salesAmount = salesAmount;
        calculateCommission();
    }

    private void calculateCommission() {
        if (salesAmount < 2000) {
            commission = salesAmount * 0.08;
        } else if (salesAmount >= 2000 && salesAmount <= 5000) {
            commission = salesAmount * 0.10;
        } else {
            commission = salesAmount * 0.12;
        }
    }

    public void displayCommission() {
        System.out.println("Commission for salesman " + name + " with code " + salesmanCode + " is: $" + commission);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter salesman name: ");
        String name = scanner.nextLine();

        System.out.print("Enter salesman code: ");
        int code = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter sales amount: ");
        double salesAmount = scanner.nextDouble();

        try {
            Salesman salesman = new Salesman(name, code, salesAmount);
            salesman.displayCommission();
        } catch (SalesAmountOutOfRangeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
