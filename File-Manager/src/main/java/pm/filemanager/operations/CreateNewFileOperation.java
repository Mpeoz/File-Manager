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
public class CreateNewFileOperation {

    /**
     * public boolean function createNewFile
     *
     * @param path String
     * @param countFileExist integer
     * @return true if file is created and false if is not
     */
    public boolean createNewFile(String path, int countFileExist) {
        
        Path xPath = Paths.get(path + "testfile" + countFileExist + ".txt");
        //boolean checkIfExistDir = false;
        boolean checkIfExistDir = Files.exists(xPath);
        //check if exist 
        if (checkIfExistDir) {
            countFileExist = countFileExist + 1;
            boolean resultIfExistName = createNewFile(path, countFileExist);
            return resultIfExistName;
        }
        try {
            File myFile = new File(path + "testfile" + countFileExist + ".txt");
            return myFile.createNewFile();
        } catch (IOException ioe) {
            
        }
        return false;
    }

}
