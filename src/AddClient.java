import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddClient {


    private JPanel panel12;
    private JFrame frame2;
    private JTextField textField1;
    private JButton ADDButton;
    private String name;
    private ArrayList<String> clientList;
    private FrameMain main;
    private JComboBox comboBox;

    public AddClient () {

        frame2 = new JFrame("AddClient");
        frame2.getContentPane().add(panel12);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setVisible(true);
        clientList = new ArrayList<>();



            ADDButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                   if ( textField1.getText().isEmpty()){

                   }
                   else {
                       name = textField1.getText();
                       frame2.dispose();
                       addClient(name);
                   }
                }
            });


        }


    public ArrayList<String> getClientList() {
        return clientList;
    }

    public void addClient(String name) {

        clientList.add(name);
    }

}
