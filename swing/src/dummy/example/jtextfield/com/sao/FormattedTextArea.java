package dummy.example.jtextfield.com.sao;

import dummy.example.jtextfield.com.sao.documentfilter.DocumentSizeFilter;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;

/**
 * @saozdemir
 * @Hv.Müh.Ütğm
 */
public class FormattedTextArea extends JTextArea {
    public static final String UPPER_CASE_ALPHABETIC_TR = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZWX";
    public static final String NUMERIC = "0123456789";
    public static final String SPECIAL = UPPER_CASE_ALPHABETIC_TR + NUMERIC + "[]()-_";

    private int maxSize;
    private String mask;

    DefaultStyledDocument document;

    public FormattedTextArea(int maxSize, String mask) {
        this.maxSize = maxSize;
        this.mask = mask;
        initialize();
    }

    private void initialize() {
        document = new DefaultStyledDocument();
        document.setDocumentFilter(new DocumentSizeFilter(maxSize, mask));
        this.setDocument(document);
    }

    public DefaultStyledDocument getDefaultStyledDocument() {
        return document;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getMask() {
        return mask;
    }
}
