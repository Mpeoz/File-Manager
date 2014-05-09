/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.util.Stack;
import javax.swing.JTextField;

/**
 *
 * @author alex
 */
public class NextButtonActionOperation {
    
    public void NextButtonAction(int countStackPrev , int countStack, Stack<String> stackPrev,Stack<String> stackPop,JTextField filePathTextField){
            //Array Index for check if ArrayIndexOutOfBounds
    Integer ArrayIndex = 0;
        if (countStackPrev < 0) {
            countStackPrev = 0;
        }
        if (countStackPrev >= 0 && countStackPrev <= countStack) {
            //if ArrayIndexOutOfBounds isnt out of range keep going
            try{
             ArrayIndex = stackPrev.get(countStackPrev).length();
            }
            catch(Exception e){
                System.out.println("This is the last file for prev");
            stackPop.clear();
            }
            if(!(countStackPrev> ArrayIndex)){
            filePathTextField.setText(stackPrev.get(countStackPrev));
            }else{    
            stackPop.clear();
            }
        } else {       
            stackPop.clear();
        }
    }
    
}
