// Data is an object that contains game data generated during runtime.
// This object is passed to other objects that need it.

package data;

import custom_ui_components.MyBoardCell;
import windows.Board;
import windows.DisplayMarks;
import windows.StartGame;

public class Data {
    public Player player1;
    public Player player2;

    public short numTurns = 0;

    public StartGame startGame;
    public DisplayMarks displayMark;
    public Board board;

    public Player currentPlayer;
    public MyBoardCell boardCells[][] = new MyBoardCell[3][3];

    public boolean isGameOver = false;
}
