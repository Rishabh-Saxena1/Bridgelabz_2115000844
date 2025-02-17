import java.io.*;
public class FileReading {
    public static void main(String[] args) {
        String filePath = "riya.txt";

        // Measure time for FileReader
        long startTime = System.nanoTime();
        try (FileReader fr = new FileReader(filePath)) {
            while (fr.read() != -1) {}
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        long fileReaderTime = System.nanoTime() - startTime;
       
        // Measure time for InputStreamReader
        startTime = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            while (isr.read() != -1) {}
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        long inputStreamReaderTime = System.nanoTime() - startTime;
       
        System.out.println("File Size: 500MB");
        System.out.println("FileReader Time: " + fileReaderTime / 1000000000.0 + " s");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1000000000.0 + " s");
    }
}
