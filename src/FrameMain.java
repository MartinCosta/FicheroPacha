import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameMain {

    private JFrame frame;
    private JPanel jPanelMain;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JComboBox comboBox1;
    private JButton addClient;
    private JButton saveButton;
    private JButton saveClient;
    private JPanel jPanel2a;
    private JTextField pepaLuisaTextField;
    private ArrayList<String>clientList;
    private AddClient newClient;

    public FrameMain (){

        clientList = new ArrayList<>();

        saveClient.setEnabled(false);

        addClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                newClient = new AddClient();
                saveClient.setEnabled(true);

            }
        });


        saveClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveClient.setEnabled(false);
                clientList =  newClient.getClientList();

                for(int i = 0; i < clientList.size(); i++){

                    comboBox1.addItem(clientList.get(i));
                }
            }
        });
    }

    public void newFrame (){

        frame = new JFrame("test");
        frame.getContentPane().add(jPanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}

