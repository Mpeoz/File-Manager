/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.filemanager.operations;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author alex
 */
public class PasteFileOperation {

    public boolean resultPaste;
    
    
    /**
     * Boolean Function PasteFile
     * @param typeOfPaste String
     * @param source String
     * @param destination String
     * @return if paste is success for each of cut or paste we choose
     * @throws IOException
     */
    public boolean PasteFile(String typeOfPaste, String source, String destination) throws IOException {

        if ("copy-paste".equals(typeOfPaste)) {

            File sourceFile = new File(source);
            String name = sourceFile.getName();
            File destinationFile = new File(destination + name);

            if (sourceFile.isFile()) {

                FileUtils.copyFile(sourceFile, destinationFile);
            } else {
                FileUtils.copyDirectoryToDirectory(sourceFile, destinationFile);
            }

            File checkFileExistFile = new File(destination + name);

            if (checkFileExistFile.exists()) {
                resultPaste = true;
            } else {
                resultPaste = false;
            }

        } else if ("cut-paste".equals(typeOfPaste)) {

            File sourceFile = new File(source);
            String name = sourceFile.getName();

            File destinationFile = new File(destination + name);

            if (sourceFile.isFile()) {

                FileUtils.copyFile(sourceFile, destinationFile);
            } else {
                FileUtils.copyDirectoryToDirectory(sourceFile, destinationFile);
            }

            File checkFileExistFile = new File(destination + name);

            if (checkFileExistFile.exists()) {
                resultPaste = true;
                //delete bec if cut
                sourceFile.delete();
            } else {
                resultPaste = false;
            }

        } else {
            resultPaste = false;
        }

        return resultPaste;

    }

}
