package dummy.example.listfindsimilar;

import annotation.DocumentFunction;
import annotation.DocumetClass;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DocumetClass(name = "Main Panel", description = "Dinamik JTextField ile Aranan Listeyi filtreleme", functions = {"FN_001"})
public class PnlMain extends JPanel {
    static String[] arrayText = {"JAVA", "JAVASCRIPT", "C SHARP", "PYTON", "JAVA ENTERPRISE", "REACTH"};
    List<String> listText;
    JTextField txtEnter = new JTextField(20);
    JList listTexts = new JList();
    DefaultListModel listModel = new DefaultListModel();
    JTextField txtShow = new JTextField(20);

    public PnlMain() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Text Field"));

        txtShow.setEditable(false);
        txtShow.setText("First");

        this.add(txtEnter, BorderLayout.PAGE_START);
        this.add(listTexts, BorderLayout.CENTER);
        this.add(txtShow, BorderLayout.PAGE_END);
        fillTheList();

        initForActions();
    }

    private void fillTheList() {
        listText = new ArrayList<String>(Arrays.asList(arrayText));
        for (String text : listText) {
            listModel.addElement(text);
        }
        listTexts.setModel(listModel);

    }

    @DocumentFunction(functionName = "Initialize Actions", fuctionCode = "FN_001", description = "Actionların yazılacağı metotdur. Controller gibi görev yapar")
    private void initForActions() {
        txtEnter.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchElement();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchElement();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchElement();
            }
        });
    }

    @DocumentFunction(functionName = "Contain List", fuctionCode = "FN_002", description = "List içinde aranacak string parçasını içeren elemanları getitirir.")
    private void searchElement() {
        List<String> searchList = new ArrayList<>();
        String searchText = txtEnter.getText().toUpperCase();
        if (searchText == "") {
            searchList.addAll(listText);
        } else {
            for (String serach : listText) {
                if (serach.contains(searchText)) {
                    searchList.add(serach);
                }
            }
        }

        listModel.clear();
        for (String text : searchList) {
            listModel.addElement(text);
        }

        txtShow.setText(searchText);
    }

}
