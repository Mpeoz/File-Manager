/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import java.io.File;
import java.io.IOException;
//import javax.swing.event.TreeModelEvent;
//import pm.filemanager.model.FileTreeModel;
import pm.filemanager.model.LocalStorage;
import pm.filemanager.commands.CutCommand;
import pm.filemanager.commands.ICommand;
import pm.filemanager.operations.FileOperations;

/**
 *
 * @author PTsilopoulos
 */
public class CutController {
    
    private final String source, temp;
//    private final FileTreeModel model;
//    private final TreeModelEvent event;
    
    public CutController(String source) {
        
        this.temp = System.getProperty("user.dir") + File.separator + "temp" + File.separator;
        this.source = source;
//        this.model = model;
//        this.event = event;
    }
    
    public void cut() throws IOException {
    
        if (FileOperations.checkDirectory(temp) != true) {
              (new File(temp)).mkdirs();
        }
        ICommand cutCommand = new CutCommand(source);
        cutCommand.perform();
        LocalStorage.action(cutCommand);
        //model.deleteEntry(event);
    }
}
