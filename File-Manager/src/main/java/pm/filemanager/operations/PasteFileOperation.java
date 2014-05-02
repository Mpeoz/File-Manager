/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author alex
 */
public class PasteFileOperation {
    public boolean reslutPaste ;
    
    /**
     * Boolean Function PasteFile
     * @param typeOfPaste String
     * @param source String
     * @param destination String
     * @return if paste is success for each of cut or paste we choose
     * @throws IOException 
     */
    public boolean PasteFile(String typeOfPaste , String source , String destination) throws IOException{

        if(typeOfPaste=="copy-paste"){
            
            File sourceFile = new File(source);
            String name = sourceFile.getName();

            File destinationFile = new File(destination + name);
            FileUtils.copyFile(sourceFile, destinationFile);
            
            File checkFileExistFile = new File(destination + name);
            
            if(checkFileExistFile.exists()){
              reslutPaste= true;  
            }
            else{
               reslutPaste= false; 
            }
            
           
            
        }
        else if(typeOfPaste=="cut-paste"){
             
            File sourceFile = new File(source);
            String name = sourceFile.getName();

            File destinationFile = new File(destination + name);
            FileUtils.copyFile(sourceFile, destinationFile);
            
            File checkFileExistFile = new File(destination + name);
            
            if(checkFileExistFile.exists()){
              reslutPaste= true;  
              //delete bec if cut
              sourceFile.delete();
            }
            else{
               reslutPaste= false; 
            }
            
        }
        else{
            reslutPaste= false;
        }
        
        return reslutPaste;
        
        
    }
    
}
