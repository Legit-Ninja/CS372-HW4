import com.sun.javaws.util.JfxHelper;

import javax.print.attribute.HashAttributeSet;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class spiderTest extends JFrame{
    private JPanel panel1;
    private URL _url;
    private JLabel urlLabel;
    private JTextField url = new JTextField();
    private ArrayList<spider> spiders = new ArrayList<>();
    public int i = 100;
    spiderTest()
    {
        try {
            System.out.println("where do you want to start your spider? (whitworth.edu/cms is a good one)");
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();
            _url = new URL(s);
            spider spider = new spider(url, s);
            spiders.add(spider);
            this.find();
            this.add(panel1);

        } catch (Exception ex) { ex.printStackTrace(); }
    }
    public void find() {
        if (_url == null)
            return;
        try {
            //search.setText(String.format("looking at: " + _url.toString()));
            BufferedReader br = new BufferedReader(new InputStreamReader((_url.openStream())));
            String line = br.readLine();
            while (line != null && i > 0) {
                Pattern linkPattern = Pattern.compile("<a\\s*?href=\"(http:.*?)\"", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
                Matcher linkMatcher = linkPattern.matcher(line);
                Pattern emailPattern = Pattern.compile("\"mailto:(.*?)\"", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
                Matcher emailMatcher = emailPattern.matcher(line);
                if (linkMatcher.find())                                                 //https://stackoverflow.com/questions/5120171/extract-links-from-a-web-page
                {
                    i--;
                    JTextField tf = new JTextField(linkMatcher.group(1));
                    spiders.add(new spider(tf, linkMatcher.group(1)));
                    panel1.add(tf);
                    i--;
                    _url = new URL(linkMatcher.group(1));
                    find();
                    //https://stackoverflow.com/questions/5120171/extract-links-from-a-web-page
                }
                if (emailMatcher.find())
                {
                    JTextField email = new JTextField(emailMatcher.group(1));
                    panel1.add(email);
                }
                line = br.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        spiderTest spider= new spiderTest();
        spider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spider.setSize(720,720);
        spider.setVisible(true);
    }
}
