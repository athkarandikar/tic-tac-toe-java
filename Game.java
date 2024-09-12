// Game is the parent of windows - StartGame, DisplayMarks, Board
// Its content pane is passed to the windows.

import java.awt.Container;
import javax.swing.JFrame;

import data.Data;
import utilities.Colors;
import utilities.Utility;
import windows.StartGame;

public class Game extends JFrame {
    Data data;
    Container c;

    public Game() {
        setTitle("Tic Tac Toe");
        setSize(Utility.frameWidth, Utility.frameHeight);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        c = getContentPane();

        c.setBackground(Colors.background);

        data = new Data();
        data.startGame = new StartGame(c, data);
        Utility.updateUI(c, data.startGame);

        setVisible(true);
    }
}
