import java.io.*;
public class CountOccurences{
    public static void main(String[] args) {
        String targetWord = "Riya";
        int count = 0;
        try {
            FileReader fileReader = new FileReader("riya.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Occurrences of '" + targetWord + "': " + count);
    }
}
