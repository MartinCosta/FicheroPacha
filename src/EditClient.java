import interfaces.ISaver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditClient {


    private ISaver mSaverListener;
    private JPanel panel12;
    private JTextField nameField;
    private JButton cancelButton;
    private JButton saveButon;
    private JFrame frame2;

    public EditClient (ISaver saver){

        mSaverListener = saver;

        frame2 = new JFrame("Editar Cliente");
        frame2.getContentPane().add(panel12);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setVisible(true);

        nameField.setText(saver.getName());


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
            }
        });
        saveButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                saver.setName(nameField.getText());
                frame2.dispose();


            }
        });
    }


}
