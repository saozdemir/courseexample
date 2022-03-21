package _sw12events.example2;

import javax.swing.*;
import java.awt.*;

public class FrmMain extends JFrame {
    private PnlAddPersonName pnlAddPersonName;
    private PnlListPerson pnlListPerson;

    public FrmMain() {
        pnlAddPersonName = new PnlAddPersonName();
        pnlListPerson = new PnlListPerson();
        this.setSize(new Dimension(700, 700));
        this.setTitle("Add Person");
        this.setLayout(new BorderLayout());

        this.add(pnlAddPersonName, BorderLayout.NORTH);
        this.add(pnlListPerson, BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        pnlAddPersonName.setAddPersonNameListener(new AddPersonNameListener() {
            @Override
            public void addPersonNameEventObserved(AddPersonNameEvent e) {
                String text = e.getAddPersonName();
                pnlListPerson.getTxtPersonList().append(text + "\n");
                pnlAddPersonName.getTxtAddPersonName().setText("");
            }
        });
    }
}
