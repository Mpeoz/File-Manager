/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.operations;

import java.io.File;
import pm.filemanager.model.FileNameModel;

/**
 *
 * @author alex
 */
public class GetContentTypeOperation {

    /**
     * Function String getContentType
     *
     * @param fileName File
     * @return type of file as string if exist and is folder or is a file or a
     * null string
     */
    public String getContentType(File fileName) {

        String type = " ";
        if (fileName.isDirectory()) {
            return type = "Folder";
        } else if (fileName.isFile()) {
            //FIXME: bug if File is a type File // output : path of file... why?
            FileNameModel fileNameModel = new FileNameModel(fileName.getAbsolutePath(), '/', '.');
            return fileNameModel.extension();
        } else {
            return type;
        }

    }

}
