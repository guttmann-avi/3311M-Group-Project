package src.Database;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;

public class GetData
{
    public GetData() {
        this.saveData();
    }
    
    public String saveData() {
        try {
            final File file = new File("SavedData.json");
            if (file.exists() && file.canRead()) {
                final FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    Throwable t = null;
                    try {
                        final BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
                        try {
                            final StringBuilder sb = new StringBuilder();
                            String line;
                            while ((line = br.readLine()) != null) {
                                sb.append(line);
                                sb.append('\n');
                            }
                            return sb.toString();
                        }
                        finally {
                            if (br != null) {
                                br.close();
                            }
                        }
                    }
                    finally {
                        if (t == null) {
                            final Throwable exception;
                            t = exception;
                        }
                        else {
                            final Throwable exception;
                            if (t != exception) {
                                t.addSuppressed(exception);
                            }
                        }
                    }
                }
                catch (Exception ex) {}
            }
        }
        catch (Exception ex2) {}
        return null;
    }
}