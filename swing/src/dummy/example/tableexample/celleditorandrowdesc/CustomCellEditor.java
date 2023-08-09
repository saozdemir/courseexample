package dummy.example.tableexample.celleditorandrowdesc;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author saozd
 * @project dummy.example.tableexample.celleditor courseexample
 * 1.08.2023 Ağu 2023
 */
public class CustomCellEditor extends AbstractCellEditor implements TableCellEditor {
    private JPanel pnlMission = new JPanel(new GridLayout(1, 2));
    private JTextField txtName = new JTextField(10);
    private JComboBox<String> cmbLocation = new JComboBox<>(new String[]{"Doğu", "Batı", "Kuzey", "Güney"});

    public CustomCellEditor(JTable table) {
        pnlMission.add(txtName);
        pnlMission.add(cmbLocation);

        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if(e.getType() == TableModelEvent.UPDATE || e.getType() == TableModelEvent.INSERT){
                    fireEditingStopped();
                }
            }
        });

//        txtName.addKeyListener(new KeyAdapter() {
//            /**
//             * Invoked when a key has been released.
//             *
//             * @param e
//             */
//            @Override
//            public void keyReleased(KeyEvent e) {
//                fireEditingStopped();
//            }
//        });
    }

    /**
     * Sets an initial <code>value</code> for the editor.  This will cause
     * the editor to <code>stopEditing</code> and lose any partially
     * edited value if the editor is editing when this method is called. <p>
     * <p>
     * Returns the component that should be added to the client's
     * <code>Component</code> hierarchy.  Once installed in the client's
     * hierarchy this component will then be able to draw and receive
     * user input.
     *
     * @param table      the <code>JTable</code> that is asking the
     *                   editor to edit; can be <code>null</code>
     * @param value      the value of the cell to be edited; it is
     *                   up to the specific editor to interpret
     *                   and draw the value.  For example, if value is
     *                   the string "true", it could be rendered as a
     *                   string or it could be rendered as a check
     *                   box that is checked.  <code>null</code>
     *                   is a valid value
     * @param isSelected true if the cell is to be rendered with
     *                   highlighting
     * @param row        the row of the cell being edited
     * @param column     the column of the cell being edited
     * @return the component for editing
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return pnlMission;
    }

    /**
     * Returns the value contained in the editor.
     *
     * @return the value contained in the editor
     */
    @Override
    public Object getCellEditorValue() {
        Mission mission = new Mission();
        mission.setName(txtName.getText());
        mission.setLocation((String) cmbLocation.getSelectedItem());
        return mission;
    }
}
