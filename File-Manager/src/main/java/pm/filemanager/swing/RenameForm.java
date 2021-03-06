/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.swing;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pm.filemanager.controllers.RenameController;

/**
 *
 * @author alex
 */
public class RenameForm extends javax.swing.JFrame {
boolean resultCorrectTxtName;
    /**
     * Creates new form renameForm
     */
    public RenameForm() {
        initComponents();
        oldPathTextField.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oldPathTextField = new javax.swing.JTextField();
        oldPathLabel = new javax.swing.JLabel();
        newNameLabel = new javax.swing.JLabel();
        newNameTextField = new javax.swing.JTextField();
        renameTitleLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        anncoumentLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        oldPathLabel.setText("old Path");

        newNameLabel.setText("new name");

        newNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newNameTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newNameTextFieldKeyReleased(evt);
            }
        });

        renameTitleLabel.setText("Rename");

        okButton.setText("ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(oldPathLabel)
                                    .addComponent(newNameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(oldPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(renameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(anncoumentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(renameTitleLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldPathLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newNameLabel))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 45, Short.MAX_VALUE)
                .addComponent(anncoumentLabel)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        RenameController renameAFile = new RenameController(oldPathTextField.getText().toString(), newNameTextField.getText().toString());
        File pathFile = new File(oldPathTextField.getText().toString());
        if(pathFile.exists()) {
            try {
                if(!renameAFile.rename()) {
                    anncoumentLabel.setText("Faild to rename!");
                    anncoumentLabel.setForeground(Color.red);
                } else {
                    anncoumentLabel.setText("Success");
                    anncoumentLabel.setForeground(Color.green);
                }
            } catch (IOException ex) {
                Logger.getLogger(RenameForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("The file does not exist!");
        }
        MainWindow.rootFileTree.updateUI();
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void newNameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newNameTextFieldKeyPressed
        
    }//GEN-LAST:event_newNameTextFieldKeyPressed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
       this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void newNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newNameTextFieldKeyReleased
//        File pathFile = new File(oldPathTextField.getText().toString());
//        
//        if(pathFile.isFile()){
//            CorrectTxtNameController newCorrectTxtName = new CorrectTxtNameController();
//           resultCorrectTxtName =newCorrectTxtName.CorrectTxtName(newNameTextField.getText().toString());
//                if(resultCorrectTxtName){
//                    newNameTextField.setBackground(Color.green);
//                    okButton.setVisible(true);
//                    
//                }
//                else{
//                     newNameTextField.setBackground(Color.red);
//                     anncoumentLabel.setText("new name must ends with .txt");
//                      anncoumentLabel.setForeground(Color.red);
//                     okButton.setVisible(false);
//                     
//                }
//        }
//        else{
//            CorrectNameController newCorrectName = new CorrectNameController();
//            resultCorrectTxtName =newCorrectName.CorrectName(newNameTextField.getText().toString());
//                if(resultCorrectTxtName){
//                    newNameTextField.setBackground(Color.green);
//                    okButton.setVisible(true);
//                    
//                }
//                else{
//                     newNameTextField.setBackground(Color.red);
//                     anncoumentLabel.setText("wrong name");
//                      anncoumentLabel.setForeground(Color.red);
//                     okButton.setVisible(false);
//                      
//                }
//            
//        }
//         MainWindow.rootFileTree.updateUI();
    }//GEN-LAST:event_newNameTextFieldKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RenameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RenameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RenameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RenameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RenameForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anncoumentLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel newNameLabel;
    private javax.swing.JTextField newNameTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel oldPathLabel;
    protected static javax.swing.JTextField oldPathTextField;
    private javax.swing.JLabel renameTitleLabel;
    // End of variables declaration//GEN-END:variables
}
