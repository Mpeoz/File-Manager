/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import pm.filemanager.operations.IFileOperations;

/**
 *
 * @author PTsilopoulos
 */
public class CopyPasteFileController {
    
    private static final Logger LOG = Logger.getLogger(DeleteFileController.class.getName());
    private final IFileOperations fileOperations;
        public CopyPasteFileController(IFileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }
    
    public boolean copyPasteFile(String sourceString, String destinationString) throws IOException {
        
        Path sourcePath = Paths.get(sourceString);
        Path destinationPath = Paths.get(destinationString);
        
        fileOperations.copyPasteFile(sourcePath, destinationPath);
        return true;
    }
}
