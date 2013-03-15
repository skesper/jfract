package de.jfract.gui;

import de.jfract.gui.actions.ExportCalculationAction;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * User: kesper
 * Date: 11.03.13
 * Time: 09:56
 */
public class ExportFrame extends javax.swing.JFrame {
    private javax.swing.JButton doItButton;
    private javax.swing.JTextField fileNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton selectButton;
    private javax.swing.JTextField xResField;
    private javax.swing.JTextField yResField;

    public ExportFrame() {
        initComponents();
    }

    public void setXRes(int xres) {
        xResField.setText("" + xres);
    }

    public void setYRes(int yres) {
        yResField.setText("" + yres);
    }

    public int getXRes() {
        return Integer.parseInt(xResField.getText());
    }

    public int getYRes() {
        return Integer.parseInt(yResField.getText());
    }

    public String getExportFileName() {
        return fileNameField.getText();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        xResField = new javax.swing.JTextField();
        yResField = new javax.swing.JTextField();
        fileNameField = new javax.swing.JTextField();
        selectButton = new javax.swing.JButton();
        doItButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Export");

        jLabel1.setText("x-resolution");

        jLabel2.setText("y-resolution");

        fileNameField.setEditable(false);

        selectButton.setAction(new SelectButtonAction("..."));

        doItButton.setAction(new ExportCalculationAction(this));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(fileNameField)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(selectButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(yResField)
                                                        .addComponent(xResField)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 288, Short.MAX_VALUE)
                                                .addComponent(doItButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(xResField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(yResField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fileNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectButton))
                                .addGap(18, 18, 18)
                                .addComponent(doItButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }


    private class SelectButtonAction extends AbstractAction {
        private SelectButtonAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.isDirectory() || f.getName().toLowerCase().endsWith(".png");
                }

                @Override
                public String getDescription() {
                    return "*.png";
                }
            });

            fc.showSaveDialog(ExportFrame.this);

            File selFile = fc.getSelectedFile();
            if (selFile!=null) {
                String path = selFile.getAbsolutePath();
                if (!path.endsWith(".png")) {
                    path = path.concat(".png");
                }
                ExportFrame.this.fileNameField.setText(path);
            }
        }
    }
}
