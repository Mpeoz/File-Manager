/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.validators;

import java.io.File;
import javax.swing.JTextField;
import pm.filemanager.controllers.checkPathIfDirectoryController;

/**
 *
 * @author alex
 */
public class StringIfEndsWithSeparatorValidator {

    public String checkIfStringEndWithSeparator( JTextField filePathTextField) {

        String resultPathForCreateFolder;
//        checkPathIfDirectoryController checkIfDirectory = new checkPathIfDirectoryController();
//        boolean ifDirectory = checkIfDirectory.checkPathIfDirectory(filePathTextField.getText().toString());
//
//        if (ifDirectory) {
            if (filePathTextField.getText().toString().endsWith("\\")) {
                
                resultPathForCreateFolder = filePathTextField.getText().toString();

            } else {
                resultPathForCreateFolder = filePathTextField.getText().toString() + "\\";

            }
//        }
        return resultPathForCreateFolder;
    }
}
