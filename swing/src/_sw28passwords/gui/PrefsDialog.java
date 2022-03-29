package _sw28passwords.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrefsDialog extends JDialog {
    private JButton okBtn;
    private JButton cancelBtn;
    private JSpinner portSpinner;
    private SpinnerNumberModel spinnerNumberModel;
    private JTextField userField;
    private JPasswordField passwordField;

    public PrefsDialog(JFrame parent) {
        super(parent, "Preferences", false);
        setSize(new Dimension(400, 300));
        //setVisible(true); Main Frame de çağrılacak
        setLocationRelativeTo(parent);

        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");

        spinnerNumberModel = new SpinnerNumberModel(3306, 0, 9999, 1);

        portSpinner = new JSpinner(spinnerNumberModel);

        userField = new JTextField(10);
        passwordField = new JPasswordField(10);
        passwordField.setEchoChar('*');

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        //gc.anchor=GridBagConstraints.WEST;

        /////////////////First row
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        add(new JLabel("User: "), gc);

        gc.gridx++;
        add(userField, gc);

        ///////////////////Next Row

        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        add(new JLabel("Password: "), gc);

        gc.gridx++;
        add(passwordField, gc);

        //////////////////NextRow

        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        add(new JLabel("Port: "), gc);

        gc.gridx++;
        add(portSpinner, gc);

        /////////////////////Next row
        gc.gridy++;
        gc.gridx = 0;
        add(okBtn, gc);

        gc.gridx++;
        add(cancelBtn, gc);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = (Integer) portSpinner.getValue();
                String user = userField.getText();
                char[] password = passwordField.getPassword();
                System.out.println(user + " : " + new String(password));

                JOptionPane.showMessageDialog(parent, "Port number set: " + value, "Info", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false); //Kapat
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
