/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.controllers;

import java.io.IOException;
import pm.filemanager.commands.ICommand;
import pm.filemanager.commands.RenameCommand;
import pm.filemanager.model.LocalStorage;

/**
 *
 * @author PTsilopoulos
 */
public class RenameController {

    private final String sourceName, newName;

    public RenameController(String sourceName, String newName) {
        
        this.sourceName = sourceName;
        this.newName = newName;
    }
    
    public boolean rename() throws IOException {
        
        try {
            ICommand renameCommand = new RenameCommand(sourceName, newName);
            renameCommand.perform();
            LocalStorage.action(renameCommand);
            return true;
        } catch (IOException e) {
            return false;
        }     
    }  
}
