package dummy.example.tableexample.editabletablemodel;

import dummy.example.tableexample.editabletablemodel.view.FrmEditableTableSpecial;

import javax.swing.*;

public class TableApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmEditableTableSpecial();
            }
        });
    }
}
