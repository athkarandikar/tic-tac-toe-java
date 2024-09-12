// MyUI is an object that is just a MyVerticalJPanel. It represents a user interface (UI).
// It is the top-most component that contains all the components that a window wants to render.

package custom_ui_components;

import utilities.Utility;

public class MyUI extends MyVerticalJPanel {
    public MyUI() {
        super(null);
        this.setSize(Utility.frameWidth, Utility.frameHeight);
        this.setLocation(0, 0);
    }
}
