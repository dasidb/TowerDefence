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

    public Menu(PApplet pApplet){
        this.pApplet = pApplet;

    }
    public void displayMenu(ArrayList<String> values){
        for(String msg : values) {
            counter ++;


            if((a < pApplet.mouseX && a +c > pApplet.mouseX) &&
                b < pApplet.mouseY && b + d > pApplet.mouseY)
            {
                pApplet.fill(255, 255, 255, 255);
                pApplet.rect(a, b * counter, c, d);
            }else {
                pApplet.fill(50, 50, 50);
            }
            pApplet.fill(70,0,0,255);
            pApplet.text(msg, a + a/2,b * counter +b /2);

            if(counter > values.size()){
                counter = 1;
            }
        }


    }

}
