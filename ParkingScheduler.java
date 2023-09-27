import java.util.*;

class ParkingSpace {
    private int spaceNumber;
    private boolean isOccupied;
    private String licensePlate;

    public ParkingSpace(int spaceNumber) {
        this.spaceNumber = spaceNumber;
        this.isOccupied = false;
        this.licensePlate = null;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void occupy(String licensePlate) {
        this.licensePlate = licensePlate;
        this.isOccupied = true;
    }

    public void vacate() {
        this.licensePlate = null;
        this.isOccupied = false;
    }

    @Override
    public String toString() {
        String status = isOccupied ? "Occupied by " + licensePlate : "Vacant";
        return "Space Number: " + spaceNumber + "\nStatus: " + status;
    }
}

public class ParkingScheduler {
    private static ParkingSpace[] parkingSpaces;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of parking spaces in the system: ");
        int numberOfSpaces = scanner.nextInt();
        parkingSpaces = new ParkingSpace[numberOfSpaces];

        for (int i = 0; i < numberOfSpaces; i++) {
            parkingSpaces[i] = new ParkingSpace(i + 1);
        }

        while (true) {
            System.out.println("\nParking Scheduler Menu:");
            System.out.println("1. List Available Spaces");
            System.out.println("2. Park a Vehicle");
            System.out.println("3. Vacate a Space");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1/2/3/4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    listAvailableSpaces();
                    break;
                case 2:
                    parkVehicle(scanner);
                    break;
                case 3:
                    vacateSpace(scanner);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void listAvailableSpaces() {
        System.out.println("\nAvailable Parking Spaces:");
        for (ParkingSpace space : parkingSpaces) {
            if (!space.isOccupied()) {
                System.out.println(space);
            }
        }
    }

    private static void parkVehicle(Scanner scanner) {
        System.out.print("Enter the space number to park: ");
        int spaceNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (spaceNumber >= 1 && spaceNumber <= parkingSpaces.length) {
            ParkingSpace space = parkingSpaces[spaceNumber - 1];
            if (!space.isOccupied()) {
                System.out.print("Enter the vehicle's license plate: ");
                String licensePlate = scanner.nextLine();
                space.occupy(licensePlate);
                System.out.println("Vehicle parked successfully!");
            } else {
                System.out.println("The space is already occupied.");
            }
        } else {
            System.out.println("Invalid space number.");
        }
    }

    private static void vacateSpace(Scanner scanner) {
        System.out.print("Enter the space number to vacate: ");
        int spaceNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (spaceNumber >= 1 && spaceNumber <= parkingSpaces.length) {
            ParkingSpace space = parkingSpaces[spaceNumber - 1];
            if (space.isOccupied()) {
                space.vacate();
                System.out.println("Space vacated successfully!");
            } else {
                System.out.println("The space is already vacant.");
            }
        } else {
            System.out.println("Invalid space number.");
        }
    }
}

