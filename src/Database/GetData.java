package src.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class GetData {

    public GetData() {
        saveData();
    }

    public String saveData() {
        try {
            File file = new File("SavedData.json");
            if (file.exists() && file.canRead()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                try (BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream))) {
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                        sb.append( '\n' );
                    }
                    return sb.toString();
                } catch (Exception e) {
                   System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
               System.out.println(e.getMessage());
        }
        return null;
    }
} 