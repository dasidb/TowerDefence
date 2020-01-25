import processing.core.PApplet;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Menu {

    HashMap<String,Menu> menuHashMap;
    float posX = 100;
    float posY = 100;
    float boxSize = 600;
    ArrayList<MenuOptions> menuOptionsArrayList;
    PApplet pApplet;
    String menuType = "Start_Menu";
    boolean canPress = true;
    boolean toogleMenu1 = true;



    public boolean isToogleMenu1(){
        return this.toogleMenu1;
    }

    public void setToogleMenu1(boolean toogleMenu1){
        this.toogleMenu1 = toogleMenu1;
    }

    public void setCanPress(boolean canPress){
        this.canPress = canPress;
    }

    public Menu(){

    }


    public Menu(PApplet pApplet){
        this.pApplet = pApplet;

        menuHashMap = new HashMap<>();
        menuHashMap.put("Start_Menu", new StartMenu());
    }

    public void fillOptions(){
        menuOptionsArrayList = new ArrayList<>();

    }

    public void chooseMenu(){
        displayMenu(menuHashMap.get(menuType));
    }

    public void changeMenu(MenuOptions option){
    System.out.println(option);
        switch(option) {
            case Continue:
                setToogleMenu1(false);
                break;
            case New_Game:
                setToogleMenu1(false);
                break;
            case Einstellungen:
                if(!menuHashMap.containsKey("OptionMenu"))
                    menuHashMap.put("OptionMenu", new OptionMenu());

                    menuType = "OptionMenu";
                break;
            case Volume:
                System.out.println("lautstärke");
                break;
            case WindowSize:
                pApplet.frame.setSize(400,400);
                break;
            case Quit:
                if(!menuHashMap.containsKey("StartMenu"))
                    menuHashMap.put("StartMenu", new StartMenu());

                if(menuType == "StartMenu"){
                    // TODO: 1/25/2020 should game be closed?
                }else {
                    menuType = "StartMenu";
                }

                break;
        }

    }

    public void displayMenu(Menu tmpMenu) {
        int counter = 1;
        for (MenuOptions option : tmpMenu.menuOptionsArrayList) {

            if ((posX < pApplet.mouseX && posX + boxSize > pApplet.mouseX) &&
                    posY * counter < pApplet.mouseY && posY * counter + posY > pApplet.mouseY) {
                // if(counter == 2) {
                pApplet.fill(255, 255, 255, 255);

                pApplet.rect(posX, posY * counter, boxSize, posY);

                if(pApplet.mousePressed && canPress == true) {
                    System.out.println(pApplet.mousePressed);
                    canPress = false;
                    changeMenu(option);
                }

            }



        else {
            pApplet.fill(200, 50, 50);
            pApplet.rect(posX, posY * counter, boxSize, posY);
        }
        pApplet.fill(70,0,0,255);
        pApplet.text(option.name(), posX + posX/2,posY * counter +posY /2);
        counter++;
    }
        }

}
