/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.model;

/**
 *
 * @author PTsilopoulos
 */
public class DirectoriesNavigationModel {
    
    private String parents, children;
    
    public void setChildrenPath(String children) {
        this.children = children;
    }
    
    public void setParentsPath(String parents) {
        this.parents = parents;
    }

    public String getChildrenPath() {
        return children;
    }
    
    public String getParentPath() {
        return parents;
    }
}
