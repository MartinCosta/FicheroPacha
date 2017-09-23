import interfaces.ISaver;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddClient {


    private ISaver mSaverListener;
    private JPanel panel12;
    private JFrame frame;
    private JTextField clientName;
    private JButton ADDButton;
    private JLabel Nombre;
    private JTextField dateAndData;
    private String name;
    private String data;


    public AddClient (ISaver saver) {

        mSaverListener = saver;
        frame = new JFrame("AddClient");
        frame.getContentPane().add(panel12);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


            ADDButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                   if ( !clientName.getText().isEmpty()){
                       name = clientName.getText();
                       data = dateAndData.getText();
                       mSaverListener.save(name, data);
                       frame.dispose();
                   }
                }
            });
        }
}
