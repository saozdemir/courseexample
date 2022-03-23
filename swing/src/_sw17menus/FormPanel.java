package _sw17menus;

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
    private JComboBox empCombo;
    private JCheckBox citizenCheck;
    private JLabel taxLabel;
    private JTextField taxField;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        citizenCheck = new JCheckBox();
        taxLabel = new JLabel("Tax ID: ");
        taxField = new JTextField(10);
        taxField.setEnabled(false);
        taxLabel.setEnabled(false);

        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        maleRadio.setActionCommand("Male");
        femaleRadio.setActionCommand("Female");

        maleRadio.setSelected(true);

        citizenCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isTicked = citizenCheck.isSelected();
                taxLabel.setEnabled(isTicked);
                taxField.setEnabled(isTicked);
            }
        });

        //Costumize ListBox
        ageList = new JList();

        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "Under 18"));
        ageModel.addElement(new AgeCategory(1, "18 to 65"));
        ageModel.addElement(new AgeCategory(2, "65 or Over"));

        ageList.setModel(ageModel);

        ageList.setPreferredSize(new Dimension(110, 66));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);

        //Costumize ComboBox
        this.empCombo = new JComboBox();

        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("Employed");
        empModel.addElement("Self-Employed");
        empModel.addElement("Unemployed");

        empCombo.setModel(empModel);
        empCombo.setSelectedIndex(0);
        empCombo.setEditable(false);

        okBtn = new JButton("OK");

        okBtn.addActionListener(new ActionListener() { //Buton action listeneri
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();//Öncelikle textfiel lerden ttring değerleri al
                String occupation = occupationField.getText();
                AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
                String empCategory = (String) empCombo.getSelectedItem();
                boolean citizen = citizenCheck.isSelected();

                String genderCommand = genderGroup.getSelection().getActionCommand();

                FormEvent ev = new FormEvent(this, name, occupation, ageCat.getId(), empCategory, citizen, genderCommand);  //Bir FormEvent instance ı oluştur

                if (formListener != null) {
                    formListener.formEventOccured(ev); //FormListener aForm eventi gönder
                }

            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponent();
    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

    public void layoutComponent() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        //////////// First row ///////////////////////////////////

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;
        //gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        ////////////Second row ///////////////////////////////////

        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.1;


        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gc);

        //gc.gridy = 1;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gc);

        ////////////Third row ///////////////////////////////////

        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;


        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(ageList, gc);

        ////////////////////////////////////Combo

        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;


        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Employement: "), gc);

        //gc.gridy = 1;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(empCombo, gc);

        /////////////////////////////////Check
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;


        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Citizen: "), gc);

        //gc.gridy = 1;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(citizenCheck, gc);

        //////////////////Tax
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;


        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(taxLabel, gc);

        //gc.gridy = 1;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(taxField, gc);

        //////////////////Gender
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.05;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Gender: "), gc);

        //gc.gridy = 1;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(maleRadio, gc);
        /////////gender second row
        gc.gridy++;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(femaleRadio, gc);

        //////////Fourth row//////////////////////////////////
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(okBtn, gc);
    }
}

class AgeCategory {
    private int id;
    private String text;

    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public int getId() {
        return id;
    }
}