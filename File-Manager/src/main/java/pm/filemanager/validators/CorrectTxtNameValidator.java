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
public class CorrectTxtNameValidator {

    /**
     * boolean function CorrectTxtName
     *
     * @param name String
     * @return true if is txt or false if is not
     */
    public boolean CorrectTxtName(String name) {

        return name.toLowerCase().endsWith(".txt") && !name.matches(".*([ \t]).*") && !name.isEmpty();

    }

}
