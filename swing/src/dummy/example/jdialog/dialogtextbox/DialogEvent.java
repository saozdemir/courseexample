package dummy.example.jdialog.dialogtextbox;

import java.util.EventObject;

public class DialogEvent extends EventObject {
    private String description;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public DialogEvent(Object source, String description) {
        super(source);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
