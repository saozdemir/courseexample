package _sw12events.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private AddPanel addPanel;
    private ShowPanel showPanel;

    public MainFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Example");
        this.addPanel = new AddPanel();
        this.showPanel = new ShowPanel();
        this.setSize(new Dimension(500, 400));

        this.setLayout(new BorderLayout());
        this.add(addPanel, BorderLayout.NORTH);
        this.add(showPanel, BorderLayout.CENTER);
        this.setVisible(true);

        addPanel.setAddPanelListener(new AddPanelListener() {
            public void addPanelEventOccured(AddPanelEvent e) {
                String text = e.getAddText();
                showPanel.getTextArea().append(text + "\n");
            }
        });
    }
}
