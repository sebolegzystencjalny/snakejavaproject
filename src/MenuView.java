import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuView extends JPanel {
    private JButton startButton;

    public MenuView() {
        startButton = new JButton("Start");
        add(startButton);
    }
}

