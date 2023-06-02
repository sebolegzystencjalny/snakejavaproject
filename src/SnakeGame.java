//import static GameBoard.BOARD_HEIGHT;
//import static GameBoard.BOARD_WIDTH;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.JFrame;

public class SnakeGame extends JFrame {
//    gameBoard gameBoard
    private JPanel menuView;
    private JPanel GameView;
    private JPanel CreateView;
    private JPanel mainPanel;
    public SnakeGame() {
        this.setBackground(Color.DARK_GRAY);
        this.setFocusable(true);
//        this.set
       
        mainPanel = new JPanel();
        this.add(mainPanel);
        menuView = new MenuView();
        mainPanel.add(new GameBoard());
//        mainPanel.add(menuView, "menuView");
        this.setTitle("Snake Game");//cos do aktalnego i ciagle nasluchwiac>?
        this.setPreferredSize(new Dimension(900, 600));
        this.setBackground(Color.DARK_GRAY);
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
//                if (inGame) {
//                    //gameState.addInput(e.getKeyCode());
//                } else {
//                    //initiateGame();
//                }
            }
        });
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
