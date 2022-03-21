package _sw12events.example2;

import _sw12events.example.AddPanelEvent;

import java.util.EventListener;

public interface AddPersonNameListener extends EventListener {
    void addPersonNameEventObserved(AddPersonNameEvent e);
}
