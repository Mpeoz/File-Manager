/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import javax.swing.JTextField;
import pm.filemanager.validators.StringIfEndsWithSeparatorValidator;

/**
 *
 * @author alex
 */
public class stringIfEndsWithSeparatorController {
    /**
     * public String function stringIfEndsWithSeparator
     * @param filePathTextField
     * @return a string with file separator.
     */
    public String stringIfEndsWithSeparator( JTextField filePathTextField){
       StringIfEndsWithSeparatorValidator newStringIfEndsWithSeparatorValidator  = new StringIfEndsWithSeparatorValidator(); 
    String result = newStringIfEndsWithSeparatorValidator.checkIfStringEndWithSeparator( filePathTextField);
    return result; 
 
    }
   
}
