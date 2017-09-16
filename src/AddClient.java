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
    private MainFrame main;
    private JComboBox comboBox;

    public AddClient () {

        frame2 = new JFrame("AddClient");
        frame2.getContentPane().add(panel12);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setVisible(true);
        clientList = new ArrayList<>();


        if (textField1.getText().equals("")) {
            ADDButton.setEnabled(false);
        }
            ADDButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    name = textField1.getText();

                    frame2.dispose();
                    addClient(name);


                    //  for (int i = 0; i < clientList.size(); i++){
                    //   comboBox.addItem(clientList.get(i).toString());
                    // }
                }
            });


        }


    public ArrayList<String> getClientList() {
        return clientList;
    }

    public void addClient(String name) {

        clientList.add(name);
    }

    public JComboBox getComboBox() {
        return comboBox;
    }
}
