import java.util.Stack;
import java.util.Scanner;

public class HandleComplementaryPasses {
    private Stack<ComplementaryPasses> complementaryPassesStack;

    public HandleComplementaryPasses() {
        complementaryPassesStack = new Stack<>();
    }

    public void handleComplementaryPasses() {
        Scanner scanner = new Scanner(System.in);

        char choice;
        do {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Redeem complementary passes");
            System.out.println("2. Display all redeemed complementary passes");
            System.out.println("3. Display the last redeemed complementary pass");
            System.out.println("4. Undo a redeemed complementary pass");
            System.out.println("5. QUIT");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    System.out.print("Enter the number of passes to redeem: ");
                    int numPasses = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    redeemComplementaryPasses(numPasses);
                    break;
                case '2':
                    displayComplementaryPasses();
                    break;
                case '3':
                    displayLastRedeemedComplementaryPass();
                    break;
                case '4':
                    undoRedeemedComplementaryPass();
                    break;
                case '5':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != '5');

        scanner.close();
    }

    private void redeemComplementaryPasses(int numPasses) {
        if (complementaryPassesStack.size() >= 10) {
            System.out.println("Invalid operation. All the passes have been redeemed.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numPasses; i++) {
            System.out.print("Enter Pass ID: ");
            String passID = scanner.nextLine();

            System.out.print("Enter access level: ");
            String accessLevel = scanner.nextLine();

            ComplementaryPasses complementaryPass = new ComplementaryPasses(passID, accessLevel);
            complementaryPassesStack.push(complementaryPass);
        }

        System.out.println("Redeemed " + numPasses + " complementary passes successfully.");

        scanner.close();
    }

    private void displayComplementaryPasses() {
        System.out.println("Redeemed Complementary Passes:");
        for (ComplementaryPasses complementaryPass : complementaryPassesStack) {
            System.out.println(complementaryPass);
        }
    }

    private void displayLastRedeemedComplementaryPass() {
        if (complementaryPassesStack.isEmpty()) {
            System.out.println("No complementary passes redeemed yet.");
        } else {
            ComplementaryPasses lastPass = complementaryPassesStack.peek();
            System.out.println("Last Redeemed Complementary Pass:");
            System.out.println(lastPass);
        }
    }

    private void undoRedeemedComplementaryPass() {
        if (complementaryPassesStack.isEmpty()) {
            System.out.println("No complementary passes redeemed yet.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Pass ID to undo: ");
        String passID = scanner.nextLine();

        boolean isPassFound = false;
        Stack<ComplementaryPasses> tempStack = new Stack<>();

        while (!complementaryPassesStack.isEmpty()) {
            ComplementaryPasses pass = complementaryPassesStack.pop();
            if (!isPassFound && pass.getPassID().equals(passID)) {
                isPassFound = true;
                System.out.println("Undoing complementary pass: " + pass);
            } else {
                tempStack.push(pass);
            }
        }

        while (!tempStack.isEmpty()) {
            complementaryPassesStack.push(tempStack.pop());
        }

        if (!isPassFound) {
            System.out.println("Complementary pass with Pass ID '" + passID + "' not found.");
        }

        scanner.close();
    }
}
