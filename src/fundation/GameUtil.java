package fundation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GameUtil {

    // avoid create instance when use
    private GameUtil() {
    }

    public static final int _frame_width = 500;
    public static final int _frame_height = 500;

    public static Image getImage(String path) {
        URL url = GameUtil.class.getClassLoader().getResource(path);
        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
