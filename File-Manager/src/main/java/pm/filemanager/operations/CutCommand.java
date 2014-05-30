/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author PTsilopoulos
 */
public class CutCommand implements ICommand {
    
    private final String source, filename;
    private final String temp = System.getProperty("user.dir") + File.separator + "temp" + File.separator;

    public CutCommand(String source) {
        
        this.source = source;
        File myFile = new File(source);
        filename = myFile.getName();
    }

    @Override
    public void undo() throws IOException {
        
        FileOperations.cutPasteFile(temp + filename, source);
    }

    @Override
    public void redo() throws IOException {
  
        perform();
    }

    @Override
    public void perform() throws IOException {
        
        FileOperations.cutPasteFile(source, temp);
    }
    
}
