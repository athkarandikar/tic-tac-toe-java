package custom_ui_components;

import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.Box;

public class MyHorizontalJPanel extends MyJPanel {
    public MyHorizontalJPanel() {
        super();
    }

    public MyHorizontalJPanel(LayoutManager layout) {
        super(layout);
    }

    @Override
    public void setHeight() {
        int panelHeight = 0;

        for (Component component : this.getComponents()) {
            int height = component.getWidth();
            if (height > panelHeight)
                panelHeight = height;
        }

        this.setSize(this.getWidth(), panelHeight);
    }

    @Override
    public void setWidth() {
        int panelWidth = 0;

        for (Component component : this.getComponents()) {
            panelWidth += component.getWidth() + defaultGap;
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
        int xPointer = 0;

        for (Component component : components) {
            component.setLocation(xPointer, 0);
            xPointer += component.getWidth() + defaultGap;
        }
    }

    @Override
    public void addSpaceBetweenComponents(int size) {
        Component box = Box.createHorizontalStrut(size);
        box.setSize(size, 1);
        this.add(box);
    }

    @Override
    public void centerComponent(Component component) {
        component.setLocation(component.getX(), this.getHeight() / 2 - component.getHeight() / 2);
    }
}
