/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.swing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import org.apache.commons.io.FileUtils;
import pm.filemanager.controllers.ClearTableController;
import pm.filemanager.controllers.CutFileController;
import pm.filemanager.controllers.DeleteFileController;
import pm.filemanager.controllers.SetTreeModelController;
import pm.filemanager.controllers.setTableFileDetailsController;
import pm.filemanager.controllers.checkPathIfDirectoryController;
import pm.filemanager.controllers.stringIfEndsWithSeparatorController;
import pm.filemanager.model.CopyModel;
import pm.filemanager.model.PathModel;
import pm.filemanager.model.StackModel;
import pm.filemanager.operations.CreateNewFileOperation;
import pm.filemanager.operations.CreateNewFolderOperation;
import pm.filemanager.operations.FileOperations;
import pm.filemanager.operations.PathCopyToClipboardOperations;
import pm.filemanager.operations.StackPushOperation;
import pm.filemanager.validators.FixTreeSelectionStringtoCorrectedPathValidator;

/**
 *
 * @author PTsilopoulos
 */
public class MainWindow extends javax.swing.JFrame {
PathModel newPathModel = new PathModel();
StackPushOperation newStackPush = new StackPushOperation();
CopyModel newCopy =  new CopyModel();
StackModel newStack = new StackModel();
//stack for pop
Stack<String> stackPop = new Stack<String>();
//stack for prev
Stack<String> stackPrev = new Stack<String>();
private int countStack=-1;
private int countStackPov=-1;
private int countStackPrev=-1;
    /**
     * Creates new form mainWindow
     */
    public MainWindow() {
        initComponents();
       // backButton.setIcon(new ImageIcon(getClass().getResource("//pm.filemanager.images//BackIcon.png")));
        //set tree model
        SetTreeModelController newSetTreeModelController = new SetTreeModelController();
        rootFileTree = newSetTreeModelController.SetTreeModelController(rootFileTree);
//------------------------------------------------------------------------------------        
//------------------------------------------------------------------------------------        
//add listener
//        JTreeValueChangedController newJTreeValueChangedController = new JTreeValueChangedController();
//        newJTreeValueChangedController.valueChanged(rootFileTree, filePathTextField);
//TODO:Check how refactor this code  
         rootFileTree.addTreeSelectionListener(new TreeSelectionListener() {  
  
        public void valueChanged(TreeSelectionEvent e) { 
            FixTreeSelectionStringtoCorrectedPathValidator newCorrectPath = new FixTreeSelectionStringtoCorrectedPathValidator();
             String pathForNode = newCorrectPath.FixTreeSelectionStringToCorrectedPath(e);
            filePathTextField.setText(pathForNode);
           newPathModel.setPath(pathForNode);
           //stack add for undo redo
           newStackPush.StackPush(stackPop, pathForNode);
           //stack for prev
           newStackPush.StackPush(stackPrev, pathForNode);
           
           countStack+=1;
           countStackPov+=1;
           countStackPrev+=1;
           
           
            
     }});    
        
//------------------------------------------------------------------------------------       
//------------------------------------------------------------------------------------        
        PathCopyToClipboardOperations newPathCopyToClipboardOperations = new PathCopyToClipboardOperations();
        
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
       
        //System.out.println(newPathModel.getPath());
       
//RightClicker
        //fileDetailsTable.addMouseListener(new RightClicker());
//        
//         rootFileTree.addTreeSelectionListener(new TreeSelectionListener() {  
//  
//        public void valueChanged(TreeSelectionEvent e) { 
//           FixTreeSelectionStringtoCorrectedPathValidator newCorrectPath = new FixTreeSelectionStringtoCorrectedPathValidator();
//             String pathForNode = newCorrectPath.FixTreeSelectionStringToCorrectedPath(e);
//            filePathTextField.setText(pathForNode);
//        
//     }});  
//        //drag and drop
//        TreeDragAndDropOperations newTreeDragAndDropOperations = new TreeDragAndDropOperations();
//        newTreeDragAndDropOperations.getContent(rootFileTree);
//    //this.add(new TreeDragAndDropOperations().getContent());   
//------------------------------------------------------------------------------------        
//------------------------------------------------------------------------------------         
        //TODO:Check how refactor this code
        fileDetailsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
           stringIfEndsWithSeparatorController newStringIfEndsWithSeparatorController = new stringIfEndsWithSeparatorController();
           String nowPath = newStringIfEndsWithSeparatorController.stringIfEndsWithSeparator(filePathTextField);
              fileDetailsTable.getValueAt(fileDetailsTable.getSelectedRow(),0);
          filePathTextField.setText("");
           filePathTextField.setText(newPathModel.getPath().toString()+fileDetailsTable.getValueAt(fileDetailsTable.getSelectedRow(),0).toString() +"\\");
           //stack add for undo redo 
            newStackPush.StackPush(stackPop,newPathModel.getPath().toString()+fileDetailsTable.getValueAt(fileDetailsTable.getSelectedRow(),0) +"\\");
            newStackPush.StackPush(stackPrev, newPathModel.getPath().toString()+fileDetailsTable.getValueAt(fileDetailsTable.getSelectedRow(),0) +"\\");          
            countStack+=1;
           countStackPov+=1;
           countStackPrev+=1;
           // ClearTableAddTableDetails();
        }
    });
 //------------------------------------------------------------------------------------        
