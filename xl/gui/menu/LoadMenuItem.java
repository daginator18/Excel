package edaf60.xl.gui.menu;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;

import edaf60.xl.gui.Controller;
import edaf60.xl.gui.StatusLabel;
import edaf60.xl.gui.XL;

class LoadMenuItem extends OpenMenuItem {

    Controller controller;

    public LoadMenuItem(XL xl, StatusLabel statusLabel, Controller controller) {
        super(xl, statusLabel, "Load");
        this.controller = controller;
    }

    protected void action(String path) {
        try {
            controller.loadFromFile(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}