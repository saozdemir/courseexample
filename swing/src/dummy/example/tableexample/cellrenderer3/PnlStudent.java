package dummy.example.tableexample.cellrenderer3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PnlStudent extends JPanel {
    private StudentTable tblStudent;
    private StudentTableModel studentTableModel;
    private List<Student> studentList = new ArrayList<>();

    public PnlStudent() {
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        createList();
        initTable();
    }

    private void createList() {
        Student s1 = new Student(1, "Ahmet", 20);
        Student s2 = new Student(2, "Esra", 50);
        Student s3 = new Student(3, "Badem", 60);
        Student s4 = new Student(4, "Tarçın", 90);
        Student s5 = new Student(5, "Bebem", 100);
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);

    }

    private void initTable() {
        studentTableModel = new StudentTableModel(studentList);
        tblStudent = new StudentTable(studentTableModel);


        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Table Panel"));
        this.add(new JScrollPane(tblStudent), BorderLayout.CENTER);
    }
}
