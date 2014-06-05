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

/**
 *
 * @author alex
 */
public class CreateNewFolderOperation {

    protected static int countFileExist = 0;
    String finalPath = "";

    /**
     * public boolean createNewFolder
     *
     * @param path String
     * @param count integer
     * @return true if folder is created or false if is not
     */
    public static void createNewFolder(String path, int count) {

            Path dPath = Paths.get(path + "New Folder" + count);
            
            boolean checkIfExistDir = Files.exists(dPath);
            //check if exist 
            if (checkIfExistDir) {
                countFileExist = countFileExist + 1;
                createNewFolder(path, countFileExist);
            }
            try {
                Files.createDirectory(dPath);
            } catch (IOException e) {
                System.out.println("Could not create Directory");
        }
    }
}
