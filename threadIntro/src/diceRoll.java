import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class diceRoll extends JFrame {
    private JPanel panel1;
    private JButton rollButton;

    diceRoll() {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        this.add(panel1);

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dice[] die = new Dice[5];
                for (int i = 0; i < die.length; i++) {
                    JLabel l = new JLabel();
                    die[i] = new Dice(l);
                    panel1.add(l);

                }

                for (int i = 0; i < die.length; i++) {
                    Thread t = new Thread(die[i]);
                    t.start();
                    try {
                        Thread.sleep(200);
                    } catch (Exception ex) {
                    }
                }
            }
        });

    }
    public static void main(String[] args) {
        diceRoll roll = new diceRoll();
        roll.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        roll.setVisible(true);
    }
}