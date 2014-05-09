/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import pm.filemanager.operations.CreateNewFileOperation;

/**
 *
 * @author alex
 */
public class CreateNewFileController {
    /**
     * boolean  function CreateNewFile
     * @param path String
     * @param countFileExist int
     * @return true if file created success else return false
     */
    public boolean CreateNewFile(String path, int countFileExist){
        CreateNewFileOperation createNewFile = new CreateNewFileOperation();
        return createNewFile.CreateNewFile(path, countFileExist);
    }
    
}
