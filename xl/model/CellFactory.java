package edaf60.xl.model;

import java.io.IOException;

import edaf60.xl.expr.ExprParser;
import edaf60.xl.util.XLException;

public class CellFactory {

    public static Cell createCell(String s) throws IOException {
        if (s.startsWith("#")) {
            return new CommentCell(s.substring(1));
        }
        else {

            try {
                ExprParser parser = new ExprParser();

                return new ExprCell(parser.build(s));

            } catch (XLException e) {
                
                return new BombCell(e.getMessage());
                
            }
        }
    }
    
}
