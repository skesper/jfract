package de.jfract.gui;

import de.jfract.ApplicationContext;
import de.jfract.math.Complex;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * User: kesper
 * Date: 26.02.13
 * Time: 09:38
 */
public class ParameterFrame extends JFrame {

    public ParameterFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        setIconImage(IconHolder.getIcon());
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        startPointRe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        startPointIm = new javax.swing.JTextField();
        fixPointRe = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fixPointIm = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        iterations = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton(new SaveAction());
        jButton2 = new javax.swing.JButton(new CancelAction());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Start Point:");

        jLabel2.setText("Fix Point:");

        jLabel3.setText("+ i");

        jLabel4.setText("+ i");

        jLabel5.setText("Iterations:");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(startPointRe)
                                                        .addComponent(fixPointRe, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(startPointIm))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(fixPointIm))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(iterations))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 214, Short.MAX_VALUE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(startPointRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(startPointIm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(fixPointRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(fixPointIm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private javax.swing.JTextField fixPointIm;
    private javax.swing.JTextField fixPointRe;
    private javax.swing.JTextField iterations;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField startPointIm;
    private javax.swing.JTextField startPointRe;

    public void setFixPoint(Complex fixPoint) {
        if (fixPoint!=null) {
            fixPointRe.setText(Double.toString(fixPoint.real()));
            fixPointIm.setText(Double.toString(fixPoint.imaginary()));
        }
    }

    public void setStartPoint(Complex startPoint) {
        if (startPoint!=null) {
            startPointRe.setText(Double.toString(startPoint.real()));
            startPointIm.setText(Double.toString(startPoint.imaginary()));
        }
    }

    public Complex getFixPoint() {
        String re = fixPointRe.getText();
        String im = fixPointIm.getText();
        if (fitForParsing(re) && fitForParsing(im)) {
            return new Complex(Double.parseDouble(re),Double.parseDouble(im));
        }
        return null;
    }

    public Complex getStartPoint() {
        String re = startPointRe.getText();
        String im = startPointIm.getText();
        if (fitForParsing(re) && fitForParsing(im)) {
            return new Complex(Double.parseDouble(re),Double.parseDouble(im));
        }
        return null;
    }

    private boolean fitForParsing(String s) {
        if (s==null) return false;
        if ("".equals(s.trim())) return false;
        return true;
    }

    public void setIterations(int it) {
        iterations.setText(Integer.toString(it));
    }

    public int getIterations() {
        return Integer.parseInt(iterations.getText());
    }

    private class SaveAction extends AbstractAction {
        private SaveAction() {
            putValue(Action.NAME, "Save");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ApplicationContext ac = ApplicationContext.getInstance();

            ac.getFractalParameters().setStartPoint(getStartPoint());
            ac.getFractalParameters().setFixPoint(getFixPoint());
            ac.getFractalParameters().setMaxit(getIterations());
            dispose();

            ApplicationContext.getInstance().recalculate();
        }
    }

    private class CancelAction extends AbstractAction {
        private CancelAction() {
            putValue(Action.NAME, "Cancel");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

}
