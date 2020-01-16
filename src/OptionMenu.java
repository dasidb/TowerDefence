import processing.core.PApplet;

import java.util.ArrayList;

public class OptionMenu extends Menu {
    //ArrayList<MenuOptions> optionList;

    public OptionMenu(){

        fillOptions();
    }

    public void fillOptions(){
        super.fillOptions();
        menuOptionsArrayList.add(MenuOptions.WindowSize);
        menuOptionsArrayList.add(MenuOptions.Volume);
        menuOptionsArrayList.add(MenuOptions.Quit);
    }

        //super.setMenu(this);


        //super.setMenu(this);
       // super.displayMenu(this.optionsArrayList);
      //  displayMenu(optionsArrayList);

    }


 /*   public ArrayList<MenuOptions> getOptionsArrayList(){
        if(optionsArrayList == null) {
            optionsArrayList = new ArrayList<>();
            optionsArrayList.add(MenuOptions.WindowSize);
            optionsArrayList.add(MenuOptions.Volume);
            optionsArrayList.add(MenuOptions.Volume);
            optionsArrayList.add(MenuOptions.Quit);
        }

        return buildMenuOptions();
    }

    public ArrayList<MenuOptions> buildMenuOptions(){
        optionsArrayList.add(MenuOptions.WindowSize);
        optionsArrayList.add(MenuOptions.Volume);
        optionsArrayList.add(MenuOptions.Volume);
        optionsArrayList.add(MenuOptions.Quit);

        return optionsArrayList;
    }
    public void testObject(){
        System.out.println("ist ein optionmenu");
    }

 */

