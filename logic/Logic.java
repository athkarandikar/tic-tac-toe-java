// Logic contains the logic for tic tac toe game.

package logic;

import java.util.Arrays;
import java.util.List;

import custom_ui_components.MyBoardCell;
import data.Data;

public class Logic {
    // checks for win
    // returns a List containing a boolean whether someone's won the game, and the winning cell combination
    public static List<Object> checkForWin(Data data) {
        // check for diagonal win
        if (data.boardCells[0][0].getText().equals(data.boardCells[1][1].getText())
                && data.boardCells[1][1].getText().equals(data.boardCells[2][2].getText())
                && !data.boardCells[0][0].getText().equals("")) {
            // return true;
            return Arrays.asList(true,
                    new MyBoardCell[] { data.boardCells[0][0], data.boardCells[1][1], data.boardCells[2][2] });
        }
        if (data.boardCells[0][2].getText().equals(data.boardCells[1][1].getText())
                && data.boardCells[1][1].getText().equals(data.boardCells[2][0].getText())
                && !data.boardCells[0][2].getText().equals("")) {
            // return true;
            return Arrays.asList(true,
                    new MyBoardCell[] { data.boardCells[0][2], data.boardCells[1][1], data.boardCells[2][0] });
        }

        // check for horizontal win
        for (int i = 0; i < 3; i++) {
            if (data.boardCells[i][0].getText().equals(data.boardCells[i][1].getText())
                    && data.boardCells[i][1].getText().equals(data.boardCells[i][2].getText())
                    && !data.boardCells[i][0].getText().equals("")) {
                // return true;
                return Arrays.asList(true,
                        new MyBoardCell[] { data.boardCells[i][0], data.boardCells[i][1], data.boardCells[i][2] });
            }
        }

        // check for vertical win
        for (int i = 0; i < 3; i++) {
            if (data.boardCells[0][i].getText().equals(data.boardCells[1][i].getText())
                    && data.boardCells[1][i].getText().equals(data.boardCells[2][i].getText())
                    && !data.boardCells[0][i].getText().equals("")) {
                // return true;
                return Arrays.asList(true,
                        new MyBoardCell[] { data.boardCells[0][i], data.boardCells[1][i], data.boardCells[2][i] });
            }
        }

        // return false;
        return Arrays.asList(false, new MyBoardCell[] {});
    }

    // checks for a tie
    public static boolean checkForTie(Data data) {
        if (data.numTurns >= 9)
            return true;
        return false;
    }
}
