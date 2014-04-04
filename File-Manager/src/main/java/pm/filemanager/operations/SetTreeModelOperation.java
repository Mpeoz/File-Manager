/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import javax.swing.JTree;
import javax.swing.tree.TreeSelectionModel;

import pm.filemanager.model.FileTreeModel;


/**
 *
 * @author alex
 */
public class SetTreeModelOperation {

    public SetTreeModelOperation() {
    }
    
    public JTree SetTreeModel(JTree tree,String path){   
       
    //FileSystemModel  fileSystemModel = new FileSystemModel(new File(path));
   FileTreeModel  fileSystemModel = new FileTreeModel();
     
    tree.setModel(fileSystemModel);
    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
    tree.setShowsRootHandles(true);
    
    return tree;
    
    
}
   
    
    
   
}

