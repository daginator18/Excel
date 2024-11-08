package edaf60.xl.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import edaf60.xl.gui.XL;
import edaf60.xl.gui.XLList;

class CloseMenuItem extends JMenuItem implements ActionListener {

    private XL xl;
    private XLList xlList;

    public CloseMenuItem(XL xl, XLList xlList) {
        super("Close");
        this.xl = xl;
        this.xlList = xlList;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        xlList.remove(xl);
        xl.dispose();
        if (xlList.isEmpty()) {
            System.exit(0);
        } else {
            xlList.last().toFront();
        }
    }
}