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
        StringIfEndsorNoWithSeparatorValidator stringIfEndsorNoWithSeparator = new StringIfEndsorNoWithSeparatorValidator();
        String path = stringIfEndsorNoWithSeparator.checkIfStringNoEndWithSeparator(name);
        path = name.replaceAll("\\\\.*$", "");

        path = stringIfEndsorNoWithSeparator.checkIfStringEndWithSeparator(path);
        return path;
    }
}
