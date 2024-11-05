package edaf60.xl.gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import edaf60.xl.gui.menu.XLMenuBar;
import edaf60.xl.model.XLSheet;
@SuppressWarnings("deprecation")
public class XL extends JFrame {

    private static final int ROWS = 10, COLUMNS = 8;
    private XLCounter counter;
    private StatusLabel statusLabel = new StatusLabel();
    private XLList xlList;
    private XLSheet xlSheet;
    private Controller controller;
    private Editor editor;

    public XL(XL oldXL) {
        this(oldXL.xlList, oldXL.counter);
    }

    public XL(XLList xlList, XLCounter counter) {
        super("Untitled-" + counter);
        this.xlList = xlList;
        this.counter = counter;
        xlList.add(this);
        xlSheet = new XLSheet();
        controller = new Controller(xlSheet);
        counter.increment();
        JPanel statusPanel = new StatusPanel(statusLabel);
        SelectedLabel selectedLabel = new SelectedLabel(controller);
        JPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, controller, selectedLabel);
        this.editor = new Editor(controller);
        
        CurrentLabel currentLabel = ((StatusPanel) statusPanel).getCurrentLabel();
        SlotLabels slotLabels = ((SheetPanel) sheetPanel).getSlotLabels();

        Observer[] observers = {currentLabel, slotLabels, selectedLabel, editor, statusLabel}; //Alla instanser av klasserna som implementerar Observable
        xlSheet.addObservers( observers ); 

        add(NORTH, statusPanel);
        add(CENTER, editor);
        add(SOUTH, sheetPanel);
        setJMenuBar(new XLMenuBar(this, xlList, statusLabel, controller, editor));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void rename(String title) {
        setTitle(title);
        xlList.setChanged();
    }

    public XLSheet getSheet() {
        return xlSheet;
    }

    public static void main(String[] args) {
        new XL(new XLList(), new XLCounter());
        
    }
}