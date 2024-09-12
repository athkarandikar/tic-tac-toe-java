package custom_ui_components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;

class RoundBorder extends AbstractBorder {
    private Color color;
    private int thickness;
    private int radii;
    private Insets insets = null;
    private BasicStroke stroke = null;
    private int strokePad;
    RenderingHints hints;

    RoundBorder(Color color) {
        this(color, 1, 8);
    }

    RoundBorder(Color color, int thickness, int radii) {
        this.thickness = thickness;
        this.radii = radii;
        this.color = color;

        stroke = new BasicStroke(thickness);
        strokePad = thickness / 2;

        hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int pad = radii + strokePad;
        int bottomPad = pad + strokePad;
        insets = new Insets(pad, pad, bottomPad, pad);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return insets;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;

        RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(
                0 + strokePad,
                0 + strokePad,
                width - thickness,
                height - thickness,
                radii,
                radii);

        Area area = new Area(bubble);

        g2.setRenderingHints(hints);

        // paint the background color of the parent, everywhere outside the clip of the
        // component having this border
        Component parent = c.getParent();
        if (parent != null) {
            Color bg = parent.getBackground();
            Rectangle rect = new Rectangle(0, 0, width, height);
            Area borderRegion = new Area(rect);
            borderRegion.subtract(area);
            g2.setClip(borderRegion);
            g2.setColor(bg);
            g2.fillRect(0, 0, width, height);
            g2.setClip(null);
        }
        g2.setColor(color);
        g2.setStroke(stroke);
        g2.draw(area);
    }
}