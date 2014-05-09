/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.logging.Logger;
import pm.filemanager.operations.IFileOperations;

/**
 *
 * @author PTsilopoulos
 */
public class CopyFileController {
    
    private static final Logger LOG = Logger.getLogger(DeleteFileController.class.getName());
    private final IFileOperations fileOperations;
    public CopyFileController(IFileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }
    
    public void copyFile(String sourceString) throws IOException {
    
        ClipboardOwner co = null;
        Toolkit tk = Toolkit.getDefaultToolkit();
        StringSelection st = new StringSelection(sourceString);
        Clipboard cp = tk.getSystemClipboard();
        cp.setContents(st, co);
    }
}
