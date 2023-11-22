package Polyaeva;

import java.util.*;

public class PhoneBook {
    private  final Map<String, List<Contact>> phoneBook = new HashMap<>();
    List<String> group = new ArrayList<>();

    public  boolean addGroup(String groupName) {
        if (phoneBook.containsKey(groupName)) {
            return false;
        } else {
            phoneBook.put(groupName, new ArrayList<>());
            return true;
        }
    }
    public  Contact findContactInGroup(String name, String groupName) {
        if (!phoneBook.containsKey(groupName))
            return  null;
        for (Contact contact :
                phoneBook.get(groupName)) {
            if (contact.name.equals(name))
                return contact;
        }
        return null;
    }
    public  boolean  addContactInGroup(Contact contact, String groupName) {
        if (findContactInGroup(contact.name, groupName) != null) {
            return false;
        } else {
            if (!phoneBook.containsKey(groupName)){
                addGroup(groupName);
            }
            phoneBook.get(groupName).add(contact);
            return true;
        }
    }
    public  Contact findUsePhoneNumber(String phoneNumber) {

        for (List<Contact> contacts : phoneBook.values()) {
            for (Contact contact :
                    contacts) {
                if (contact.phoneNumber.equals(phoneNumber)) ;
                return contact;
            }
        }
        return null;
    }
    public  Set<String> getGroupName() {
        return phoneBook.keySet();
    }
    public  List<Contact> getContactInGroup(String groupName) {
        return phoneBook.get(groupName);
    }
}
