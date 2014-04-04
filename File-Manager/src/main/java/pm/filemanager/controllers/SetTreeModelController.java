/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import javax.swing.JTree;
import pm.filemanager.operations.SetTreeModelOperation;

/**
 *
 * @author user
 */
public class SetTreeModelController {
    
     public JTree  SetTreeModelController(JTree tree){
         SetTreeModelOperation setTreeModel = new SetTreeModelOperation();
         JTree resultTree =setTreeModel.SetTreeModel(tree);
         return resultTree;
     }
    
}
