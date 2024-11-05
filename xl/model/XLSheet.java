package edaf60.xl.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;
import edaf60.xl.expr.Environment;
import edaf60.xl.util.XLException;

@SuppressWarnings("deprecation")
public class XLSheet extends Observable implements Environment {

    private Map<String, Cell> xlSheet;
    private String currentCellAdress;

    public String status;


    public XLSheet() {
        this.xlSheet = new TreeMap<String, Cell>();
        currentCellAdress = "A1";
    }

    public void addCell(String adress, String value) throws IOException {

        Cell newCell = CellFactory.createCell(value);
            
        if (!isValidCell(adress, newCell)){
            if (!value.equals("")) {
                xlSheet.put(adress, newCell);
            } else {
                xlSheet.remove(adress);
            }
            setChanged();
            notifyObservers("updatedCell");
        }
    }

    //Kollar om cellen som ska läggas till kan anta ett värde med getValue
    //Skickar vidare felmeddelande vid diviton med 0 eller circulär referens t.ex.    
    private boolean isValidCell(String adress, Cell cell) {

        Cell tempCell = xlSheet.get(adress);
        BombCell bombCell = new BombCell("error: circular reference");
        xlSheet.put(adress, bombCell);

        try {
            cell.getValue(this);

        } catch (XLException e) {
            
            this.status = e.getMessage();
            setChanged();
            notifyObservers("updatedStatus");
            xlSheet.put(adress, tempCell);
            return true;
        }

        xlSheet.put(adress, tempCell);
        return false;
    }

    public Cell getCell(String name) {
        return xlSheet.get(name);
    }

    public Cell getCurrentCell() {
        return getCell(currentCellAdress);
    }

    public void selectCell(String adress) {
        currentCellAdress = adress;
        setChanged();
        notifyObservers("updateSelectedCell");
        
    }

    public boolean isCell(String adress) {
        return xlSheet.containsKey(adress);
    }

    public void clearAll() {
        xlSheet.clear();
        setChanged();
		notifyObservers("clearAllCell");
    }

    public void clear(String adress) {
        xlSheet.remove(adress);
        setChanged();
        notifyObservers("clearCell");
    }

    public void clearCell() {
        xlSheet.remove(currentCellAdress);
        setChanged();
        notifyObservers("clearCell");
    }

    public void saveSheet(String fileName) throws FileNotFoundException {
        try (XLPrintStream fileToSave = new XLPrintStream(fileName)){
            fileToSave.save(xlSheet.entrySet());

        }
        this.status = ("saved file: " + fileName);
        setChanged();
        notifyObservers("updatedStatus");
    }

    public void loadFromFile(String fileName) throws FileNotFoundException, IOException {
        try (XLBufferedReader xlBufferedReader = new XLBufferedReader(fileName)) {
            clearAll();
            xlBufferedReader.load(xlSheet);
            xlBufferedReader.close();
        }
        this.status = ("loaded from file: " + fileName);
        setChanged();
        notifyObservers("updatedCell");
        setChanged();
		notifyObservers("updatedStatus");
    }

    public String getCurrentCellValue(Environment e) {
        return getCellValue(currentCellAdress, e);
    }

    public String getCellValue(String adress, Environment e) {
        if (isCell(adress)) {
            return getCell(adress).getValueString(e);
        }
        return "";
    }

    public String getCurrentCellAdress() {
        return currentCellAdress;
    }
    
    //lägger till alla classer som instansieras i xl och implementerar Observer, 
    //krävs för att observer syncronization skall funka
    public void addObservers(Observer[] observers) { 

        for (Observer o : observers) {
            this.addObserver(o);
        }
    }

    @Override
    public double value(String name) {
       
        return xlSheet.get(name).getValue(this);
    }    
}
