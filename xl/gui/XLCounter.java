package edaf60.xl.gui;

public class XLCounter {

    private int counter;

    public XLCounter() {
        counter = 0;
    }

    public void increment() {
        counter++;
    }

    public String toString() {
        return Integer.toString(counter);
    }
}