package pm.filemanager.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import pm.filemanager.swing.MainWindow;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
       try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
           try {
               throw e;
           } catch (Exception ex) {
               Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        MainWindow theView = new MainWindow();

        MainWindow.setDefaultLookAndFeelDecorated(true);
        theView.setVisible(true);
    }
}
