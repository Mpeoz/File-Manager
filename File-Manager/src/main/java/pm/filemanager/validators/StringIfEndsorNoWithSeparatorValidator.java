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
public class StringIfEndsorNoWithSeparatorValidator {
/**
 * public String checkIfStringEndWithSeparator
 * @param name String
 * @return a String with Separator in end if exist or not
 */
    public String checkIfStringEndWithSeparator(String name) {

        String resultPathForCreateFolder;

        if (name.endsWith("\\")) {

            resultPathForCreateFolder = name;

        } else {
            resultPathForCreateFolder = name+ "\\";

        }

        return resultPathForCreateFolder;
    }
    //TODO:TEST FUNCTION for PropertiesForm
    public String checkIfStringNoEndWithSeparator(String name) {

        String resultPathForCreateFolder;

        if (name.endsWith("\\")) {

            resultPathForCreateFolder = name.replaceAll("$//", " ");
            System.out.println(resultPathForCreateFolder);

        } else {
            resultPathForCreateFolder = name;
            System.out.println(resultPathForCreateFolder);

        }

        return resultPathForCreateFolder;
    }
}
