package edaf60.xl.gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import edaf60.xl.model.XLSheet;
@SuppressWarnings("deprecation")
public class StatusLabel extends ColoredLabel implements Observer {

    public StatusLabel() {
        super("", Color.WHITE);
    }

    public void update(Observable o, Object arg) {
        
        if (((String) arg).equals("updatedStatus")) {

            setText((((XLSheet) o)).status);
        }
        else if (((String) arg).equals("updateSelectedCell")) {
            setText("");
        } 
    }
}
