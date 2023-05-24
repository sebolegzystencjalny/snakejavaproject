//import static GameBoard.BOARD_HEIGHT;
//import static GameBoard.BOARD_WIDTH;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.JFrame;

public class SnakeGame extends JFrame {
//    gameBoard gameBoard
    public SnakeGame() {
        this.add(new GameBoard());
        this.setTitle("Snake Game");
//        this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
//        this.setBackground(Color.DARK_GRAY);
//        this.setFocusable(true);
//        this.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (inGame) {
//                    gameState.addInput(e.getKeyCode());
//                } else {
//                    initiateGame();
//                }
//            }
//        });
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
