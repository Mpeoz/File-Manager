/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.swing;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import pm.filemanager.controllers.ClearTableController;
import pm.filemanager.controllers.CopyController;
import pm.filemanager.controllers.CutController;
import pm.filemanager.controllers.DeleteController;
import pm.filemanager.controllers.NextButtonActionController;
import pm.filemanager.controllers.OpenWebPageController;
import pm.filemanager.controllers.PasteController;
import pm.filemanager.controllers.PushWhenValueChangedController;
import pm.filemanager.controllers.RedoController;
import pm.filemanager.controllers.SetTreeModelController;
import pm.filemanager.controllers.UndoController;
import pm.filemanager.controllers.setTableFileDetailsController;
import pm.filemanager.controllers.createFolderMenuItemController;
import pm.filemanager.controllers.stringIfEndsWithSeparatorController;
import pm.filemanager.model.CopyCutModel;
import pm.filemanager.model.PathModel;
import pm.filemanager.model.StackModel;
import pm.filemanager.operations.CreateNewFileMenuItemOperatation;
import pm.filemanager.operations.StackPushOperation;
import pm.filemanager.validators.FixTreeSelectionStringtoCorrectedPathValidator;
import pm.filemanager.validators.RemoveLastSeparatorValidator;

/**
 *
 * @author PTsilopoulos
 */
public class MainWindow extends javax.swing.JFrame {

    SetTreeModelController newSetTreeModelController = new SetTreeModelController();
    PathModel newPathModel = new PathModel();
    StackPushOperation newStackPush = new StackPushOperation();
    StackModel newStack = new StackModel();
    //stack for pop
    Stack<String> stackPop = new Stack<String>();
    //stack for prev
    Stack<String> stackPrev = new Stack<String>();
    //push when value changed
    PushWhenValueChangedController pushWhenValueChanged = new PushWhenValueChangedController();
    private int countStack;
    private int countStackPov;
    private int countStackPrev;
    UndoController undoController = new UndoController();
    RedoController redoController = new RedoController();

    //new cut-Copy model
    CopyCutModel copyCut = new CopyCutModel();
    //paste String type 
    String pasteType = "";

