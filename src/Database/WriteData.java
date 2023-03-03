package src.Database;

import java.io.FileOutputStream;
import java.io.File;
import java.util.ArrayList;

public class WriteData {
    public WriteData(ArrayList<String> data, String householdData) {
        try {
            File file = new File("SavedData.json");
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            StringBuilder sb = new StringBuilder();
            sb.append(householdData);
            sb.append(",\r\n Users:{");
            for (int i = 0; i < data.size(); ++i) {
                sb.append(data.get(i));
                if (i + 1 != data.size()) {
                    sb.append(",\r\n");
                } else {
                    sb.append("}");
                }
            }
            sb.append("}");
            outputStream.write(sb.toString().getBytes());
            outputStream.close();
        }
        catch (Exception ex) { System.out.println(ex.getMessage()); }
    }
}