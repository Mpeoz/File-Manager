/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;


import javax.swing.JTable;
import pm.filemanager.operations.ClearTableFao;
/**
 *
 * @author user
 */
public class ClearTableController {
    
    public boolean ClearTable(JTable table){
        ClearTableFao newClearTableFao = new ClearTableFao();
        boolean resultClearTable = newClearTableFao.ClearTable(table);
        return resultClearTable;
       
    }
    
}
