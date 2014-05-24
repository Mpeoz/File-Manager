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
import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 *
 * @author PTsilopoulos
 */
public class FileOperations implements IFileOperations {
    
    @Override
    public boolean deleteFile(File filePath) throws IOException {
        filePath.delete();
        return true;
    }
    
    @Override
    public boolean copyPasteFile(Path source, Path dest) throws IOException {
        Files.copy(source, dest, REPLACE_EXISTING, ATOMIC_MOVE);
        return true;
    }
    
    @Override
    public boolean cutPasteFile(Path source, Path dest) throws IOException {
        Files.move(source, dest, REPLACE_EXISTING, ATOMIC_MOVE);
        return true;
    }     
}
