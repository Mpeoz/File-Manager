/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.commands;

import java.io.IOException;
import pm.filemanager.operations.CreateNewFileOperation;
import pm.filemanager.operations.FileOperations;

/**
 *
 * @author PTsilopoulos
 */
public class CreateFileCommand implements ICommand {
    private final String source;
    //private final String temp = System.getProperty("user.dir") + File.separator + "temp" + File.separator;
    protected final int count;
    private String filename;
    
    public CreateFileCommand(String source, int count) {
        this.source = source;
        this.count = count;
    }

    @Override
    public void undo() throws IOException {
        
        FileOperations.deleteFile(source + filename);
    }

    @Override
    public void redo() throws IOException {
        
        perform();
    }

    @Override
    public void perform() throws IOException {
        // FIX it doesn't currently create the .txt doc, look into the CreateNewFileOperation
        filename = CreateNewFileOperation.createNewFile(source, count);
    }   
}
