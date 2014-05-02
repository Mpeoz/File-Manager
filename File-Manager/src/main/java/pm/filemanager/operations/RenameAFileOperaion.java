/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author nova
 */
public class RenameAFileOperaion {
//TODO: insertCode for name and take all name into a stack for undo .    
    boolean result;
    /**
     * boolean function RenameAFile
     * @param path String
     * @param nameOfFile String
     * @return true if success renamed or false if is not
     */
    public boolean  RenameAFile(String path,String nameOfFile){
        
        Path source = Paths.get(path);
        try {
            Files.move(source, source.resolveSibling(nameOfFile));
            result=true;
        } catch (IOException ex) {
            Logger.getLogger(RenameAFileOperaion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }
    
}
