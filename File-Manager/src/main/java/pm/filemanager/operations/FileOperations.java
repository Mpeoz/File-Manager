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
 * @author PTsilopoulos
 */
public class FileOperations {
    
    //private static boolean resultPaste;
    
    public static void deleteFile(String sourceName) throws IOException {
        
        File sourceFile = new File(sourceName);
        if (sourceFile.isFile()) {
            FileUtils.deleteQuietly(sourceFile);
        } else {
            FileUtils.deleteDirectory(sourceFile);
        }
    }
    
    public static void copyPasteFile(String sourceName, String destName) throws IOException {
        
        File sourceFile = new File(sourceName);
        File destFile = new File(destName);
        if (sourceFile.isFile() && destFile.isDirectory()) {
            FileUtils.copyFileToDirectory(sourceFile, destFile);
        } else if (sourceFile.isFile() && destFile.isFile()) {
            FileUtils.copyFile(sourceFile, destFile);
        } else {
            FileUtils.copyDirectoryToDirectory(sourceFile, destFile);
        }
//        File checkFileExistance = new File(destName + name);
//        resultPaste = checkFileExistance.exists();
//        if(checkFileExistance.exists()) {
//            resultPaste = true;
//        }
//        else {
//            resultPaste = false;
//            // TO-DO logger, exception handling
//        }
    }     

    public static void cutPasteFile(String sourceName, String destName) throws IOException {
        
        File sourceFile = new File(sourceName);
        File destFile = new File(destName);
        if (sourceFile.isFile() && destFile.isDirectory()) {
            FileUtils.copyFileToDirectory(sourceFile, destFile);
        } else if (sourceFile.isFile() && destFile.isFile()) {
            FileUtils.copyFile(sourceFile, destFile);
        } else {
            FileUtils.copyDirectoryToDirectory(sourceFile, destFile);
        }
        FileUtils.deleteQuietly(sourceFile);
//        File checkFileExistance = new File(destName + name);
//        resultPaste = checkFileExistance.exists();
//        if(checkFileExistance.exists()) {
//            resultPaste = true;
//            sourceFile.delete();
//        }
//        else {
//            resultPaste = false;
//            // TO-DO logger, exception handling
//        }
    }   
}    
