/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import javax.swing.JTable;
import pm.filemanager.operations.TableFileDetailsFao;

/**
 *
 * @author user
 */
public class TableFileDetailsController {
    
    public boolean TableFileDetailsController(JTable table, String path){
        TableFileDetailsFao newTableFileDetailsFao = new TableFileDetailsFao();
        boolean result = newTableFileDetailsFao.TableFileDetailsFao(table, path);
        return result;
    }
}
