import javax.swing.*;

public class ClientLog {


    private String name;
    private String date;
    private String color;


    public ClientLog (String name, String date, String color){

        this.name = name;
        this.date = date;
        this.color = color;
    }
    public ClientLog (String name){
        this.name = name;
    }


    public String getColor() {
        return color;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return (getName() + "\n" +
                getDate() + "\n" +
                getColor());
    }

    public void addRegister (String date, String color){
        JTextArea newRegister = new JTextArea();

        newRegister.setText(getName() + "\n");
        newRegister.setText(date + "\n");
        newRegister.setText(color + "\n");
    }


}
