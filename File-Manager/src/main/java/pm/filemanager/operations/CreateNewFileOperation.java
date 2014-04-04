/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author alex
 */
public class CreateNewFileOperation {
   
    
    public boolean CreateNewFile(String path,int countFileExist){
        Path xPath = Paths.get(path+"testfile"+countFileExist+".txt");
        boolean checkIfExistDir = false;
        checkIfExistDir = Files.exists(xPath);
        //check if exist 
        if(checkIfExistDir){
            countFileExist=countFileExist+1;
            boolean resultIfExistName =CreateNewFile(path,countFileExist);
            return resultIfExistName;
        }
    try {
   
    File myFile = new File(path+"testfile"+countFileExist+".txt");
    if ( myFile.createNewFile() ) {
       System.out.println("Success!");
       return true;
    } else {
       System.out.println("Failure!");
       return false;
    }
 } catch ( IOException ioe ) { 
     ioe.printStackTrace(); }
        return false;
    
        
        
       
    }
    
    
    
}
