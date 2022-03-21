package _sw12events.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPanel extends JPanel {
    private JTextField txt;
    private JButton btnAdd;
    private AddPanelListener addPanelListener; // Panel için yazılan listener Sınıfı. Panelde butona tıklanınca aktif olacakç

    public AddPanel() {
        txt = new JTextField(15);
        btnAdd = new JButton("Add");
        this.setLayout(new FlowLayout());
        this.add(txt);
        this.add(btnAdd);

        btnAdd.addActionListener(new ActionListener() { //Butona action Listener eklendi
            @Override
            public void actionPerformed(ActionEvent e) {
                String addText = txt.getText();

                AddPanelEvent ev = new AddPanelEvent(this, addText);
                if (addPanelListener != null) {
                    addPanelListener.addPanelEventOccured(ev);// Butona tıklanınca oluşan eventi gönder.
                }
            }
        });
    }

    public void setAddPanelListener(AddPanelListener addPanelListener) {
        this.addPanelListener = addPanelListener;
    }
}
