
import java.util.*;
public class StringConcatenation {
    public static void main(String[] args) {
        int size = 1_000_000;
        String word = "r";

        // Measure time for String Concatenation
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < size; i++) {
            str += word;
        }
        long stringTime = System.nanoTime() - startTime;
       
        // Measure time for StringBuilder Concatenation
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(word);
        }
        long stringBuilderTime = System.nanoTime() - startTime;
       
        // Measure time for StringBuffer Concatenation
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sbf.append(word);
        }
        long stringBufferTime = System.nanoTime() - startTime;
       
        System.out.println("Operations Count: " + size);
        System.out.println("String Concatenation Time: " + stringTime / 1_000_000.0 + " ms");
        System.out.println("StringBuilder Concatenation Time: " + stringBuilderTime / 1_000_000.0 + " ms");
        System.out.println("StringBuffer Concatenation Time: " + stringBufferTime / 1_000_000.0 + " ms");
    }
}

