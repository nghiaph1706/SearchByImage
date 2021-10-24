package Main;

import GUI.mainFrame;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class main {
    public static mainFrame mF ;
    public static JFrame frame;
    public static void main(String[] args) throws IOException, ParseException {
        mF = new mainFrame();
        mF.setVisible(true);
    }
}
