import processing.core.PApplet;

import java.util.ArrayList;

public class Menu {

    boolean toogleMenu;
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

    public Menu(PApplet pApplet, boolean canPress){
        this.pApplet = pApplet;
        this.canPress = canPress;

    }
    public void displayMenu(ArrayList<String> values){
        for(String msg : values) {
            counter ++;


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
                chooseMenu(msg);
                }

            }else {
                pApplet.fill(200, 50, 50);
                pApplet.rect(a, b * counter, c, d);
            }
            pApplet.fill(70,0,0,255);
            pApplet.text(msg, a + a/2,b * counter +b /2);

            if(counter > values.size()){
                counter = 1;
            }
        }


    }

    public void chooseMenu(String value){

        switch (value){

            case "Spiel Starten":
                System.out.println("Starten");
                break;
            case "Einstellungen":
                System.out.println("Einstellungen");
                break;
            case "Quit":
                break;
        }
    }

}
