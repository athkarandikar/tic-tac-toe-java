// UICreatable is an interface that is implemented by windows (StartGame, DisplayMarks, Board)

package windows;

import custom_ui_components.MyUI;

public interface UICreatable {
    // returns the MyUI object
    public MyUI UI();
}
