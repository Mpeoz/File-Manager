/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import pm.filemanager.operations.IFileOperations;

/**
 *
 * @author PTsilopoulos
 */
public class CutFileController {
    
    private static final Logger LOG = Logger.getLogger(DeleteFileController.class.getName());
    //public static final DataFlavor stringFlavor = null;
    private final IFileOperations fileOperations;
        public CutFileController(IFileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }
    
    public void cutFile(String sourceString) throws IOException {
        
//        ClipboardOwner co = null;
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        StringSelection st = new StringSelection(sourceString);
//        Clipboard cp = tk.getSystemClipboard();
//        cp.setContents(st, co);
        File path = new File(sourceString);
        // TO-DO needs fixing as it completely deletes the file making it 
        // impossible for the PasteFileController to use the Transferable
        path.delete();
    }  
}
