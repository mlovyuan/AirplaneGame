package fundation;

import java.awt.*;

public class Cannonball extends GameObject {

    private double _degree;

    public Cannonball() {
        _degree = Math.random() * Math.PI * 2;
        _xAxis = 100;
        _yAxis = 100;
        _width = 10;
        _height = 10;
        _speed = 6;
    }

    @Override
    public void drawMyself(Graphics graphics) {
        Color originalColor = graphics.getColor();
        graphics.setColor(Color.yellow);
        graphics.fillOval(_xAxis, _yAxis, _width, _height);
        flyDirectionWithDegree(_degree);
        reboundDealing();
        graphics.setColor(originalColor);
    }

    private void reboundDealing() {
        if (_yAxis > GameUtil._frame_height - _height || _yAxis < 30)
            _degree = -_degree;

        if (_xAxis > GameUtil._frame_width - _width || _xAxis < 0)
            _degree = Math.PI - _degree;
    }

    private void flyDirectionWithDegree(double degree) {
        _xAxis += _speed * Math.cos(degree);
        _yAxis += _speed * Math.sin(degree);
    }
}
