import processing.core.PApplet;

public class StartMenu extends Menu {

    public StartMenu(PApplet pApplet, Boolean canPress){
        super(pApplet, canPress);
        this.getOptionsArrayList();
        this.setMenu(this);



    }

  //  public Menu getMenu(){

     //  return this;
 //   }
}
