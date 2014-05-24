/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 *
 * @author PTsilopoulos
 */
public interface IFileOperations {
    
    boolean deleteFile(File filePath) throws IOException;
    
    boolean copyPasteFile(Path source, Path dest) throws IOException;
            
    boolean cutPasteFile(Path source, Path dest) throws IOException;
}
