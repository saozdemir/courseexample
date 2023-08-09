package dummy.example.tableexample.celleditorandrowdesc;

import javax.swing.*;

/**
 * @author saozd
 * @project dummy.example.tableexample.celleditor courseexample
 * 1.08.2023 Ağu 2023
 */
public class TestMainCelEditor {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmCellEditor();
            }
        });
    }
}
