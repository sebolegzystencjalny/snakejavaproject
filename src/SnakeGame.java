import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Klasa SnakeGame reprezentuje główne okno gry Snake.
 */
public class SnakeGame extends JFrame implements ActionListener {

    private int snakes = 1;
    private int food = 1;
    private int frogs = 1;
    private JPanel RestartView;
    private JPanel gameView;
    private JPanel menuView;
    private JPanel mainView;
    
    /**
     * Konstruktor klasy SnakeGame.
     * Tworzy główne okno gry.
     */
    public SnakeGame() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.DARK_GRAY);
        setResizable(false);
        setLocationRelativeTo(null);
        gameView = new GameView();
        menuView = new MenuView();
        mainView = new JPanel();
        setLayout(new BorderLayout());
        

        add(mainView, BorderLayout.CENTER);
        mainView.add(menuView);
        setPreferredSize(new Dimension(980, 550));
        setFocusable(true);
        
        setVisible(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                ((GameView) gameView).addInput(e.getKeyCode());
            }
        });
        pack();
    }
    /**
     * Metoda setValues ustawia ilość węży, jedzenia i żab.
     * @param _snakes liczba węży
     * @param _food   liczba jedzenia
     * @param _frogs  liczba żab
     */
    public void setValues(int _snakes,int _food,int _frogs){
        snakes = _snakes;
        food = _food;
        frogs = _frogs;
    }
    /**
     * Metoda returnToMenu powraca do widoku menu głównego.
     * Resetuje grę i wyświetla menu.
     */
    public void returnToMenu(){
        mainView.remove(gameView);
        gameView.setFocusable(false);
        menuView.setFocusable(true);
        ((MenuView)menuView).setScoreLabel();
        ((GameView) gameView).initialize();
        mainView.add(menuView);
        pack();
        mainView.repaint();
    }
    
    /**
     * Metoda InitializeGame inicjalizuje rozpoczęcie gry.
     * Przełącza widok na ekran gry.
     */
    public void InitializeGame(){
        mainView.remove(menuView);
        menuView.setFocusable(false);
        gameView.setFocusable(true);
        ((GameView) gameView).initialize(snakes,food,frogs);
        mainView.add(gameView);
        pack();
        mainView.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    }
}





