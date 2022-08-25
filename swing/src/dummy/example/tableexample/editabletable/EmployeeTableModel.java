package dummy.example.tableexample.editabletable;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {
    private final List<Employee> employeeList;

    private final String[] columnNames = new String[]{
            "ID", "NAME", "WORK TIME", "IS PART TIME"
    };
    private final Class[] columnClass = new Class[]{
            Integer.class, String.class, Double.class, Boolean.class
    };

    public EmployeeTableModel(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return employeeList.size();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee row = employeeList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return row.getId();
            case 1:
                return row.getName();
            case 2:
                return row.getWorkTime();
            case 3:
                return row.isPartTime();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Employee row = employeeList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                row.setId((Integer) aValue);
                break;
            case 1:
                row.setName((String) aValue);
                break;
            case 2:
                row.setWorkTime((Double) aValue);
                break;
            case 3:
                row.setPartTime((Boolean) aValue);
                break;
            default:
        }
    }
}
