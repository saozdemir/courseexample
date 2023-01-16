package dummy.example.joptionpane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmTestOptionPane extends JFrame {
    private JButton btnOk = new JButton("Aç");
    private JLabel lblResult = new JLabel("...");

    public FrmTestOptionPane() throws HeadlessException {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(300, 300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.add(lblResult, BorderLayout.CENTER);
        this.add(btnOk, BorderLayout.PAGE_END);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pane = JOptionPane.showInputDialog("Neden?");
                lblResult.setText(pane);
            }
        });
    }

}
