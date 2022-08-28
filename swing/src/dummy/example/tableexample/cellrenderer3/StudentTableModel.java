package dummy.example.tableexample.cellrenderer3;

import dummy.example.tableexample.editabletable.Employee;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {
    public static final int ID = 0;
    public static final int NAME = 1;
    public static final int EXAM = 2;
    private List<Student> studentList;

    public StudentTableModel(List<Student> studentList) {
        this.studentList = studentList;
    }

    private final String[] columnNames = new String[]{
            "ID", "NAME", "EXAM"
    };
    private final Class[] columnClass = new Class[]{
            Integer.class, String.class, Integer.class
    };

    @Override
    public int getRowCount() {
        return studentList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
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
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student row = studentList.get(rowIndex);
        switch (columnIndex) {
            case ID:
                return row.getId();
            case NAME:
                return row.getName();
            case EXAM:
                return row.getExam();
            default:
                return null;
        }
    }
}
