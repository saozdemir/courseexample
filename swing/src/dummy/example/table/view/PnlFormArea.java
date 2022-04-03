package dummy.example.table.view;

import javax.swing.*;
import java.awt.*;

public class PnlFormArea extends JPanel {
    private JLabel lblName;

    public PnlFormArea() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("From Panel"));
        lblName = new JLabel("Name");

        this.add(lblName, BorderLayout.PAGE_START);
    }

    public JLabel getLblName() {
        return lblName;
    }

    public void setLblName(JLabel lblName) {
        this.lblName = lblName;
    }
}
