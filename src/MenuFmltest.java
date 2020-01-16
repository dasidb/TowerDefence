/*
import processing.core.PApplet;

import java.util.ArrayList;

public class MenuFmltest {


    int test = 0;
    float cordX;
    float cordY;
    PApplet pApplet;
    int a = 100;
    int b = 100;
    int c = 400;
    int d = 100;
    int counter = 1;
    boolean canPress;
    ArrayList<MenuOptions> optionsArrayList;
    MenuFmltest menu;
    boolean toogleMenu = true;
    boolean change = true;


    public MenuFmltest getMenu(){


        return menu;

    }
    public ArrayList<MenuOptions> getOptionsArrayList(){
        if(optionsArrayList == null)
            setMenu(new StartMenu(pApplet,canPress));


        return optionsArrayList;
    }

    public void setMenu(MenuFmltest menu){

        this.menu = menu;

    }

    public boolean isCanPress() {
        return canPress;
    }


    public void setCanPress(boolean canPress) {
        this.canPress = canPress;
    }
    public MenuFmltest(int a, int b , int c , int d, int counter){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.counter = counter;
    }
    public MenuFmltest(){

    }
    public MenuFmltest(PApplet pApplet, boolean canPress){

        this.pApplet = pApplet;
        this.canPress = canPress;
        System.out.println(menu + " wichtiges menu");
        menu = this;
        System.out.println(menu);
        menu.testObject();

    }

    // TODO: 1/10/2020 fill menu usage (Screensize etc) exchange Spiel starten with continue

    public boolean displayMenu(ArrayList<MenuOptions> values){
    toogleMenu = true;

       // System.out.println(menu);

        for(Enum msg : values) {
            counter ++;



            if((a < pApplet.mouseX && a +c > pApplet.mouseX) &&
                b * counter < pApplet.mouseY && b * counter + d > pApplet.mouseY)
            {
               // if(counter == 2) {
                    pApplet.fill(255, 255, 255, 255);

                    pApplet.rect(a, b * counter, c, d);

               // }

                if(pApplet.mousePressed && canPress) {
                    canPress = false;
                    System.out.println("kommt dkwadwakdwap");
                    test++;
               toogleMenu =  chooseMenu((MenuOptions) msg);

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

    public MenuFmltest changeMenu(MenuFmltest menu){

        this.menu = menu;

        return menu;
    }

    public boolean chooseMenu(MenuOptions value){

        System.out.println(value);
        switch (value){

            case Spiel_Starten:
                System.out.println("Starten");
                toogleMenu = false;

                return toogleMenu;

            case Einstellungen:
                System.out.println("Einstellungen");
            this.menu = new OptionMenu(pApplet,canPress);

                System.out.println(menu + " rückgabe");
                break;

            case WindowSize:
                pApplet.frame.setSize(200,200);
                break;
            case Volume:
                break;

            case New_Game:
                break;

            case Continue:
                break;

            case Quit:
            System.out.println("kommt an");
                menu = new StartMenu(pApplet,true);
            //setMenu(new StartMenu(pApplet,true));

                break;
        }
    System.out.println(menu + " rückgabe menu");
    return true;
    }

    public void testObject(){
    System.out.println("ist ein menu ");
    }

    public void drawMenu(){
        System.out.println(menu);

        menu.displayMenu(menu.optionsArrayList);

    }

}
 */