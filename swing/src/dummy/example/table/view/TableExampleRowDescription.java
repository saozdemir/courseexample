package dummy.example.table.view;

import dummy.example.table.model.Person;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableExampleRowDescription extends AbstractTableModel {
    public final int ID = 0;
    public final int NAME = 1;
    public final int SURNAME = 2;
    public static List<Person> personsList;
    public static final String[] COLUMN_NAMES = {"ID", "NAME", "SURNAME"};

    static {
        personsList = new ArrayList<>();
        Person p1 = new Person(1, "Esra", "ÖZDEMİR");
        Person p2 = new Person(2, "Ahmet", "ÖZDEMİR");
        Person p3 = new Person(3, "Badem", "ÖZDEMİR");
        Person p4 = new Person(4, "Tarçın", "ÖZDEMİR");

        personsList.add(p1);
        personsList.add(p2);
        personsList.add(p3);
        personsList.add(p4);
    }

    @Override
    public int getRowCount() {
        return personsList.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = personsList.get(rowIndex);

        switch (columnIndex) {
            case ID:
                return person.getId();
            case NAME:
                return person.getName();
            case SURNAME:
                return person.getSurname();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Person person = (Person) aValue;
        switch (columnIndex) {
            case ID:
                person.setId((int) ((Person) aValue).getId());
                break;
            case NAME:
                person.setName((String) person.getName());
                break;
            case SURNAME:
                person.setSurname((String) person.getSurname());
        }
    }

    public void getColumnSize(int column) {

    }

}
