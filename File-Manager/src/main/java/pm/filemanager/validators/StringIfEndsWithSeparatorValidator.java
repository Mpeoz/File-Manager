/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.validators;

import javax.swing.JTextField;

/**
 *
 * @author alex
 */
public class StringIfEndsWithSeparatorValidator {
/**
 * public String checkIfStringEndWithSeparator
 * @param filePathTextField JTextField
 * @return a String with Separator in end if exist or not
 */
    public String checkIfStringEndWithSeparator(JTextField filePathTextField) {

        String resultPathForCreateFolder;

        if (filePathTextField.getText().toString().endsWith("\\")) {

            resultPathForCreateFolder = filePathTextField.getText().toString();

        } else {
            resultPathForCreateFolder = filePathTextField.getText().toString() + "\\";

        }

        return resultPathForCreateFolder;
    }
}
