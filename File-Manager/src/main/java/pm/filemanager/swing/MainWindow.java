/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.swing;

import static java.awt.Event.UP;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import static javax.swing.SwingConstants.PREVIOUS;

/**
 *
 * @author PTsilopoulos
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form mainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        SidePane = new javax.swing.JTree();
        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollBar2 = new javax.swing.JScrollBar();
        NavigationToolbar = new javax.swing.JToolBar();
        ContentPane = new javax.swing.JPanel();
        jScrollBar3 = new javax.swing.JScrollBar();
        StatusBar = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        UpButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        HomeDirButton = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        CurrentFolderMenuItem = new javax.swing.JMenuItem();
        CreateDocumentMenuItem = new javax.swing.JMenuItem();
        PropertiesMenuItem = new javax.swing.JMenuItem();
        CloseMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        CutMenuItem = new javax.swing.JMenuItem();
        CopyMenuItem = new javax.swing.JMenuItem();
        PasteMenuItem = new javax.swing.JMenuItem();
        DeleteMenuItem = new javax.swing.JMenuItem();
        RenameMenuItem = new javax.swing.JMenuItem();
        ContentsMenuItem = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollBar2.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        NavigationToolbar.setRollover(true);

        ContentPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContentPaneMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ContentPaneLayout = new javax.swing.GroupLayout(ContentPane);
        ContentPane.setLayout(ContentPaneLayout);
        ContentPaneLayout.setHorizontalGroup(
            ContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ContentPaneLayout.setVerticalGroup(
            ContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        StatusBar.setText("Status");
        StatusBar.setName("Status"); // NOI18N

        BackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pm/filemanager/images/BackIcon.png"))); // NOI18N
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        NextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pm/filemanager/images/NextIcon.png"))); // NOI18N

        UpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pm/filemanager/images/UpIcon.png"))); // NOI18N

        RefreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pm/filemanager/images/RefreshIcon.png"))); // NOI18N

        HomeDirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pm/filemanager/images/HomeIcon.png"))); // NOI18N

        jMenu1.setText("File");

        CurrentFolderMenuItem.setText("Create Folder");
        CurrentFolderMenuItem.setName("CreateFolder"); // NOI18N
        CurrentFolderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrentFolderMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(CurrentFolderMenuItem);
        CurrentFolderMenuItem.getAccessibleContext().setAccessibleParent(CurrentFolderMenuItem);

        CreateDocumentMenuItem.setText("Create Document");
        jMenu1.add(CreateDocumentMenuItem);

        PropertiesMenuItem.setText("Properties");
        jMenu1.add(PropertiesMenuItem);

        CloseMenuItem.setText("Close");
        CloseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(CloseMenuItem);

        MenuBar.add(jMenu1);

        jMenu2.setText("Edit");

        CutMenuItem.setText("Cut");
        CutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(CutMenuItem);

        CopyMenuItem.setText("Copy");
        jMenu2.add(CopyMenuItem);

        PasteMenuItem.setText("Paste");
        PasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasteMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(PasteMenuItem);

        DeleteMenuItem.setText("Delete");
        jMenu2.add(DeleteMenuItem);

        RenameMenuItem.setText("Rename");
        jMenu2.add(RenameMenuItem);

        MenuBar.add(jMenu2);

        ContentsMenuItem.setText("Help");

        jMenuItem10.setText("Contents...");
        ContentsMenuItem.add(jMenuItem10);

        MenuBar.add(ContentsMenuItem);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(UpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(HomeDirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ContentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NavigationToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NavigationToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BackButton, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HomeDirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ContentPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                            .addComponent(jScrollBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        statusbar.setBorder(BorderFactory.createEtchedBorder(
            EtchedBorder.RAISED));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CloseMenuItemActionPerformed

    private void PasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasteMenuItemActionPerformed

    private void CurrentFolderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrentFolderMenuItemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CurrentFolderMenuItemActionPerformed

    private void CutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CutMenuItemActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add ActionListener to catch the Image Exception
       
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ContentPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContentPaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ContentPaneMouseClicked

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JMenuItem CloseMenuItem;
    private javax.swing.JPanel ContentPane;
    private javax.swing.JMenu ContentsMenuItem;
    private javax.swing.JMenuItem CopyMenuItem;
    private javax.swing.JMenuItem CreateDocumentMenuItem;
    private javax.swing.JMenuItem CurrentFolderMenuItem;
    private javax.swing.JMenuItem CutMenuItem;
    private javax.swing.JMenuItem DeleteMenuItem;
    private javax.swing.JButton HomeDirButton;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JToolBar NavigationToolbar;
    private javax.swing.JButton NextButton;
    private javax.swing.JMenuItem PasteMenuItem;
    private javax.swing.JMenuItem PropertiesMenuItem;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JMenuItem RenameMenuItem;
    private javax.swing.JTree SidePane;
    private javax.swing.JLabel StatusBar;
    private javax.swing.JButton UpButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollBar jScrollBar3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
