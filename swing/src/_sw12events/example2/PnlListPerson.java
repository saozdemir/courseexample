package _sw12events.example2;

import javax.swing.*;
import java.awt.*;

public class PnlListPerson extends JPanel {
    private JTextArea txtPersonList;

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public PnlListPerson() {
        txtPersonList = new JTextArea();
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEtchedBorder());
        this.add(new JScrollPane(txtPersonList), BorderLayout.CENTER);
    }

    public JTextArea getTxtPersonList() {
        return txtPersonList;
    }

    public void setTxtPersonList(JTextArea txtPersonList) {
        this.txtPersonList = txtPersonList;
    }
}
