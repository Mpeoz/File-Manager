/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import pm.filemanager.validators.CorrectNameValidator;

/**
 *
 * @author alex
 */
public class CorrectNameController {
    /**
     * 
     * @param name String
     * @return 
     */
     public boolean CorrectName(String name){
        CorrectNameValidator newCorrectTxtName = new CorrectNameValidator();
        return newCorrectTxtName.CorrectName(name);
    }
    
}
