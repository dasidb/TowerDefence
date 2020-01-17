import processing.core.PApplet;
import processing.core.PImage;


import java.awt.print.Paper;
import java.nio.channels.Pipe;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Tower {
    int cost;
    int dmg;
    float range;
    PImage img;
    float posX;
    float posY;
    long attackspeed;
    PApplet pApplet;
    public Date lastdate;
    public long lastAttack = 0;
    Map<String,PImage> imageMap;
    boolean canShoot;




    public Tower(PImage img, float posX, float posY) {
        this.img = img;
        this.posX = posX;
        this.posY = posY;
    }

    public Tower(PImage img, float posX, float posY, float range, int cost, long attackspeed, PApplet pApplet, Map<String, PImage> imageMap) {
        this.img = img;
        this.posX = posX;
        this.posY = posY;
        this.range = range;
        this.cost = cost;
        this.attackspeed = attackspeed;
        this.pApplet = pApplet;
        this.imageMap = imageMap;
    }

  /*  public void loadImages(String assetPath){
         tower_red_t1 =  pApplet.loadImage(assetPath + "tower_red_t1.png");
         tower_red_t2 =  pApplet.loadImage(assetPath + "tower_red_t2.png");
         tower_red_t3 =  pApplet.loadImage(assetPath + "tower_red_t3.png");
         tower_green_t1 =  pApplet.loadImage(assetPath + "tower_green_t1.png");
         tower_green_t2 =  pApplet.loadImage(assetPath + "tower_green_t2.png");
         tower_green_t3 = pApplet.loadImage(assetPath + "tower_green_t3.png");
    } */

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
            //shoot();
        }

    }
    public void shoot(Enemy enemy){
        if(canShoot) {
            long time = System.currentTimeMillis();

            double ergebnis = Math.sqrt(Math.pow((this.posX - enemy.getCordX()), 2) + Math.pow((this.posY - enemy.getCordY()), 2));
            if (time > attackspeed + lastAttack && ergebnis <= range) {
                this.img = imageMap.get("tower_red_t1.png");
                System.out.println(enemy.getLife());
                enemy.setLife(enemy.getLife() - dmg);
                lastAttack = time;

            }
        }
    }

    public void draw(Map<String, Tower> towerHashMap){
        for (Map.Entry<String, Tower> entry : towerHashMap.entrySet()) {



            pApplet.image(entry.getValue().img, entry.getValue().posX, entry.getValue().posY);
        }
    }
}

