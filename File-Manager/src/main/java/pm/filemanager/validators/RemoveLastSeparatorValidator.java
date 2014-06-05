/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.validators;

/**
 *
 * @author alex
 */
public class RemoveLastSeparatorValidator {

    public String removeLastSeparator(String name) {
        
        FileSeparatorValidator looksLikeFile = new FileSeparatorValidator(name);
        String path = looksLikeFile.removeFileSeparator();
        path = path.replaceAll("\\\\.*$", "");
        //path = looksLikeFile.removeFileSeparator();
        return path;
    }
}
