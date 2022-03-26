package dummy.example.matchedscreen.view.panels;

import javax.swing.*;
import java.awt.*;

public class PnlList extends JPanel {
    private PnlListTop pnlListTop = new PnlListTop();
    private PnlListBot pnlListBot = new PnlListBot();
    private JPanel pnlButton = new JPanel();


    private JButton btnAdd = new JButton(new ImageIcon("swing/src/dummy/example/matchedscreen/icons/add.png"));
    private JButton btnDelete = new JButton(new ImageIcon("swing/src/dummy/example/matchedscreen/icons/delete.png"));
    private JButton btnUpdate = new JButton(new ImageIcon("swing/src/dummy/example/matchedscreen/icons/update.png"));

    public PnlList() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(200, 200));
        this.setBorder(BorderFactory.createTitledBorder("List"));

        pnlButton.setBorder(BorderFactory.createEtchedBorder());
        pnlButton.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(5, 1, 1, 1);
        gc.weightx = 1;
        gc.weighty = 0;
        gc.ipadx = 1;
        gc.ipady = 20;


        pnlButton.add(btnAdd, gc);

        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.insets = new Insets(0, 1, 1, 1);
        gc.weightx = 1;
        gc.weighty = 0;
        gc.ipadx = 1;
        gc.ipady = 20;

        pnlButton.add(btnUpdate, gc);

        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.insets = new Insets(0, 1, 1, 1);
        gc.weightx = 1;
        gc.weighty = 0;
        gc.ipadx = 1;
        gc.ipady = 20;

        pnlButton.add(btnDelete, gc);

        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.BOTH;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.weightx = 1;
        gc.weighty = 0.1;
        pnlButton.add(new JPanel(), gc);

        this.add(pnlListTop, BorderLayout.PAGE_START);
        this.add(pnlListBot, BorderLayout.CENTER);
        this.add(pnlButton, BorderLayout.LINE_END);
    }
}
