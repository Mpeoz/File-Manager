package pm.filemanager.operations;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import pm.filemanager.swing.MainWindow;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
public class OpenWebPageOperation {
    
    public  void openWebpage(String urlString) throws MalformedURLException, URISyntaxException {
        
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (URISyntaxException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
