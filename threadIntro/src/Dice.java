import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Random;

public class Dice implements Runnable{
    private int value;
    private JLabel label;
    private Icon[] dicesides = new Icon[6];
    Dice(JLabel _label)
    {
        label = _label;
        // value = value_;
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes dice1Label
            URL imgurl = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Dice-1-b.svg/557px-Dice-1-b.svg.png");
            Image img = toolkit.getImage(imgurl);
            img = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            dicesides[0] = icon;
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes dice2 laebel
            URL imgurl = new URL("http://dobbelsteen.virtuworld.net/img/2c.gif");
            Image img = toolkit.getImage(imgurl);
            img = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);;
            dicesides[1] = icon;
        } catch (Exception ex) {
            ex.getStackTrace();
        }

        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes dice3 laebel
            URL imgurl = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Dice-3-b.svg/1000px-Dice-3-b.svg.png");
            Image img = toolkit.getImage(imgurl);
            img = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            dicesides[2] = icon;
        } catch (Exception ex) {
            ex.getStackTrace();
        }

        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes dice4 laebel
            URL imgurl = new URL("https://previews.123rf.com/images/imagevectors/imagevectors1803/imagevectors180300001/97719819-white-dice-number-4-icon-.jpg");
            Image img = toolkit.getImage(imgurl);
            img = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            dicesides[3] = icon;
        } catch (Exception ex) {
            ex.getStackTrace();
        }

        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes dice5 laebel
            URL imgurl = new URL("https://ecdn.teacherspayteachers.com/thumbitem/Roll-and-Color-Activity-to-Identify-Dots-on-Dice-and-the-Corresponding-Number-2766397-1500873592/original-2766397-3.jpg");
            Image img = toolkit.getImage(imgurl);
            img = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            dicesides[4] = icon;
        } catch (Exception ex) {
            ex.getStackTrace();
        }

        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();      //makes dice6 laebel
            URL imgurl = new URL("https://previews.123rf.com/images/tatyanabezrukova70/tatyanabezrukova701704/tatyanabezrukova70170400028/75362696-one-cube-side-with-6-black-on-white-background.jpg");
            Image img = toolkit.getImage(imgurl);
            img = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            dicesides[5] = icon;
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    public void run()
    {
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < 10; i++)
        {
            int r = rand.nextInt(6);
            label.setIcon(dicesides[r]);
            try {
                Thread.sleep(300);
            }catch (Exception ex) { ex.printStackTrace(); }
        }

    }

}
