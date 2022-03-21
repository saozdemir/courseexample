package _sw14workinglistbox;

import java.util.EventObject;

public class FormEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */

    private String name;
    private String occupation;
    private int ageCategory;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String occupation, int ageCategory) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
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

    public int getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
    }
}
