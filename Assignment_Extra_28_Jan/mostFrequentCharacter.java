import java.util.*;
public class mostFrequentCharacter{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String str=sc.nextLine();

        char mostFrequent=findMostFrequentCharacter(str);
        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
    }
    public static char findMostFrequentCharacter(String str){
        Map<Character,Integer> frequencyMap=new HashMap<>();
        for(char c:str.toCharArray()){
            frequencyMap.put(c,frequencyMap.getOrDefault(c, 0)+1);
        }
        char mostFrequentChar = str.charAt(0);
        int maxCount = 0;
        for(Map.Entry<Character,Integer>entry:frequencyMap.entrySet()){
            if(entry.getValue()>maxCount){
                maxCount=entry.getValue();
                mostFrequentChar=entry.getKey();
            }
        }
        return mostFrequentChar;
    }
}
