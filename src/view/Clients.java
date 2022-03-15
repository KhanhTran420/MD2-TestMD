package view;

import controller.ContactManager;
import model.Contacts;

import java.util.ArrayList;
import java.util.Scanner;

public class Clients {

    private static ArrayList<Contacts> contactsArrayList = ContactManager.contactList;
    public static void main(String[] args) {



        int choice = -1;
        Scanner inputChoice = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Hiển thị danh sách ");
            System.out.println("2. thêm thông tin");
            System.out.println("3. Sửa thông tin ");
            System.out.println("4. xóa thông tin khỏi danh sách");
            System.out.println("5. tìm thông tin ");
            System.out.println("0. Exit!");
            System.out.println("Nhập lựa chọn: ");
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                  showAllContacts();
                  break;
                case 2:
                    Contacts newContact = creatNewContact();
                    ContactManager.addNewContact(newContact);
                    break;
                case 3:
                     editContact();
                     break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                     ContactManager.findContact();
                     break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Chưa nhập lựa chọn!");
            }
        }
    }

    public static void showAllContacts(){
        for (Contacts e: contactsArrayList){
            System.out.println(e);
        }
    }

    public static Contacts creatNewContact(){

        Scanner input = new Scanner(System.in);
        int choice = -1;
        Contacts newContact = null;
        System.out.println("1. Thêm mới danh bạ");
        System.out.println("Nhập 1: ");
        choice = input.nextInt();
        if (choice == 1) {
            newContact = creatContacts();
        }
        return newContact;
    }

    public static Contacts creatContacts(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập số điện thoại: ");
        String phone = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập tên nhóm: ");
        String group = scanner2.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Nhập họ và tên: ");
        String name = scanner3.nextLine();

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Nhập giới tính: ");
        String gender = scanner4.nextLine();

        Scanner scanner5 = new Scanner(System.in);
        System.out.println("Nhập số địa chỉ:  ");
        String address = scanner5.nextLine();

        Scanner scanner6 = new Scanner(System.in);
        System.out.println("Nhập ngày, tháng, năm: ");
        String date = scanner6.nextLine();

        Scanner scanner7 = new Scanner(System.in);
        System.out.println("Nhập số email: ");
        String email = scanner7.nextLine();

        Contacts newContact= new Contacts(phone,group,name,gender,address,date,email);
        return newContact;
    }

    public static void deleteContact() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        System.out.println("1. Xóa thông tin theo tên: ");

        System.out.println("Nhập 1: ");
        choice = input.nextInt();
        if (choice == 1) {
            deleteContactByName();
        }

    }

    public static void editContact() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        System.out.println(" Sửa thông tin theo tên: ");

        System.out.println("Nhập 1: ");
        choice = input.nextInt();
        if (choice == 1) {
            editContactByName();
        }


    }

    public static void deleteContactByName() {
        Scanner inputName = new Scanner(System.in);
        System.out.println("Nhập tên bạn muốn xóa");
        String name = inputName.nextLine();

        int deleteName = ContactManager.findContactIndexByName(name);
        ContactManager.removeContactByIndex(deleteName);
    }

    public static void editContactByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập thông tin tên bạn muốn sửa: ");
        String editName = input.nextLine();

        Contacts editContact = creatNewContact();
        int editIndex = ContactManager.findContactIndexByName(editName);
        ContactManager.editContactByIndex(editIndex,editContact);
    }



}

