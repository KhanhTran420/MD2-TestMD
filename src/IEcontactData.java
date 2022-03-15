
import java.io.IOException;
import java.util.ArrayList;

public interface IEcontactData {
    ArrayList<Contacts> readFile();
    void writeFile(ArrayList<Contacts> arrayList) throws IOException;
}
