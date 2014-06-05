/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.model;

import java.io.IOException;
import java.util.Stack;
import pm.filemanager.commands.ICommand;

/**
 *
 * @author PTsilopoulos
 */
public class LocalStorage {
    
    static Stack<ICommand> commandsPerformed = new Stack<>();
    static Stack<ICommand> commandsUndone = new Stack<>();
    
    public static ICommand popUndo() {
        
        ICommand command = commandsPerformed.pop();
        commandsUndone.push(command);
        return command;
    }
    
    public static ICommand popRedo() {
        
        if (!commandsUndone.isEmpty()) {
            ICommand command = commandsUndone.pop();
            commandsPerformed.push(command);
            return command;
        }
        return null;
    }
    
    public static final boolean action(ICommand command) throws IOException {

        commandsPerformed.push(command);
        return false;
    }
}
