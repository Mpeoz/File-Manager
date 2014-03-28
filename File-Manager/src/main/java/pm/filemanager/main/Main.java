package pm.filemanager.main;

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
            e.printStackTrace();
        }
        MainWindow theView = new MainWindow();

        MainWindow.setDefaultLookAndFeelDecorated(true);
        theView.setVisible(true);
    }
}
