package edaf60.xl.gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import edaf60.xl.model.XLSheet;

@SuppressWarnings("deprecation")
public class CurrentLabel extends ColoredLabel implements Observer {
    
    public CurrentLabel() {
        super("A1", Color.WHITE);
    }

    @Override
    public void update(Observable o, Object arg) {

        
        if (((String) arg).equals("updateSelectedCell")) {
            
            XLSheet g = (XLSheet) o;
            setText(g.getCurrentCellAdress());
        }

    }

}