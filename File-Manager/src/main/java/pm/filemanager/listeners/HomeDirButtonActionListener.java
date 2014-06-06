/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTree;
import pm.filemanager.controllers.SetFileTreeController;

/**
 *
 * @author alex
 */
public class HomeDirButtonActionListener extends JFrame implements ActionListener {
   public JTree rootFileTree;
    public   JTextField filePathTextField;
    public   SetFileTreeController setFileTreeController;
    public HomeDirButtonActionListener(JTree rootFileTree, JTextField filePathTextField ,SetFileTreeController setFileTreeController){
         this.rootFileTree = rootFileTree;
         this.filePathTextField = filePathTextField;
          this.setFileTreeController = setFileTreeController;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        rootFileTree = setFileTreeController.getFileTree(rootFileTree);
        //set Home Directory to filepathTextField 
        filePathTextField.setText("C:\\");
    }
    
}
