package _sw26dialogs.gui;

import javax.swing.*;
import java.awt.*;

public class PrefsDialog extends JDialog {
    public PrefsDialog(JFrame parent) {
        super(parent, "Preferences", false);
        setSize(new Dimension(400, 300));
        //setVisible(true); Main Frame de çağrılacak
    }
}
