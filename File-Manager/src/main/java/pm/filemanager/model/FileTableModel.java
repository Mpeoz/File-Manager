/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.model;

import java.io.File;
import java.net.URLConnection;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alex
 */
public class FileTableModel extends AbstractTableModel{
  
  protected File dir;
  protected String[] filenames;

  protected String[] columnNames = new String[] {
    "Name",  "Date Modified", "Type","Size"
  };

  protected Class[] columnClasses = new Class[] { 
    String.class, Long.class, Date.class, 
      Boolean.class, Boolean.class, Boolean.class
  };

  // This table model works for any one given directory
  public FileTableModel(File dir) { 
    this.dir = dir; 
    this.filenames = dir.list();  // Store a list of files in the directory
  }

  // These are easy methods.
  public int getColumnCount() { return 4; }  // A constant for this model
  public int getRowCount() { return filenames.length; }  // # of files in dir

  // Information about each column.
  public String getColumnName(int col) { return columnNames[col]; }
  public Class getColumnClass(int col) { return columnClasses[col]; }

  // The method that must actually return the value of each cell.
  public Object getValueAt(int row, int col) {
      
    File f = new File(dir, filenames[row]);
    
    switch(col) {
         
         case 0: return filenames[row];
         case 1: return new Date(f.lastModified());
         case 2: return new Long(URLConnection.guessContentTypeFromName(f.getName()));
         case 3: return new Long(f.length());
    
    default: return null;
    }
  }
}
