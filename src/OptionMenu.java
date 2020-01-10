import processing.core.PApplet;

import java.util.ArrayList;

public class OptionMenu extends Menu {
    //ArrayList<MenuOptions> optionList;
    public OptionMenu(PApplet pApplet){
        super(100,100,400,100,1);
        this.pApplet = pApplet;
        System.out.println(this.a);
        this.getOptionsArrayList();
        this.setMenu(this);
        super.displayMenu(this.optionsArrayList);
    }


    public ArrayList<MenuOptions> getOptionsArrayList(){
        if(optionsArrayList == null) {
            optionsArrayList = new ArrayList<>();
            optionsArrayList.add(MenuOptions.WindowSize);
            optionsArrayList.add(MenuOptions.Volume);
            optionsArrayList.add(MenuOptions.Quit);
        }

        return optionsArrayList;
    }


}
