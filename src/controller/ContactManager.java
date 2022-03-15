package controller;

import storage.ContactFromFileBinary;
import storage.IEcontactData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    public static IEcontactData contactData = new ContactFromFileBinary();
    public static ArrayList<Contacts> contactList = contactData.readFile();

    public static void addNewContact(Contacts contacts) {
        contactList.add(contacts);
        try {
            contactData.writeFile(contactList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeContactByIndex(int index) {
        contactList.remove(index);
        try {
            contactData.writeFile(contactList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editContactByIndex(int index, Contacts contacts) {
        contactList.set(index, contacts);
        try {
            contactData.writeFile(contactList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findContactIndexByName(String searchName) {
        int index = -1;
        for (int i = 0; i < contactList.size(); i++) {
            Contacts currentBuses = contactList.get(i);
            String currentBusesName = currentBuses.getName();
            if (currentBusesName.equals(searchName)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public static void findContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên Tài xế bạn muốn tìm: ");
        String namePhone = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < contactList.size(); i++) {
//
            if (contactList.get(i).getName().equals(namePhone)) {
                System.out.println(contactList.get(i).toString());
                check = true;
                break;
            }
        }
        if (!check){
            System.out.println("Ò!!! không tìm thấy số");
        }
    }


}
