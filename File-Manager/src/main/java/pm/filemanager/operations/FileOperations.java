/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 *
 * @author PTsilopoulos
 */
public class FileOperations implements IFileOperations {
    
    @Override
    public boolean deleteFile(Path filePath) throws IOException {
        Files.delete(filePath);
        return true;
    }
    
    @Override
    public boolean copyPasteFile(Path source, Path dest) throws IOException {
        Files.copy(source, dest);
        return true;
    }
    
    @Override
    public boolean cutPasteFile(Path dest) throws IOException {
        // TO-DO prepei na usarw thn PathCopyToClipboardOperations gia na
        // kanw temp save to path tou file kai na perimenw to Mouse event
        // gia na kanw paste
        //Path source = mousePressed(Mouse event e).
        Files.move(source, dest, REPLACE_EXISTING);
        return true;
    } 
    
}
