/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.filemanager.controllers;

import pm.filemanager.operations.CreateFolderMenuItemOperatation;

/**
 *
 * @author alex
 */
public class createFolderMenuItemController {
    
     public void createFolderMenuItem(String path){
         CreateFolderMenuItemOperatation newCreateFolderMenuItem = new CreateFolderMenuItemOperatation();
         newCreateFolderMenuItem.createFolderMenuItem(path);
     }
    
}
