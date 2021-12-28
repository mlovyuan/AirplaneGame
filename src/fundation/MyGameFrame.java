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
    private Airplane _airplane = new Airplane(_airplaneImg, 200, 200, 7);
    private Cannonball[] _cannonballs = new Cannonball[50];
    private Explode _explode;

    @Override
    public void paint(Graphics g) {
        g.drawImage(_backgroundImg, 0, 0, _frame_width, _frame_height, null);
        _airplane.drawMyself(g);

        for (int i = 0; i < _cannonballs.length; i++) {
            if (_cannonballs[i] == null)
                initFrame();
            _cannonballs[i].drawMyself(g);
            boolean isBoom = _cannonballs[i].getRectangle().intersects(_airplane.getRectangle());
            if (isBoom) {
                _airplane._isAlive = false;
                if (_explode == null)
                    _explode = new Explode(_airplane._xAxis, _airplane._yAxis);
                _explode.draw(g);
            }
        }

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

    class KeyboardMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            _airplane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            _airplane.minusDirection(e);
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
        addKeyListener(new KeyboardMonitor());

        for (int i = 0; i < _cannonballs.length; i++)
            _cannonballs[i] = new Cannonball();
    }

    public static void main(String[] args) {
        MyGameFrame frame = new MyGameFrame();
        frame.initFrame();
    }
}
