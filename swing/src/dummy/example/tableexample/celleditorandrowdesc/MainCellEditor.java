package dummy.example.tableexample.celleditorandrowdesc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author saozd
 * @project dummy.example.tableexample.celleditor courseexample
 * 1.08.2023 Ağu 2023
 */
public class MainCellEditor {
        public static void main(String[] args) {
            JFrame frame = new JFrame("JTable ile JPanel Kullanımı");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            String[] columns = {"Ad", "Soyad", "Cinsiyet"};
            Object[][] data = {
                    {"John", "Doe", "Erkek"},
                    {"Jane", "Smith", "Kadın"},
                    {"Mike", "Johnson", "Erkek"}
            };

            DefaultTableModel tableModel = new DefaultTableModel(data, columns);
            JTable table = new JTable(tableModel);

            table.getColumnModel().getColumn(2).setCellEditor(new CustomCellEditor());

            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane);

            frame.pack();
            frame.setVisible(true);
        }

    static class CustomCellEditor extends AbstractCellEditor implements TableCellEditor {
        private JPanel panel;
        private JTextField textField;
        private JComboBox<String> comboBox;

        public CustomCellEditor() {
            panel = new JPanel();
            textField = new JTextField(10);
            comboBox = new JComboBox<>(new String[]{"Erkek", "Kadın"});

            panel.setLayout(new BorderLayout());
            panel.add(textField, BorderLayout.WEST);
            panel.add(comboBox, BorderLayout.EAST);

            comboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            String text = value.toString();
            String gender = "";

            if (text.equals("Erkek")) {
                gender = "Erkek";
            } else if (text.equals("Kadın")) {
                gender = "Kadın";
            } else {
                gender = "Diğer";
            }

            textField.setText(gender);
            comboBox.setSelectedItem(gender);

            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return textField.getText();
        }
    }
}
