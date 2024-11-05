package edaf60.xl.gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

public class StatusPanel extends BorderPanel {

    private CurrentLabel currentLabel;

    protected StatusPanel(StatusLabel statusLabel) {

        CurrentLabel currentLabel = new CurrentLabel();
        this.currentLabel = currentLabel;

        add(WEST, currentLabel);
        add(CENTER, statusLabel);
    }
    
    //Krävs för att CurrentLabel skall kunna läggas till som en Observer
    public CurrentLabel getCurrentLabel() {
        return currentLabel;
    }
}
