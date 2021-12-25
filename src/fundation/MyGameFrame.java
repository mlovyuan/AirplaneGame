package fundation;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static fundation.GameUtil.*;

public class MyGameFrame extends Frame {
    private Image _backgroundImg = getImage("images/starry.jpg");
    private Image _airplaneImg = getImage("images/aircraft.png");
    private Airplane airplane = new Airplane(_airplaneImg, 200, 200, 3);

    @Override
    public void paint(Graphics g) {
        g.drawImage(_backgroundImg, 0, 0, _frame_width, _frame_height, null);
        airplane.drawMyself(g);
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

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // start paint thread
        new PaintThread().start();
    }

    public static void main(String[] args) {
        MyGameFrame frame = new MyGameFrame();
        frame.initFrame();
    }
}
