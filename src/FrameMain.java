import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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

        dataListAllUser = new ArrayList<>();

        try{

            FileInputStream fis = new FileInputStream("data.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            clientList = (ArrayList<String>)ois.readObject();
            ois.close();
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
            clientList = new ArrayList<>();
        }
        for(int i = 0; i < clientList.size(); i++){

            comboBox1.addItem(clientList.get(i));
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

                clientList.add(clientName);
                comboBox1.addItem(clientName);

            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dataListAllUser.add(new ClientLog(dataClient));
                clientNumberComboBox = comboBox1.getSelectedIndex();
                clientNameComboBox = comboBox1.getItemAt(clientNumberComboBox).toString();
                pepaLuisaTextField.setText(clientNameComboBox);

                textField1.setText(dataListAllUser.get(clientNumberComboBox).getClientData().toString());

            }
        });
        saveLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            try {
                    FileOutputStream fos = new FileOutputStream("data.tmp");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(clientList);
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

