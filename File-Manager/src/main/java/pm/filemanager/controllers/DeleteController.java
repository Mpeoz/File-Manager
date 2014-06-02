/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.controllers;

import pm.filemanager.model.LocalStorage;
import java.io.File;
import java.io.IOException;
import javax.swing.event.TreeModelEvent;
import pm.filemanager.model.FileTreeModel;
import pm.filemanager.operations.CheckPathIfDirectoryOperation;
import pm.filemanager.operations.ICommand;

/**
 *
 * @author PTsilopoulos
 */
public class DeleteController {

    private final String source, temp;
    private final FileTreeModel model;
    private final TreeModelEvent event;
    
    public DeleteController(FileTreeModel model, TreeModelEvent event, String source) {
        
        this.temp = System.getProperty("user.dir") + File.separator + "temp" + File.separator;
        this.source = source;  
        this.model = model;
        this.event = event;
    }
    
    public void delete() throws IOException {
        
        CheckPathIfDirectoryOperation check = new CheckPathIfDirectoryOperation();
        boolean checkPathIfDirectory = check.checkPathIfDirectory(temp);
        if (!checkPathIfDirectory) {
              (new File(temp)).mkdirs();
        }
        ICommand deleteCommand = new DeleteCommand(source);
        deleteCommand.perform();
        LocalStorage.action(deleteCommand);
        model.deleteEntry(event);
    }
}
