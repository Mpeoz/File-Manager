/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.controllers;

import pm.filemanager.operations.RenameAFileOperaion;

/**
 *
 * @author alex
 */
public class RenameAFileController {

    /**
     * boolean function RenameAFile: rename a file
     *
     * @param path String
     * @param nameOfFile nameOfFile
     * @return if is renamed success return true if is not return false
     */
    public boolean RenameAFile(String path, String nameOfFile) {
        RenameAFileOperaion RenameAFileOperaion = new RenameAFileOperaion();
        boolean result = RenameAFileOperaion.RenameAFile(path, nameOfFile);
        return result;

    }

}
