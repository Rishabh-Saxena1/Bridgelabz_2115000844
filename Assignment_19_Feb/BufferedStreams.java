import java.io.*;
public class BufferedStreams {
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        String sourceFile = "riya.txt";
        String destinationFile = "dst.txt";

        copyUsingBufferedStreams(sourceFile, destinationFile);
        copyUsingUnbufferedStreams(sourceFile, destinationFile);
    }

    private static void copyUsingBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            long endTime = System.nanoTime();
            System.out.println("Buffered Stream Copy Time: " + (endTime - startTime) / 1000000 + " ms");
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void copyUsingUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            long endTime = System.nanoTime();
            System.out.println("Unbuffered Stream Copy Time: " + (endTime - startTime) / 1000000 + " ms");
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
