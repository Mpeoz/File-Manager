/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.commands;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author PTsilopoulos
 */
public class ChangeDirectoryCommand implements ICommand {

    private final String currentPath;
    private String previousPath, nextPath;
    
    public ChangeDirectoryCommand(String currentPath) {
        
        this.currentPath = currentPath;
    }

    @Override
    public void undo() throws IOException {
        
        
    }

    @Override
    public void redo() throws IOException {
        
        perform();
    }

    @Override
    public void perform() throws IOException {
        
        File currentFile = new File(currentPath);
        if(currentFile.exists()) {        
            
            previousPath = currentFile.getParent();
            
        }    
    } 
}
