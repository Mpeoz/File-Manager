/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.listeners;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import pm.filemanager.validators.FixTreeSelectionStringtoCorrectedPathValidator;

/**
 * public void value Changed addTreeSelectionListener
 * @author alex 
 * set to the clipboard the real path 
 */
public class JTreeValueChangedListener {
    
    public void valueChanged(final JTree rootFileTree , final JTextField  filePathTextField){
        
         rootFileTree.addTreeSelectionListener(new TreeSelectionListener() {  
  
        @Override
        public void valueChanged(TreeSelectionEvent e) { 
           FixTreeSelectionStringtoCorrectedPathValidator newCorrectPath = new FixTreeSelectionStringtoCorrectedPathValidator();
             String pathForNode = newCorrectPath.FixTreeSelectionStringToCorrectedPath(e);
            filePathTextField.setText(pathForNode);
            
            
            
            
     }});    
    }
    
}
