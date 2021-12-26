package fundation;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static fundation.GameUtil.*;

public class MyGameFrame extends Frame {
    private Image _backgroundImg = getImage("images/starry.jpg");
    private Image _airplaneImg = getImage("images/aircraft.png");
    private Airplane airplane = new Airplane(_airplaneImg, 200, 200, 7);

    @Override
    public void paint(Graphics g) {
        g.drawImage(_backgroundImg, 0, 0, _frame_width, _frame_height, null);
        airplane.drawMyself(g);
        new Cannonball().drawMyself(g);
    }

    class PaintThread extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class KeyboardMoniter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            airplane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            airplane.minusDirection(e);
        }
    }


    // resolve game window flicker
    public void update(Graphics g) {
        Image offScreenImage = null;
        if (offScreenImage == null)
            offScreenImage = createImage(_frame_width, _frame_height);
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public void initFrame() {
        setTitle("Airplane Game");
        setVisible(true);
        setSize(_frame_width, _frame_height);
        setLocation(300, 300);

        // listen to close window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // start paint thread
        new PaintThread().start();

        // listen to keyboard's action
        addKeyListener(new KeyboardMoniter());
    }

    public static void main(String[] args) {
        MyGameFrame frame = new MyGameFrame();
        frame.initFrame();
    }
}
