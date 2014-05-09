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
public class CorrectNameValidator {
    /**
     * Function boolean CorrectName 
     * @param name String
     * @return true if is correct ( with out spaces and no empty ) else return false
     */
     public boolean CorrectName(String name) {

        return  !name.matches(".*([ \t]).*") && !name.isEmpty();

    }
    
}
