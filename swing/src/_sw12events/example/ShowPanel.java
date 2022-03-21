package _sw12events.example;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.JavaParam;

import javax.swing.*;
import java.awt.*;

public class ShowPanel extends JPanel {
    private JTextArea textArea;

    public ShowPanel() {
        this.textArea = new JTextArea();
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}
