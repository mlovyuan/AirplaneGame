package fundation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GameUtil {

    // avoid create instance when use
    private GameUtil() {
    }

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
