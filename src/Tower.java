import processing.core.PImage;


import java.nio.channels.Pipe;
import java.util.HashMap;
import java.util.Map;

public class Tower {
    int cost;
    int dmg;
    float range;
    PImage img;
    float posX;
    float posY;


    public Tower(PImage img, float posX, float posY) {
        this.img = img;
        this.posX = posX;
        this.posY = posY;
    }

    public Tower(PImage img, float posX, float posY, float range, int cost) {
        this.img = img;
        this.posX = posX;
        this.posY = posY;
        this.range = range;
        this.cost = cost;
    }

    public boolean collisionCheck(Tower tower, int mouseX, int mouseY) {
    if(tower.posX < mouseX && tower.posX + tower.img.width > mouseX &&
            tower.posY < mouseY && tower.posY + tower.img.height > mouseY){
        System.out.println("yayayaya");
    }

        return true;
    }

    // TODO: 12.01.2020 kreisgleichung x^2 + y^2 = r^2
    // r^2 range of tower x^2 y^2 distance tower -> enemy
    public void checkEnemyCollision(float enemyPosX, float enemyPosY){
        if( Math.sqrt(Math.pow((enemyPosX - posX),2) + Math.pow((enemyPosY- posY),2)) <= range){
            shoot();
        }

    }
    public void shoot(){
        if(3 < 2){

        }
    }
}

