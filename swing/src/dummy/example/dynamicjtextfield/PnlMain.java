package dummy.example.dynamicjtextfield;

import annotation.DocumentFunction;
import annotation.DocumetClass;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

@DocumetClass(name = "Main Panel", description = "Dinamik JTextField Örneği", functions = {"FN_001"})
public class PnlMain extends JPanel {
    JTextField txtEnter = new JTextField(20);
    JTextField txtShow = new JTextField(20);

    public PnlMain() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Text Field"));

        txtShow.setEditable(false);
        txtShow.setText("First");

        this.add(txtEnter, BorderLayout.PAGE_START);
        this.add(txtShow, BorderLayout.PAGE_END);

        initForActions();
    }

    @DocumentFunction(functionName = "Initialize Actions", fuctionCode = "FN_001", description = "Actionların yazılacağı metotdur. Controller gibi görev yapar")
    private void initForActions() {
        txtEnter.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //textChange();
            }
        });
    }

    private void textChange() {
        String cacheText = txtEnter.getText();
        txtShow.setText(cacheText);
    }

}
