package edaf60.xl.model;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map.Entry;


import java.util.Set;


public class XLPrintStream extends PrintStream {

    public XLPrintStream(String fileName) throws FileNotFoundException {
        super(fileName + ".xl");
    }

    public void save(Set<Entry<String, Cell>> set) {
        for (Entry<String, edaf60.xl.model.Cell> entry : set) {
            print(entry.getKey());
            print('=');
            println(entry.getValue());
        }
        flush();
        close();
    }
}
