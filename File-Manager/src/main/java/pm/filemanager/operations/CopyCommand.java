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
public class CopyCommand implements ICommand {
    
    private final String source, fileName;
    private final String temp = System.getProperty("user.dir") + File.separator + "temp" + File.separator;

    public CopyCommand(String source) {
        
        this.source = source;
        File myFile = new File(source);
        fileName = myFile.getName();
    }

    @Override
    public void undo() throws IOException {
        
        FileOperations.cutPasteFile(temp + fileName, source);
    }

    @Override
    public void redo() throws IOException {
        
        perform();
    }

    @Override
    public void perform() throws IOException {
        
        FileOperations.copyPasteFile(source, temp);
    }
}
