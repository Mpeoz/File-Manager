/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.commands;

import java.io.File;
import java.io.IOException;
import pm.filemanager.operations.CreateNewFolderOperation;
import pm.filemanager.operations.FileOperations;

/**
 *
 * @author PTsilopoulos
 */
public class CreateFolderCommand implements ICommand {
    
    private final String source;
    private final String temp = System.getProperty("user.dir") + File.separator + "temp" + File.separator;
    protected final int count;

    public CreateFolderCommand(String source, int count) {
        
        this.source = source;
        this.count = count;
    }

    @Override
    public void undo() throws IOException {
        
        FileOperations.moveFolder(source, temp);
    }

    @Override
    public void redo() throws IOException {
        
        perform();
    }

    @Override
    public void perform() throws IOException {
        
        CreateNewFolderOperation.createNewFolder(source, count);
    }
    
    
    
    
//    /**
//     *  Function for create correctly
//     * @param path String
//     */
//    public void createFolderMenuItem(String path) {
//        
//        CheckPathIfDirectoryController checkIfDirectory = new CheckPathIfDirectoryController();
//        boolean ifDirectory = checkIfDirectory.checkPathIfDirectory(path);      
//        //check if is a Directory
//        if (ifDirectory) {
//            //check if file and with / or not
//            StringIfEndsWithSeparatorController newStringIfEndsWithSeparatorController = new StringIfEndsWithSeparatorController();
//            String pathForCreateFolder = newStringIfEndsWithSeparatorController.stringIfEndsWithSeparator(path);
//            //Create a new Folder..
//            CreateNewFolderController createFolder = new CreateNewFolderController();
//            createFolder.createNewFolder(pathForCreateFolder, 1);
//            //FileUtils.c
//
//        } else {
//            System.out.println("You must select directory to make a new folder");
//        }
//    }
    
}
