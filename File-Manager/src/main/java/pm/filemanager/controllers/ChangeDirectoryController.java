/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import java.io.File;
import java.io.IOException;
import pm.filemanager.commands.ChangeDirectoryCommand;
import pm.filemanager.commands.ICommand;
import pm.filemanager.model.LocalStorage;

/**
 *
 * @author PTsilopoulos
 */
public class ChangeDirectoryController {

    private final String filePath;
    
    public ChangeDirectoryController(String filePath) {
        
        this.filePath = filePath;
    }
    
    public void changeDirectory(String filePath) throws IOException {
     
        
        ICommand ChangeDirectoryCommand = new ChangeDirectoryCommand(filePath);
        ChangeDirectoryCommand.perform();
        LocalStorage.action(ChangeDirectoryCommand);
    }    
}
