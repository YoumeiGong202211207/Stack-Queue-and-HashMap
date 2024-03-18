import java.time.LocalDate;
import java.util.ArrayList;
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
            System.out.println("1. Add attendee");
            System.out.println("2. Remove attendee");
            System.out.println("3. Update attendee");
            System.out.println("4. Find attendee");
            System.out.println("5. Display total attendees");
            System.out.println("6. Display event details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case '1':
                    // Prompt the user to enter attendee details
        System.out.println("Enter Attendee Names (separated by commas): ");
        String attendeeNames = scanner.nextLine();

        // Split the comma-separated names and add them as attendees
        String[] names = attendeeNames.split(",");
        for (String name : names) {
            event.addAttendee(name.trim());
        }

                    break;
                case '2':
                    System.out.print("Enter attendee name to remove: ");
                    String attendeeToRemove = scanner.nextLine();
                    event.removeAttendee(attendeeToRemove);
                    break;
                case '3':
                    System.out.print("Enter index of attendee to update: ");
                    int indexToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new name for attendee: ");
                    String newName = scanner.nextLine();
                    event.updateAttendee(indexToUpdate, newName);
                    break;
                case '4':
                    System.out.print("Enter index of attendee to find: ");
                    int indexToFind = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    String foundAttendee = event.findAttendee(indexToFind);
                    System.out.println(foundAttendee);
                    break;
                case '5':
                    int totalAttendees = event.getTotalAttendees();
                    System.out.println("Total attendees: " + totalAttendees);
                    break;
                case '6':
                    System.out.println(event);
                    break;
                case '7':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != '7');

        scanner.close();
    }
    
}


