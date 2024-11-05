package edaf60.xl.gui;
import java.io.FileNotFoundException;
import java.io.IOException;
import edaf60.xl.model.*;

public class Controller {

    private XLSheet xlSheet;

    public Controller(XLSheet xlSheet) {
        this.xlSheet = xlSheet;
    }

    public void changeSelectedCell(String adress) {
        xlSheet.selectCell(adress);
    }
 
    public void saveSheet(String fileName) throws FileNotFoundException {
        xlSheet.saveSheet(fileName);
    }

    public void loadFromFile(String fileName) throws FileNotFoundException, IOException {
        xlSheet.loadFromFile(fileName);
    }

    public void clearSheet() {
        xlSheet.clearAll();
    }

    public void clearCell() {
        xlSheet.clearCell();
    }

    public void addCell(String adress, String value) throws IOException {
        xlSheet.addCell(adress, value);
    }

    public Cell getCell(String adress) {
        return xlSheet.getCell(adress);
    }

    public Cell getCurrentCell() {
        return xlSheet.getCurrentCell();
    }

    public String getCurrentCellValue() {
       return xlSheet.getCurrentCellValue(xlSheet);
    }

    public String getCurrentCellAdress()  {
        return xlSheet.getCurrentCellAdress();
    }

    public String getCellValue(String adress) {
        return xlSheet.getCellValue(adress, xlSheet);
    }

    public boolean isCell(String adress) {
        return xlSheet.isCell(adress);
    }
}