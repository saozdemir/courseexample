package _sw28passwords.gui;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import java.io.File;

public class PersonFileFilter extends FileFilter {
    /**
     * Whether the given file is accepted by this filter.
     *
     * @param f
     */
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return  true;
        }

        String name = f.getName();

        String extension = Utils.getFileExtension(name);
        if (extension == null) {
            return false;
        }

        if (extension.equals("per")) {
            return true;
        }
        return false;
    }

    /**
     * The description of this filter. For example: "JPG and GIF Images"
     *
     * @see FileView#getName
     */
    @Override
    public String getDescription() {
        return "Person database files (*.per)";
    }
}
