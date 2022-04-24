package dummy.example.listfindsimilar;

import _sw13listbox.FormEvent;
import _sw13listbox.FormListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton okBtn;
    private FormListener formListener; //FormPanel sınıfına ait listener
    private JList ageList;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        ageList = new JList();

        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement("Under 18");
        ageModel.addElement("18 to 65");
        ageModel.addElement("65 or Over");

        ageList.setModel(ageModel);

        ageList.setPreferredSize(new Dimension(110, 66));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);


        okBtn = new JButton("OK");

        okBtn.addActionListener(new ActionListener() { //Buton action listeneri
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();//Öncelikle textfiel lerden ttring değerleri al
                String occupation = occupationField.getText();
                String ageCat = (String) ageList.getSelectedValue();
                System.out.println(ageCat);

                FormEvent ev = new FormEvent(this, name, occupation);  //Bir FormEvent instance ı oluştur

                if (formListener != null) {
                    formListener.formEventOccured(ev); //FormListener aForm eventi gönder
                }

            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();


        //////////// First row ///////////////////////////////////

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        ////////////Second row ///////////////////////////////////

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridy = 1;
        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gc);

        ////////////Third row ///////////////////////////////////

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridy = 2;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(ageList, gc);

        //////////Fourth row//////////////////////////////////
        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridy = 3;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(okBtn, gc);


    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }
}

