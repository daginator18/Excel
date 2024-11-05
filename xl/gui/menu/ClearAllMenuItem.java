package edaf60.xl.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import edaf60.xl.gui.*;

class ClearAllMenuItem extends JMenuItem implements ActionListener {

    private Controller controller;

    public ClearAllMenuItem(Controller controller, Editor editor) {
        super("Clear all");
        this.controller = controller;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        controller.clearSheet(); 
        
    }
}