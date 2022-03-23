package _sw17menus;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel;


    public MainFrame() {
        super("Hello World");

        setLayout(new BorderLayout());

        toolbar = new Toolbar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();

        this.setJMenuBar(createMenuBar());

        toolbar.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        formPanel.setFormListener(new FormListener() {
            public void formEventOccured(FormEvent e) {
                String name = e.getName();
                String occupation = e.getOccupation();
                int ageCat = e.getAgeCategory();
                String empCat = e.getEmpCategory();
                boolean isCitizen = e.isCitizen();
                String gender = e.getGender();

                textPanel.appendText(name + " : " + occupation + " : " + ageCat + " : " + empCat + " : " + isCitizen + " : " + gender + "\n");
            }
        });

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        setMinimumSize(new Dimension(200, 200));
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem exportDataItem = new JMenuItem("Export Data...");
        JMenuItem importDataItem = new JMenuItem("Import Data...");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.add(exitItem);


        JMenu windowMenu = new JMenu("Window");
        JMenu showmenu = new JMenu("Show");
        JMenuItem showFormItem = new JMenuItem("Person Form");
        showmenu.add(showFormItem);
        windowMenu.add(showmenu);


        menuBar.add(fileMenu);
        menuBar.add(windowMenu);
        return menuBar;
    }
}
