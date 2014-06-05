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
public class CreateFileCommand implements ICommand {

    public CreateFileCommand() {
    }

    @Override
    public void undo() throws IOException {
        
    }

    @Override
    public void redo() throws IOException {
        
        perform();
    }

    @Override
    public void perform() throws IOException {
        
    }   
}
