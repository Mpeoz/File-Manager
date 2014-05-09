/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import pm.filemanager.operations.CreateNewFolderOperation;

/**
 *
 * @author alex
 */
public class CreateNewFolderController {
    /**
     * Public Function createNewFolder
     * @param path String
     * @param count int
     * @return true if is created or false if is not
     */
    public boolean createNewFolder(String path, int count) {
        CreateNewFolderOperation createNewFolder = new CreateNewFolderOperation();
        return createNewFolder.createNewFolderOperation(path, count);
    }
    
}
