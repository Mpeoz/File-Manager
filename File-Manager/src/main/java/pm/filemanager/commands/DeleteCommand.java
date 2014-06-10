/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.commands;

import java.io.File;
import java.io.IOException;
import pm.filemanager.operations.FileOperations;

/**
 *
 * @author PTsilopoulos
 */
public class DeleteCommand implements ICommand {

    private final String source, filename, parentname;
    private final String temp = System.getProperty("user.dir") + File.separator + "temp" + File.separator;

    public DeleteCommand(String source) {
        
        this.source = source;
        File myFile = new File(source);
        filename = myFile.getName();
        parentname = myFile.getParent();
    }
    
    @Override
    public void undo() throws IOException {
        
        // TO-DO fix the case where someone is trying to restore a folder under root C:\\
//        if (parentname == null) {
//                parentname = "C:\\";
//        }       
        FileOperations.cutPasteFile(temp + filename, parentname);
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
