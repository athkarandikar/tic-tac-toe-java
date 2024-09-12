package custom_ui_components;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import utilities.Colors;
import utilities.Fonts;

public class MyJButton extends JButton {
    public MyJButton(String text, MyJPanel ui) {
        super(text);
        Dimension size = this.getPreferredSize();
        setSize(size.width, 30);
        setBackground(Colors.accent);

        // click effects
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getParent().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                getParent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setContentAreaFilled(true);
                setOpaque(false);
                setBackground(Colors.accent);
            }
        });

        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setContentAreaFilled(false);
                setOpaque(true);
                setBackground(Colors.accent_200);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBorder(new RoundBorder(Colors.accent, 1, 10));
        setFont(Fonts.paragraph_bold);
        this.setFocusPainted(false); // disables border upon focus
        setContentAreaFilled(false); // disables background color change upon click
        setOpaque(true);
        setForeground(Colors.foreground);
    }
}
