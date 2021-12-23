package fundation;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame extends Frame {
    Image _background;
    Image _airplane;

    public void initFrame() {
        setTitle("Airplane Game");
        setVisible(true);
        setSize(500, 500);
        setLocation(300, 300);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        _background = GameUtil.getImage("images/starry.jpg");
        _airplane = GameUtil.getImage("images/aircraft.png");

        // start paint thread
        new PaintThread().start();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(_background,0,0,500,500,null);
        g.drawImage(_airplane,200,200,30,30,null);
    }

    class PaintThread extends Thread{
        @Override
        public void run() {
            while (true){
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        MyGameFrame frame = new MyGameFrame();
        frame.initFrame();
    }
}
