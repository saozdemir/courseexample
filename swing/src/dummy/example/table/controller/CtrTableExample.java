package dummy.example.table.controller;


import dummy.example.table.model.Person;
import dummy.example.table.view.FrmTableExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CtrTableExample {
    FrmTableExample frame;
    JTable tablePerson;

    public CtrTableExample(FrmTableExample frame) {
        this.frame = frame;
        tablePerson = this.frame.getPnlTableExample().getPnlTableArea().getTablePerson();
        actions();
    }

    private void actions() {
        tablePerson.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = tablePerson.rowAtPoint(e.getPoint());
                frame.getPnlTableExample().getPnlFormArea().getLblName().setText("Row: " + row);
            }
        });
    }


}