//------------------------------------------------------------------------------------         
    }
    
    /**
     * 
     * Add table details
     */
    private void ClearTableAddTableDetails(){
        
        setTableFileDetailsController newTableFileDetailsController = new setTableFileDetailsController();
        //clear table
        ClearTableController clearTable = new ClearTableController();
        boolean isClear = clearTable.ClearTable(fileDetailsTable);

        //if is clear add new selected path
        if (isClear) {
            //check if show all file details
            try {
                newTableFileDetailsController.setTableFileDetailsController(fileDetailsTable, filePathTextField.getText().toString());
            } catch (Exception e) {
                try {
                    throw e;
                } catch (Exception ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePopupMenu = new javax.swing.JPopupMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        StatusBar = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        UpButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        homeDirButton = new javax.swing.JButton();
        rootFileTreeScrollPane = new javax.swing.JScrollPane();
        rootFileTree = new javax.swing.JTree();
        filePathTextField = new javax.swing.JTextField();
        rootFileTableScrollPane = new javax.swing.JScrollPane();
        fileDetailsTable = new javax.swing.JTable();
        MenuBar = new javax.swing.JMenuBar();
        propertiesMenu = new javax.swing.JMenu();
        createFolderMenuItem = new javax.swing.JMenuItem();
        createDocumentMenu = new javax.swing.JMenu();
        createTextDocumentMenuItem = new javax.swing.JMenuItem();
        PropertiesMenuItem = new javax.swing.JMenuItem();
        closeMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        editMenu = new javax.swing.JMenu();
        CutMenuItem = new javax.swing.JMenuItem();
        CopyMenuItem = new javax.swing.JMenuItem();
        PasteMenuItem = new javax.swing.JMenuItem();
        DeleteMenuItem = new javax.swing.JMenuItem();
        RenameMenuItem = new javax.swing.JMenuItem();
        helpMenuItem = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();

        cutMenuItem.setText("jMenuItem1");
        tablePopupMenu.add(cutMenuItem);

        jMenuItem2.setText("jMenuItem2");
        tablePopupMenu.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        tablePopupMenu.add(jMenuItem3);

        jMenuItem4.setText("jMenuItem4");
        tablePopupMenu.add(jMenuItem4);

        jMenuItem5.setText("jMenuItem5");
        tablePopupMenu.add(jMenuItem5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        StatusBar.setText("Status");
        StatusBar.setName("Status"); // NOI18N

        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        homeDirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeDirButtonActionPerformed(evt);
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

        filePathTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePathTextFieldActionPerformed(evt);
            }
        });
        filePathTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filePathTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filePathTextFieldKeyTyped(evt);
            }
        });

        fileDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date modified", "Type", "Size"
            }
        ));
        fileDetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileDetailsTableMouseClicked(evt);
            }
        });
        fileDetailsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fileDetailsTableKeyReleased(evt);
            }
        });
        rootFileTableScrollPane.setViewportView(fileDetailsTable);

        MenuBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuBarMouseClicked(evt);
            }
        });

        propertiesMenu.setText("File");

        createFolderMenuItem.setText("Create Folder");
        createFolderMenuItem.setName("CreateFolder"); // NOI18N
        createFolderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createFolderMenuItemActionPerformed(evt);
            }
        });
        propertiesMenu.add(createFolderMenuItem);
        createFolderMenuItem.getAccessibleContext().setAccessibleParent(createFolderMenuItem);

        createDocumentMenu.setText("Create Document");

        createTextDocumentMenuItem.setText("text document");
        createTextDocumentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTextDocumentMenuItemActionPerformed(evt);
            }
        });
        createDocumentMenu.add(createTextDocumentMenuItem);

        propertiesMenu.add(createDocumentMenu);

        PropertiesMenuItem.setText("Properties");
        PropertiesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropertiesMenuItemActionPerformed(evt);
            }
        });
        propertiesMenu.add(PropertiesMenuItem);

        closeMenuItem.setText("Close");
        closeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMenuItemActionPerformed(evt);
            }
        });
        propertiesMenu.add(closeMenuItem);
        propertiesMenu.add(jSeparator1);

        MenuBar.add(propertiesMenu);

        editMenu.setText("Edit");

        CutMenuItem.setText("Cut");
        CutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(CutMenuItem);

        CopyMenuItem.setText("Copy");
        CopyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(CopyMenuItem);

        PasteMenuItem.setText("Paste");
        PasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(PasteMenuItem);

        DeleteMenuItem.setText("Delete");
        DeleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(DeleteMenuItem);

        RenameMenuItem.setText("Rename");
        editMenu.add(RenameMenuItem);

        MenuBar.add(editMenu);

        helpMenuItem.setText("Help");

        contentsMenuItem.setText("Contents...");
        helpMenuItem.add(contentsMenuItem);

        MenuBar.add(helpMenuItem);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rootFileTableScrollPane))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(homeDirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(homeDirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rootFileTableScrollPane)
                    .addComponent(rootFileTreeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        //statusbar.setBorder(BorderFactory.createEtchedBorder(
            // EtchedBorder.RAISED));

    pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * private void closeMenuItemActionPerformed
 * @param evt 
 */
    private void closeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMenuItemActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeMenuItemActionPerformed

    private void PasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteMenuItemActionPerformed
//FIX: refactor to a new boolean class 
      //result boolean wantToCut= false
       
        
    try {
       //name of source file
        File sourceFile = new File(newCopy.getCopyPath());
        String name = sourceFile.getName();
     
        File targetFile = new File(filePathTextField.getText()+name);
        System.out.println("Copying file : " + sourceFile.getName() +" from Java Program");
     
        //copy file from one location to other
        FileUtils.copyFile(sourceFile, targetFile);
     
        System.out.println("copying of file from Java program is completed");

ClearTableAddTableDetails();

//        try {
//            PasteFileController pasteController = new PasteFileController(new FileOperations());
//            pasteController.PasteFile(newCopy.getCopyPath(),filePathTextField.getText());
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Something went wrong!",JOptionPane.ERROR_MESSAGE);
//        }
    } catch (IOException ex) {
        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_PasteMenuItemActionPerformed
/**
 * 
 * @param evt 
 */
    private void createFolderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFolderMenuItemActionPerformed
    
        checkPathIfDirectoryController checkIfDirectory = new checkPathIfDirectoryController();
        boolean ifDirectory = checkIfDirectory.checkPathIfDirectory(filePathTextField.getText().toString());
            //TODO: refactor         
              //check if is a Directory
        if (ifDirectory) {
            //check if file and with / or not
            stringIfEndsWithSeparatorController newStringIfEndsWithSeparatorController = new stringIfEndsWithSeparatorController();
           String pathForCreateFolder = newStringIfEndsWithSeparatorController.stringIfEndsWithSeparator(filePathTextField);
            //Create a new Folder..
            CreateNewFolderOperation createFolder = new CreateNewFolderOperation();
            createFolder.createNewFolderOperation(pathForCreateFolder, 1);
            
        } else {
            System.out.println("You must select directory to make a new folder");

        }
        // add new table details  
       ClearTableAddTableDetails();


    }//GEN-LAST:event_createFolderMenuItemActionPerformed

    private void CutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutMenuItemActionPerformed
      //FIX: refactor to a new boolean class 
      //result boolean wantToCut= true 
        try {
            CutFileController cutController = new CutFileController(new FileOperations());
            cutController.cutFile(filePathTextField.getText());
            newCopy.setCopyPath(filePathTextField.getText().toString());
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Something went wrong!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CutMenuItemActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
//TODO:Refactor
       System.out.println(countStackPov);
       countStackPov=countStackPov-1;
       countStackPrev=countStackPrev-1;
       if(!(countStackPov<0)){
        filePathTextField.setText(stackPop.get(countStackPov));
        ClearTableAddTableDetails();    
       }else{
           countStackPov=-1;
           stackPop.clear();
       }
       

    }//GEN-LAST:event_backButtonActionPerformed

    private void rootFileTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rootFileTreeMouseClicked
         ClearTableAddTableDetails();
    }//GEN-LAST:event_rootFileTreeMouseClicked

    private void rootFileTreeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rootFileTreeKeyPressed

    }//GEN-LAST:event_rootFileTreeKeyPressed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

    }//GEN-LAST:event_formWindowStateChanged

    private void createTextDocumentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTextDocumentMenuItemActionPerformed
         checkPathIfDirectoryController checkIfDirectory = new checkPathIfDirectoryController();
        boolean ifDirectory = checkIfDirectory.checkPathIfDirectory(filePathTextField.getText().toString());
        
        //check if is a Directory
        if (ifDirectory) {
            //check if file and with / or not
            stringIfEndsWithSeparatorController newStringIfEndsWithSeparatorController = new stringIfEndsWithSeparatorController();
            String pathForCreateFile = newStringIfEndsWithSeparatorController.stringIfEndsWithSeparator(filePathTextField);
            //Create a new text File..
            CreateNewFileOperation newTextFile = new CreateNewFileOperation();
           newTextFile.CreateNewFile(pathForCreateFile,1);
           
            
        } else {
            System.out.println("You must select directory to make a new text file");

        }
        ClearTableAddTableDetails();
    }//GEN-LAST:event_createTextDocumentMenuItemActionPerformed

    private void PropertiesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropertiesMenuItemActionPerformed
         
       
    }//GEN-LAST:event_PropertiesMenuItemActionPerformed
