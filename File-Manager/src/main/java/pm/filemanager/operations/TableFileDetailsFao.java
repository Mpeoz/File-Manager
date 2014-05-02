/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.operations;

import java.io.File;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pm.filemanager.controllers.GetContetTypeController;

/**
 *
 * @author alex
 */
public class TableFileDetailsFao {

    GetContetTypeController newGetContetTypeController = new GetContetTypeController();

    /**
     * public boolean setTableFileDetailsFao
     *
     * @param table JTable
     * @param path String
     * @return true if details is set or false if is not
     */

    public boolean setTableFileDetailsFao(JTable table, String path) {

        File folder = new File(path);
        boolean success = false;
        File[] listOfFiles = folder.listFiles();
        try {
            if (folder.isDirectory()) {

                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isAbsolute()) {
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.addRow(new Object[]{
                            listOfFiles[i].getName(),
                            new Date(listOfFiles[i].lastModified()),
                            newGetContetTypeController.getContentType(listOfFiles[i]),
                            listOfFiles[i].length() + " bytes"

                        });
                    }
                }
                success = true;

            } else if (folder.isFile()) {
                int i = 0;
                //  if (listOfFiles[i].isAbsolute()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{
                    folder.getName(),
                    new Date(folder.lastModified()),
                    newGetContetTypeController.getContentType(folder),
                    folder.length() + " bytes"

                });
                // }
                success = true;
            } else {
                success = false;
            }
        } catch (Exception e) {
            e.printStackTrace();;

        }
        return success;

    }

}
