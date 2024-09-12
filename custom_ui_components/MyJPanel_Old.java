package custom_ui_components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.Box;
import javax.swing.JPanel;

import utilities.Colors;

public class MyJPanel_Old extends JPanel {
    private int defaultGap = 2; // default gap between components

    public MyJPanel_Old() {
        super();
    }

    public MyJPanel_Old(LayoutManager layout) {
        super(layout);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Colors.background);
    }

    public void adjustHeight() {
        int panelHeight = 0;

        for (Component component : this.getComponents()) {
            panelHeight += component.getHeight() + defaultGap;
        }

        this.setSize(this.getWidth(), panelHeight);
    }

    public void adjustWidth() {
        int panelWidth = 0;

        for (Component component : this.getComponents()) {
            int width = component.getWidth();
            if (width > panelWidth)
                panelWidth = width;
        }

        this.setSize(panelWidth, this.getHeight());
    }

    public void adjustSize() {
        this.adjustHeight();
        this.adjustWidth();
    }

    public void adjustComponents() {
        Component components[] = this.getComponents();
        int yPointer = 0;

        for (Component component : components) {
            component.setLocation(0, yPointer);
            yPointer += component.getHeight() + defaultGap;
        }
    }

    public void addSpaceBetweenComponents(int size) {
        Component box = Box.createVerticalStrut(size);
        box.setBackground(Color.green);
        box.setSize(1, size);
        this.add(box);
    }

    public void centerComponent(Component component) {
        component.setLocation(this.getWidth() / 2 - component.getWidth() / 2, component.getY());
    }

    public void centerComponents(Component components[]) {
        for (Component component : components)
            centerComponent(component);
    }

    public void centerAllComponents() {
        centerComponents(this.getComponents());
    }
}
