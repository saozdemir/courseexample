package dummy.example.table.view;

import javax.swing.*;
import java.awt.*;

public class PnlTableExample extends JPanel {
    private PnlTableArea pnlTableArea;
    private PnlFormArea pnlFormArea;

    public PnlTableExample() {
        this.setLayout(new BorderLayout());
        pnlFormArea = new PnlFormArea();
        pnlTableArea = new PnlTableArea();

        this.add(pnlFormArea, BorderLayout.LINE_START);
        this.add(pnlTableArea, BorderLayout.CENTER);
    }

    public PnlTableArea getPnlTableArea() {
        return pnlTableArea;
    }

    public PnlFormArea getPnlFormArea() {
        return pnlFormArea;
    }
}
