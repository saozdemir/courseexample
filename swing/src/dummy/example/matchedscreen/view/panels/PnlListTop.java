package dummy.example.matchedscreen.view.panels;

import javax.swing.*;
import java.awt.*;

public class PnlListTop extends JPanel {

    public PnlListTop() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(100,100));
        this.setBorder(BorderFactory.createTitledBorder("List Top"));
    }
}
