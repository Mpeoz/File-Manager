/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.controllers;

import pm.filemanager.commands.DeleteCommand;
import pm.filemanager.model.LocalStorage;
import java.io.File;
import java.io.IOException;
import javax.swing.event.TreeModelEvent;
import pm.filemanager.model.FileTreeModel;
import pm.filemanager.commands.ICommand;
import pm.filemanager.operations.FileOperations;

/**
 *
 * @author PTsilopoulos
 */
public class DeleteController {

    private final String source, temp;

    public DeleteController(String source) {

        this.temp = System.getProperty("user.dir") + File.separator + "temp" + File.separator;
        this.source = source;

    }

    public void delete() throws IOException {

        if (FileOperations.checkDirectory(temp) != true) {
            (new File(temp)).mkdirs();
        }
        ICommand deleteCommand = new DeleteCommand(source);
        deleteCommand.perform();
        LocalStorage.action(deleteCommand);

    }
}
