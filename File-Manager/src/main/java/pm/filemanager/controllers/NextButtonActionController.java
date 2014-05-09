/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import java.util.Stack;
import javax.swing.JTextField;
import pm.filemanager.operations.NextButtonActionOperation;

/**
 *
 * @author alex
 */
public class NextButtonActionController {
    /**
     * Public Void Function NextButtonAction
     * @param countStackPrev int
     * @param countStack int
     * @param stackPrev Stack<String>
     * @param stackPop Stack<String>
     * @param filePathTextField  JTextField
     */
    public void NextButtonAction(int countStackPrev , int countStack, Stack<String> stackPrev,Stack<String> stackPop,JTextField filePathTextField){
        NextButtonActionOperation nextButtonAction = new NextButtonActionOperation();
        nextButtonAction.NextButtonAction(countStackPrev, countStack, stackPrev, stackPop, filePathTextField);
    }
    
}
