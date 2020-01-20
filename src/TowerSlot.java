import processing.core.PApplet;
import processing.core.PImage;

import java.awt.print.Paper;
import java.util.Map;

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

    public TowerSlot(PImage img, float posX , float posY, float range, int cost, long attackspeed, PApplet pApplet, Map<String, PImage> imageMap){
        super(img,posX,posY,range,cost, attackspeed, pApplet, imageMap);
        canShoot = false;
    }
    public TowerSlot(PImage img , float posX, float posY,Map<String, PImage> imageMap, PApplet pApplet){
        super(img,posX,posY,imageMap, pApplet);
    }

}
