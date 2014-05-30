/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.model;

/**
 *
 * @author alex
 */
public class CopyCutModel {
    
    private String copyCutPath;
    private String typeOfPaste;

    public String getCopyCutPath() {
        return copyCutPath;
    }

    public void setCopyCutPath(String copyCutPath) {
        
        this.copyCutPath = copyCutPath;
    }    
    
    public String getTypeOfPaste() {
        
        return typeOfPaste;
    }
    
    public void setTypeOfPaste() {
        
        this.typeOfPaste = typeOfPaste;
    }
}
