package edaf60.xl.model;

import edaf60.xl.expr.Environment;

public class CommentCell implements Cell{

    private String comment;
    private double value = 0;

    public CommentCell(String comment) {
        this.comment = comment;
    }

    @Override
    public double getValue(Environment environment) {
        return value;
    }

    @Override
    public String getValueString(Environment environment) {
        return comment;
    }

    @Override
    public String toString() {
        return "#" + comment;
    }
    
}
