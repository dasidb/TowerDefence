import processing.core.PImage;

import java.util.ArrayList;

public class Enemy {

    PImage img;
    float cordX;
    float cordY;
    boolean moveLeft;
    boolean moveRight;
    boolean moveUp;
    boolean moveDown;
    int maxMovement = 720;
    int increment = 80;
    int smallerRadiusMovement = 40;
    boolean test = true;
    int wave = 1;
    int life = 3 + wave;


    public Enemy(PImage img, float cordX, float cordY, int wave){
        this.img = img;
        this.cordX = cordX;
        this.cordY = cordY;
        this.wave = wave;
        this.life = 3 + wave;
        moveRight = true;


    }

    public PImage getImg() {
        return img;
    }

    public void setImg(PImage img) {
        this.img = img;
    }

    public float getCordX() {
        return cordX;
    }

    public void setCordX(float cordX) {
        this.cordX = cordX;
    }

    public float getCordY() {
        return cordY;
    }

    public void setCordY(float cordY) {
        this.cordY = cordY;
    }

    public void enemyMovePattern(){


        if(this.getCordX() <= maxMovement && moveRight){
            moveUp = false;
            moveRight();
            test = true;

            if(this.getCordX() >= maxMovement)
                moveDown = true;
        }
        if(this.getCordY() <= maxMovement && moveDown){
            moveRight = false;
            moveDown();
            if(this.getCordY() >= maxMovement)
                moveLeft = true;
        }
        if(this.getCordX() >= smallerRadiusMovement && moveLeft){
            moveDown = false;
            moveLeft();

            if(this.getCordX() <= smallerRadiusMovement)

                moveUp = true;
        }

        if(this.getCordY() >= smallerRadiusMovement&& moveUp){
            moveLeft = false;
            moveUp();
            if(test) {
                smallerRadiusMovement += 150;
                test = false;
            }

            if(this.getCordY() <= (smallerRadiusMovement)) {

                if (!moveRight) {
                    maxMovement -= increment *2;
                    //smallerRadiusMovement += increment *2;
                    //System.out.println(maxMovement);
                    System.out.println(smallerRadiusMovement);
                }

                moveRight = true;

            }
        }

        if(life >0 && smallerRadiusMovement == 490){
            System.out.println("-1 HP");
            life = 0;

        }
    }
    public void moveRight(){
        this.setCordX( this.getCordX() + 5);
    }
    public void moveLeft(){
        this.setCordX( this.getCordX() - 5);
    }
    public void moveUp(){
        this.setCordY( this.getCordY() - 5);
    }
    public void moveDown(){
        this.setCordY( this.getCordY() + 5);
    }

}
