import processing.core.PApplet;

import javax.rmi.ssl.SslRMIClientSocketFactory;
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
    ArrayList<MenuOptions> optionsArrayList;
    Menu menu;
    boolean toogleMenu = true;

    public Menu getMenu(){

        return menu;
    }
    public ArrayList<MenuOptions> getOptionsArrayList(){
        if(optionsArrayList == null) {
            optionsArrayList = new ArrayList<>();
            optionsArrayList.add(MenuOptions.Spiel_Starten);
            optionsArrayList.add(MenuOptions.Einstellungen);
            optionsArrayList.add(MenuOptions.Quit);
        }

        return optionsArrayList;
    }

    public void setMenu(Menu menu){

        this.menu = menu;

    }

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

    // TODO: 1/10/2020 fill menu usage (Screensize etc) exchange Spiel starten with continue  

    public boolean displayMenu(ArrayList<MenuOptions> values){
    toogleMenu = true;

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

    public Menu changeMenu(Menu menu){

        this.menu = menu;

        return menu;
    }

    public boolean chooseMenu(MenuOptions value){


        switch (value){

            case Spiel_Starten:
                System.out.println("Starten");
                toogleMenu = false;

                return toogleMenu;
            case Einstellungen:
                System.out.println("Einstellungen");
            setMenu(new OptionMenu(pApplet));
            //menu = changeMenu(new OptionMenu(pApplet));
            //menu = new OptionMenu(pApplet);
                System.out.println(menu + " rückgabe");
                break;
            case Quit:

              // if(this instanceof StartMenu){
                //   System.out.println("menu");
                //}else{
                  // setMenu(new OptionMenu(pApplet));
                   setMenu(new StartMenu(pApplet,true));
                   System.out.println("kommt an");
               //}

                break;
        }

    return true;
    }

}
