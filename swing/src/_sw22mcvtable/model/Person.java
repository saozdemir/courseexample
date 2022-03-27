package _sw22mcvtable.model;

public class Person {
    public static int count = 0;
    private int id;
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private EmploymentCategory empCategory;
    private String taxId;
    private boolean citizen;
    private Gender gender;

    public Person(String name, String occupation, AgeCategory ageCategory, EmploymentCategory empCategory, String taxId, boolean citizen, Gender gender) {
        this.id = count;
        count++;

        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCategory = empCategory;
        this.taxId = taxId;
        this.citizen = citizen;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public EmploymentCategory getEmpCategory() {
        return empCategory;
    }

    public void setEmpCategory(EmploymentCategory empCategory) {
        this.empCategory = empCategory;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public boolean isCitizen() {
        return citizen;
    }

    public void setCitizen(boolean citizen) {
        this.citizen = citizen;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
