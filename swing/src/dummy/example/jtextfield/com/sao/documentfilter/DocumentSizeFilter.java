package dummy.example.jtextfield.com.sao.documentfilter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * @saozdemir
 * @Hv.Müh.Ütğm
 */
public class DocumentSizeFilter extends DocumentFilter {
    private int maxSize;
    private String mask;

    public DocumentSizeFilter(int maxSize, String mask) {
        this.maxSize = maxSize;
        this.mask = mask;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if ((fb.getDocument().getLength() + string.length()) <= maxSize) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if ((fb.getDocument().getLength() + text.length() - length) <= maxSize) {
            //char[] ch = text.toCharArray();
            if(mask.contains(text.toUpperCase()))//Character.isLetter(ch[0]) || Character.isDigit(ch[0])
                super.replace(fb, offset, length, text.toUpperCase(), attrs);
        }
    }
}
