/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.io.File;

/**
 *
 * @author alex
 */
public class CheckPathIfDirectoryOperation {
    
    public boolean checkPathIfDirectory(String path) {
        File file = new File(path);
       if(file.isDirectory()){
           return true;
       }
       else{
           return false;
       }
       
    
}
    
}
