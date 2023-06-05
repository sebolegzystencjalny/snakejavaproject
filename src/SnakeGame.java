//import static GameBoard.BOARD_HEIGHT;
//import static GameBoard.BOARD_WIDTH;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JFrame implements ActionListener {

    private int snakes = 1;
    private int food = 1;
    private int frogs = 1;
    private JPanel RestartView;
    private JPanel gameView;
    private JPanel menuView;
    private JPanel mainView;

    public SnakeGame() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.DARK_GRAY);
        setResizable(false);
        setLocationRelativeTo(null);
        gameView = new GameView();
        menuView = new MenuView();
        mainView = new JPanel();
//        mainView = menuView;

//        setContentPane(new MenuView().menupanel);
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
    public void setValues(int _snakes,int _food,int _frogs){
        snakes = _snakes;
        food = _food;
        frogs = _frogs;
    }
    
    public void returnToMenu(){
        mainView.remove(gameView);
        gameView.setFocusable(false);
        menuView.setFocusable(true);
        ((GameView) gameView).initialize();
        mainView.add(menuView);
        pack();
        mainView.repaint();
    }
    
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
//        if (isRunning) {
//            move();
//            observe();
//            collisionTest();

//            repaint();
    }
}

////        this.setFocusable(true);
////        this.set
////        gameBoard = new GameBoard();
////        gameView = new GameView();
//        mainPanel = new JPanel();
////        this.add(mainPanel);
//        add(new JButton("HEJ"),"hej");
//        JPanel menuView = new MenuView();
//        mainPanel = new JPanel();
//
////        mainPanel.add(menuView, "menuView");
//
//
//        this.setTitle("Snake Game");
//        this.setPreferredSize(new Dimension(1000, 600));
//        this.setFocusable(true);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setResizable(false);
//        this.setVisible(true);
//        this.setLocationRelativeTo(null);
//        this.setBackground(Color.DARK_GRAY);
//
////        this.addKeyListener(new KeyAdapter() {
////            @Override
////            public void keyPressed(KeyEvent e) {
//////                if (inGame) {
//////                    //gameState.addInput(e.getKeyCode()); //interfejs ekranu  gry, co dostaje i co zwraca?
//////                } else {
//////                    //initiateGame();
//////                }
////            }
////        });
//        this.pack();
//        this.setBackground(Color.DARK_GRAY);





