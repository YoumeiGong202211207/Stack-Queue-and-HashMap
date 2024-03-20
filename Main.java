import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Event Organization System!");

        System.out.print("Enter event ID: ");
        String eventID = scanner.nextLine();

        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();

        System.out.print("Enter event venue: ");
        String eventVenue = scanner.nextLine();

        System.out.print("Enter event date (YYYY-MM-DD): ");
        LocalDate eventDate = LocalDate.parse(scanner.nextLine());

        Event event = new Event(eventID, eventName, eventVenue, eventDate);

        char choice;
        do {
            System.out.println("\nSelect an operation:");
            System.out.println("0. Add attendee");
            System.out.println("1. Remove attendee");
            System.out.println("2. Update attendee");
            System.out.println("3. Find attendee");
            System.out.println("4. Display total attendees");
            System.out.println("5. Display event details");
            System.out.println("6. Handle complementary passes");
            System.out.println("7. Handle performances");
            System.out.println("8. Get seat details");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case '0':
                    System.out.println("Enter Attendee Names (separated by commas): ");
                    String attendeeNames = scanner.nextLine();
                    String[] names = attendeeNames.split(",");
                    for (String name : names) {
                        event.addAttendee(name, ""); // Assuming seat number is not provided for now
                    }
                    break;
                case '1':
                    System.out.print("Enter attendee name to remove: ");
                    String attendeeToRemove = scanner.nextLine();
                    event.removeAttendee(attendeeToRemove, ""); // Assuming seat number is not provided for now
                    break;
                case '2':
                    System.out.print("Enter index of attendee to update: ");
                    int indexToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new name for attendee: ");
                    String newName = scanner.nextLine();
                    event.updateAttendee(indexToUpdate, newName);
                    break;
                case '3':
                    System.out.print("Enter index of attendee to find: ");
                    int indexToFind = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    String foundAttendee = event.findAttendee(indexToFind);
                    System.out.println(foundAttendee);
                    break;
                case '4':
                    int totalAttendees = event.getTotalAttendees();
                    System.out.println("Total attendees: " + totalAttendees);
                    break;
                case '5':
                    System.out.println(event);
                    break;
                case '6':
                    handleComplementaryPasses();
                    break;
                case '7':
                    handlePerformances();
                    break;
                case '8':
                    getSeatDetails(event);
                    break;
                case '9':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != '9');

    }

    private static void handleComplementaryPasses() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Complementary Passes System!");

        HandleComplementaryPasses handleComplementaryPasses = new HandleComplementaryPasses();

        char choice;
        do {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Handle complementary passes");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    handleComplementaryPasses.handleComplementaryPasses();
                    break;
                case '2':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != '2');

    }

    private static void handlePerformances() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Event Organization System!");

        HandlePerformances handlePerformances = new HandlePerformances();

        char choice;
        do {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Handle performances");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    handlePerformances.handlePerformances();
                    break;
                case '2':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != '2');

    }

    private static void getSeatDetails(Event event) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Enter attendee name: ");
            String name = scanner.nextLine();
    
            System.out.print("Enter seat number: ");
            String seatNo = scanner.nextLine();
    
            try {
                Attendee attendee = new Attendee(name, seatNo);
                System.out.println("Attendee Details:");
                System.out.println(attendee);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
    
    }
}




