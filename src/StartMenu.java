import processing.core.PApplet;

import java.util.ArrayList;

public class StartMenu extends Menu {

    public StartMenu(){
        fillOptions();

    }

    public StartMenu(PApplet pApplet, boolean canPress) {


    }
@Override
    public void fillOptions(){
        super.fillOptions();
        menuOptionsArrayList.add(MenuOptions.New_Game);
        menuOptionsArrayList.add(MenuOptions.Continue);
        menuOptionsArrayList.add(MenuOptions.Einstellungen);
        menuOptionsArrayList.add(MenuOptions.Quit);

    }
/*
    public ArrayList<MenuOptions> getOptionsArrayList() {

        if (optionsArrayList == null) {
            optionsArrayList = new ArrayList<>();
            buildMenuOptions();
        }

        return buildMenuOptions();
    }

    public ArrayList<MenuOptions> buildMenuOptions(){
        optionsArrayList.add(MenuOptions.New_Game);
        optionsArrayList.add(MenuOptions.Spiel_Starten);
        optionsArrayList.add(MenuOptions.Einstellungen);
        optionsArrayList.add(MenuOptions.Quit);
        optionsArrayList.add(MenuOptions.Continue);

        return optionsArrayList;
    } */
}
