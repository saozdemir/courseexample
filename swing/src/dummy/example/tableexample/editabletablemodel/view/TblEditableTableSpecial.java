package dummy.example.tableexample.editabletablemodel.view;

import dummy.example.tableexample.editabletablemodel.abstractmodel.SpecialAbstractTableModel;
import dummy.example.tableexample.editabletablemodel.data.Person;

import javax.swing.*;
import java.util.List;

public class TblEditableTableSpecial extends JTable {
    public TblEditableTableSpecial(SpecialAbstractTableModel<Person> tableModelSpecial) {
        super(tableModelSpecial);
        init();
    }

    private void init() {
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public Object getSelectedObject() {
        Object retval = null;
        if (this.getModel() instanceof SpecialAbstractTableModel) {
            int selectedRow = this.getSelectedRow();
            if (selectedRow >= 0 && selectedRow < this.getRowCount()) {
                SpecialAbstractTableModel rowListModel = (SpecialAbstractTableModel) this.getModel();
                List items = rowListModel.getData();
                retval = items.get(selectedRow);
            }
        }
        return retval;
    }
}
