/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.validators;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author alex
 */
public class RemoveLastSeparatorValidator {

    public String getParent(String name) {
        String finalName = null;
        FileSeparatorValidator looksLikeFile = new FileSeparatorValidator(name);
        String pathName = looksLikeFile.removeFileSeparator();
        Path path = Paths.get(pathName);
        try{
         finalName = path.getParent().toString();     
        }catch(Exception e){
            
        }
        if(finalName==null){
            finalName="C:\\";
        }
        return finalName;
    }
}
