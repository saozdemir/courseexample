package dummy.example.tableexample.editabletablemodel.view;

import dummy.example.tableexample.editabletablemodel.abstractmodel.SpecialAbstractTableModel;
import dummy.example.tableexample.editabletablemodel.data.Person;
import dummy.example.tableexample.editabletablemodel.rowdescription.EditableTableRowDescription;
import dummy.example.tableexample.editabletablemodel.rowdescription.EditableTableRowDescriptionSpecial;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PnlEditableTableSpecial extends JPanel {
    private TblEditableTableSpecial table;
    private EditableTableRowDescription rowDesc;
    private EditableTableRowDescriptionSpecial rowDescSpecial;
    private SpecialAbstractTableModel<Person> tableModelSpecial;

    private JLabel lblSelected = new JLabel("...");
    private JButton btnUpdate = new JButton("Update");

    public PnlEditableTableSpecial() {
        this.setLayout(new BorderLayout());
        //init();
        initSpecial();

        actions();

    }


    private void init() {
        rowDesc = new EditableTableRowDescription(createPersonList());
    }

    private List<Person> createPersonList() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(100, "Ahmet", "Özdemir"));
        personList.add(new Person(101, "Esra", "Özdemir"));
        personList.add(new Person(102, "Emir", "Özdemir"));
        return personList;
    }

    private void initSpecial() {
        rowDescSpecial = new EditableTableRowDescriptionSpecial();
        tableModelSpecial = new SpecialAbstractTableModel<Person>(createPersonList(), rowDescSpecial);
        table = new TblEditableTableSpecial(tableModelSpecial);

        this.add(lblSelected, BorderLayout.PAGE_START);
        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(btnUpdate, BorderLayout.PAGE_END);
    }

    private void actions() {
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Person> actualPersonList = createPersonList();
                actualPersonList.add(new Person(104, "EEEE", "WWWW"));
                tableModelSpecial.setData(actualPersonList);
                table.clearSelection();
                tableModelSpecial.fireTableDataChanged();
            }
        });

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Person selectedPerson = (Person) table.getSelectedObject();
                if(selectedPerson != null){
                    lblSelected.setText(selectedPerson.getId() + " " +
                            selectedPerson.getName() + " " +
                            selectedPerson.getSurname());
                }
            }
        });
    }

}
