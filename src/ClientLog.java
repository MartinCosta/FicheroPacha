import com.sun.javafx.UnmodifiableArrayList;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class ClientLog implements Serializable {


    private String nameClient;
    private String clientData;


    public ClientLog (String name, String data ){

        this.clientData = data;
        this.nameClient = name;
    }

    public String getClientData() {
        return clientData;
    }

    public String getNameClient() {
        return nameClient;
    }

   /*
    public void addRegister (String date, String color){
        JTextArea newRegister = new JTextArea();

        newRegister.setText(getName() + "\n");
        newRegister.setText(date + "\n");
        newRegister.setText(color + "\n");
    }
*/

}
