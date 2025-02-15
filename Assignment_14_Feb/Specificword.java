public class SpecificWord {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "You are the awesome guy I have ever known.",
            "You are my first and last best friend",
            "Linear search is a simple searching algorithm."
        };

        String word = "are";
        String result = findSentenceWithWord(sentences, word);
        System.out.println("Result: " + result);
    }
}
