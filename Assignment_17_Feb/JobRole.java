import java.util.*;

abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract String getJobRole();

    public String toString() {
        return candidateName + " - " + getJobRole();
    }
}

// Specific Job Roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    public String getJobRole() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    public String getJobRole() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    public String getJobRole() {
        return "Product Manager";
    }
}

class Resume<T extends JobRole> {
    private T jobRole;
    private String skills;
    private double experienceYears;

    public Resume(T jobRole, String skills, double experienceYears) {
        this.jobRole = jobRole;
        this.skills = skills;
        this.experienceYears = experienceYears;
    }

    public T getJobRole() {
        return jobRole;
    }

    public String getSkills() {
        return skills;
    }

    public double getExperienceYears() {
        return experienceYears;
    }

    public String toString() {
        return jobRole + " Skills: " + skills + " ,Experience: " + experienceYears + " years";
    }
}

class ResumeScreeningSystem {
    public static void screenResumes(List<? extends JobRole> resumes) {
        System.out.println("AI-Driven Resume Screening:");
        for (JobRole resume : resumes) {
            System.out.println("Screening Resume: " + resume);
        }
    }
}

public class ResumeScreening {
    public static void main(String[] args) {
        SoftwareEngineer seCandidate = new SoftwareEngineer("Riya Bansal");
        DataScientist dsCandidate = new DataScientist("Abhay Agrawal");
        ProductManager pmCandidate = new ProductManager("Rahul Jain");

        Resume<SoftwareEngineer> seResume = new Resume<>(seCandidate, "Java, SpringBoot, JVE", 5);
        Resume<DataScientist> dsResume = new Resume<>(dsCandidate, "Python, SQL", 4);
        Resume<ProductManager> pmResume = new Resume<>(pmCandidate, "Agile, Market Research, Strategy", 6);

        System.out.println(seResume);
        System.out.println(dsResume);
        System.out.println(pmResume);

        List<JobRole> resumes = new ArrayList<>();
        resumes.add(seCandidate);
        resumes.add(dsCandidate);
        resumes.add(pmCandidate);

        ResumeScreeningSystem.screenResumes(resumes);
    }
}
