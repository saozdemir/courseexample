package dummy.example.tableexample.cellrenderer2;

import dummy.example.tableexample.editabletable.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ExperienceTableModel extends AbstractTableModel {
    private List<Experience> experienceList;
    public static final int NAME = 0;
    public static final int DIRECTIVE = 1;
    public static final int DONE = 2;

    public ExperienceTableModel(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    private final String[] columnNames = new String[]{
            "NAME", "DIRECTIVE", "DONE"
    };
    private final Class[] columnClass = new Class[]{
            String.class, Integer.class, Integer.class
    };

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return experienceList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Experience row = experienceList.get(rowIndex);
        switch (columnIndex) {
            case NAME:
                return row.getName();
            case DIRECTIVE:
                return row.getDirective();
            case DONE:
                return row.getDone();
            default:
                return null;
        }
    }
}
