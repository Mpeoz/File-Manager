/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.commands;

import java.io.IOException;

/**
 *
 * @author PTsilopoulos
 */
public interface ICommand {
    
    void undo() throws IOException;
    
    void redo() throws IOException;
    
    void perform() throws IOException;
}
