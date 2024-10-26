package Project3;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(name, phone, email);
        contacts.add(newContact);
        System.out.println("Contact added successfully!");
    }

   public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    public void editContact() {
        viewContacts();
        System.out.println("Select a contact number to edit: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (choice > 0 && choice <= contacts.size()) {
            Contact contact = contacts.get(choice - 1);
            System.out.println("Enter new name (or press Enter to keep current): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) contact.setName(newName);

            System.out.println("Enter new phone (or press Enter to keep current): ");
            String newPhone = scanner.nextLine();
            if (!newPhone.isEmpty()) contact.setPhoneNumber(newPhone);

            System.out.println("Enter new email (or press Enter to keep current): ");
            String newEmail = scanner.nextLine();
            if (!newEmail.isEmpty()) contact.setEmail(newEmail);

            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    public void deleteContact() {
        viewContacts();
        System.out.println("Select a contact number to delete: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (choice > 0 && choice <= contacts.size()) {
            contacts.remove(choice - 1);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);
    }

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        manager.showMenu();
    }
}
