import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddClient {


    private JPanel panel12;
    private JFrame frame2;
    private JTextField clientName;
    private JButton ADDButton;
    private JLabel Nombre;
    private JTextField dateAndData;
    private String name;
    private String data;


    public AddClient () {

        frame2 = new JFrame("AddClient");
        frame2.getContentPane().add(panel12);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setVisible(true);


            ADDButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                   if ( clientName.getText().isEmpty()){

                   }
                   else {
                       name = clientName.getText();
                       frame2.dispose();
                       data = dateAndData.getText();

                   }
                }
            });
        }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}
