import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverView extends JPanel {
    private JLabel gameOverLabel;

    public GameOverView() {
        gameOverLabel = new JLabel("Game Over");
        add(gameOverLabel);
    }
}