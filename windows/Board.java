package windows;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import custom_ui_components.MyBoardCell;
import custom_ui_components.MyHorizontalJPanel;
import custom_ui_components.MyJLabel;
import custom_ui_components.MyUI;
import custom_ui_components.MyVerticalJPanel;
import data.Data;
import logic.Logic;
import utilities.Colors;

/* Board cells layout:
    |0|1|2|
    |3|4|5|
    |6|7|8|
*/

public class Board extends MyVerticalJPanel implements UICreatable {
    private Data data;
    public MyUI UI;

    public Board(Data data) {
        this.data = data;

        // COMPONENTS

        MyJLabel jlHeader = new MyJLabel(data.currentPlayer.name
                + "'s turn (" + data.currentPlayer.strNumber + "): " + "mark " + data.currentPlayer.mark); // displays message like "John's turn (player 1): mark X"

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                data.boardCells[i][j] = new MyBoardCell(data);
            }
        }

        MyHorizontalJPanel jpRow1 = new MyHorizontalJPanel(null);
        for (int i = 0; i < 3; i++) {
            jpRow1.add(data.boardCells[0][i]);
        }
        jpRow1.adjustSize();
        jpRow1.adjustComponents();

        MyHorizontalJPanel jpRow2 = new MyHorizontalJPanel(null);
        for (int i = 0; i < 3; i++) {
            jpRow2.add(data.boardCells[1][i]);
        }
        jpRow2.adjustSize();
        jpRow2.adjustComponents();

        MyHorizontalJPanel jpRow3 = new MyHorizontalJPanel(null);
        for (int i = 0; i < 3; i++) {
            jpRow3.add(data.boardCells[2][i]);
        }
        jpRow3.adjustSize();
        jpRow3.adjustComponents();

        MyVerticalJPanel jpBoard = new MyVerticalJPanel(null);
        jpBoard.add(jpRow1);
        jpBoard.add(jpRow2);
        jpBoard.add(jpRow3);
        jpBoard.adjustSize();
        jpBoard.adjustComponents();

        // ADDING COMPONENTS TO UI

        UI = new MyUI();

        UI.addSpaceBetweenComponents(10);
        UI.add(jlHeader);
        UI.addSpaceBetweenComponents(10);
        UI.add(jpBoard);

        UI.adjustComponents();
        UI.centerAllComponents();
        UI.setLocation(UI.getX() - 7, UI.getY());

        // EVENT LISTENERS

        for (MyBoardCell boardCellRow[] : data.boardCells) {
            for (MyBoardCell boardCell : boardCellRow) {
                boardCell.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // if game is not over and cell is empty
                        if (!data.isGameOver && boardCell.getText().equals("")) {
                            data.numTurns++;
                            boardCell.setMark(data.currentPlayer.mark);

                            List<Object> winDetails = Logic.checkForWin(data);
                            // if a player wins
                            if ((boolean) winDetails.get(0)) {
                                data.isGameOver = true;
                                highlightWinningCells((MyBoardCell[]) winDetails.get(1));
                                updateHeaderText(jlHeader, data.currentPlayer.name + " won! (" + data.currentPlayer.strNumber + ")");
                                jlHeader.setForeground(Colors.foregroundAccent);
                                // if there is a tie
                            } else if (Logic.checkForTie(data)) {
                                data.isGameOver = true;
                                updateHeaderText(jlHeader, "It's a tie! Great game!");
                                jlHeader.setForeground(Colors.foregroundAccent);
                            }

                            // if game is not over
                            if (!data.isGameOver) {
                                if (data.currentPlayer.equals(data.player1)) {
                                    data.currentPlayer = data.player2;
                                } else {
                                    data.currentPlayer = data.player1;
                                }
                                updateHeaderText(jlHeader, data.currentPlayer.name + "'s turn (" + data.currentPlayer.strNumber + "): " + "mark " + data.currentPlayer.mark);
                            }
                        }
                    }
                });
            }
        }
    }

    // updates the text at the top (text that displays info)
    private void updateHeaderText(MyJLabel header, String text) {
        header.setText(text);
        // center the label as the size of label changes each time the text is changed
        UI.centerComponent(header);
    }

    // highlights the winning cell combination
    public static void highlightWinningCells(MyBoardCell[] winningCells) {
        for (MyBoardCell cell : winningCells) {
            cell.setForeground(Colors.accent);
        }
    }

    @Override
    public MyUI UI() {
        return this.UI;
    }
}