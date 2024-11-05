package edaf60.xl.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import edaf60.xl.util.XLException;


public class XLBufferedReader extends BufferedReader {

    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    public void load(Map<String, Cell> map) {
        
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=') + 1;

                String cellAdress = string.substring(0, i-1);

                String cell = string.substring(i, string.length());
                System.out.println(cellAdress + "     " + cell);

                map.put(cellAdress, CellFactory.createCell(cell));

            }

        }
        catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
