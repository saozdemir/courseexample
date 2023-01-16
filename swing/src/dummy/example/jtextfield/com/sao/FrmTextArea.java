package dummy.example.jtextfield.com.sao;

import javax.swing.*;
import java.awt.*;

public class FrmTextArea extends JFrame {
    private PnlTextArea pnlCommon = new PnlTextArea();

    public FrmTextArea() throws HeadlessException {
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(300, 300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(pnlCommon);
    }
}
