package dummy.example.jtabbedpane;

import javax.swing.*;
import java.awt.*;

/**
 * @saozdemir
 * @Hv.Müh.Ütğm
 */
public class TabbetPane extends JFrame {
    private JTabbedPane pnlTabbedPane = new JTabbedPane();
    private JPanel pnlFirst = new JPanel();
    private JPanel pnlSecond = new JPanel();

    private JLabel lblFirst = new JLabel("First Label");
    private JLabel lblSecond = new JLabel("Second Label");

    public TabbetPane() throws HeadlessException {
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(300, 300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        pnlFirst.add(lblFirst);
        pnlSecond.add(lblSecond);

        pnlTabbedPane.addTab("First", pnlFirst);
        pnlTabbedPane.addTab("Second", pnlSecond);

        this.add(pnlTabbedPane);

    }
}
