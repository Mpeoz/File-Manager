/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import java.io.IOException;
import pm.filemanager.operations.ICommand;

/**
 *
 * @author PTsilopoulos
 */
public class RedoController {
    
    public static void redo(ICommand com) {
        try {
            ICommand command = LocalStorage.popRedo();
            command.redo();
        } catch (IOException e) {
            //TO-DO add logger
        }
    }
}