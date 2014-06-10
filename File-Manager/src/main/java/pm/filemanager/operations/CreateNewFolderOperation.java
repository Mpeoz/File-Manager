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
     */
    public static String createNewFolder(String path, int count) {

            Path dPath = Paths.get(path + "NewFolder" + count);
            
            boolean checkIfExistDir = Files.exists(dPath);
            //check if exist 
            if (checkIfExistDir) {
                countFileExist = countFileExist + 1;
                createNewFolder(path, countFileExist);
            }
            try {
                Files.createDirectory(dPath);
                String newFolderLocation = dPath.toString();
                return newFolderLocation;
            } catch (IOException e) {
                System.out.println("Could not create Directory");
                return null;
        }
    }
}
