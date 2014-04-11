/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.model;

import java.io.File;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author alex
 */
public class FileTreeModel implements TreeModel {  
          private String root; // The root identifier  
                    
          // Get a File object list of all of our drives  
          File[] fRoots = File.listRoots();  
  
          private Vector listeners; // Declare the listeners vector  
  
          public FileTreeModel() {  
  
               root = System.getProperty("user.dir");  
  
               File tempFile = new File(root);  
                          
               // Root is going to start as a simple string  
               root = "Computer";  
               listeners = new Vector();  
          }  
  
       //Return our start string as root  
          public Object getRoot() {  
              return root;  
               
          }  
  
          public Object getChild(Object parent, int index) {  
               // Check if this call is on our root string, if so, feed it an instance from the fRoots File object array  
               if (parent instanceof String) { 
                   return fRoots[index];
               }  
               else {  
                    // Otherwise process a branch as normal  
                    File directory = (File) parent;  
                    String[] directoryMembers = directory.list(); 
                    //return (new File(directory, directoryMembers[index]));
                    return new FileTreeModel.TreeFile(directory, directoryMembers[index]);
                    
                    
                    
               }  
          }  
  
          public int getChildCount(Object parent) {  
               // Again, we are checking if this is a call with root string as parent, if so, give it the length of our File object array.  
               if (parent instanceof String) { 
                   return fRoots.length; 
               }  
               else {  
                    // Otherwise process as a normal file branch  
                    File fileSystemMember = (File) parent;  
                    if (fileSystemMember.isDirectory()) {  
                         String[] directoryMembers = fileSystemMember.list(); 
                         
                        //HACK :PROBLEM WITH SOME FOLDERS 
                         if(!(directoryMembers.length==0)){
                         return directoryMembers.length;    
                         }
                         else{
                            return 0;
                          
                         }
                    }
                    if (fileSystemMember != null){
                      return fileSystemMember.list().length;
    
    
                           
                    }  
  
                  return 0;
               }
          
              
          }  
  
          public int getIndexOfChild(Object parent, Object child) {  
               int result = -1;  
               // Again check if parent is our root string, feed it the index from the fRoots array  
               if (parent instanceof String) {  
                    File theChild = (File) child;  
                    for (int i = 0; i < fRoots.length; i++) {  
                         if (child.equals(fRoots[i])) {  
                              return i;  
                         }  
                    }  
               }  
               else {  
                    File directory = (File) parent;  
                    File directoryMember = (File) child;  
                    String[] directoryMemberNames = directory.list();  
                      
  
                    for (int i = 0; i < directoryMemberNames.length; ++i) {  
                         if (directoryMember.getName().equals(directoryMemberNames[i])) {  
                              result = i;  
                              break;  
                         }  
                    }   
               }  
               return result;  
          }  

          public boolean isLeaf(Object node) {  
               // One last time checking if it is our root string node  
               if (node instanceof String) { 
                   return false;
               }  
               else {  
                    return ((File) node).isFile();  
               }  
          }  
          
          

          public void addTreeModelListener(TreeModelListener l) {  
            if (l != null && !listeners.contains(l)) {  
              listeners.addElement(l);  
            }  
          }  
  
         public void removeTreeModelListener(TreeModelListener l) {  
            if (l != null) {  
              listeners.removeElement(l);  
            }  
          }  
  

          public void valueForPathChanged(TreePath path, Object value) {
        File oldFile = (File) path.getLastPathComponent();
        String fileParentPath = oldFile.getParent();
        String newFileName = (String) value;
        File targetFile = new File(fileParentPath, newFileName);
        oldFile.renameTo(targetFile);
        File parent = new File(fileParentPath);
        int[] changedChildrenIndices = { getIndexOfChild(parent, targetFile) };
        Object[] changedChildren = { targetFile };
        fireTreeNodesChanged(path.getParentPath(), changedChildrenIndices, changedChildren);

      }
  
          public void fireTreeNodesInserted(TreeModelEvent e) {  
            Enumeration listenerCount = listeners.elements();  
            while (listenerCount.hasMoreElements()) {  
                if(listenerCount.hasMoreElements()){
                     TreeModelListener listener = (TreeModelListener) listenerCount.nextElement();  
              listener.treeNodesInserted(e); 
                }
                else{
                    break;
                }
            }
              
              
          }  
  
          public void fireTreeNodesRemoved(TreeModelEvent e) {  
            Enumeration listenerCount = listeners.elements(); 
            
               while (listenerCount.hasMoreElements()) {  
                   if(listenerCount.hasMoreElements()){
               
              TreeModelListener listener = (TreeModelListener) listenerCount.nextElement();  
              listener.treeNodesRemoved(e);  
                   }
                   else{
                       break;
                   }
            
          }
            
  
          }  
  
          public void fireTreeNodesChanged(TreeModelEvent e) {  
            Enumeration listenerCount = listeners.elements(); 
            
            while (listenerCount.hasMoreElements()) {  
                if(listenerCount.hasMoreElements()){
              TreeModelListener listener = (TreeModelListener) listenerCount.nextElement();  
              listener.treeNodesChanged(e);  
            }  
                else{
                    break;
                }
            
  
          }  
          }
  
         
      private void fireTreeNodesChanged(TreePath parentPath, int[] indices, Object[] children) {
    TreeModelEvent event = new TreeModelEvent(this, parentPath, indices, children);
    Iterator iterator = listeners.iterator();
    TreeModelListener listener = null;
    while (iterator.hasNext()) {
      listener = (TreeModelListener) iterator.next();
      listener.treeNodesChanged(event);
    }
  }

 

 private class TreeFile extends File {
    public TreeFile(File parent, String child) {
      super(parent, child);
    }
   

    public String toString() {
      return getName();
    }
  }
          
}
