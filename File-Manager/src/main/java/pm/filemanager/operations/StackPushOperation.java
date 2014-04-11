/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author alex
 */
public class StackPushOperation {
     /**
     * public List function 
     * @param stack
     * @param name String
     * @return undo
     */
    public void StackPush(Stack<String> stack,String name){
        stack.push(name);
        
        
        
           }
//    public List StackPush(String name){
//        List myList = new LinkedList();
//        myList.add(new String(name));
//        return myList;
//        
//           }
    public void StackPop(Stack nameStack){
        nameStack.pop().toString();
   
    }
    
}

