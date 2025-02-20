import java.util.*;
public class VotingSystem {
    private Map<String, Integer> voteMap;
    private LinkedHashMap<String, Integer> votingOrderMap;
    public VotingSystem() {
        voteMap = new HashMap<>();
        votingOrderMap = new LinkedHashMap<>();
    }

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        votingOrderMap.put(candidate, voteMap.get(candidate));
        System.out.println("Vote casted for: " + candidate);
    }

    public void displayVotesInOrder() {
        System.out.println("\nVotes in Voting Order:");
        for (Map.Entry<String, Integer> entry : votingOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    public void displayResultsInSortedOrder() {
        System.out.println("Results in Sorted Order:");
        TreeMap<String, Integer> sortedMap = new TreeMap<>(voteMap);
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.castVote("Siya");
        votingSystem.castVote("Gauri");
        votingSystem.castVote("Priya");
        votingSystem.castVote("Riya");
        votingSystem.castVote("Reena");
        votingSystem.castVote("Priyanshi");
       
        votingSystem.displayVotesInOrder();
        votingSystem.displayResultsInSortedOrder();
    }
}
