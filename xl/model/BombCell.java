package edaf60.xl.model;

import edaf60.xl.expr.Environment;
import edaf60.xl.util.XLException;

public class BombCell  implements Cell{

    String message;

    public BombCell(String message) {
        this.message = message;
    }

    @Override
    public double getValue(Environment environment) {
        
        throw new XLException(message); 
    }

    @Override
    public String getValueString(Environment environment) {
        
        throw new XLException(message);
    }

    public String bombString() {
        return message;
    }

    public String toString() {
        return "";
    }
    
}
