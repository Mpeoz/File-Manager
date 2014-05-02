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
public class PasteFileController {

    private static final Logger LOG = Logger.getLogger(DeleteFileController.class.getName());
    private final IFileOperations fileOperations;

    public PasteFileController(IFileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

//    public void PasteFile(String destinationString) throws IOException {
//        
//        // TO-DO create Transferable & DataFlavor gia Files
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        String sourceString = clipboard.toString();
//        Path sourcePath = Paths.get(sourceString);
//        Path destinationPath = Paths.get(destinationString);
//        fileOperations.cutPasteFile(sourcePath, destinationPath);
//    }
    public void PasteFile(String sourceString, String destinationString) throws IOException {

        // TO-DO create Transferable & DataFlavor gia Files
        Path sourcePath = Paths.get(sourceString);
        Path destinationPath = Paths.get(destinationString);
        fileOperations.cutPasteFile(sourcePath, destinationPath);
    }

}
