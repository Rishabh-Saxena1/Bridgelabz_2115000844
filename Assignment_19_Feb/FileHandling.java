import java.io.*;
public class FileHandling {
    public static void main(String[] args) {
        String sourceFile = "riya.txt";
        String destinationFile = "dest.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File inputFile = new File(sourceFile);
            if (!inputFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(destinationFile);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully to " + destinationFile);
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        finally {
            try {
                if (fis != null){
                    fis.close();
                }
                if (fos != null){
                    fos.close();
                }
            }
            catch (IOException e) {
                System.err.println("Error closing the files: " + e.getMessage());
            }
        }
    }
}
