import java.util.*;

class Medicine {
    private String name;
    private String manufacturer;
    private double price;
    private int quantity;

    public Medicine(String name, String manufacturer, double price, int quantity) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters for medicine properties
}

class Pharmacy {
    private List<Medicine> inventory;

    public Pharmacy() {
        inventory = new ArrayList<>();
    }

    // Methods for managing medicine inventory
    public void addMedicine(Medicine medicine) {
        inventory.add(medicine);
    }

    public void removeMedicine(String name) {
        // Implement removal logic
    }

    public void sellMedicine(String name, int quantity) {
        // Implement sale logic
    }

    public void displayInventory() {
        // Display the list of medicines in the inventory
    }
}

public class   PharmacyManagementSystem {
    public static void main(String[] args) {
        Pharmacy pharmacy = new Pharmacy();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPharmacy Management System Menu:");
            System.out.println("1. Add Medicine");
            System.out.println("2. Remove Medicine");
            System.out.println("3. Sell Medicine");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1/2/3/4/5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addMedicine(pharmacy, scanner);
                    break;
                case 2:
                    removeMedicine(pharmacy, scanner);
                    break;
                case 3:
                    sellMedicine(pharmacy, scanner);
                    break;
                case 4:
                    pharmacy.displayInventory();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addMedicine(Pharmacy pharmacy, Scanner scanner) {
        // Implement logic to add a new medicine to the inventory
    }

    private static void removeMedicine(Pharmacy pharmacy, Scanner scanner) {
        // Implement logic to remove a medicine from the inventory
    }

    private static void sellMedicine(Pharmacy pharmacy, Scanner scanner) {
        // Implement logic to sell medicine from the inventory
    }
}
