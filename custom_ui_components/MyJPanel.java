package custom_ui_components;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.JPanel;

import utilities.Colors;

public abstract class MyJPanel extends JPanel {
    public int defaultGap = 0; // default gap between components

    public MyJPanel() {
        super();
    }

    public MyJPanel(LayoutManager layout) {
        super(layout);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Colors.background);
    }

    // sets height based on components
    public abstract void setHeight();

    // sets width based on components
    public abstract void setWidth();

    // sets size based on components
    public abstract void adjustSize();

    // places components one-by-one based on their size
    public abstract void adjustComponents();

    // adds an invisible component (Box) that imitates the behaviour of empty space
    public abstract void addSpaceBetweenComponents(int size);

    // centers the component based on panel size
    // component will be centered horizontally in MyHorizontalJPanel, and vertically
    // in MyVerticalJPanel
    public abstract void centerComponent(Component component);

    // centers the given components in the array
    public void centerComponents(Component components[]) {
        for (Component component : components)
            centerComponent(component);
    }

    // centers all components in the panel
    public void centerAllComponents() {
        centerComponents(this.getComponents());
    }
}
