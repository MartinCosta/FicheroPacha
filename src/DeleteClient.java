import interfaces.ISaver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteClient {


    private JPanel Jpanel1;
    private JTextField textField1;
    private JButton Cancel;
    private JButton Accept;
    private ISaver mSaverListener;
    private JFrame frame2;


    public DeleteClient (ISaver saver){

        mSaverListener = saver;
        frame2 = new JFrame("Borrar Cliente");
        frame2.getContentPane().add(Jpanel1);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setVisible(true);


        Accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saver.delete();
                frame2.dispose();
            }
        });
        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
            }
        });
    }


}
