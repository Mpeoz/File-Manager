/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.controllers;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import pm.filemanager.operations.CheckPathIfDirectoryOperation;
import pm.filemanager.operations.ICommand;

/**
 *
 * @author alex
 */
public class DeleteCommand implements ICommand {

    private final String source;
    private final String temp = System.getProperty("user.dir") + File.separator + "temp" +File.separator ;
    private final String filename;
    private final String filepath;

    public DeleteCommand(String source) {
        this.source = source;
        File myfile = new File(source);
        filename = myfile.getName();
        filepath = myfile.getParent();
                
    }
    
    @Override
    public void undo() throws IOException {
         copyDelete(temp + filename,filepath);
        
    }

    @Override
    public void redo() throws IOException {
        perform();
    }

    @Override
    public void perform() throws IOException {
            copyDelete(source,temp);
 
    }

    public void copyDelete(String sourceName  ,String destName) throws IOException {
        File filepath = new File(sourceName);
        File sourceFile = new File(sourceName);
        String name = sourceFile.getName();
        File destinationFile = new File(destName+name);
        if (sourceFile.isFile()) {
            FileUtils.copyFile(sourceFile, destinationFile);
        } else {
            FileUtils.copyDirectoryToDirectory(sourceFile, destinationFile);
        }  
          
        filepath.delete();
    }

}
