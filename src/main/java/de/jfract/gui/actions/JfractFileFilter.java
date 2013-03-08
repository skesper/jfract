package de.jfract.gui.actions;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * User: kesper
 * Date: 08.03.13
 * Time: 11:57
 */
public class JfractFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) return true;
        return f.getName().endsWith(".jf");
    }

    @Override
    public String getDescription() {
        return ".jf (jfract files)";
    }
}
