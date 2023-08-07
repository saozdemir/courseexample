package dummy.example.tableexample.editabletablemodel.abstractmodel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class SpecialAbstractTableModel<T> extends AbstractTableModel {
    private List<T> rowDataList = null;
    private SpecialRowDescription<T> rowDescription;
    private Class[] columnClasses;

    public SpecialAbstractTableModel(List<T> rowDataList, SpecialRowDescription<T> rowDescription) {
        this.rowDataList = rowDataList;
        this.rowDescription = rowDescription;
    }

    @Override
    public int getRowCount() {
        return rowDataList.size();
    }

    @Override
    public int getColumnCount() {
        return rowDescription.getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowDescription != null) {
            if (rowIndex < rowDataList.size()) {
                T rowData = rowDataList.get(rowIndex);
                Object value = rowDescription.getCellValueAt(columnIndex, rowData);

                initColumnClasses();

                if (columnIndex < columnClasses.length &&
                        columnClasses[columnIndex] == null && value != null) {
                    columnClasses[columnIndex] = value.getClass();
                }
                return value;
            }
        }
        return null;
    }

    private void initColumnClasses() {
        if (columnClasses == null) {
            columnClasses = new Class[rowDescription.getColumnCount()];
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (rowDescription != null && rowDescription instanceof SpecialRowDescription) {
            SpecialRowDescription<T> rowDesc = (SpecialRowDescription<T>) rowDescription;
            T obj = rowDesc.setCellValueAt(columnIndex, rowDataList.get(rowIndex), aValue);
            rowDataList.set(rowIndex, obj);
            fireTableRowsUpdated(rowIndex, rowIndex);
        }
    }

    public final List<T> getData() {
        return rowDataList;
    }

    public void setData(List<T> rowDataList) {
        this.rowDataList = rowDataList == null ? new ArrayList<>() : rowDataList;
    }

    public boolean isCellEditable(int row, int column) {
        boolean result = super.isCellEditable(row, column);
        if (rowDescription instanceof SpecialRowDescription) {
            result = ((SpecialRowDescription<T>) rowDescription).isCellEditable(row, column, getRowData(row));
        }
        return result;
    }

    private T getRowData(int row) {
        List<T> dataList = rowDataList;
        if (dataList != null && row >= 0 && row < getRowCount()) {
            return dataList.get(row);
        }
        return null;
    }
}