/**
 * private void function homeDirButton
 * @param evt 
 * 
 */
    private void homeDirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeDirButtonActionPerformed

        SetTreeModelController newSetTreeModelController = new SetTreeModelController();
        rootFileTree = newSetTreeModelController.SetTreeModelController(rootFileTree);
        //set Home Directory to filepathTextField 
        filePathTextField.setText("C:\\");
        ClearTableAddTableDetails();
    }//GEN-LAST:event_homeDirButtonActionPerformed

    private void fileDetailsTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fileDetailsTableKeyReleased
       
    }//GEN-LAST:event_fileDetailsTableKeyReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       
    }//GEN-LAST:event_formMouseClicked

    private void MenuBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBarMouseClicked
       
        
    }//GEN-LAST:event_MenuBarMouseClicked

    private void filePathTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filePathTextFieldKeyPressed
    ClearTableAddTableDetails();
    }//GEN-LAST:event_filePathTextFieldKeyPressed

    private void filePathTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePathTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filePathTextFieldActionPerformed

    private void filePathTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filePathTextFieldKeyTyped
     ClearTableAddTableDetails();
    }//GEN-LAST:event_filePathTextFieldKeyTyped

    private void fileDetailsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileDetailsTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fileDetailsTableMouseClicked

    private void CopyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyMenuItemActionPerformed

            newCopy.setCopyPath(filePathTextField.getText().toString());
