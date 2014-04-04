/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

/**
 *
 * @author PTsilopoulos
 */
public class PathCopyToClipboardOperations {
    private JScrollPane getTreeComponent() {
        JTree tree = new JTree();
        tree.getSelectionModel().setSelectionMode(
            TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setTransferHandler(new CopyHandler());
        tree.addMouseListener(copier);
        expandTree(tree);
        return new JScrollPane(tree);
    }
 
    private void expandTree(JTree tree) {
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
 
    public static void main(String[] args) {
        PathCopyToClipboardOperations test = new PathCopyToClipboardOperations();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(test.getTreeComponent());
        f.setSize(400,400);
        f.setLocation(100,100);
        f.setVisible(true);
    }
 
    public MouseListener copier = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)) {
                JTree tree = (JTree)e.getComponent();
                Clipboard clipboard =
                    Toolkit.getDefaultToolkit().getSystemClipboard();
                tree.getTransferHandler().exportToClipboard(tree,
                    clipboard, TransferHandler.COPY);
            }
        }
    };
}
 
class CopyHandler extends TransferHandler {
    public void exportToClipboard(JComponent comp, Clipboard clip, int action) {
        JTree tree = (JTree)comp;
        TreePath path = tree.getSelectionPath();
        if(path != null) {
            clip.setContents(new StringSelection(path.toString()), null);
        }
    }
}