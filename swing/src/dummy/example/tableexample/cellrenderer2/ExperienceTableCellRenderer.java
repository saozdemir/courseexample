package dummy.example.tableexample.cellrenderer2;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ExperienceTableCellRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return null;
    }


//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        Component component = super.getTableCellRendererComponent(table, value,
//                isSelected, hasFocus, row, column);
//
//        Integer directiveVal = (Integer) table.getModel().getValueAt(row, 2);
//        Integer doneVal = (Integer) table.getModel().getValueAt(row, 3);
//
//        if (directiveVal.intValue() == 0) {
//            component.setBackground(Color.lightGray);
//        } else {
//            if (doneVal.intValue() >= directiveVal.intValue()) {
//                component.setBackground(Color.green);
//            } else if (doneVal.intValue() < directiveVal.intValue()) {
//                component.setBackground(Color.red);
//            } else {
//                component.setBackground(Color.lightGray);
//            }
//        }
//
//        return component;
//    }
}
