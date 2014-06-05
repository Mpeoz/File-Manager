/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.commands;

import java.io.IOException;
import pm.filemanager.operations.FileOperations;

/**
 *
 * @author PTsilopoulos
 */
public class RenameCommand implements ICommand {

    private final String sourceName, newName;

    public RenameCommand(String sourceName, String newName) {
        
        this.sourceName = sourceName;
        this.newName = newName;
    }

    @Override
    public void undo() throws IOException {
        
        FileOperations.renameFile(newName, sourceName);
    }

    @Override
    public void redo() throws IOException {
        
        perform();
    }

    @Override
    public void perform() throws IOException {
        
        FileOperations.renameFile(sourceName, newName);
    }
}
