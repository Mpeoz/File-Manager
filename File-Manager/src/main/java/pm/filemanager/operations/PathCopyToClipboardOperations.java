/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.tree.*;

/**
 *
 * @author PTsilopoulos
 */
public class PathCopyToClipboardOperations {
    
 
   public void expandTree(JTree tree) {
        DefaultMutableTreeNode root =
            (DefaultMutableTreeNode)tree.getModel().getRoot();
        java.util.Enumeration e = root.breadthFirstEnumeration();
        while(e.hasMoreElements()) {
            DefaultMutableTreeNode node =
                (DefaultMutableTreeNode)e.nextElement();
            if(node.isLeaf()) continue;
            int row = tree.getRowForPath(new TreePath(node.getPath()));
            tree.expandRow(row);
        }
    }
 //TODO:refactor
    private MouseListener copier = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)) {
               // rootFileTree = (JTree)e.getComponent();
                Clipboard clipboard =
                    Toolkit.getDefaultToolkit().getSystemClipboard();
                //rootFileTree.getTransferHandler().exportToClipboard(rootFileTree,
                    //clipboard, TransferHandler.COPY);
            }
        }
    };
class CopyHandler extends TransferHandler {
    public void exportToClipboard(JComponent comp, Clipboard clip, int action) {
        JTree tree = (JTree)comp;
        TreePath path = tree.getSelectionPath();
        if(path != null) {
            clip.setContents(new StringSelection(path.toString()), null);
        }
    }
}
} 
 