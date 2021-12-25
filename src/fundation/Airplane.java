package fundation;

import java.awt.*;

public class Airplane extends GameObject {
    public Airplane(Image img, int xAxis, int yAxis, int speed) {
        super(img, xAxis, yAxis, speed);
    }

    @Override
    public void drawMyself(Graphics graphics) {
        super.drawMyself(graphics);
        _xAxis += 3;
    }
}
