

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ScreenCaptureRectangle {
    Rectangle captureRect;
    public static JFrame jFrame;

    void ScreenCaptureRectangle(BufferedImage screen,Dimension screenSize) throws AWTException, IOException {
         BufferedImage screenCopy = new BufferedImage(
                screen.getWidth(),
                screen.getHeight(),
                screen.getType());
         JLabel screenLabel = new JLabel(new ImageIcon(screenCopy));
        JScrollPane screenScroll = new JScrollPane(screenLabel);
        screenLabel.setSize((int)screenSize.getWidth(), (int) screenSize.getHeight());

        screenScroll.setPreferredSize(new Dimension(
                (int)(screen.getWidth()/3),
                (int)(screen.getHeight()/3)));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(screenScroll, BorderLayout.CENTER);



        repaint(screen, screenCopy);
        screenLabel.repaint();

        screenLabel.addMouseMotionListener(new MouseMotionAdapter() {

            Point start = new Point();

            @Override
            public void mouseMoved(MouseEvent me) {
                start = me.getPoint();
                repaint(screen, screenCopy);
                screenLabel.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent me) {
                Point end = me.getPoint();
                captureRect = new Rectangle(start,
                        new Dimension(end.x-start.x, end.y-start.y));
                repaint(screen, screenCopy);
                screenLabel.repaint();
            }
        });
        screenLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                try {
                    takeScreen();
                } catch (AWTException ex) {
                    Logger.getLogger(ScreenCaptureRectangle.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ScreenCaptureRectangle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });





        jFrame.add(panel);
        jFrame.setUndecorated(true);
        jFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        jFrame.setSize((int)screenSize.getWidth(), (int) screenSize.getHeight());
        jFrame.setVisible(true);
    }

    public void takeScreen() throws AWTException, IOException{
        Robot robot = new Robot();
        BufferedImage screen1 = robot.createScreenCapture(new Rectangle(captureRect));
        ImageIO.write(screen1, "jpg", new File("test.jpg"));
        System.out.println("Screenshot saved");
        jFrame.dispose();
    }

    public void repaint(BufferedImage orig, BufferedImage copy) {
        Graphics2D g = copy.createGraphics();
        g.drawImage(orig,0,0, null);
        if (captureRect!=null) {
            g.setColor(Color.RED);
            g.draw(captureRect);
        }
        g.dispose();
    }



    public String getScreenCapture() throws AWTException, IOException{
        jFrame = new JFrame();
        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        BufferedImage screen = robot.createScreenCapture(new Rectangle(screenSize));
        ScreenCaptureRectangle(screen, screenSize);
        return "test.jpg";
    }
}