//        try {
//            CopyFileController cutController = new CopyFileController(new FileOperations());
//            cutController.copyFile(filePathTextField.getText());
//           
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Something went wrong!",JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_CopyMenuItemActionPerformed

    private void DeleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMenuItemActionPerformed
        try {
            DeleteFileController deleteController = new DeleteFileController(new FileOperations());
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this file?", "Warning", dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION) {
                deleteController.deleteFile(filePathTextField.getText());
            } else 
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (IOException e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "File not found!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DeleteMenuItemActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
       if(countStackPrev<0) countStackPrev=0;
        countStackPrev+=1;
        if(countStackPrev>=0&&countStackPrev<=countStack){
            System.out.println(countStackPrev);
       filePathTextField.setText( stackPrev.get(countStackPrev));
       ClearTableAddTableDetails();  
       }else{
           System.out.println("This is the last file for prev");
          // countStackPrev=-1;
           stackPop.clear();
       }
       
          
    }//GEN-LAST:event_nextButtonActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
       ClearTableAddTableDetails();
    }//GEN-LAST:event_RefreshButtonActionPerformed

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
    private javax.swing.JMenuItem CopyMenuItem;
    private javax.swing.JMenuItem CutMenuItem;
    private javax.swing.JMenuItem DeleteMenuItem;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem PasteMenuItem;
    private javax.swing.JMenuItem PropertiesMenuItem;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JMenuItem RenameMenuItem;
    private javax.swing.JLabel StatusBar;
    private javax.swing.JButton UpButton;
    public javax.swing.JButton backButton;
    private javax.swing.JMenuItem closeMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenu createDocumentMenu;
    private javax.swing.JMenuItem createFolderMenuItem;
    private javax.swing.JMenuItem createTextDocumentMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JTable fileDetailsTable;
    private javax.swing.JTextField filePathTextField;
    private javax.swing.JMenu helpMenuItem;
    private javax.swing.JButton homeDirButton;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JButton nextButton;
    private javax.swing.JMenu propertiesMenu;
    private javax.swing.JScrollPane rootFileTableScrollPane;
    private javax.swing.JTree rootFileTree;
    private javax.swing.JScrollPane rootFileTreeScrollPane;
    private javax.swing.JPopupMenu tablePopupMenu;
    // End of variables declaration//GEN-END:variables
}
