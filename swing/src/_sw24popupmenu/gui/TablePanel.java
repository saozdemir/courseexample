package _sw24popupmenu.gui;

import _sw24popupmenu.model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;
    private PersonTableModel tableModel;
    private JPopupMenu popup;


    public TablePanel() {
        tableModel = new PersonTableModel();
        table = new JTable(tableModel); //Projede RowDescription classları ile bu aynı
        popup = new JPopupMenu();

        JMenuItem removeItem = new JMenuItem("Delete Row");
        popup.add(removeItem);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(table, e.getX(), e.getY());
                }
            }
        });

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Person> db) {
        tableModel.setData(db);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();// Tabloda Data değiştiğide refresh et.
    }
}
