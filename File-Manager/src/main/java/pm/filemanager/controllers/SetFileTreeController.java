/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import pm.filemanager.operations.SetTreeModelOperation;

/**
 *
 * @author PTsilopoulos
 */
public class SetFileTreeController {
    /**
     * public JTree setTreeModelController
     * @param tree
     * @return JTree
     */    
    
     public JTree getFileTree(JTree tree) {
         
         SetTreeModelOperation setSystemTree = new SetTreeModelOperation();
         JTree resultTree = setSystemTree.setTreeModel(tree);
         return resultTree;
     }
     
     public TreeModel getTreeModel(JTree tree) {
         
         SetTreeModelOperation setSystemTree = new SetTreeModelOperation();
         return setSystemTree.getTreeModel(tree);
     }
     
     // TO-DO method that returns the .getModel() method of the FileTreeModel
    
}
