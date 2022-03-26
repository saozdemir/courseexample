package dummy.example.matchedscreen.view;

import dummy.example.matchedscreen.SwingThemes;

import javax.swing.*;
import java.awt.*;

public class FrmMainScreen extends JFrame {
    private PnlMainScreen pnlMainScreen = new PnlMainScreen();

    public FrmMainScreen() throws HeadlessException {
        this.setVisible(true);
        this.setTitle("Example Screen");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(950, 800));
        try {
            UIManager.setLookAndFeel(SwingThemes.srt5);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame.setDefaultLookAndFeelDecorated(true);

        this.add(pnlMainScreen, BorderLayout.CENTER);
    }
}
