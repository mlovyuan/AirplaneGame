package fundation;

import java.awt.*;

public class Cannonball extends GameObject {
    public Cannonball() {
        double degree = Math.random() * Math.PI * 2;
        _xAxis = 200;
        _yAxis = 200;
        _width = 10;
        _height = 10;
        _speed = 3;
    }

    @Override
    public void drawMyself(Graphics graphics) {
        Color originalColor = graphics.getColor();
        graphics.setColor(Color.yellow);
        graphics.fillOval(_xAxis, _yAxis, _width, _height);
        graphics.setColor(originalColor);

    }
}
