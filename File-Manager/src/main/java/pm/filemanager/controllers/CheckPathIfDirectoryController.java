/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import pm.filemanager.operations.CheckPathIfDirectoryOperation;

/**
 *
 * @author user
 */
public class CheckPathIfDirectoryController {
    /**
     * public boolean function checkPathIfDirectory
     * @param path
     * @return true if is a directory and false if is not
     */
    public boolean checkPathIfDirectory(String path){
        CheckPathIfDirectoryOperation checkPathIfDirectory = new CheckPathIfDirectoryOperation();
        Boolean checkResult=checkPathIfDirectory.checkPathIfDirectory(path);
        return checkResult;
        
    }
    
}
