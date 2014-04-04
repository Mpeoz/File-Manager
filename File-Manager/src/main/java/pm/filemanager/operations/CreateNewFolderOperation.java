/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author alex
 */
public class CreateNewFolderOperation {
    
    public boolean createNewFolderOperation(String path){
        File f = new File(path);
    try{
        if(f.exists() == false){
            f.mkdir();
            System.out.println("Directory Created");
            return true;
        }
        else {
            System.out.println("Directory is not created");
            return false;
        }
    }catch(Exception e){
        e.printStackTrace();
       }
        return false;
    }
}
    

