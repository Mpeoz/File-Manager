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
import pm.filemanager.operations.PasteFileOperation;

/**
 *
 * @author PTsilopoulos
 */
public class PasteFileController {
  /**
   * Public Boolean PasteFile
   * @param typeOfPaste String
   * @param source String
   * @param destination String
   * @return true if pasted success else return false
   * @throws IOException 
   */
    public boolean PasteFile(String typeOfPaste, String source, String destination) throws IOException{
        PasteFileOperation pasteFile = new PasteFileOperation();
        return pasteFile.PasteFile(typeOfPaste, source, destination);
    }
    

}
