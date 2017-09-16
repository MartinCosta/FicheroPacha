import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame {

    private ArrayList<String>clientList;
    private JButton addClient;
    private  JPanel panel1;
    private JComboBox comboBox1;
    private JButton button1;
    private JFrame frame;
    private AddClient newClient;

    public MainFrame (){

        clientList = new ArrayList<>();


        addClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                newClient = new AddClient();

            }
        });


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientList =  newClient.getClientList();

               for(int i = 0; i < clientList.size(); i++){

                   comboBox1.addItem(clientList.get(i));
               }
            }
        });
    }

    public void newFrame (){

        frame = new JFrame("test");
        frame.getContentPane().add(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


}
