/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.controllers;

import java.io.IOException;
import pm.filemanager.model.LocalStorage;
import pm.filemanager.commands.ICommand;
import pm.filemanager.commands.PasteCommand;

/**
 *
 * @author PTsilopoulos
 */
public class PasteController {

    private final String typeOfPaste, source, destination;
    
    public PasteController(String typeOfPaste, String source, String destination) {
        
        this.source = source;
        this.destination = destination;
        this.typeOfPaste = typeOfPaste;
    }
  
    public void paste() throws IOException {
        
        ICommand pasteCommand = new PasteCommand(typeOfPaste, source, destination);
        pasteCommand.perform();
        LocalStorage.action(pasteCommand);
    }
    
}
