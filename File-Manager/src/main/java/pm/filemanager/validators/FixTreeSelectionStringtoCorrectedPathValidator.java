/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.validators;

import javax.swing.event.TreeSelectionEvent;

/**
 *
 * @author alex
 */
public class FixTreeSelectionStringtoCorrectedPathValidator {
    /**
     * public String function FixTreeSelectionStringToCorrectedPath
     * @param e TreeSelectionEvent
     * @return a Fixed String with Corrected Path
     */
    public String FixTreeSelectionStringToCorrectedPath(TreeSelectionEvent e){
          //remove [Computer, from string
            String pathForNode = e.getPath().toString().replaceAll("^\\[Computer,", "");
            //remove all \ from string
            pathForNode=pathForNode.replaceAll("\\\\","");
             //remove all white spaces from string
            pathForNode=pathForNode.replaceAll("\\s+","");
            //replace all , with \
            pathForNode=pathForNode.replaceAll(",","\\\\");
            //remove ] from string 
            pathForNode=pathForNode.replaceAll("]","");
            //add \ to end of path
            pathForNode=pathForNode.replaceAll("$","\\\\");
            //return a fixed path String..
            return pathForNode;
    }
    
}
