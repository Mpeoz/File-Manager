/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import java.io.File;
import java.io.IOException;
import pm.filemanager.commands.CreateFileCommand;
import pm.filemanager.commands.ICommand;
import pm.filemanager.model.LocalStorage;


/**
 *
 * @author alex
 */
public class CreateFileController {

    private final String source;
    private final String temp = System.getProperty("user.dir") + File.separator + "temp" + File.separator;
    protected final int count;
    
    public CreateFileController(String source, int count) {
        
        this.source = source;
        this.count = count;
    }
 
    public void createFile() throws IOException {
        
        ICommand createFileCommand = new CreateFileCommand();
        createFileCommand.perform();
        LocalStorage.action(createFileCommand);
    }
}    
