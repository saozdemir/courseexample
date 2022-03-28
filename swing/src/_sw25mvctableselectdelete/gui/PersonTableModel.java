package _sw25mvctableselectdelete.gui;

import _sw25mvctableselectdelete.model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonTableModel extends AbstractTableModel {
    private List<Person> db;

    private String[] colNames = {
            "ID", "Name", "Occupation", "Age Category", "Employment Category", "Citizen", "Tax ID"
    };

    public PersonTableModel() {
    }

    public void setData(List<Person> db) {
        this.db = db;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return db.size(); //Dizideki eleman sayısı
    }

    @Override
    public int getColumnCount() {
        return 7;
    }



    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = db.get(rowIndex); //Tabloya eleman yazdırma için tanımlandı

        switch (columnIndex) {
            case 0:
                return person.getId();
            case 1:
                return person.getName();
            case 2:
                return person.getOccupation();
            case 3:
                return person.getAgeCategory();
            case 4:
                return person.getEmpCategory();
            case 5:
                return person.isCitizen();
            case 6:
                return person.getTaxId();
            default:
                return null;
        }
    }
}
