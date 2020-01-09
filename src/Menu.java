import processing.core.PApplet;

import javax.swing.text.html.Option;
import java.util.ArrayList;

public class Menu {



    float cordX;
    float cordY;
    PApplet pApplet;
    int a = 100;
    int b = 100;
    int c = 400;
    int d = 100;
    int counter = 1;
    boolean canPress;


    public boolean isCanPress() {
        return canPress;
    }


    public void setCanPress(boolean canPress) {
        this.canPress = canPress;
    }
    public Menu(int a, int b , int c , int d, int counter){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.counter = counter;
    }
    public Menu(){

    }
    public Menu(PApplet pApplet, boolean canPress){
        this.pApplet = pApplet;
        this.canPress = canPress;

    }

    // TODO: 1/9/2020 make the MenuOption display the menu and change it to subclass try start with displaymenu choose one

    public boolean displayMenu(ArrayList<MenuOptions> values){
        boolean toogleMenu = true;
        for(Enum msg : values) {
            counter ++;
            System.out.println(values);


            if((a < pApplet.mouseX && a +c > pApplet.mouseX) &&
                b * counter < pApplet.mouseY && b * counter + d > pApplet.mouseY)
            {
               // if(counter == 2) {
                    pApplet.fill(255, 255, 255, 255);

                    pApplet.rect(a, b * counter, c, d);
               // }
                //System.out.println(canPress);
                if(pApplet.mousePressed && canPress) {
                    canPress = false;
                System.out.println("dwadawda");
                toogleMenu = chooseMenu((MenuOptions) msg, toogleMenu);
                }

            }else {
                pApplet.fill(200, 50, 50);
                pApplet.rect(a, b * counter, c, d);
            }
            pApplet.fill(70,0,0,255);
            pApplet.text(msg.name(), a + a/2,b * counter +b /2);

            if(counter > values.size()){
                counter = 1;
            }

        }

    return toogleMenu;
    }

    public boolean chooseMenu(MenuOptions value, Boolean toogleMenu){
        Menu menu;

        switch (value){

            case Spiel_Starten:
                System.out.println("Starten");
                toogleMenu = false;
                return toogleMenu;
            case Einstellungen:
                System.out.println("Einstellungen");

            menu = new OptionMenu(pApplet);
                break;
            case Quit:
                break;
        }
        return true;
    }

}
