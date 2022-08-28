package dummy.example.tableexample.cellrenderer2;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ExperienceTable extends JTable {
    public ExperienceTable(ExperienceTableModel experienceTableModel) {
        super(experienceTableModel);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        return super.prepareRenderer(renderer, row, column);
    }
}
