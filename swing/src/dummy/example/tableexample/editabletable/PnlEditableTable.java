package dummy.example.tableexample.editabletable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PnlEditableTable extends JPanel {
    EmployeeTableModel model;
    JTable tblEditable;
    List<Employee> employeeList = new ArrayList<Employee>();

    public PnlEditableTable() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Table Panel"));
        initTablePane();
        this.add(new JScrollPane(tblEditable), BorderLayout.CENTER);
    }

    private void initTablePane() {
        generateData();
        model = new EmployeeTableModel(employeeList);
        tblEditable = new JTable(model);
    }

    private void generateData() {
        Employee row1 = new Employee(1, "John", 40.0, false);
        Employee row2 = new Employee(2, "Rambo", 70.0, false);
        Employee row3 = new Employee(3, "Zorro", 60.0, true);

        employeeList.add(row1);
        employeeList.add(row2);
        employeeList.add(row3);
    }
}
