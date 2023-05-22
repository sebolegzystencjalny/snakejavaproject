import javax.swing.*;
import java.awt.*;

public interface Renderable {
    static final int PIXEL_SIZE = 10;
    
    void render(Graphics g);
}