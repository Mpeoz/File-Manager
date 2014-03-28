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

import pm.filemanager.model.FileNameModel;

/**
 *
 * @author alex
 */
public class TableFileDetailsFao {

    public boolean TableFileDetailsFao(JTable table, String path) {

        File folder = new File(path);
       boolean success = false;
        File[] listOfFiles = folder.listFiles();
       try{ 
       if(folder.isDirectory()){
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isAbsolute()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{
                    listOfFiles[i].getName(),
                    new Date(listOfFiles[i].lastModified()),
                    getContentType(listOfFiles[i]),
                    listOfFiles[i].length() + " bytes"

                });
            }
        }
                success= true;
        
       }
       else if(folder.isFile()){
           int i =0;
         //  if (listOfFiles[i].isAbsolute()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{
                    folder.getName(),
                    new Date(folder.lastModified()),
                    getContentType(folder),
                    folder.length() + " bytes"

                });
           // }
           success=true;
       }
       else{
           success= false;
       }
       }catch(Exception e){
           e.printStackTrace();;
           
       }
        return success;
       
    }

    private String getContentType(File fileName) {

        String type = " ";
        if (fileName.isDirectory()) {
            return type = "Folder";
        } else if(fileName.isFile() ) {
            //FIXME: bug if File is a type File // output : path of file... why?
            FileNameModel fileNameModel = new FileNameModel(fileName.getAbsolutePath(), '/', '.');
            return fileNameModel.extension();
        }
        else {
            return type;
        }

    }

}
