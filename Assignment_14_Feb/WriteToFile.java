import java.io.*;
public class WriteToFile{
    public static void main(String[] args) {
        try (InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter("Write.txt")) {
            String line;
            while (!(line = br.readLine()).equals("exit")) {
               fw.write(line + "\n");
            }
        }
        catch (IOException e) {
           e.printStackTrace();
        }
   }
}
