package dummy.example.tableexample.celleditorandrowdesc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author saozd
 * @project dummy.example.tableexample.celleditor courseexample
 * 1.08.2023 Ağu 2023
 */
public class FrmCellEditor extends JFrame {
    private JTable tblMissionTable;
    private MissionTableModel mdlMissionTableModel;
    JButton btnOk = new JButton("Tamam");

    /**
     * Constructs a new frame that is initially invisible.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    public FrmCellEditor() throws HeadlessException {
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(250, 200));
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initTable();
        actions();
        this.setVisible(true);
    }

    private void actions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tblMissionTable.isEditing()){
                    tblMissionTable.getCellEditor().stopCellEditing();
                    mdlMissionTableModel.fireTableDataChanged();
                }
            }
        });
    }

    private void initTable() {
        mdlMissionTableModel = new MissionTableModel();
        tblMissionTable = new JTable(mdlMissionTableModel);
        //tblMissionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//Otomatik Boyutlandırmayı kapatır.
        tblMissionTable.getTableHeader().setReorderingAllowed(false);//Sürükle bırak özelliğini kapatır.
        tblMissionTable.getColumnModel().getColumn(MissionTableModel.MISSION_NUMBER).setCellEditor(new CustomCellEditor(tblMissionTable));

        this.add(new JScrollPane(tblMissionTable), BorderLayout.CENTER);
        this.add(btnOk, BorderLayout.LINE_END);
    }
}
