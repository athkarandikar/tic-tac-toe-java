package windows;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import custom_ui_components.MyHorizontalJPanel;
import custom_ui_components.MyJButton;
import custom_ui_components.MyJLabel;
import custom_ui_components.MyUI;
import custom_ui_components.MyVerticalJPanel;
import data.Data;
import utilities.Colors;
import utilities.Fonts;
import utilities.Utility;

public class DisplayMarks extends MyVerticalJPanel implements UICreatable {
    private Data data;
    private Container parentContentPane;
    public MyUI UI;

    public DisplayMarks(Container contentPane, Data data) {
        this.data = data;
        this.parentContentPane = contentPane;

        // COMPONENTS

        MyJLabel jlHeader = new MyJLabel("Tic Tac Toe", Fonts.paragraph_bold);
        MyJLabel jlPlayer1 = new MyJLabel("Player 1 - " + data.player1.name);
        MyJLabel jlPlayer2 = new MyJLabel("Player 2 - " + data.player2.name);
        MyJLabel jlPlayer1Mark = new MyJLabel(data.player1.mark, Fonts.mark, Colors.foreground_200);
        MyJLabel jlPlayer2Mark = new MyJLabel(data.player2.mark, Fonts.mark, Colors.foreground_200);
        MyJLabel jlFooter = new MyJLabel("(The above is randomly chosen)", Fonts.footer, Colors.footerForeground);

        MyJButton jbStart = new MyJButton("Start", this);

        MyVerticalJPanel jpPlayer1 = new MyVerticalJPanel(null);
        jpPlayer1.add(jlPlayer1);
        jpPlayer1.add(jlPlayer1Mark);
        jpPlayer1.adjustSize();
        jpPlayer1.adjustComponents();
        jpPlayer1.centerAllComponents();

        MyVerticalJPanel jpPlayer2 = new MyVerticalJPanel(null);
        jpPlayer2.add(jlPlayer2);
        jpPlayer2.add(jlPlayer2Mark);
        jpPlayer2.adjustSize();
        jpPlayer2.adjustComponents();
        jpPlayer2.centerAllComponents();

        MyHorizontalJPanel jpPlayerInfo = new MyHorizontalJPanel(null);
        jpPlayerInfo.add(jpPlayer1);
        jpPlayerInfo.addSpaceBetweenComponents(120);
        jpPlayerInfo.add(jpPlayer2);
        jpPlayerInfo.adjustSize();
        jpPlayerInfo.adjustComponents();

        // ADDING COMPONENTS TO UI

        UI = new MyUI();

        UI.addSpaceBetweenComponents(21);
        UI.add(jlHeader);
        UI.addSpaceBetweenComponents(110);
        UI.add(jpPlayerInfo);
        UI.addSpaceBetweenComponents(110);
        UI.add(jlFooter);
        UI.addSpaceBetweenComponents(14);
        UI.add(jbStart);

        UI.adjustComponents();
        UI.centerAllComponents();
        UI.setLocation(UI.getX() - 7, UI.getY());

        // EVENT LISTENERS

        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.board = new Board(data);
                Utility.updateUI(parentContentPane, data.board);
            }
        });
    }

    @Override
    public MyUI UI() {
        return UI;
    }
}
