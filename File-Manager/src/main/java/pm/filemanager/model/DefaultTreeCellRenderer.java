/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.model;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTree;

/**
 *
 * @author Enlightened
 */
public abstract class DefaultTreeCellRenderer extends JLabel implements TreeCellRenderer {

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // TO-DO This is where we'll define the default look & feel values of the JTree
}
