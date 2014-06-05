/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import java.io.IOException;
import pm.filemanager.commands.CreateFolderCommand;
import pm.filemanager.commands.ICommand;
import pm.filemanager.model.LocalStorage;

/**
 *
 * @author PTsilopoulos
 */
public class CreateFolderController {

    private final String path;
    protected final int count;
    
    public CreateFolderController(String path, int count) {
        
        this.path = path;
        this.count = count;
    }
       
    public void createFolder() throws IOException {
        
        ICommand createFolderCommand = new CreateFolderCommand(path, count);
        createFolderCommand.perform();
        LocalStorage.action(createFolderCommand);
    }
    
}
