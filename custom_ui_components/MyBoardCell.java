package custom_ui_components;

import java.awt.Cursor;

import javax.swing.BorderFactory;

import data.Data;
import utilities.Colors;
import utilities.Fonts;

public class MyBoardCell extends MyJLabel {
    public String mark = "";

    public MyBoardCell(Data data) {
        super("", Fonts.mark, Colors.foreground_200);
        this.setSize(135, 135);
        this.setHorizontalAlignment(MyJLabel.CENTER);
        this.setVerticalAlignment(MyJLabel.CENTER);
        this.setBorder(BorderFactory.createLineBorder(Colors.border_200, 1));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // sets mark (X or O) and updates UI
    public void setMark(String mark) {
        this.setText(mark);
        this.mark = mark;
    }

    @Override
    public void setText(String text) {
        super.setText(text, false);
    }
}
