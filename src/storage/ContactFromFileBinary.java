package storage;

import model.Contacts;

import java.io.*;
import java.util.ArrayList;

public class ContactFromFileBinary implements IEcontactData {

    public ArrayList<Contacts> readFile() {
        File file = new File("contact.dat");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            ArrayList<Contacts> contactList = (ArrayList<Contacts>) result;
            ois.close();
            fis.close();
            return contactList;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }


    public void writeFile(ArrayList<Contacts> arrayList) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("contact.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            oos.close();
            fos.close();
        }
    }
}
