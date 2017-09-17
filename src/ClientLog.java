import com.sun.javafx.UnmodifiableArrayList;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class ClientLog implements Serializable {



    private ArrayList<String> clientData;


    public ClientLog (String data ){

        this.clientData = new ArrayList<>();
        clientData.add(data);
    }


    public ArrayList<String> getClientData() {
        return clientData;
    }

    @Override
    public String toString() {
        return (getClientData().toString());
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
