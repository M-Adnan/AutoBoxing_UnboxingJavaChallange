package com.company;

import java.util.Scanner;

public class Main {
public static Scanner scanner = new Scanner(System.in);
public static MobilePhone myMobile = new MobilePhone("123");

    public static void main(String[] args) {
        int option;
        boolean quit = false;
        printInstructions();
        while(!quit){
            System.out.println("Please enter your choice:");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    printInstructions();
                    break;
                case 2:
                    myMobile.printContactList();
                    break;
                case 3:
                    addContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    removeContact();
                    break;
                case 7:
                    quit = true;
                    System.out.println("Shutting down...");
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }
        }
    }

    public static void printInstructions(){
        System.out.println("Please select from the options below\n1. Print Option Menu.\n2. Print Contact List.\n3. Add Contact.\n4. Update Contact.\n5. Find Contact.\n6. Remove Contact.\n7. Quit Program\n");
    }

    public static void addContact(){
        System.out.println("Please enter contact's name:");
        String newContactName = scanner.next();
        System.out.println("Please enter contact's phone:");
        String newContactPhone = scanner.next();
        boolean isAdded = myMobile.addContact(Contact.createContact(newContactName,newContactPhone));
        printMessage(isAdded,"added");
    }

    public static void updateContact(){
        System.out.println("Please enter existing contact's name:");
        String oldContactName = scanner.next();
        System.out.println("Please enter existing contact's phone:");
        String oldContactPhone = scanner.next();
        Contact oldContact = Contact.createContact(oldContactName,oldContactPhone);
        System.out.println("Please enter updated contact's name:");
        String updatedContactName = scanner.next();
        System.out.println("Please enter updated contact's phone:");
        String updatedContactPhone = scanner.next();
        Contact updatedContact = Contact.createContact(updatedContactName,updatedContactPhone);
        boolean isUpdated = myMobile.updateContact(oldContact,updatedContact);
        printMessage(isUpdated,"updated");
    }

    public static void findContact(){
        System.out.println("Please enter existing contact's name:");
        String findContactName = scanner.next();
        System.out.println("Please enter existing contact's phone:");
        String findContactPhone = scanner.next();
        Contact findContact = Contact.createContact(findContactName,findContactPhone);
        boolean isFound = myMobile.findContact(findContact);
        printMessage(isFound,"found");
    }

    public static void removeContact(){
        System.out.println("Please enter existing contact's name:");
        String deleteContactName = scanner.next();
        System.out.println("Please enter existing contact's phone:");
        String deleteContactPhone = scanner.next();
        Contact deleteContact = Contact.createContact(deleteContactName,deleteContactPhone);
        boolean isDeleted = myMobile.removeContact(deleteContact);
        printMessage(isDeleted,"deleted");
    }

    private static void printMessage(boolean isCompleted, String task){
        if(isCompleted){
            System.out.println("Contact has been successfully " + task);
        }else{
            System.out.println("Sorry Contact can't be " + task);
        }
    }
}
