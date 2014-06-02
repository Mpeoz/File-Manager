/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import pm.filemanager.controllers.CreateNewFolderController;
import pm.filemanager.controllers.CheckPathIfDirectoryController;
import pm.filemanager.controllers.StringIfEndsWithSeparatorController;

/**
 *
 * @author alex
 */
public class CreateFolderMenuItemOperatation {
    /**
     *  Function for create correctly
     * @param path String
     */
    public void createFolderMenuItem(String path){
         CheckPathIfDirectoryController checkIfDirectory = new CheckPathIfDirectoryController();
        boolean ifDirectory = checkIfDirectory.checkPathIfDirectory(path);      
        //check if is a Directory
        if (ifDirectory) {
            //check if file and with / or not
            StringIfEndsWithSeparatorController newStringIfEndsWithSeparatorController = new StringIfEndsWithSeparatorController();
            String pathForCreateFolder = newStringIfEndsWithSeparatorController.stringIfEndsWithSeparator(path);
            //Create a new Folder..
            CreateNewFolderController createFolder = new CreateNewFolderController();
            createFolder.createNewFolder(pathForCreateFolder, 1);

        } else {
            System.out.println("You must select directory to make a new folder");

        }
    }
    
}
