import java.util.*;
public class replaceWord{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the sentence:");
        String sentence=sc.nextLine();
        System.out.println("Enter the word to replace:");
        String wordToReplace=sc.nextLine();
        System.out.println("Enter the word to replace with:");
        String replacementWord=sc.nextLine();
        String newSentence=replaceWord(sentence, wordToReplace, replacementWord);
        System.out.println("New Sentence: " + newSentence);
    }
    public static String replaceWord(String sentence, String wordToReplace, String replacementWord) {
        return sentence.replaceAll("\\b" + wordToReplace + "\\b", replacementWord);
    }
}
