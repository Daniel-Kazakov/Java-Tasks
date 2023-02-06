import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();
        boolean menuOpen = true;

        printMenu();

        while (menuOpen) {
            String choice = scanner.nextLine();
            try {
                int choiceNumber = Integer.parseInt(choice);
                switch (choiceNumber) {
                    case 1  -> {
                        System.out.println("What is the name of the contact?");
                        String name = scanner.nextLine();
                        System.out.println("What is the phone number of the contact?");
                        String phoneNumber = scanner.nextLine();
                        contacts.add(new Contact(name ,phoneNumber));
                        printMenu();
                    }
                    case 2  -> {
                        System.out.println("What is the name of the contact you want to remove?");
                        String name = scanner.nextLine();
                        for (Contact contact : contacts) {
                            if (contact.getName().equals(name)) {
                                contacts.remove(contact);
                                break;
                            } else {
                                System.out.println("No such contact");
                            }
                        }
                        printMenu();

                    }
                    case 3  -> {
                        System.out.println();
                        System.out.println("Contact List:\n");
                        for (Contact contact : contacts) {
                            System.out.println(contact.getName() + " - " + contact.getPhone());
                        }
                        System.out.println("\nType enter to return to the menu");
                        String key = scanner.nextLine();
                        printMenu();
                    }
                    case 4  -> {
                        System.out.println("Who are you looking for?");
                        String name = scanner.nextLine();
                        for (Contact contact : contacts) {
                            if (contact.getName().equals(name)) {
                                printContactDetails(contact);
                                break;
                            }
                            if (contact.getName() != name) {
                                 System.out.println("No such contact");
                                break;
                            }
                        }
                        printMenu();
                    }
                    case 5 -> {
                        Collections.sort(contacts);
                        for (Contact contact : contacts) {
                            printContactDetails(contact);
                        }
                        System.out.println("\nType enter to return to the menu");
                        String key = scanner.nextLine();
                        printMenu();
                    }

                    case 6 -> {
                        Comparator<Contact> compareByPhone = (Contact contact1, Contact contact2) ->
					    contact1.getPhone().compareTo( contact2.getPhone());
                        Collections.sort(contacts, compareByPhone);

                        for (Contact contact : contacts) {
                            printContactDetails(contact);
                        }
                        System.out.println("\nType enter to return to the menu");
                        String key = scanner.nextLine();
                        printMenu();
                    }

                    case 7 -> {
                        Collections.sort(contacts, Collections.reverseOrder());
                        for (Contact contact : contacts) {
                            printContactDetails(contact);
                        }
                        System.out.println("\nType enter to return to the menu");
                        String key = scanner.nextLine();
                        printMenu();
                    }
                    case 11 -> {
                        System.out.println("Bye bye");
                        menuOpen = false;
                }
                default -> System.out.println("Invalid choice");
                 }
            } catch (Exception e) {
                System.out.println("Invalid choice, type a valid number");
            }
        }
    }

    //Function which prints the menu
    private static void printMenu() {
        System.out.println("\nPhone Book\n");
        System.out.println(" 1. Add Contact");
        System.out.println(" 2. Delete Contact");
        System.out.println(" 3. Show all contacts");
        System.out.println(" 4. Find contact");
        System.out.println(" 5. Sort contacts by name A - Z ");
        System.out.println(" 6. Sort contacts by phone number");
        System.out.println(" 7. Sort contacts by name Z - A");
        System.out.println(" 8. Delete repetitive contact");
        System.out.println(" 9. Save phone book as text file");
        System.out.println("10. Load contacts from text file");
        System.out.println("11. Exit");
        System.out.println("\nPlease type the number of your choice: ");
    }

    public static void printContactDetails(Contact contact) {
        System.out.println(contact.getName() + " - " + contact.getPhone());
    }
}
