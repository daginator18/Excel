package edaf60.xl.gui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import edaf60.xl.gui.StatusLabel;
import edaf60.xl.gui.XL;
import edaf60.xl.gui.XLList;
import edaf60.xl.gui.*;

public class XLMenuBar extends JMenuBar {

    public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel, Controller controller, Editor editor) {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.add(new SaveMenuItem(xl, statusLabel, controller));
        file.add(new LoadMenuItem(xl, statusLabel, controller));
        file.add(new NewMenuItem(xl));
        file.add(new CloseMenuItem(xl, xlList));
        edit.add(new ClearMenuItem(controller, editor));
        edit.add(new ClearAllMenuItem(controller, editor));
        add(file);
        add(edit);
        add(new WindowMenu(xlList));
    }
}