import processing.core.PImage;

public class TowerSlot extends  Tower{
    PImage img;
    float posX;
    float posY;

    public TowerSlot(PImage img, float posX, float posY){
       super(img,posX,posY);
        this.img = img;
        this.posX = posX;
        this.posY = posY;
    }


}
