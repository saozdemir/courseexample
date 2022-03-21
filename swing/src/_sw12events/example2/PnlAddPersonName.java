package _sw12events.example2;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.JavaParam;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.Documented;

public class PnlAddPersonName extends JPanel {
    private JLabel lblAddPersonName;
    private JTextField txtAddPersonName;
    private JButton btnAddPerson;
    private AddPersonNameListener addPersonNameListener;

    public PnlAddPersonName() {
        lblAddPersonName = new JLabel("Add Person: ");
        txtAddPersonName = new JTextField(15);
        btnAddPerson = new JButton("Add Person");

        this.setLayout(new FlowLayout());
        this.add(lblAddPersonName);
        this.add(txtAddPersonName);
        this.add(btnAddPerson);

        btnAddPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addPerson = txtAddPersonName.getText();
                if (addPerson.equals("")) {
                    JOptionPane.showMessageDialog(new JFrame(), "Personel Adı Boş", "Hata", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                AddPersonNameEvent addEvent = new AddPersonNameEvent(this, addPerson);

                if (addPersonNameListener != null) {
                    addPersonNameListener.addPersonNameEventObserved(addEvent);
                }
            }
        });

    }

    public void setAddPersonNameListener(AddPersonNameListener addPersonNameListener) {
        this.addPersonNameListener = addPersonNameListener;
    }

    public JTextField getTxtAddPersonName() {
        return txtAddPersonName;
    }
}
