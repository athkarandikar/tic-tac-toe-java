// Utility contains some miscellaneous static fields and methods that are reused by other objects.

package utilities;

import java.awt.Container;

import custom_ui_components.MyUI;
import windows.UICreatable;

public class Utility {
    public static int frameWidth = 500;
    public static int frameHeight = 500;

    // changes the current window to another window
    public static void updateUI(Container contentPane, UICreatable panel) {
        // remove all components before adding a UI (as you want to swap UIs)
        contentPane.removeAll();
        MyUI UI = panel.UI();
        contentPane.add(UI);
        // paint the update
        contentPane.repaint();
    }
}
