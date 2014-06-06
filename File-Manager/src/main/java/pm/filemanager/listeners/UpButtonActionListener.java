/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import pm.filemanager.validators.RemoveLastSeparatorValidator;

/**
 *
 * @author alex
 */
public class UpButtonActionListener  extends JFrame implements ActionListener {
    
    private final JTextField filePathTextField;
    public UpButtonActionListener(JTextField filePathTextField ){
    this.filePathTextField = filePathTextField;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        RemoveLastSeparatorValidator removeLastSeparator = new RemoveLastSeparatorValidator();
        String removed = removeLastSeparator.getParent(filePathTextField.getText().toString());
        System.out.println(removed);
        filePathTextField.setText(removed);
        
    }
    
}
