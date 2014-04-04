/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.swing;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import pm.filemanager.controllers.ClearTableController;
import pm.filemanager.controllers.SetTreeModelController;
import pm.filemanager.controllers.TableFileDetailsController;
import pm.filemanager.controllers.CheckPathIfDirectoryController;
import pm.filemanager.operations.CheckPathIfDirectoryOperation;
import pm.filemanager.operations.ClearTableFao;
import pm.filemanager.operations.SetTreeModelOperation;
import pm.filemanager.operations.TableFileDetailsFao;
import pm.filemanager.operations.CreateNewFolderOperation;

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
        SetTreeModelController newSetTreeModelController = new SetTreeModelController();
         
        rootFileTree = newSetTreeModelController.SetTreeModelController(rootFileTree,"\\");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        
      
         rootFileTree.addTreeSelectionListener(new TreeSelectionListener() {  
  
        public void valueChanged(TreeSelectionEvent e) { 
            
            filePathTextField.setText(rootFileTree.getSelectionPath().getLastPathComponent().toString());
        
     }});      
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StatusBar = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        UpButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        HomeDirButton = new javax.swing.JButton();
        rootFileTreeScrollPane = new javax.swing.JScrollPane();
        rootFileTree = new javax.swing.JTree();
        rootFileTableScrollPane = new javax.swing.JScrollPane();
        fileDetailsTable = new javax.swing.JTable();
        filePathTextField = new javax.swing.JTextField();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        createFolderMenuItem = new javax.swing.JMenuItem();
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

        StatusBar.setText("Status");
        StatusBar.setName("Status"); // NOI18N

        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        rootFileTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        rootFileTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rootFileTreeMouseClicked(evt);
            }
        });
        rootFileTree.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rootFileTreeKeyPressed(evt);
            }
        });
        rootFileTreeScrollPane.setViewportView(rootFileTree);

        fileDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date modified", "Type", "Size"
            }
        ));
        rootFileTableScrollPane.setViewportView(fileDetailsTable);

        jMenu1.setText("File");

        createFolderMenuItem.setText("Create Folder");
        createFolderMenuItem.setName("CreateFolder"); // NOI18N
        createFolderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createFolderMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(createFolderMenuItem);
        createFolderMenuItem.getAccessibleContext().setAccessibleParent(createFolderMenuItem);

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
                        .addComponent(rootFileTreeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rootFileTableScrollPane))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HomeDirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(filePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(UpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(HomeDirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filePathTextField)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rootFileTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addComponent(rootFileTreeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        //statusbar.setBorder(BorderFactory.createEtchedBorder(
            // EtchedBorder.RAISED));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CloseMenuItemActionPerformed

    private void PasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasteMenuItemActionPerformed

    private void createFolderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFolderMenuItemActionPerformed
       CheckPathIfDirectoryController checkIfDirectory = new CheckPathIfDirectoryController();
       boolean ifDirectory = checkIfDirectory.checkPathIfDirectory(filePathTextField.getText().toString());
       
       if(ifDirectory){
            String pathForCreateFolder= filePathTextField.getText().toString()+"\\";
            CreateNewFolderOperation createFolder = new CreateNewFolderOperation();
       boolean success = createFolder.createNewFolderOperation(pathForCreateFolder);
            if (success) {
               System.out.println("success");
            }
            else {
               System.out.println("failed");
            }
           
       }
       else {
           System.out.println("You must select directory to make a new folder");
       }
      
           

    }//GEN-LAST:event_createFolderMenuItemActionPerformed

    private void CutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutMenuItemActionPerformed
        
    }//GEN-LAST:event_CutMenuItemActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add ActionListener to catch the Image Exception
       
    }//GEN-LAST:event_BackButtonActionPerformed

    private void rootFileTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rootFileTreeMouseClicked

        
        TableFileDetailsController newTableFileDetailsController = new TableFileDetailsController();
        //clear table
        

        ClearTableController clearTable = new ClearTableController();
        boolean isClear = clearTable.ClearTable(fileDetailsTable);

        //if is clear add new selected path
        if(isClear){
            //check if show all file details
            try{
           newTableFileDetailsController.TableFileDetailsController(fileDetailsTable,filePathTextField.getText().toString());
            }
            catch(Exception e){
                try {
                    throw e;
                } catch (Exception ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_rootFileTreeMouseClicked

    private void rootFileTreeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rootFileTreeKeyPressed

    }//GEN-LAST:event_rootFileTreeKeyPressed

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
    public javax.swing.JButton BackButton;
    private javax.swing.JMenuItem CloseMenuItem;
    private javax.swing.JMenu ContentsMenuItem;
    private javax.swing.JMenuItem CopyMenuItem;
    private javax.swing.JMenuItem CreateDocumentMenuItem;
    private javax.swing.JMenuItem CutMenuItem;
    private javax.swing.JMenuItem DeleteMenuItem;
    private javax.swing.JButton HomeDirButton;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton NextButton;
    private javax.swing.JMenuItem PasteMenuItem;
    private javax.swing.JMenuItem PropertiesMenuItem;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JMenuItem RenameMenuItem;
    private javax.swing.JLabel StatusBar;
    private javax.swing.JButton UpButton;
    private javax.swing.JMenuItem createFolderMenuItem;
    private javax.swing.JTable fileDetailsTable;
    private javax.swing.JTextField filePathTextField;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JScrollPane rootFileTableScrollPane;
    private javax.swing.JTree rootFileTree;
    private javax.swing.JScrollPane rootFileTreeScrollPane;
    // End of variables declaration//GEN-END:variables
}
