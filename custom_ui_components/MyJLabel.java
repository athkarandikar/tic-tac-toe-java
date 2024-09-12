package custom_ui_components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;

import utilities.Colors;
import utilities.Fonts;

public class MyJLabel extends JLabel {
    private Color foreground = Colors.foreground;

    public MyJLabel(String text) {
        this(text, Fonts.paragraph);
    }

    public MyJLabel(String text, Font font) {
        this(text, font, Colors.foreground);
    }

    public MyJLabel(String text, Font font, Color foreground) {
        super(text);
        setFont(font);
        changeSizeToPreferredSize();
        this.foreground = foreground;
        setForeground(this.foreground);
    }

    // changes size to preferred size of this component
    public void changeSizeToPreferredSize() {
        Dimension size = this.getPreferredSize();
        setSize(size.width + 10, size.height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void setText(String text, boolean changeSize) {
        super.setText(text);
        if (changeSize) {
            changeSizeToPreferredSize();
        }
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        changeSizeToPreferredSize();
    }
}
