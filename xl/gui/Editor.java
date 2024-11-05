package edaf60.xl.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;

@SuppressWarnings("deprecation")
public class Editor extends JTextField implements Observer{

    Controller controller;

    public Editor(Controller controller) {
        
        setBackground(Color.WHITE);

        this.controller = controller;
        
        //skapar en ny cell i modellen efter att man har tyckt enter
        addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {

                String text = getText();
                    
                try {
                    controller.addCell(controller.getCurrentCellAdress(), text);
                    setText("");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                    
            }
        });

    }

    //skriver in det aktuellla uttrycket eller värdet från den markerade cellen i editorn
    @Override
    public void update(Observable o, Object arg) {
        
        if (((String) arg).equals("updateSelectedCell") && controller.isCell(controller.getCurrentCellAdress())) {
            setText(controller.getCurrentCell().toString());
        } else {
            setText("");
        }
    }
}
