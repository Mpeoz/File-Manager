/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alex
 */
public class ClearTableFao {
    /**
     * public boolean function ClearTable
     * @param table
     * @return true if is clear and  false if is not
     */
    public boolean ClearTable(JTable table){
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.getDataVector().removeAllElements();
        table.revalidate();
        //return true or false
        return table.getRowCount()==0;
        
    }
    
}
