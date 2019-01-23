import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class spider {
    private JTextField search;
    private URL _url;
    private ArrayList<String> urls = new ArrayList<>();
    private ArrayList<JTextField> urlTexts = new ArrayList<>();
    public static int i = 50;
    spider(JTextField url_, String url)
    {
        search = url_;
        try {
            _url = new URL(url);

        } catch(Exception ex) {ex.printStackTrace(); }

    }




}
