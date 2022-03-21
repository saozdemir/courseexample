package _sw12events.example2;

import java.util.EventObject;

public class AddPersonNameEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    private String addPersonName;

    public AddPersonNameEvent(Object source) {
        super(source);
    }

    public AddPersonNameEvent(Object source, String addPerson) {
        super(source);
        this.addPersonName = addPerson;
    }

    public String getAddPersonName() {
        return addPersonName;
    }

    public void setAddPersonName(String addPersonName) {
        this.addPersonName = addPersonName;
    }
}
