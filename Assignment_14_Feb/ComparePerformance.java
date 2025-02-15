import java.io.*;
public class ComparePerformance {
    public static void main(String[] args) {
        int iterate= 1000000;
        long startTime, endTime;
        StringBuffer stringBuffer = new StringBuffer();
        startTime = System.nanoTime();
        for (int i = 0; i < iterate; i++) {
            stringBuffer.append("hello");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ns");
        StringBuilder stringBuilder = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < iterate; i++) {
            stringBuilder.append("hello");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ns");

        try {
            FileReader fileReader = new FileReader("riya.txt");
            BufferedReader br= new BufferedReader(fileReader);
            long wordCount = 0;
            String line;
            startTime = System.nanoTime();
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            endTime = System.nanoTime();
            System.out.println("FileReader word count: " + wordCount);
            System.out.println("FileReader time: " + (endTime - startTime) + " ns");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream("Rashi.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader br= new BufferedReader(inputStreamReader);
            long wordCount = 0;
            String line;
            startTime = System.nanoTime();
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            endTime = System.nanoTime();
            System.out.println("InputStreamReader word count: " + wordCount);
            System.out.println("InputStreamReader time: " + (endTime - startTime) + " ns");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
