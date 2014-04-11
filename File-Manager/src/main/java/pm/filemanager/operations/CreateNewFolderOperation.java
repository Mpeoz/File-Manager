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

    protected int countFileExist = 0;
    String finalPath = "";

    /**
     * public boolean createNewFolderOperation
     *
     * @param path String
     * @param count integer
     * @return true if folder is created or false if is not
     */
    public boolean createNewFolderOperation(String path, int count) {

        Path xPath = Paths.get(path + "newFolder" + count);
        boolean checkIfExistDir = false;

        checkIfExistDir = Files.exists(xPath);
        //check if exist 
        if (checkIfExistDir) {
            countFileExist = countFileExist + 1;
            boolean resultIfExistName = createNewFolderOperation(path, countFileExist);
            return resultIfExistName;
        }
        try {
            Files.createDirectory(xPath);
            //Files.delete();
            return true;

        } catch (IOException e) {
            System.out.println("Could not create Directory");
            return false;

        }

    }

}
