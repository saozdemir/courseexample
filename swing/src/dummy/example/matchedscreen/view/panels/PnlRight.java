package dummy.example.matchedscreen.view.panels;

import javax.swing.*;
import java.awt.*;

public class PnlRight extends JPanel {

    public PnlRight() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(300,300));
        this.setBorder(BorderFactory.createTitledBorder("Right Panel"));
    }
}
