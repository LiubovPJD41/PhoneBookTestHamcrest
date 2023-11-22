package Polyaeva;

import Polyaeva.Contact;
import Polyaeva.PhoneBook;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        List<String> family = new ArrayList<>();
        List<String> friends = new ArrayList<>();
        List<String> work = new ArrayList<>();

        phoneBook.addGroup("family");
        phoneBook.addGroup("friends");
        phoneBook.addGroup("work");

        Contact contact1 = new Contact("Veronica", "89183366967");
        Contact contact2 = new Contact("Tatyana", "89181702906");
        Contact contact3 = new Contact("Natasha", "89654558777");
        Contact contact4 = new Contact("Valentina", "8913380985");

        phoneBook.addContactInGroup(contact1, "friends");
        phoneBook.addContactInGroup(contact2, "family");
        phoneBook.addContactInGroup(contact3, "work");
        phoneBook.addContactInGroup(contact4, "work");
        phoneBook.addContactInGroup(contact1, "work");

        while (true) {
            System.out.println("Select the desired command: ");
            System.out.println("1. Create a contact.");
            System.out.println("2. Creating a contact group.");
            System.out.println("3. Group list.");
            System.out.println("4. Contact list");
            System.out.println("5. Search for a contact in a group.");
            System.out.println("6 Search for a contact by phone number.");
            System.out.println("0. Exit the program");

            String input = scanner.nextLine();
            int choise = Integer.parseInt(input);                   //variable where the user`s choice is stored
            if (choise == 0) {
                break;
            }
            switch (choise) {
                case 1: {
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter phoneNumber: ");
                    String phoneNumber = scanner.nextLine();
                    Contact contact = new Contact(name, phoneNumber);
                    System.out.println("Select a group: ");
                    System.out.println("family");
                    System.out.println("friends");
                    System.out.println("work");
                    String groupName = scanner.nextLine();
                    phoneBook.addContactInGroup(contact, groupName);
                    System.out.println("Contact successfully added to the group.");
                    break;
                }
                case 2: {
                    System.out.println("Enter group name: ");
                    String groupName = scanner.nextLine();
                    if (phoneBook.addGroup(groupName)) {
                        System.out.println("Created a group " + groupName + ".");
                    } else {
                        System.out.println("Such a group already exists.");
                    }
                    break;
                }
                case 3: {
                    for (String groupName : phoneBook.getGroupName()) {
                        System.out.println("- " + groupName);
                    }
                    break;
                }
                case 4: {
                    for (String key : phoneBook.getGroupName()) {
                        System.out.printf("The group %s has the following contacts:\n", key);
                        for (Contact contact : phoneBook.getContactInGroup(key)) {
                            System.out.println(contact.toString());
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Enter the name and group name to search: ");
                    String input1 = scanner.nextLine();
                    String[] parts = input1.split(" ");   //  Alex Trip
                    System.out.println();
                    String name = parts[0];     //"Alex"
                    String groupName = parts[1];    //"Trip"
                    // PhoneBook.findContactInGroup(name, groupName) {
                    if (phoneBook.findContactInGroup(name, groupName) != null) {
                        System.out.println("Contact found  " + name + ".");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                }

                case 6: {
                    System.out.println("Enter the phone number you want to find: ");
                    String phoneNumber = scanner.nextLine();
                    //PhoneBook.findUsePhoneNumber(phoneNumber);
                    if (phoneBook.findUsePhoneNumber(phoneNumber) != null) {
                        System.out.println("Contact found: " + phoneBook.findUsePhoneNumber(phoneNumber).toString());
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                }
            }
        }
    }
}