    /**
     * Creates new form mainWindow
     */
    public MainWindow() {
        initComponents();
        //set tool tip to the buttons (hover mouse)
        backButton.setToolTipText("back");
        nextButton.setToolTipText("next");
        UpButton.setToolTipText("Up");
        RefreshButton.setToolTipText("Refresh");
        homeDirButton.setToolTipText("home directory");
        //TODO:image button add because problems with other pc default location
        // addd code here
        //set tree modelback
        rootFileTree = newSetTreeModelController.SetTreeModelController(rootFileTree);

        //TODO:Check how refactor this code  
        rootFileTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                FixTreeSelectionStringtoCorrectedPathValidator newCorrectPath = new FixTreeSelectionStringtoCorrectedPathValidator();
                String pathForNode = newCorrectPath.FixTreeSelectionStringToCorrectedPath(e);
                filePathTextField.setText(pathForNode);
                newPathModel.setPath(pathForNode);
//                try {
//                    pushWhenValueChanged.stackPush(newStackPush, stackPop, stackPrev, pathForNode);
//                } catch (IOException ex) {
//                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                countStack++;
//                countStackPov++;
//                countStackPrev++;

            }
        });
        this.setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);

    }

    /**
     *
     * Add table details
     */
    //refactor se kainourgia i prepei na einai edw mesa? 
    public void ClearTableAddTableDetails() {

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
     * Checks which nodes are visible throught the JTREE, reloads the tree, and
     * set those nodes visible again
     */
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
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        renameMenuItem = new javax.swing.JMenuItem();
        propertiesMenuItem = new javax.swing.JMenuItem();
        undoMenuItem = new javax.swing.JMenuItem();
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
        editMenu = new javax.swing.JMenu();
        CutMenuItem = new javax.swing.JMenuItem();
        CopyMenuItem = new javax.swing.JMenuItem();
        PasteMenuItem = new javax.swing.JMenuItem();
        DeleteMenuItem = new javax.swing.JMenuItem();
        RenameMenuItem = new javax.swing.JMenuItem();
        helpMenuItem = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();

        cutMenuItem.setText("cut");
        cutMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cutMenuItemMouseReleased(evt);
            }
        });
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        tablePopupMenu.add(cutMenuItem);

        copyMenuItem.setText("copy");
        copyMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                copyMenuItemMouseReleased(evt);
            }
        });
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        tablePopupMenu.add(copyMenuItem);

        pasteMenuItem.setText("paste");
        pasteMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pasteMenuItemMouseReleased(evt);
            }
        });
        pasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuItemActionPerformed(evt);
            }
        });
        tablePopupMenu.add(pasteMenuItem);

        deleteMenuItem.setText("delete");
        deleteMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteMenuItemMouseReleased(evt);
            }
        });
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        tablePopupMenu.add(deleteMenuItem);

        renameMenuItem.setText("rename");
        renameMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                renameMenuItemMouseReleased(evt);
            }
        });
        renameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameMenuItemActionPerformed(evt);
            }
        });
        tablePopupMenu.add(renameMenuItem);

        propertiesMenuItem.setText("properties");
        propertiesMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                propertiesMenuItemMouseReleased(evt);
            }
        });
        propertiesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesMenuItemActionPerformed(evt);
            }
        });
        tablePopupMenu.add(propertiesMenuItem);

        undoMenuItem.setText("undo");
        undoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoMenuItemActionPerformed(evt);
            }
        });
        tablePopupMenu.add(undoMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        StatusBar.setText("Status");
        StatusBar.setName("Status"); // NOI18N
        String string = filePathTextField.getText();
        Path file = new File(string).toPath();
        try {
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
            StatusBar.setText("creationTime: " + attr.creationTime());
            // TO-DO it needs to refresh every time we change directory
        } catch(IOException e) {   }

        backButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                backButtonMouseMoved(evt);
            }
        });
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

        UpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpButtonActionPerformed(evt);
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

        rootFileTreeScrollPane.setComponentPopupMenu(tablePopupMenu);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        rootFileTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        rootFileTree.setComponentPopupMenu(tablePopupMenu);
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filePathTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filePathTextFieldKeyTyped(evt);
            }
        });

        rootFileTableScrollPane.setComponentPopupMenu(tablePopupMenu);

        fileDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date modified", "Type", "Size"
            }
        ));
        fileDetailsTable.setComponentPopupMenu(tablePopupMenu);
        fileDetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileDetailsTableMouseClicked(evt);
            }
        });
        fileDetailsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fileDetailsTableKeyPressed(evt);
            }
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
        RenameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RenameMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(RenameMenuItem);

        MenuBar.add(editMenu);

        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });

        contentsMenuItem.setText("Contents...");
        contentsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentsMenuItemActionPerformed(evt);
            }
        });
        helpMenuItem.add(contentsMenuItem);

        MenuBar.add(helpMenuItem);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(StatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(rootFileTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addComponent(rootFileTreeScrollPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        //statusbar.setBorder(BorderFactory.createEtchedBorder(
            // EtchedBorder.RAISED));

    pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * private void closeMenuItemActionPerformed
     *
     * @param evt
     */
    private void closeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMenuItemActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_closeMenuItemActionPerformed

    private void PasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteMenuItemActionPerformed

        PasteController pasteController = new PasteController(pasteType, copyCut.getCopyCutPath(), filePathTextField.getText());
        try {
            pasteController.paste();
        } catch(IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_PasteMenuItemActionPerformed
    /**
     *
     * @param evt
     */
    private void createFolderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFolderMenuItemActionPerformed
        
        createFolderMenuItemController createFolder = new createFolderMenuItemController();
        createFolder.createFolderMenuItem(filePathTextField.getText().toString());
        rootFileTree.updateUI();
        ClearTableAddTableDetails();


    }//GEN-LAST:event_createFolderMenuItemActionPerformed

    private void CutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutMenuItemActionPerformed
        
        CutController cutController = new CutController(filePathTextField.getText());
        copyCut.setCopyCutPath(filePathTextField.getText().toString());
        pasteType = "cut-paste";
        try {
            cutController.cut();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClearTableAddTableDetails();
        rootFileTree.updateUI();
    }//GEN-LAST:event_CutMenuItemActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed

        undoController.undo();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_backButtonActionPerformed

    private void rootFileTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rootFileTreeMouseClicked
        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_rootFileTreeMouseClicked

    private void rootFileTreeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rootFileTreeKeyPressed

    }//GEN-LAST:event_rootFileTreeKeyPressed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

    }//GEN-LAST:event_formWindowStateChanged

    private void createTextDocumentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTextDocumentMenuItemActionPerformed
        CreateNewFileMenuItemOperatation newCreateNewFile = new CreateNewFileMenuItemOperatation();
        newCreateNewFile.createNewFileMenuItem(filePathTextField.getText().toString());
        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_createTextDocumentMenuItemActionPerformed

    private void PropertiesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropertiesMenuItemActionPerformed
        PropertiesForm newPropertiesForm = new PropertiesForm();
        PropertiesForm.locationTextField.setText(filePathTextField.getText().toString());
        newPropertiesForm.setVisible(true);

    }//GEN-LAST:event_PropertiesMenuItemActionPerformed
    /**
     * private void function homeDirButton
     *
     * @param evt
     *
     */
    private void homeDirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeDirButtonActionPerformed

        SetTreeModelController newSetTreeModel = new SetTreeModelController();
        rootFileTree = newSetTreeModelController.SetTreeModelController(rootFileTree);
        //set Home Directory to filepathTextField 
        filePathTextField.setText("C:\\");
        rootFileTree.updateUI();
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

    }//GEN-LAST:event_filePathTextFieldActionPerformed

    private void filePathTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filePathTextFieldKeyTyped
        ClearTableAddTableDetails();
    }//GEN-LAST:event_filePathTextFieldKeyTyped
    /**
     * private void function fileDetailsTableMouseClicked
     *
     * @param evt
     */
    private void fileDetailsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileDetailsTableMouseClicked
        stringIfEndsWithSeparatorController newStringIfEndsWithSeparatorController = new stringIfEndsWithSeparatorController();
        String nowPath = newStringIfEndsWithSeparatorController.stringIfEndsWithSeparator(filePathTextField.getText().toString());

        if (!(fileDetailsTable.getSelectedRow() < 0)) {
            String nameOfFile = fileDetailsTable.getValueAt(fileDetailsTable.getSelectedRow(), 0).toString();
            filePathTextField.setText("");
            String path = newPathModel.getPath().toString() + nameOfFile + "\\";
            File file = new File(path);
            //check if file exist with now path   
            if (file.exists()) {
                filePathTextField.setText(path);
                PushWhenValueChangedController newPushWhenValueChanged = new PushWhenValueChangedController();
                String pathForNode = newPathModel.getPath().toString() + fileDetailsTable.getValueAt(fileDetailsTable.getSelectedRow(), 0) + "\\";
                try {
                    newPushWhenValueChanged.stackPush(newStackPush, stackPop, stackPrev, pathForNode);
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                countStack++;
                countStackPov++;
                countStackPrev++;
            } else {
                filePathTextField.setText(nowPath);

            }

        } else {
            fileDetailsTable.setRowSelectionInterval(0, 0);
        }
        ClearTableAddTableDetails();

    }//GEN-LAST:event_fileDetailsTableMouseClicked

    private void CopyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyMenuItemActionPerformed

        CopyController copyController = new CopyController(filePathTextField.getText());
        copyCut.setCopyCutPath(filePathTextField.getText().toString());
        pasteType = "copy-paste";
        try {
            copyController.copy();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClearTableAddTableDetails();
        rootFileTree.updateUI();
    }//GEN-LAST:event_CopyMenuItemActionPerformed

    private void DeleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMenuItemActionPerformed

        DeleteController deleteController = new DeleteController(filePathTextField.getText());
        try {
            deleteController.delete();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_DeleteMenuItemActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        
        
        ClearTableAddTableDetails();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        
        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void fileDetailsTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fileDetailsTableKeyPressed


    }//GEN-LAST:event_fileDetailsTableKeyPressed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed

    }//GEN-LAST:event_helpMenuItemActionPerformed

    private void RenameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenameMenuItemActionPerformed
        RenameForm newRenameForm = new RenameForm();
        RenameForm.oldPathTextField.setText(filePathTextField.getText().toString());
        newRenameForm.setVisible(true);
        rootFileTree.updateUI();
        ClearTableAddTableDetails();


    }//GEN-LAST:event_RenameMenuItemActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        
        CutController cutController = new CutController(filePathTextField.getText());
        copyCut.setCopyCutPath(filePathTextField.getText().toString());
        pasteType = "cut-paste";
        try {
            cutController.cut();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClearTableAddTableDetails();
        rootFileTree.updateUI();
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
       
        CopyController copyController = new CopyController(filePathTextField.getText());
        copyCut.setCopyCutPath(filePathTextField.getText().toString());
        pasteType = "copy-paste";
        try {
            copyController.copy();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClearTableAddTableDetails();
        rootFileTree.updateUI();
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void pasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteMenuItemActionPerformed
        
        PasteController pasteController = new PasteController(pasteType, copyCut.getCopyCutPath(), filePathTextField.getText());
        try {
            pasteController.paste();
        } catch(IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_pasteMenuItemActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        
        DeleteController deleteController = new DeleteController(filePathTextField.getText());
        try {
            deleteController.delete();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClearTableAddTableDetails();
        rootFileTree.updateUI();
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void renameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameMenuItemActionPerformed
        RenameForm newRenameForm = new RenameForm();
        RenameForm.oldPathTextField.setText(filePathTextField.getText().toString());
        newRenameForm.setVisible(true);
        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_renameMenuItemActionPerformed

    private void cutMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutMenuItemMouseReleased
       
        CutController cutController = new CutController(filePathTextField.getText());
        copyCut.setCopyCutPath(filePathTextField.getText().toString());
        pasteType = "cut-paste";
        try {
            cutController.cut();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClearTableAddTableDetails();
        rootFileTree.updateUI();
    }//GEN-LAST:event_cutMenuItemMouseReleased

    private void copyMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyMenuItemMouseReleased
       
        CopyController copyController = new CopyController(filePathTextField.getText());
        copyCut.setCopyCutPath(filePathTextField.getText().toString());
        pasteType = "copy-paste";
        try {
            copyController.copy();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClearTableAddTableDetails();
        rootFileTree.updateUI();
    }//GEN-LAST:event_copyMenuItemMouseReleased

    private void pasteMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pasteMenuItemMouseReleased
        
        PasteController pasteController = new PasteController(pasteType, copyCut.getCopyCutPath(), filePathTextField.getText());
        try {
            pasteController.paste();
        } catch(IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_pasteMenuItemMouseReleased

    private void deleteMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMenuItemMouseReleased
        
        DeleteController deleteController = new DeleteController(filePathTextField.getText());
        try {
            deleteController.delete();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_deleteMenuItemMouseReleased

    private void backButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseMoved

    }//GEN-LAST:event_backButtonMouseMoved

    private void propertiesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesMenuItemActionPerformed
        PropertiesForm newPropertiesForm = new PropertiesForm();
        PropertiesForm.locationTextField.setText(filePathTextField.getText().toString());
        newPropertiesForm.setVisible(true);
    }//GEN-LAST:event_propertiesMenuItemActionPerformed

    private void renameMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_renameMenuItemMouseReleased
        RenameForm newRenameForm = new RenameForm();
        RenameForm.oldPathTextField.setText(filePathTextField.getText().toString());
        newRenameForm.setVisible(true);
        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_renameMenuItemMouseReleased

    private void propertiesMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propertiesMenuItemMouseReleased
        PropertiesForm newPropertiesForm = new PropertiesForm();
        PropertiesForm.locationTextField.setText(filePathTextField.getText().toString());
        newPropertiesForm.setVisible(true);
    }//GEN-LAST:event_propertiesMenuItemMouseReleased

    private void filePathTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filePathTextFieldKeyReleased
        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_filePathTextFieldKeyReleased

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_formFocusGained

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_formFocusLost

    private void UpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpButtonActionPerformed
        RemoveLastSeparatorValidator removeLastSeparator = new RemoveLastSeparatorValidator();
        String removed = removeLastSeparator.removeLastSeparator(filePathTextField.getText().toString());
        System.out.println(removed);
        filePathTextField.setText(removed);
    }//GEN-LAST:event_UpButtonActionPerformed

    private void StatusBar(javax.swing.JLabel evt) {                               
        String string = filePathTextField.getText();
        Path path = new File(string).toPath();
        BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        StatusBar.setText(view.toString());
    } 

    private void contentsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentsMenuItemActionPerformed
        OpenWebPageController openWebPage = new OpenWebPageController();
        try {
            openWebPage.openWebpage("http://files.enjin.com/51510/Beta_stuff/HelpContents.html");
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_contentsMenuItemActionPerformed

    private void undoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoMenuItemActionPerformed

        UndoController undoController = new UndoController();
        undoController.undo();

        rootFileTree.updateUI();
        ClearTableAddTableDetails();
    }//GEN-LAST:event_undoMenuItemActionPerformed

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
            @Override
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
    public javax.swing.JLabel StatusBar;
    private javax.swing.JButton UpButton;
    public javax.swing.JButton backButton;
    private javax.swing.JMenuItem closeMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenu createDocumentMenu;
    private javax.swing.JMenuItem createFolderMenuItem;
    private javax.swing.JMenuItem createTextDocumentMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JTable fileDetailsTable;
    public javax.swing.JTextField filePathTextField;
    private javax.swing.JMenu helpMenuItem;
    private javax.swing.JButton homeDirButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenu propertiesMenu;
    private javax.swing.JMenuItem propertiesMenuItem;
    private javax.swing.JMenuItem renameMenuItem;
    private javax.swing.JScrollPane rootFileTableScrollPane;
    public static javax.swing.JTree rootFileTree;
    private javax.swing.JScrollPane rootFileTreeScrollPane;
    private javax.swing.JPopupMenu tablePopupMenu;
    private javax.swing.JMenuItem undoMenuItem;
    // End of variables declaration//GEN-END:variables
}
