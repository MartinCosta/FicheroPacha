import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    ArrayList<String>clientList;
    String text;
    String [] text1;
    String name;
    String color;
    String date;




  //      AddClient client = new AddClient();

  //      clientList = client.getClientList();

  //      comboBox1.addItem(clientList.toArray());




/*
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                text = addClient.getText();

                text1 = text.split("\n");

                name = text1[0];
                date = text1[1];
                color = text1[2];
                clientListA(name, date, color);


            }
        });
    */



    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.newFrame();
    }







}