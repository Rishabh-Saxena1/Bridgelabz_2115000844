import java.time.LocalDate;
import java.util.*;
class InsurancePolicy {
    String policyNumber;
    String policyholder;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholder, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholder = policyholder;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String toString() {
        return policyNumber + " - " + policyholder + " (" + coverageType + ") Exp: " + expiryDate + " | Premium: $" + premiumAmount;
    }
}

public class InsuranceSystem {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private Map<String, InsurancePolicy> orderedPolicies = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<InsurancePolicy>> sortedPolicies = new TreeMap<>();

    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);

        sortedPolicies.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    public InsurancePolicy getPolicy(String policyNumber) {
        return policyMap.getOrDefault(policyNumber, null);
    }

    public List<InsurancePolicy> getExpiringSoon() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate cutoff = today.plusDays(30);

        for (Map.Entry<LocalDate, List<InsurancePolicy>> entry : sortedPolicies.entrySet()) {
            if (!entry.getKey().isAfter(cutoff)) {
                expiringPolicies.addAll(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    public List<InsurancePolicy> getPoliciesByHolder(String policyholder) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : orderedPolicies.values()) {
            if (policy.policyholder.equalsIgnoreCase(policyholder)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<InsurancePolicy>>> iterator = sortedPolicies.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<InsurancePolicy>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                for (InsurancePolicy policy : entry.getValue()) {
                    policyMap.remove(policy.policyNumber);
                    orderedPolicies.remove(policy.policyNumber);
                }
                iterator.remove();
            }
        }
    }

    public void displayAllPolicies() {
        for (InsurancePolicy policy : orderedPolicies.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsuranceSystem system = new InsuranceSystem();

        system.addPolicy(new InsurancePolicy("P001", "Alice", LocalDate.of(2024, 3, 10), "Health", 500.0));
        system.addPolicy(new InsurancePolicy("P002", "Bob", LocalDate.of(2024, 3, 20), "Auto", 700.0));
        system.addPolicy(new InsurancePolicy("P003", "Charlie", LocalDate.of(2024, 2, 25), "Home", 600.0));
        system.addPolicy(new InsurancePolicy("P004", "Alice", LocalDate.of(2024, 3, 5), "Auto", 550.0));

        System.out.println("All Policies:");
        system.displayAllPolicies();

        System.out.println("Expiring Soon (Next 30 Days):");
        List<InsurancePolicy> expiring = system.getExpiringSoon();
        expiring.forEach(System.out::println);

        System.out.println("Policies of Alice:");
        List<InsurancePolicy> alicePolicies = system.getPoliciesByHolder("Alice");
        alicePolicies.forEach(System.out::println);

        System.out.println("Removing Expired Policies...");
        system.removeExpiredPolicies();

        System.out.println("Policies After Cleanup:");
        system.displayAllPolicies();
    }
}
