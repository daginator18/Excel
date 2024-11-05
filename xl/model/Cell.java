package edaf60.xl.model;

import edaf60.xl.expr.Environment;

public interface Cell {

    double getValue(Environment environment);

    String getValueString(Environment environment);

    String toString();
    
}
