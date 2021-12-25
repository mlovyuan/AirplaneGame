package fundation;

import java.awt.*;

public class GameObject {
    Image _img;
    int _xAxis, _yAxis;
    int _speed;
    int _width, _height;

    public GameObject() {
    }

    public GameObject(Image img) {
        this._img = img;
        if (img != null) {
            _width = img.getWidth(null);
            _height = img.getHeight(null);
        }
    }

    public GameObject(Image img, int xAxis, int yAxis) {
        this(img);
        this._xAxis = xAxis;
        this._yAxis = yAxis;
    }

    public GameObject(Image img, int xAxis, int yAxis, int speed) {
        this(img, xAxis, yAxis);
        this._speed = speed;
    }

    public GameObject(Image img, int _xAxis, int yAxis, int speed, int width, int height) {
        this._img = img;
        this._xAxis = _xAxis;
        this._yAxis = yAxis;
        this._speed = speed;
        this._width = width;
        this._height = height;
    }

    public void drawMyself(Graphics graphics) {
        graphics.drawImage(_img, _xAxis, _yAxis, _width, _height, null);
    }

    public Rectangle getRectangle(){
        return new Rectangle(_xAxis, _yAxis, _width, _height);
    }
}
