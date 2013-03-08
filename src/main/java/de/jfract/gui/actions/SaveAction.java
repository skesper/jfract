package de.jfract.gui.actions;

import de.jfract.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 01.03.13
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public class SaveAction extends AbstractAction {
    public SaveAction() {
        putValue(Action.NAME, "Save ...");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser ch = new JFileChooser(System.getProperty("user.dir"));
        ch.setFileFilter(new JfractFileFilter());
        if (ch.showSaveDialog(null) == JFileChooser.CANCEL_OPTION) return;

        try {
            File selectedFile = ch.getSelectedFile();
            if (!selectedFile.getName().endsWith(".jf")) {
                selectedFile = new File(selectedFile.getAbsolutePath().concat(".jf"));
            }
            FileOutputStream fos = new FileOutputStream(selectedFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ApplicationContext.getInstance().getFractalParameters());
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
