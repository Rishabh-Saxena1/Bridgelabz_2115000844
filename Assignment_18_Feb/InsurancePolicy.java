import java.util.*;
class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy policy = (InsurancePolicy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate); // Sort by expiry date for TreeSet
    }

    public String toString() {
        return "Policy[" + policyNumber + ", " + policyholderName + ", " + expiryDate + ", " + coverageType + ", $" + premiumAmount + "]";
    }
}

public class InsurancePolicySystem {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Policies (HashSet - Unordered):");
        hashSetPolicies.forEach(System.out::println);

        System.out.println("All Policies (LinkedHashSet - Insertion Order):");
        linkedHashSetPolicies.forEach(System.out::println);

        System.out.println("All Policies (TreeSet - Sorted by Expiry Date):");
        treeSetPolicies.forEach(System.out::println);
    }

    public void displayExpiringSoon() {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date thirtyDaysLater = cal.getTime();

        System.out.println("Policies Expiring Soon (within 30 days):");
        treeSetPolicies.stream()
                .filter(policy -> policy.getExpiryDate().after(today) && policy.getExpiryDate().before(thirtyDaysLater))
                .forEach(System.out::println);
    }

    public void displayByCoverageType(String coverageType) {
        System.out.println("Policies with Coverage Type: " + coverageType);
        hashSetPolicies.stream()
                .filter(policy -> policy.getCoverageType().equalsIgnoreCase(coverageType))
                .forEach(System.out::println);
    }

    public void findDuplicatePolicies() {
        Set<String> seenPolicyNumbers = new HashSet<>();
        System.out.println("\nDuplicate Policies:");
        hashSetPolicies.stream()
                .filter(policy -> !seenPolicyNumbers.add(policy.getPolicyNumber()))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();

        Calendar cal = Calendar.getInstance();

        cal.set(2025, Calendar.JANUARY, 12);
        system.addPolicy(new InsurancePolicy("R123", "Riya Bansal", cal.getTime(), "Health Insurance", 5000.0));

        cal.set(2024, Calendar.MARCH, 10);
        system.addPolicy(new InsurancePolicy("P456", "Preeti Bansal", cal.getTime(), "Health Insurance", 1200.0));

        cal.set(2024, Calendar.MARCH, 25);
        system.addPolicy(new InsurancePolicy("A789", "Anil Kumar Bansal", cal.getTime(), "Home Insurance", 800.0));

        cal.set(2024, Calendar.FEBRUARY, 28);
        system.addPolicy(new InsurancePolicy("G101", "Gogo Bansal", cal.getTime(), "Health Insurance", 700.0));

        cal.set(2025, Calendar.APRIL, 12);
        system.addPolicy(new InsurancePolicy("R123", "Riya Bansal", cal.getTime(), "Health Insurance", 5000.0));

        system.displayAllPolicies();
        system.displayExpiringSoon();
        system.displayByCoverageType("Health");
        system.findDuplicatePolicies();
    }
}
