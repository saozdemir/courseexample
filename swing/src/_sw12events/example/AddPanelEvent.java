package _sw12events.example;

import java.util.EventListener;
import java.util.EventObject;

public class AddPanelEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    private String addText;

    public AddPanelEvent(Object source) {
        super(source);
    }

    public AddPanelEvent(Object source, String addText) {
        super(source);
        this.addText = addText;
    }

    public String getAddText() {
        return addText;
    }

    public void setAddText(String addText) {
        this.addText = addText;
    }
}
