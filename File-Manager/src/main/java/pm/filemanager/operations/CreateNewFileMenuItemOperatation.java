/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import pm.filemanager.controllers.CreateNewFileController;
import pm.filemanager.controllers.CheckPathIfDirectoryController;
import pm.filemanager.controllers.StringIfEndsWithSeparatorController;

/**
 *
 * @author alex
 */
public class CreateNewFileMenuItemOperatation {
    
     public void createNewFileMenuItem(String path){
        CheckPathIfDirectoryController checkIfDirectory = new CheckPathIfDirectoryController();
        boolean ifDirectory = checkIfDirectory.checkPathIfDirectory(path);

        //check if is a Directory
        if (ifDirectory) {
            //check if file and with / or not
            StringIfEndsWithSeparatorController newStringIfEndsWithSeparatorController = new StringIfEndsWithSeparatorController();
            String pathForCreateFile = newStringIfEndsWithSeparatorController.stringIfEndsWithSeparator(path);
            //Create a new text File..
            CreateNewFileController newTextFile = new CreateNewFileController();
            newTextFile.CreateNewFile(pathForCreateFile, 1);

        } else {
            System.out.println("You must select directory to make a new text file");

        }
     }
    
}
