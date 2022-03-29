package _sw27spinners.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrefsDialog extends JDialog {
    private JButton okBtn;
    private JButton cancelBtn;
    private JSpinner portSpinner;
    private SpinnerNumberModel spinnerNumberModel;

    public PrefsDialog(JFrame parent) {
        super(parent, "Preferences", false);
        setSize(new Dimension(400, 300));
        //setVisible(true); Main Frame de çağrılacak
        setLocationRelativeTo(parent);

        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");

        spinnerNumberModel = new SpinnerNumberModel(3306, 0, 9999, 1);

        portSpinner = new JSpinner(spinnerNumberModel);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        add(new JLabel("Port"), gc);

        gc.gridx++;
        add(portSpinner, gc);

        //////next row
        gc.gridy++;
        gc.gridx = 0;
        add(okBtn, gc);

        gc.gridx++;
        add(cancelBtn, gc);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = (Integer) portSpinner.getValue();
                System.out.println(value);
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
