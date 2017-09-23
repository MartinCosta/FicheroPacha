import com.sun.deploy.util.SessionState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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
    private JTextArea textArea1;
    private JButton saveLogButton;
    private JTextField textField1;
    private AddClient newClient;
    private ArrayList<ClientLog> dataListAllUser;
    private int clientNumber;
    private String clientName;
    private ArrayList<String> clientList;
    private String dataClient;
    private ArrayList<String> dataPerUser;
    private int clientNumberComboBox;
    private String clientNameComboBox;



    public FrameMain  (){



        try{

            FileInputStream fis = new FileInputStream("DataBase.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);

            dataListAllUser = (ArrayList<ClientLog>)ois.readObject();
            ClientNameComparator comparator = new ClientNameComparator();
            Collections.sort(dataListAllUser, comparator);

            ois.close();
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
            dataListAllUser = new ArrayList<>();
        }
        catch (IOException e) {
            e.printStackTrace();
            dataListAllUser = new ArrayList<>();
        }


        for(int i = 0; i < dataListAllUser.size(); i++){

            comboBox1.addItem(dataListAllUser.get(i).toString());
        }


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

                clientName = newClient.getName();
                dataClient = newClient.getData();
                ClientNameComparator comparator = new ClientNameComparator();
                Collections.sort(dataListAllUser, comparator);

                String clientNames[] = new String[dataListAllUser.size()];
                int index = 0;
                for (ClientLog client : dataListAllUser) {
                    clientNames[index++] = client.getNameClient();
                }
                int newIndex = Arrays.binarySearch(clientNames, clientName);

                if (newIndex >= 0) {
                    dataListAllUser.add(newIndex,(new ClientLog(clientName, dataClient)));


                } else if ( -( newIndex + 1) == dataListAllUser.size()) { // client not found, let's add it at the new index
                    dataListAllUser.add((new ClientLog(clientName, dataClient)));
                } else {
                    int realNewIndex = -( newIndex + 1); // because the binary-seacrch return
                    dataListAllUser.add(realNewIndex,(new ClientLog(clientName, dataClient)));
                }
                comboBox1.updateUI();


            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                clientNumberComboBox = comboBox1.getSelectedIndex();
                clientNameComboBox = comboBox1.getItemAt(clientNumberComboBox).toString();
                pepaLuisaTextField.setText(clientNameComboBox);

         //       textField1.setText(dataListAllUser.get(clientNumberComboBox).getClientData());

            }
        });


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            try {
                    FileOutputStream fos = new FileOutputStream("DataBase.tmp");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(dataListAllUser);
                     oos.close();
                    }
            catch(IOException ie) {
                    ie.printStackTrace();
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

