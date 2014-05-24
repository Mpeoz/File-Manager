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
public class DeleteCommandController  {

    private final String source;
    private final String temp = System.getProperty("user.dir") + File.separator + "temp" +File.separator ;
    

    public DeleteCommandController(String source) {
        this.source = source;
                
    }
    
    public void perform() throws IOException {

        
        CheckPathIfDirectoryOperation check = new CheckPathIfDirectoryOperation();
        boolean checkPathIfDirectory = check.checkPathIfDirectory(temp);
         if (!checkPathIfDirectory) {
              (new File(temp)).mkdirs();
         }
        ICommand deleteCommand = new DeleteCommand(source);
        deleteCommand.perform();
        LocalStorage.action(deleteCommand);
       

    }

   

}
