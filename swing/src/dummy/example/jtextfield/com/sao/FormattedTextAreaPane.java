package dummy.example.jtextfield.com.sao;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * @saozdemir
 * @Hv.Müh.Ütğm
 */
public class FormattedTextAreaPane extends JPanel {
    private FormattedTextArea textArea;
    private JLabel lblSize = new JLabel("");
    private int maxSize;
    private String mask;

    public FormattedTextAreaPane(int maxSize, String mask) {
        this.maxSize = maxSize;
        this.mask = mask;
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        textArea = new FormattedTextArea(maxSize, mask);
        this.add(new JScrollPane(textArea), BorderLayout.CENTER);
        this.add(lblSize, BorderLayout.PAGE_END);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSize();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSize();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSize();
            }
        });
        updateSize();
    }

    private void updateSize() {
        lblSize.setText("" + (maxSize - textArea.getDocument().getLength()));
    }

    public FormattedTextArea getTextArea() {
        return textArea;
    }

    public void enableSizeLabel(boolean isVisible) {
        lblSize.setVisible(isVisible);
    }
}
