package fundation;

import java.awt.*;

public class Airplane extends GameObject {

    private boolean _isLeftDirection;

    public Airplane(Image img, int xAxis, int yAxis, int speed) {
        super(img, xAxis, yAxis, speed,30,30);
    }

    @Override
    public void drawMyself(Graphics graphics) {
        super.drawMyself(graphics);
        if (_isLeftDirection)
            _xAxis -= _speed;
        else
            _xAxis += _speed;

        if (_xAxis > GameUtil._frame_width - _width)
            _isLeftDirection = true;
        else if (_xAxis < 0)
            _isLeftDirection = false;
    }
}
