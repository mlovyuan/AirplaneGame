package fundation;

import java.awt.*;

public class Explode {
    public Explode(double xAxis, double yAxis) {
        this._xAxis = xAxis;
        this._yAxis = yAxis;
    }

    double _xAxis, _yAxis;
    static Image[] _images = new Image[3];

    static {
        for (int i = 0; i < 3; i++) {
            _images[i] = GameUtil.getImage("images/explosion" + (i + 1) + ".png");
            // because Load On Demand, so call a method make it truly load
            _images[i].getHeight(null);
        }
    }

    private int _count;
    private boolean _alive = true;

    public void draw(Graphics graphics) {
        if (!_alive)
            return;

        if (_count < 3) {
            graphics.drawImage(_images[_count], (int) _xAxis, (int) _yAxis, 30, 30, null);
            _count++;
        } else
            _alive = false;
    }

}
