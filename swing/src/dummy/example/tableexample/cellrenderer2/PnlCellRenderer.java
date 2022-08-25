package dummy.example.tableexample.cellrenderer2;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PnlCellRenderer extends JPanel {
    ExperienceTable tblExperience;
    ExperienceTableModel experienceTableModel;
    List<Experience> experienceList = new ArrayList<>();

    public PnlCellRenderer() {
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        createList();
        initTable();
    }

    private void createList() {
        Experience experience1 = new Experience("Ahmet", 5, 2);
        Experience experience2 = new Experience("Esra", 4, 5);
        Experience experience3 = new Experience("Badem", 0, 0);
        Experience experience4 = new Experience("Tarçın", 1, 2);
        Experience experience5 = new Experience("Bebem", 3, 0);
        experienceList.add(experience1);
        experienceList.add(experience2);
        experienceList.add(experience3);
        experienceList.add(experience4);
        experienceList.add(experience5);

    }

    private void initTable() {
        experienceTableModel = new ExperienceTableModel(experienceList);
        //tblExperience = new ExperienceTable(experienceTableModel);
        tblExperience = new ExperienceTable(experienceTableModel) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                //Component component = super.prepareRenderer(renderer, row, column);
                Component component;
                int directiveVal;
                int doneVal;
                switch (column) {
                    case ExperienceTableModel.DIRECTIVE:
                        directiveVal = (int) getValueAt(row, ExperienceTableModel.DIRECTIVE);
                        if (directiveVal == 0) {
                            component = super.prepareRenderer(renderer, row, ExperienceTableModel.DIRECTIVE);
                            component.setBackground(Color.lightGray);
                        } else {
                            component = super.prepareRenderer(renderer, row, ExperienceTableModel.DIRECTIVE);
                            component.setBackground(getBackground());
                        }
                        break;
                    case ExperienceTableModel.DONE:
                        directiveVal = (int) getValueAt(row, ExperienceTableModel.DIRECTIVE);
                        doneVal = (int) getValueAt(row, ExperienceTableModel.DONE);
                        if (doneVal == 0 && directiveVal == 0) {
                            component = super.prepareRenderer(renderer, row, ExperienceTableModel.DONE);
                            component.setBackground(Color.lightGray);
                        } else {
                            if (doneVal >= directiveVal) {
                                component = super.prepareRenderer(renderer, row, ExperienceTableModel.DONE);
                                component.setBackground(Color.green);
                            } else if (doneVal < directiveVal) {
                                component = super.prepareRenderer(renderer, row, ExperienceTableModel.DONE);
                                component.setBackground(Color.red);
                            } else {
                                component = super.prepareRenderer(renderer, row, ExperienceTableModel.DONE);
                                component.setBackground(Color.lightGray);
                            }
                        }
                        break;
                    default:
                        component = super.prepareRenderer(renderer, row, column);
                        break;
                }

                return component;
            }
        };

        //tblExperience.setDefaultRenderer(Object.class, new ExperienceTableCellRenderer());
        this.add(new JScrollPane(tblExperience), BorderLayout.CENTER);
    }


}
