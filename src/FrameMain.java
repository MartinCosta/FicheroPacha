import interfaces.ISaver;

import javax.naming.Context;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class FrameMain implements ISaver{

    private static ISaver mSaver;
    private JFrame frame;
    private JPanel jPanelMain;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JComboBox comboBox1;
    private JButton addClient;
    private JButton saveButton;
    private JPanel jPanel2a;
    private JTextArea dataText;
    private AddClient newClient;
    private ArrayList<ClientLog> dataListAllUser;
    private JTextField clientNameJText;
    private JButton deleteButton;
    private JButton editButton;
    private int clientNumberComboBox;
    private String clientNameComboBox;


    public FrameMain(){
        mSaver = this;
        try{

            FileInputStream fis = new FileInputStream("DataBase.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            dataListAllUser = (ArrayList<ClientLog>)ois.readObject();
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

        addClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                newClient = new AddClient(mSaver);
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clientNumberComboBox = comboBox1.getSelectedIndex();
                clientNameComboBox = comboBox1.getItemAt(clientNumberComboBox).toString();
                clientNameJText.setText(clientNameComboBox);
                dataText.setText(dataListAllUser.get(clientNumberComboBox).getClientData());
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              dataListAllUser.get(clientNumberComboBox).setClientData(dataText.getText());

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
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteClient deleteClient = new DeleteClient (mSaver);
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditClient editClient = new EditClient(mSaver);
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

    @Override
    public void save(String name, String data) {
        dataListAllUser.add(new ClientLog(name, data));
        comboBox1.addItem(name);
    }

    @Override
    public void delete() {
        dataListAllUser.remove(clientNumberComboBox);
        comboBox1.removeItemAt(clientNumberComboBox);
    }

    @Override
    public String getName(){
        return clientNameComboBox;
    }

    @Override
    public void setName (String name){
        dataListAllUser.get(clientNumberComboBox).setNameClient(name);
       comboBox1.removeItemAt(clientNumberComboBox);
       comboBox1.insertItemAt(name,clientNumberComboBox);
    }

}

