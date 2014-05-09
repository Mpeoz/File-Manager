/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.io.IOException;
import java.util.Stack;

/**
 *
 * @author alex
 */
public interface IFileCommand {
 void Do(Stack<String> V,String name) throws IOException;
 void Undo(Stack<String> stack,String name) throws IOException;
 void Redo(Stack<String> stack,String name) throws IOException;
    
}
