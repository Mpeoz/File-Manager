/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.operations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import pm.filemanager.commands.RenameCommand;
import pm.filemanager.model.DirectoriesNavigationModel;

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
            FileUtils.moveFileToDirectory(sourceFile, destFile, false);
        } else if (sourceFile.isFile()) {
            FileUtils.moveFile(sourceFile, destFile);
        } else {
            //destFile.mkdir();
            FileUtils.moveDirectoryToDirectory(sourceFile, destFile, false);
        }
        //FileUtils.deleteQuietly(sourceFile); // ZOMG it deletes EVERYTHING!!!
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
    
    public static void moveFolder(String source, String destination) throws IOException {
        
        Path sourcePath = Paths.get(source);
        Path targetPath = Paths.get(destination, source);
        try {
            Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("You must select a valid directory to move the folder into!");
        }
    }
    
    /**
     * boolean function RenameAFile
     * @param path String
     * @param nameOfFile String
     */
    public static void renameFile(String path, String nameOfFile) {
        
        Path source = Paths.get(path);
        try {
            Files.move(source, source.resolveSibling(nameOfFile));
        } catch (IOException ex) {
            Logger.getLogger(RenameCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean createFolder(String path) throws IOException {
        
//        FileSeparatorValidator fileChecker = new FileSeparatorValidator(path);
//        String newFolderPath = fileChecker.removeFileSeparator();
        
        if(checkDirectory(path) == true) {
            File folder = new File(path);
            folder.mkdirs();
            System.out.println("Directory Created");
            return true;    
        } else {
            System.out.println("You must select a valid directory to create a new folder into!");
            return false;
        }
    }
    
    public static boolean checkDirectory(String path) {
        
        File file = new File(path);
        return file.isDirectory();
    }
    
    public static String goBack(String currentPath) {
        
        DirectoriesNavigationModel dirNav = new DirectoriesNavigationModel();
        File currentFile = new File(currentPath);
        if(currentFile.exists()) {        
            String parentPath = currentFile.getParent();
            dirNav.setParentsPath(parentPath);
            return dirNav.getParentPath();
        }
        return null;
    }
}    
