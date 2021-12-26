package fundation;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Airplane extends GameObject {

    private boolean _left, _right, _up, _down;
    boolean _isAlive;

    public Airplane(Image img, int xAxis, int yAxis, int speed) {
        super(img, xAxis, yAxis, speed, 30, 30);
        _isAlive = true;
    }

    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                _left = true;
                break;
            case KeyEvent.VK_RIGHT:
                _right = true;
                break;
            case KeyEvent.VK_UP:
                _up = true;
                break;
            case KeyEvent.VK_DOWN:
                _down = true;
                break;
        }
    }

    public void minusDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                _left = false;
                break;
            case KeyEvent.VK_RIGHT:
                _right = false;
                break;
            case KeyEvent.VK_UP:
                _up = false;
                break;
            case KeyEvent.VK_DOWN:
                _down = false;
                break;
        }
    }

    @Override
    public void drawMyself(Graphics graphics) {
        if (!_isAlive)
            return;

        super.drawMyself(graphics);

        if (_left)
            _xAxis -= _speed;
        else if (_right)
            _xAxis += _speed;
        else if (_up)
            _yAxis -= _speed;
        else if (_down)
            _yAxis += _speed;
    }
}
