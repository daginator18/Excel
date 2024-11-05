package edaf60.xl.gui;

import java.awt.Color;

public class SlotLabel extends ColoredLabel {

    private String adress;

    public SlotLabel(String adress) {
        super("                    ", Color.WHITE, RIGHT);
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    
}
