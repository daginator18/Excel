package edaf60.xl.gui.menu;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

import edaf60.xl.gui.Controller;
import edaf60.xl.gui.StatusLabel;
import edaf60.xl.gui.XL;

class SaveMenuItem extends OpenMenuItem {
    private Controller controller;

    public SaveMenuItem(XL xl, StatusLabel statusLabel, Controller controller) {

        super(xl, statusLabel, "Save");
        this.controller = controller;
    }

    protected void action(String path) throws FileNotFoundException {
        controller.saveSheet(path);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}