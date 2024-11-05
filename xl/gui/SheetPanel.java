package edaf60.xl.gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

public class SheetPanel extends BorderPanel {

    private SlotLabels slotlabels;

    public SheetPanel(int rows, int columns, Controller controller, SelectedLabel selectedLabel) {

        this.slotlabels = new SlotLabels(rows, columns, controller, selectedLabel);
        
        add(WEST, new RowLabels(rows));
        add(CENTER, slotlabels);
    }

    //Krävs för att SlotLabels skall kunna läggas till som en Observer
    public SlotLabels getSlotLabels() {
        return slotlabels;
    }
}
