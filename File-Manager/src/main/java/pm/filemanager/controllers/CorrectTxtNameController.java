/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import pm.filemanager.validators.CorrectTxtNameValidator;

/**
 *
 * @author alex
 */

public class CorrectTxtNameController {
    /**
     * boolean function CorrectTxtName 
     * @param name String
     * @return true if is txt or false if is not
     */
    public boolean CorrectTxtName(String name){
        CorrectTxtNameValidator newCorrectTxtName = new CorrectTxtNameValidator();
        return newCorrectTxtName.CorrectTxtName(name);
    }
    
}
