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
 * @author alex
 *
 */
public class SetTableFileDetailsController {
    /**
     * public boolean SetTableFileDetailsController
     * @param table
     * @param path
     * @return true if is set or not
     */
    public boolean setTableFileDetailsController(JTable table, String path) {
        
        TableFileDetailsFao newTableFileDetailsFao = new TableFileDetailsFao();
        boolean result=newTableFileDetailsFao.setTableFileDetailsFao(table, path);
        return result;
    }
}
