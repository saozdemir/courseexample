package dummy.example.jtextfield.com.sao;

import dummy.example.jtextfield.com.sao.documentfilter.DocumentSizeFilter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;

public class PnlTextArea extends JPanel {
    //JTextArea txtDescription = new JTextArea(1, 3);
    //FormattedTextArea txtDescription = new FormattedTextArea(50, FormattedTextArea.SPECIAL);
    FormattedTextAreaPane formattedTextAreaPane;
//    JLabel lblSize = new JLabel("Size: ");
//
//    DefaultStyledDocument document;
//
//    private int MAX = 100;
    public PnlTextArea(){
        this.setLayout(new BorderLayout());
        formattedTextAreaPane = new FormattedTextAreaPane(50, FormattedTextArea.SPECIAL);
        formattedTextAreaPane.enableSizeLabel(true);
        this.add(formattedTextAreaPane, BorderLayout.CENTER);
    }

//    public PnlTextArea() {
//        this.setLayout(new BorderLayout());
//        formattedTextAreaPane = new FormattedTextAreaPane(50, FormattedTextArea.SPECIAL);
//        this.add(formattedTextAreaPane, BorderLayout.CENTER);
//        this.add(txtDescription, BorderLayout.CENTER);
//        this.add(lblSize, BorderLayout.PAGE_END);
//        txtDescription.setLineWrap(true);
//        txtDescription.setWrapStyleWord(true);

//        document = new DefaultStyledDocument();
//        document.setDocumentFilter(new DocumentSizeFilter(MAX));
//        document.addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                updateCount();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                updateCount();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                updateCount();
//            }
//        });
//        txtDescription.setDocument(document);
//        updateCount();
//
//    }
//
//    private void updateCount() {
//        lblSize.setText((MAX - document.getLength()) + " characters remaining");
//    }
//    }
}
