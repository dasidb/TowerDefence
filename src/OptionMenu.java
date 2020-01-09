import processing.core.PApplet;

import java.util.ArrayList;

public class OptionMenu extends Menu {
    ArrayList<MenuOptions> optionList;
    public OptionMenu(PApplet pApplet){
        super(100,100,400,100,1);
        this.pApplet = pApplet;
        System.out.println(this.a);
        optionList = new ArrayList<>();
        optionList.add(MenuOptions.WindowSize);
        optionList.add(MenuOptions.Volume);
        super.displayMenu(optionList);
    }
}
