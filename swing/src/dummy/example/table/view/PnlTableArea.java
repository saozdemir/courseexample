package dummy.example.table.view;

import dummy.example.table.model.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PnlTableArea extends JPanel {
    private JTable tablePerson;
    private TableExampleRowDescription rowDescription;
    private final String[] TABLE_HEADER = {"ID", "NAME", "SURNAME"};

    public PnlTableArea() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Table Panel"));

        rowDescription = new TableExampleRowDescription();
        tablePerson = new JTable(rowDescription);

        //tablePerson.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);/////
        tablePerson.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//Otomatik Boyutlandırmayı kapatır.
        tablePerson.getTableHeader().setReorderingAllowed(false);//Sürükle bırak özelliğini kapatır.
        tablePerson.getColumnModel().getColumn(0).setPreferredWidth(100);
        tablePerson.getColumnModel().getColumn(1).setPreferredWidth(300);
        tablePerson.getColumnModel().getColumn(2).setPreferredWidth(300);
//        tablePerson.setRowSelectionAllowed(true);
//        tablePerson.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //tablePerson.setColumnSelectionAllowed(true);
        tablePerson.setCellSelectionEnabled(true);//Hücre Hücere seçimi aktif eder.
        tablePerson.setBorder(BorderFactory.createEtchedBorder());
        //DefaultTableModel tableModel = new DefaultTableModel();
        //tableModel.getColumnName();

        this.add(new JScrollPane(tablePerson), BorderLayout.CENTER); //ScrollPane eklemeyince tablename çıkmadı!!!!
    }

    public JTable getTablePerson() {
        return tablePerson;
    }
}
