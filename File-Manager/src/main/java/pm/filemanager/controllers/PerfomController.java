/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import pm.filemanager.model.LocalStorage;
import java.io.IOException;
import pm.filemanager.operations.ICommand;

/**
 *
 * @author alex
 */
public class PerfomController {
    
    public void perform(ICommand com,String temp) {
        try {
            LocalStorage.action(com);
            
        } catch(IOException e) {
            //TO-DO add logger
        }
    }
    
}
