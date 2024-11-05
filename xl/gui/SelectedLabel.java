package edaf60.xl.gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
@SuppressWarnings("deprecation")
public class SelectedLabel implements Observer{

    private Controller controller;

    //Representerar det markerade fältet i gui
    public SlotLabel selectedLabel;

    public SelectedLabel(Controller controller) {
        this.controller = controller;
    }

    //Byter bakrundsfärgen på den markerade cellen och byter den valda cellen i modellen
    //Används av SlotLabels för att bestämma vad som händer när man klickar på en SlotLabel
    public void setSelectedLabel(SlotLabel label, Controller controller) {
        
        if (selectedLabel != null) {

            selectedLabel.setBackground(Color.WHITE);
        }
        
        selectedLabel = label;
        controller.changeSelectedCell(selectedLabel.getAdress());
        selectedLabel.setBackground(Color.YELLOW);
        
    }

    //Uppdaterar texten i aktuell SlotLabel i gui efter att ett värde har tilldelats motsvarande Cell
    //Tar bort texten från aktuell SlotLabel efter att motsvarande cell har clearats 
    @Override
    public void update(Observable o, Object arg) {
        
        if (((String) arg).equals("clearCell")) {
            selectedLabel.setText("");   
        } else if (((String) arg).equals("updatedCell")) {
            selectedLabel.setText(controller.getCurrentCellValue());
        }


    }
    
}
