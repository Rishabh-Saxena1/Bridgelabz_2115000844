import java.io.*;
public class ConvertByteStream{
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("Rashi.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader br= new BufferedReader(inputStreamReader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
