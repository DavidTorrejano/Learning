package older.topics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Interfaz_intro_clases_internas {

    public static void main(String[] args) {

        Reloj myWatch = new Reloj();
        myWatch.letsGo(3, true);
        JOptionPane.showMessageDialog(null, "Press ok to finish");


    }
}

class Reloj {

    public void letsGo(int intervalo, final boolean sound) {

        class GiveMeTheTime implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("This is the time after " + (intervalo) + " seconds " + now);
                if (sound) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        ActionListener listener = new GiveMeTheTime();
        int intervalForTimer = intervalo*1000;
        Timer myTemporizer = new Timer(intervalForTimer, listener);
        myTemporizer.start();
    }

}
