package pm.filemanager.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author PTsilopoulos
 */
public class BackButtonActionListener extends JFrame implements ActionListener {

    JButton button;
    JTextField field;

    public BackButtonActionListener () {
        
//        this.setLayout(null);

        button = new JButton("Back");
        field = new JTextField();

//        field.setBounds(30, 50, 200, 25);
//        button.setBounds(240, 50, 100, 25);
        this.add(field);
        this.add(button);

        button.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        //field.setText(frame.fileName);
    }
}
