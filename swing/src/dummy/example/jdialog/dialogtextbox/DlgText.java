package dummy.example.jdialog.dialogtextbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DlgText extends JDialog {
    private final JFrame frmMain;
    private JTextArea txtDescription = new JTextArea();
    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Cancel");
    private JPanel pnlButton = new JPanel(new GridLayout(1, 2));
    private DialogEventListener dialogEventListener;

    public DlgText(JFrame frmMain) {
        super(frmMain);
        this.frmMain = frmMain;
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(300, 300));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlButton.add(btnOk);
        pnlButton.add(btnCancel);

        this.add(txtDescription, BorderLayout.CENTER);
        this.add(pnlButton, BorderLayout.PAGE_END);

        actions();
    }

    private void actions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String desc = txtDescription.getText();
                DialogEvent event = new DialogEvent(this, desc);

                if (dialogEventListener != null) {
                    dialogEventListener.dialogEventOccure(event);
                }
                txtDescription.setText("");
                dispose();
            }

        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDescription.setText("");
                dispose();
            }
        });

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                txtDescription.setText("");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                txtDescription.setText("");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public void setDialogEventListener(DialogEventListener dialogEventListener) {
        this.dialogEventListener = dialogEventListener;
    }

}
