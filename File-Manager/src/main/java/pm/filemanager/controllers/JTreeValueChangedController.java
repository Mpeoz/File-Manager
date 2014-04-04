/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import javax.swing.JTextField;
import javax.swing.JTree;
import pm.filemanager.actions.JTreeValueChangedListener;

/**
 *
 * @author alex
 */
public class JTreeValueChangedController {
    /**
     * public void JTree value Changed listener
     * @param rootFileTree
     * @param filePathTextField 
     */
     public void valueChanged(final JTree rootFileTree , final JTextField  filePathTextField){
         JTreeValueChangedListener newJTreeValueChangedListener = new JTreeValueChangedListener();
         newJTreeValueChangedListener.valueChanged(rootFileTree, filePathTextField);
     }
    
}
