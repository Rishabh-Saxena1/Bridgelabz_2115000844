import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class LargeFile {
    public static void main(String[] args) {
        String filePath = "largeFile.txt";
       
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        }
        catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
