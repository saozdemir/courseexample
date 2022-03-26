package dummy.example.matchedscreen.view;

import dummy.example.matchedscreen.view.panels.PnlCenter;
import dummy.example.matchedscreen.view.panels.PnlLeft;
import dummy.example.matchedscreen.view.panels.PnlList;
import dummy.example.matchedscreen.view.panels.PnlRight;

import javax.swing.*;
import java.awt.*;

public class PnlMainScreen extends JPanel {
    PnlLeft pnlLeft = new PnlLeft();
    PnlCenter pnlCenter = new PnlCenter();
    PnlRight pnlRight = new PnlRight();
    PnlList pnlList = new PnlList();

    JSplitPane pnlSlpTop1;
    JSplitPane pnlSlpTop2;
    JSplitPane pnlSlpBot;

    public PnlMainScreen() {
        this.setLayout(new BorderLayout());
        pnlSlpTop1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlLeft, pnlCenter);
        pnlSlpTop2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlSlpTop1, pnlRight);

        pnlSlpBot = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnlSlpTop2, pnlList);

        //pnlSlpTop1.setDividerLocation(0.5);
        //pnlSlpTop2.setDividerLocation(0.5);

        pnlSlpTop1.setResizeWeight(0.5);
        pnlSlpTop2.setResizeWeight(0.6);

        pnlSlpBot.setResizeWeight(0.2);


        this.add(pnlSlpBot, BorderLayout.CENTER);

    }
}
