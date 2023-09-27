import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return menuItem.getPrice() * quantity;
    }
}

class Cafe {
    private List<MenuItem> menu;
    private List<OrderItem> currentOrder;

    public Cafe() {
        menu = new ArrayList<>();
        currentOrder = new ArrayList<>();
    }

    public void addMenuItem(String name, double price) {
        MenuItem item = new MenuItem(name, price);
        menu.add(item);
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getName() + " - Rs" + menu.get(i).getPrice());
        }
    }

    public void takeOrder(int menuItemIndex, int quantity) {
        if (menuItemIndex >= 0 && menuItemIndex < menu.size() && quantity > 0) {
            MenuItem menuItem = menu.get(menuItemIndex);
            OrderItem orderItem = new OrderItem(menuItem, quantity);
            currentOrder.add(orderItem);
        } else {
            System.out.println("Invalid selection. Please try again.");
        }
    }

    public double calculateTotalBill() {
        double totalBill = 0;
        for (OrderItem item : currentOrder) {
            totalBill += item.getTotalPrice();
        }
        return totalBill;
    }

    public void displayReceipt() {
        System.out.println("\nReceipt:");
        for (OrderItem item : currentOrder) {
            System.out.println(item.getQuantity() + "x " + item.getMenuItem().getName() + " - Rs" + item.getTotalPrice());
        }
        System.out.println("\nTotal Bill: Rs" + calculateTotalBill());
    }
}

public class CafeBillingApp {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        cafe.addMenuItem("Coffee", 50);
        cafe.addMenuItem("Tea", 30);
        cafe.addMenuItem("Muffin", 60);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            cafe.displayMenu();
            System.out.print("Enter menu item number (0 to finish): ");
            int menuItemIndex = scanner.nextInt();

            if (menuItemIndex == 0) {
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            cafe.takeOrder(menuItemIndex - 1, quantity);
        }

        cafe.displayReceipt();
        scanner.close();
    }
}
