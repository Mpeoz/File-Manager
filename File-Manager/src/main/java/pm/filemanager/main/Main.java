package pm.filemanager.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;
import pm.filemanager.swing.MainWindow;
/**
 * Hello world!
 *
 */
public class Main 
{
   
    
    public static void main( String[] args )
    {
           MainWindow theView = new MainWindow();
       try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
           
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             SwingUtilities.updateComponentTreeUI(theView);
             MainWindow.setDefaultLookAndFeelDecorated(true);
           
           
        } catch(ClassNotFoundException e) {
           try {
               throw e;
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
           }
        } catch (InstantiationException e) {
            try {
                throw e;
            } catch (InstantiationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IllegalAccessException e) {
            try {
                throw e;
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnsupportedLookAndFeelException e) {
            try {
                throw e;
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        theView.setResizable(true);
        theView.setVisible(true);
    }
}
