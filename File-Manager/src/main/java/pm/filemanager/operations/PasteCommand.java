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
public class PasteCommand implements ICommand {
    
    private final String typeOfPaste, source, destination, fileName;
    private final String temp = System.getProperty("user.dir") + File.separator + "temp" + File.separator;
    
    public PasteCommand(String typeOfPaste, String source, String destination) {
        
        this.typeOfPaste = typeOfPaste;
        this.source = source;
        this.destination = destination;
        File myFile = new File(source);
        fileName = myFile.getName();
    }

    @Override
    public void undo() throws IOException {
        
        FileOperations.cutPasteFile(destination + fileName, source);
    }

    @Override
    public void redo() throws IOException {
        
        perform();
    }
    
    @Override
    public void perform() throws IOException {
        
        switch (typeOfPaste) {
            case "copy-paste":
                {
                    FileOperations.copyPasteFile(source, destination);
                    break;
                }
            case "cut-paste":
                {
                    FileOperations.cutPasteFile(temp + fileName, destination);
                    break;
                }
            default:
                // TO-DO add system message or w/e
                break;
        }
    }
}

