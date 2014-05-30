/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import java.io.File;
import java.io.IOException;
import pm.filemanager.model.LocalStorage;
import pm.filemanager.operations.CheckPathIfDirectoryOperation;
import pm.filemanager.operations.CopyCommand;
import pm.filemanager.operations.ICommand;

/**
 *
 * @author PTsilopoulos
 */
public class CopyController {
    
    private final String source, temp;
    
    public CopyController(String source) {
        
        this.temp = System.getProperty("user.dir") + File.separator + "temp" + File.separator;
        this.source = source;
    }
    
    public void copy() throws IOException {
    
        CheckPathIfDirectoryOperation check = new CheckPathIfDirectoryOperation();
        boolean checkPathIfDirectory = check.checkPathIfDirectory(temp);
        if (!checkPathIfDirectory) {
              (new File(temp)).mkdirs();
        }
        ICommand copyCommand = new CopyCommand(source);
        copyCommand.perform();
        LocalStorage.action(copyCommand);
    }
}
