import java.io.*;
import java.nio.charset.StandardCharsets;

public class FilterStreams {
    public static void main(String[] args) {
        String inputFile = "riya.txt";
        String outputFile = "out.txt";
       
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File converted successfully.");
        }
        catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
