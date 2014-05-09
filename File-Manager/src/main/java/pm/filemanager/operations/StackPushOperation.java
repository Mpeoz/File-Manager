/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author alex
 */
public class StackPushOperation implements IFileCommand {
     /**
     * public List function 
     * @param stack
     * @param name String
     * @throws java.io.IOException
     */
    @Override
    public void Do(Stack<String> stack,String name) throws IOException{
        stack.push(name);
        
           }

    @Override
    public void Undo(Stack nameStack,String name)  throws IOException{
        nameStack.pop().toString();
   
    }
    
    @Override
      public void Redo(Stack<String> stack, String name) throws IOException{
          
      }
   
    
}

