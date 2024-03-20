import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HandlePerformances {
    private Queue<Performance> performances;

    public HandlePerformances() {
        performances = new LinkedList<>();
    }

    public void handlePerformances() {
        Scanner scanner = new Scanner(System.in);

        char choice;
        do {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add performances");
            System.out.println("2. Display all performances");
            System.out.println("3. Start the performances");
            System.out.println("4. QUIT");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    System.out.print("Enter the number of performances to add: ");
                    int numPerformances = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    addPerformances(numPerformances);
                    break;
                case '2':
                    displayPerformances();
                    break;
                case '3':
                    startPerformance();
                    break;
                case '4':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != '4');

        scanner.close();
    }

    private void addPerformances(int numPerformances) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numPerformances; i++) {
            System.out.println("\nEnter details for Performance " + (i + 1) + ":");
            System.out.print("Enter Performance ID: ");
            String performanceID = scanner.nextLine();

            System.out.print("Enter Performance Name: ");
            String performanceName = scanner.nextLine();

            System.out.print("Enter Performance Lead Name: ");
            String performanceLeadName = scanner.nextLine();

            Performance performance = new Performance(performanceID, performanceName, performanceLeadName);
            performances.add(performance);
        }

        System.out.println("Added " + numPerformances + " performances successfully.");

        scanner.close();
    }

    private void displayPerformances() {
        System.out.println("\nPerformances:");
        for (Performance performance : performances) {
            System.out.println(performance);
        }
    }

    private void startPerformance() {
        if (performances.isEmpty()) {
            System.out.println("No performances added yet.");
        } else {
            Performance firstPerformance = performances.peek();
            System.out.println("\nStarting Performance:");
            System.out.println(firstPerformance);
        }
    }
}
