package custom_ui_components;

import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.Box;

public class MyVerticalJPanel extends MyJPanel {
    public MyVerticalJPanel() {
        super();
    }

    public MyVerticalJPanel(LayoutManager layout) {
        super(layout);
    }

    @Override
    public void setHeight() {
        int panelHeight = 0;

        for (Component component : this.getComponents()) {
            panelHeight += component.getHeight() + defaultGap;
        }

        this.setSize(this.getWidth(), panelHeight);
    }

    @Override
    public void setWidth() {
        int panelWidth = 0;

        for (Component component : this.getComponents()) {
            int width = component.getWidth();
            if (width > panelWidth)
                panelWidth = width;
        }

        this.setSize(panelWidth, this.getHeight());
    }

    @Override
    public void adjustSize() {
        this.setHeight();
        this.setWidth();
    }

    @Override
    public void adjustComponents() {
        Component components[] = this.getComponents();
        int yPointer = 0;

        for (Component component : components) {
            component.setLocation(0, yPointer);
            yPointer += component.getHeight() + defaultGap;
        }
    }

    @Override
    public void addSpaceBetweenComponents(int size) {
        Component box = Box.createVerticalStrut(size);
        box.setSize(1, size);
        this.add(box);
    }

    @Override
    public void centerComponent(Component component) {
        component.setLocation(this.getWidth() / 2 - component.getWidth() / 2, component.getY());
    }
}
