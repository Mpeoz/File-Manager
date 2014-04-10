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
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import pm.filemanager.operations.IFileOperations;

/**
 *
 * @author PTsilopoulos
 */
public class DeleteFileController {
    
    private static final Logger LOG = Logger.getLogger(DeleteFileController.class.getName());
    private final IFileOperations fileOperations;
    public DeleteFileController(IFileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }
    
    public void deleteFile(String pathString) throws IOException {
        Path path = Paths.get(pathString);
        fileOperations.deleteFile(path);
        //return JOptionPane.showMessageDialog(null, LOG, "Success!", INFORMATION_MESSAGE);
    }
}