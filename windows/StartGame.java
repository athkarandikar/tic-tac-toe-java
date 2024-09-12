package windows;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import custom_ui_components.MyJButton;
import custom_ui_components.MyJLabel;
import custom_ui_components.MyJTextField;
import custom_ui_components.MyUI;
import custom_ui_components.MyVerticalJPanel;
import data.Data;
import data.Player;
import utilities.Fonts;
import utilities.Utility;

public class StartGame extends MyVerticalJPanel implements UICreatable {
    private Data data;
    private Container parentContentPane;
    public MyUI UI;

    public StartGame(Container contentPane, Data data) {
        this.data = data;
        this.parentContentPane = contentPane;

        // COMPONENTS

        MyJLabel jlHeader = new MyJLabel("Tic Tac Toe", Fonts.paragraph_bold);

        MyJLabel jlPlayer1 = new MyJLabel("Player 1");
        MyJLabel jlPlayer2 = new MyJLabel("Player 2");

        MyJTextField jtfPlayer1 = new MyJTextField(20);
        MyJTextField jtfPlayer2 = new MyJTextField(20);

        MyJButton jbStart = new MyJButton("Start", this);

        MyVerticalJPanel jpPlayer1 = new MyVerticalJPanel(null);
        jpPlayer1.add(jlPlayer1);
        jpPlayer1.addSpaceBetweenComponents(14);
        jpPlayer1.add(jtfPlayer1);
        jpPlayer1.adjustSize();
        jpPlayer1.adjustComponents();

        MyVerticalJPanel jpPlayer2 = new MyVerticalJPanel(null);
        jpPlayer2.add(jlPlayer2);
        jpPlayer2.addSpaceBetweenComponents(14);
        jpPlayer2.add(jtfPlayer2);
        jpPlayer2.adjustSize();
        jpPlayer2.adjustComponents();

        MyVerticalJPanel jpPlayers = new MyVerticalJPanel(null);
        jpPlayers.add(jpPlayer1);
        jpPlayers.addSpaceBetweenComponents(28);
        jpPlayers.add(jpPlayer2);
        jpPlayers.adjustSize();
        jpPlayers.adjustComponents();

        // ADDING COMPONENTS TO UI

        UI = new MyUI();

        UI.addSpaceBetweenComponents(21);
        UI.add(jlHeader);
        UI.addSpaceBetweenComponents(85);
        UI.add(jpPlayers);
        UI.addSpaceBetweenComponents(135);
        UI.add(jbStart);

        UI.adjustComponents();
        UI.centerAllComponents();
        UI.setLocation(UI.getX() - 7, UI.getY());

        // EVENT LISTENERS

        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.player1 = new Player("player 1", jtfPlayer1.getText());
                data.player2 = new Player("player 2", jtfPlayer2.getText());

                assignMarks();
                data.displayMark = new DisplayMarks(parentContentPane, data);
                Utility.updateUI(parentContentPane, data.displayMark);
            }
        });
    }

    // randomly assigns marks to players
    private void assignMarks() {
        byte randomNum = (byte) Math.round(Math.random() * 1);
        if (randomNum == 1) { // assume player1 is X
            data.player1.mark = "X";
            data.player2.mark = "O";
            data.currentPlayer = data.player1;
        } else { // assume player2 is X
            data.player1.mark = "O";
            data.player2.mark = "X";
            data.currentPlayer = data.player2;
        }
    }

    @Override
    public MyUI UI() {
        return UI;
    }
}