package dummy.example.layout;

import javax.swing.*;
import java.awt.*;

public class FrmMain extends JFrame {
    private JPanel pnlMain;
    private JButton btnLeft;
    private JButton btnCenter;
    private JButton btnRight;

    public FrmMain() throws HeadlessException {
        pnlMain = new JPanel();
        btnLeft = new JButton("Left");
        btnCenter = new JButton("Center");
        btnRight = new JButton("Right");

        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        pnlMain.setBorder(BorderFactory.createEtchedBorder());
        pnlMain.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));

        pnlMain.add(btnLeft);
        pnlMain.add(btnCenter);
        pnlMain.add(btnRight);

        this.add(pnlMain, BorderLayout.CENTER);
    }
}
