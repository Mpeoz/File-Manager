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
public class PushWhenValueChangedOperation  {
    public void stackPush(StackPushOperation newStackPush ,Stack<String> stackPop, Stack<String> stackPrev,String pathForNode) throws IOException{
                //stack add for undo redo
                newStackPush.Do(stackPop, pathForNode);
                //stack for prev
                newStackPush.Do(stackPrev, pathForNode);
                
               
    }
    
}
