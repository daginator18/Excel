package edaf60.xl.gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.SwingConstants;


@SuppressWarnings("deprecation")
public class SlotLabels extends GridPanel implements Observer {

    private List<SlotLabel> labelList;
    private Controller controller;
    private SelectedLabel selectedLabel;

    public SlotLabels(int rows, int cols, Controller controller, SelectedLabel selectedLabel) {
        super(rows + 1, cols);
        this.controller = controller;
        this.selectedLabel = selectedLabel;
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY, SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                SlotLabel label = new SlotLabel((String.valueOf(ch) + row));
                add(label);
                labelList.add(label);

                //Gör så att varje fält reagerar när man klickar på det
                label.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                        selectedLabel.setSelectedLabel(label, controller);
                           
                    }


                });
       
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        selectedLabel.setSelectedLabel(firstLabel, controller);
        
    }


    /**
     * Tar bort all text från fälten i gui när clearAllCell tas emot
     * 
     * 
     * När en cell uppdateras och updatedCell tas emot skall texten i fälten uppdateras så
     * att eventuella ändringar av värden syns i fälten i gui
     * 
     */

    @Override
    public void update(Observable o, Object arg) {
        if (((String) arg).equals("clearAllCell")) {
            labelList.forEach(label -> label.setText(""));
        } 
        else if (((String) arg).equals("updatedCell")) {

            labelList.forEach(label -> {

                String value = controller.getCellValue(label.getAdress());
                
                if (!(value.equals("0"))) {

                    label.setText(controller.getCellValue(label.getAdress()));
                    
                }
                 
            });
                
        }
    }
}
