/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;
import pm.filemanager.model.FileTreeModel;

/**
 *
 * @author PTsilopoulos
 */
public class SetTreeModelOperation {
    //TODO:  fix return boolean or something else
    /**
     * public JTree Function SetTreeModel
     * @param jTree JTree
     * @return JTree
     */
    public JTree setTreeModel(JTree jTree){ 
        
        FileTreeModel fileSystemModel = new FileTreeModel();  
        jTree.setModel(fileSystemModel);
        jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
        jTree.setShowsRootHandles(true);
        return jTree;
    }
    
    public TreeModel getTreeModel(JTree jTree) {
        
        FileTreeModel fileSystemModel = new FileTreeModel();
        jTree.setModel(fileSystemModel);
        return jTree.getModel();
    }
}    
    
   


