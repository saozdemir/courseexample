package _sw23serialization.gui;

import _sw23serialization.SwingThemes;
import _sw23serialization.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    private Controller controller;
    private TablePanel tablePanel; //JTable


    public MainFrame() {
        super("Hello World");

        try {
            UIManager.setLookAndFeel(SwingThemes.srt3);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());

        toolbar = new Toolbar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();
        tablePanel = new TablePanel();//

        controller = new Controller(); // Controller tanımlandı Main Frame oluştuğunda contrtoller de oluştu.

        //Tabloya Veri Yaz
        tablePanel.setData(controller.getPeople()); //TablePanel e veri yazdırmak için contoller get data metodunu çağırdı.
        // controller.getPeople() da Database getPeople() metodu ile list döndürür.

        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new PersonFileFilter());

        this.setJMenuBar(createMenuBar());

        toolbar.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        formPanel.setFormListener(new FormListener() {
            public void formEventOccured(FormEvent e) {
                controller.addPerson(e);// Buttona tıklanınca personel eklemek için FormEvent nesnesini contollere gönderdik.
                tablePanel.refresh(); //Her eleman eklendiğinde tabloyu yenile
            }
        });

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        //add(textPanel, BorderLayout.CENTER);
        add(tablePanel, BorderLayout.CENTER); //textPanel yerine artık tablePanel kullanacağız.

        setMinimumSize(new Dimension(500, 400));
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
        //JMenuItem showFormItem = new JMenuItem("Person Form");
        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Frame");
        showFormItem.setSelected(true);

        showmenu.add(showFormItem);
        windowMenu.add(showmenu);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        showFormItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
                formPanel.setVisible(menuItem.isSelected()); //Menudeki Checkbox seçili ise form paneli görünür yap
            }
        });

        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);

        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK)); //Ctrl + X ile kapatmak için

        importDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.loadFromFile(fileChooser.getSelectedFile()); //FileChoserdan dosyayı seçtik
                        tablePanel.refresh();
                        JOptionPane.showMessageDialog(MainFrame.this,"File Loaded", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Loading Failed", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            }
        });

        exportDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.saveToFile(fileChooser.getSelectedFile()); //FileChoserdan dosyayı seçtik
                        JOptionPane.showMessageDialog(MainFrame.this,"File Saved", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Save Failed", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = JOptionPane.showInputDialog(MainFrame.this,
                        "Enter your user name",
                        "Enter User Name",
                        JOptionPane.OK_OPTION | JOptionPane.QUESTION_MESSAGE);// Icon değiştirmek için
                System.out.println(text);

                int action = JOptionPane.showConfirmDialog(MainFrame.this, "Do you want exit?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
                if (action == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });

        return menuBar;
    }
}
