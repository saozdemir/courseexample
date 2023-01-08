package dummy.example.jdialog.dialogtextbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmMain extends JFrame {
    private JLabel lblDescription = new JLabel("..");
    private JButton btnApprove = new JButton("Approve");
    private JButton btnDisapprove = new JButton("Disapprove");
    private JPanel pnlButton = new JPanel(new GridLayout(1, 2));
    private DlgText dialog;

    public FrmMain() throws HeadlessException {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(400, 400));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        pnlButton.add(btnApprove);
        pnlButton.add(btnDisapprove);

        this.add(lblDescription, BorderLayout.CENTER);
        this.add(pnlButton, BorderLayout.PAGE_END);
        dialog = new DlgText(this);
        actions();
    }

    private void actions() {
        btnApprove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
                dialog.setDialogEventListener(new DialogEventListener() {
                    @Override
                    public void dialogEventOccure(DialogEvent event) {
                        lblDescription.setText(event.getDescription() + "  approved");
                        //dialog.dispose();
                    }
                });
            }
        });

        btnDisapprove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
                dialog.setDialogEventListener(new DialogEventListener() {
                    @Override
                    public void dialogEventOccure(DialogEvent event) {
                        lblDescription.setText(event.getDescription() + "  disappoved");
                        //dialog.dispose();
                    }
                });
            }
        });
    }

    public JLabel getLblDescription() {
        return lblDescription;
    }

    public void setLblDescription(JLabel lblDescription) {
        this.lblDescription = lblDescription;
    }

    public JButton getBtnOpen() {
        return btnApprove;
    }

    public void setBtnOpen(JButton btnOpen) {
        this.btnApprove = btnOpen;
    }

}
