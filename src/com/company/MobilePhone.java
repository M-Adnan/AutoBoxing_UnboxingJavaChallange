package com.company;

import java.util.ArrayList;

/**
 * Created by muhammada on 08/03/2016.
 */
public class MobilePhone {
    private String myMobileNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myMobileNumber) {
        this.myContacts = new ArrayList<Contact>();
        this.myMobileNumber = myMobileNumber;
    }

    public boolean addContact(Contact newContact)
    {
        if(contactPosition(newContact)>=0) {
            return false;
        }else{
            myContacts.add(newContact);
            return true;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int oldContactPosition = findContact(oldContact.getName());
        if(oldContactPosition>=0) {
            myContacts.set(oldContactPosition,newContact);
            return true;
        }else{
            return false;
        }
    }

    public boolean removeContact(Contact contact){
        int lcontactPosition = findContact(contact.getName());
        if(lcontactPosition>=0) {
            myContacts.remove(lcontactPosition);
            return true;
        }else{
            return false;
        }
    }

    public boolean findContact(Contact contact){
        if(findContact(contact.getName())>=0){
            return true;
        }else{
            return false;
        }
    }

    public void printContactList(){
        if (!(myContacts.isEmpty())) {
            for (int i = 0; i < myContacts.size(); i++) {
                System.out.println("Contact "+(i + 1) + ":" + "\nName: " + myContacts.get(i).getName() + "\nPhone: " + myContacts.get(i).getPhoneNumber());
            }
        }else{
            System.out.println("There is no contact available to display");
        }
    }

    private int contactPosition(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i=0; i<this.myContacts.size();i++){
            if(this.myContacts.get(i).getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }
}
