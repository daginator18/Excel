package edaf60.xl.gui.menu;

import edaf60.xl.gui.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;


class ClearMenuItem extends JMenuItem implements ActionListener {

    private Controller controller;

    public ClearMenuItem(Controller controller, Editor editor) {
        super("Clear");
        this.controller = controller;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        controller.clearCell();
    }
}