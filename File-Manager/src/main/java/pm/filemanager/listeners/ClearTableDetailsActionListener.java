/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import pm.filemanager.controllers.ClearTableController;
import pm.filemanager.controllers.SetTableFileDetailsController;
import pm.filemanager.swing.MainWindow;

/**
 *
 * @author alex
 */
public class ClearTableDetailsActionListener extends JFrame implements KeyListener, ActionListener ,MouseListener,FocusListener{
     public  final JTextField filePathTextField;
     public  final JTable fileDetailsTable;
    
    public  ClearTableDetailsActionListener(JTextField filePathTextField,JTable fileDetailsTable){
        this.filePathTextField = filePathTextField;
        this.fileDetailsTable = fileDetailsTable;
        
    }
      //refactor se kainourgia i prepei na einai edw mesa? 
     private void ClearTableAddTableDetails() {

        SetTableFileDetailsController newTableFileDetailsController = new SetTableFileDetailsController();
        //clear table
        ClearTableController clearTable = new ClearTableController();
        boolean isClear = clearTable.ClearTable(fileDetailsTable);

        //if is clear add new selected path
        if (isClear) {
            //check if show all file details
            try {
                newTableFileDetailsController.setTableFileDetailsController(fileDetailsTable, filePathTextField.getText().toString());
            } catch (Exception e) {
                try {
                    throw e;
                } catch (Exception ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
        ClearTableAddTableDetails();
    }

    @Override
    public void keyPressed(KeyEvent e) {
       ClearTableAddTableDetails();
    }

    @Override
    public void keyReleased(KeyEvent e) {
       ClearTableAddTableDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        ClearTableAddTableDetails();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       ClearTableAddTableDetails();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ClearTableAddTableDetails();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ClearTableAddTableDetails();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ClearTableAddTableDetails();
    }
    @Override
    public void mouseExited(MouseEvent e) {
        ClearTableAddTableDetails();
    }

    @Override
    public void focusGained(FocusEvent e) {
        ClearTableAddTableDetails();
    }

    @Override
    public void focusLost(FocusEvent e) {
        ClearTableAddTableDetails();
    }
    
}
