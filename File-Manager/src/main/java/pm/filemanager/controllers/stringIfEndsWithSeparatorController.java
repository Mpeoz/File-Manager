/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import javax.swing.JTextField;
import pm.filemanager.validators.StringIfEndsorNoWithSeparatorValidator;

/**
 *
 * @author alex
 */
public class stringIfEndsWithSeparatorController {
    /**
     * public String function stringIfEndsWithSeparator
     * @param name String
     * @return a string with file separator.
     */
    public String stringIfEndsWithSeparator( String name){
       StringIfEndsorNoWithSeparatorValidator newStringIfEndsWithSeparatorValidator  = new StringIfEndsorNoWithSeparatorValidator(); 
    String result = newStringIfEndsWithSeparatorValidator.checkIfStringEndWithSeparator( name);
    return result; 
 
    }
   
}
