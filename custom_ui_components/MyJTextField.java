package custom_ui_components;

import java.awt.Graphics;
import javax.swing.JTextField;

import utilities.Colors;
import utilities.Fonts;

public class MyJTextField extends JTextField {
    public MyJTextField() {
        super();
    }

    public MyJTextField(int columns) {
        super(columns);
        setSize(185, 30);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Colors.background);
        setForeground(Colors.inputForeground);
        setCaretColor(Colors.caret);
        setBorder(new RoundBorder(Colors.border, 1, 6));
        setFont(Fonts.input);
    }
}
