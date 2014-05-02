/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import java.io.File;
import pm.filemanager.operations.GetContentTypeOperation;

/**
 *
 * @author alex
 */
public class GetContetTypeController {
    
    public String getContentType(File fileName) {
        GetContentTypeOperation newGetContentTypeOperation= new GetContentTypeOperation();
       return newGetContentTypeOperation.getContentType(fileName);
    }
    
    
}
