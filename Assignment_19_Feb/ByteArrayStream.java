import java.io.*;
import java.nio.file.Files;
public class ByteArrayStream {
    public static void main(String[] args) {
        String inputImagePath = "lion.jpeg";
        String outputImagePath = "output.jpeg";
       
        try {
            byte[] imageBytes = convertImageToByteArray(inputImagePath);
            writeByteArrayToImage(imageBytes, outputImagePath);
            System.out.println("Image successfully converted to byte array and written back to file.");
        }
        catch (IOException e) {
            System.err.println("Error processing image: " + e.getMessage());
        }
    }
   
    public static byte[] convertImageToByteArray(String imagePath) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Files.copy(new File(imagePath).toPath(), baos);
            return baos.toByteArray();
        }
    }
   
    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
