package fundation;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static fundation.GameUtil.*;

public class MyGameFrame extends Frame {
    Image _background;
    Image _airplane;

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

        _background = getImage("images/starry.jpg");
        _airplane = getImage("images/aircraft.png");

        // start paint thread
        new PaintThread().start();
    }

    int x= 200, y = 200;
    @Override
    public void paint(Graphics g) {
        g.drawImage(_background, 0, 0, _frame_width, _frame_height, null);
        g.drawImage(_airplane, x, y, 30, 30, null);
        x--;
        y--;
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

    private Image offScreenImage = null;

    // resolve game window flicker
    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = createImage(_frame_width, _frame_height);
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public static void main(String[] args) {
        MyGameFrame frame = new MyGameFrame();
        frame.initFrame();
    }
}
