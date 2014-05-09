/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import java.io.IOException;
import java.util.Stack;
import pm.filemanager.operations.PushWhenValueChangedOperation;
import pm.filemanager.operations.StackPushOperation;

/**
 *
 * @author alex
 */
public class PushWhenValueChangedController {
    /**
     * public void function stackPush
     * @param newStackPush StackPushOperation
     * @param stackPop Stack<String>
     * @param stackPrev Stack<String>
     * @param pathForNode String
     */
     public void stackPush(StackPushOperation newStackPush ,Stack<String> stackPop, Stack<String> stackPrev,String pathForNode) throws IOException{
         PushWhenValueChangedOperation push = new PushWhenValueChangedOperation();
         push.stackPush(newStackPush, stackPop, stackPrev, pathForNode);
     }
    
    
}
