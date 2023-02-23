
    package src.Database;

import java.io.FileOutputStream;
import java.io.File;
import java.util.ArrayList;

public class WriteData
{
    public WriteData(final ArrayList<String> data, final String householdData) {
        try {
            final File file = new File("SavedData.json");
            file.createNewFile();
            final FileOutputStream outputStream = new FileOutputStream(file);
            final StringBuilder sb = new StringBuilder();
            sb.append(householdData);
            sb.append(",\r\n Users:{");
            for (int i = 0; i < data.size(); ++i) {
                sb.append(data.get(i));
                if (i + 1 != data.size()) {
                    sb.append(",\r\n");
                }
                else {
                    sb.append("}");
                }
            }
            sb.append("}");
            outputStream.write(sb.toString().getBytes());
            outputStream.close();
        }
        catch (Exception ex) {}
    }
}

