package dummy.example.table.view;

import javax.swing.*;
import java.awt.*;

public class FrmTableExample extends JFrame {
    private PnlTableExample pnlTableExample;

    public FrmTableExample() {
        this.setVisible(true);
        this.setTitle("Table Example");
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(800, 800));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pnlTableExample = new PnlTableExample();
        this.add(pnlTableExample, BorderLayout.CENTER);
    }


}
