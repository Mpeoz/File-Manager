/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import pm.filemanager.operations.OpenWebPageOperation;

/**
 *
 * @author alex
 */
public class OpenWebPageController {
    public  void openWebpage(String urlString) throws MalformedURLException, URISyntaxException {
        OpenWebPageOperation openWebPage = new OpenWebPageOperation();
        openWebPage.openWebpage(urlString);
        
    }
}
