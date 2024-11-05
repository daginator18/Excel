package edaf60.xl.model;

import edaf60.xl.expr.*;

public class ExprCell implements Cell{

    private Expr expr;

    public ExprCell(Expr expr) {
        this.expr = expr;
    }

    @Override
    public double getValue(Environment environment) {
        return expr.value(environment);
    }

    @Override
    public String getValueString(Environment environment) {
        return Double.toString(getValue(environment));
    }

    @Override
    public String toString() {
        return expr.toString();
    }
    
}
