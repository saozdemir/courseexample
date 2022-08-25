package dummy.example.tableexample.cellrenderer;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class FrmTableCellRenderer extends JFrame {
    private JPanel pnlCommon = new JPanel();
    private JTable table;

    public static final int NAME = 0;
    public static final int DIRECTIVE = 1;
    public static final int DONE = 2;

    private static Object[] columnNames = {"Adı", "Yönerge", "Gercekleşen"};
    private static Object[][] data = {
            {"Ahmet", 5, 2},
            {"Esra", 0, 0},
            {"Badem", 4, 5},
            {"Tarçın", 5, 5}};

    public FrmTableCellRenderer() {
        this.setVisible(true);
        this.setTitle("Table Example");
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(800, 800));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.add(pnlCommon, BorderLayout.CENTER);
        pnlCommon.setLayout(new BorderLayout());

        //initTable();
        initTable2();
    }

    private void initTable2() {
        table = new JTable(data, columnNames) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component doneCell = super.prepareRenderer(renderer, row, col);
                Object directive = getModel().getValueAt(row, DIRECTIVE);
                Object done = getModel().getValueAt(row, DONE);
                if ((Integer) done >= (Integer) directive) {
                    doneCell.setBackground(Color.green);
                } else if ((Integer) done < (Integer) directive) {
                    doneCell.setBackground(Color.red);
                } else {
                    doneCell.setBackground(Color.lightGray);
                }
                return doneCell;
            }
        };

        pnlCommon.add(table, BorderLayout.CENTER);
    }

    private void initTable() {
        table = new JTable(data, columnNames) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component comp = super.prepareRenderer(renderer, row, col);
                Object value = getModel().getValueAt(row, col);
                if (value.equals(false)) {
                    comp.setBackground(Color.red);
                } else if (value.equals(true)) {
                    comp.setBackground(Color.green);
                } else {
                    comp.setBackground(Color.white);
                }
//                Object value = getModel().getValueAt(row, col);
//                if (getSelectedRow() == row) {
//                    if (value.equals(false)) {
//                        comp.setBackground(Color.red);
//                    } else if (value.equals(true)) {
//                        comp.setBackground(Color.green);
//                    } else {
//                        comp.setBackground(Color.white);
//                    }
//                } else {
//                    comp.setBackground(Color.white);
//                }
                return comp;
            }
        };

        pnlCommon.add(table, BorderLayout.CENTER);
    }
}
