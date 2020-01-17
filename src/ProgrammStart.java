import processing.core.PApplet;
import processing.core.PImage;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;

public class ProgrammStart extends PApplet {

    private int gameSizeX = 800;
    private int gameSizeY = 800;
    private ArrayList<Enemy> enemyArrayList = new ArrayList<>();
    private Map<String, Tower> towerHashMap = new HashMap<>();
    PImage enemyImage;
    PImage mapBackground;
    PImage destination;
    PImage towerSlotImg;
    PImage stdTileImg;
    PImage tower_red_t1;
    PImage tower_red_t2;
    PImage tower_red_t3;
    PImage tower_green_t1;
    PImage tower_green_t2;
    PImage tower_green_t3;
    Enemy enemy;
    Tower towerSlot;
    Menu menu;
    String assetPath = "\\Assets\\";
    boolean toogleMenu = true;
    ArrayList<MenuOptions> testArrayList;
    boolean canPress = true;
    int wave = 1;
    int life = 200;
    Map<String, PImage> imageMap;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public static void main(String[] args) {
        PApplet.main(ProgrammStart.class, args);
    }

    @Override
    public void settings() {
        super.settings();

        size(gameSizeX, gameSizeY);

    }

    public void setup() {
        super.setup();
        frame.setResizable(true);

        menu = new Menu(this);


        loadAssets();
        loadObjects();

    testArrayList = new ArrayList<>();

    testArrayList.add(MenuOptions.Spiel_Starten);
        testArrayList.add(MenuOptions.Einstellungen);
        testArrayList.add(MenuOptions.Quit);

    //testArrayList.add("Spiel Starten");
      //  testArrayList.add("Einstellungen");
       // testArrayList.add("Quit");


    }

    public void draw() {
        clear();

        if(menu.isToogleMenu1()) {
           // toogleMenu = menu.displayMenu(testArrayList);
           // if(menu.getChange()) {

               // menu = menu.getMenu();
               menu.chooseMenu();
                //System.out.println(menu.getMenu());


               // menu.setChange(false);
          //  }
          //  toogleMenu = menu.displayMenu(menu.getOptionsArrayList());






        }else {
            background(mapBackground);
            enemyMain();
            towerMain();


        }


    }


    public void loadAssets() {


        enemyImage = loadImage(assetPath + "Enemy.png");
        mapBackground = loadImage(assetPath + "testmap1.png");
        destination = createImage(enemyImage.width, enemyImage.height, ARGB);

        towerAssets();



        enemyImage.loadPixels();
        destination.loadPixels();

        for (int x = 0; x < enemyImage.width; x++) {
            for (int y = 0; y < enemyImage.height; y++) {
                int loc = x + y * enemyImage.width;
                if (brightness(enemyImage.pixels[loc]) > 50) {
                    //destination.pixels[loc] = color(255);
                    destination.pixels[loc] = color(0, 0, 0, 0);

                } else {
                    destination.pixels[loc] = color(0, 0, 0, 255);
                }
            }
        }
        destination.updatePixels();


        imagesIntoMap();
    }

    public void imagesIntoMap(){
        imageMap = new HashMap<>(){{
            put("Enemy.png",enemyImage);
            put("testmap1.png",mapBackground);
            put("stdTowerSlot.png",towerSlotImg);
            put("tower_red_t1.png",tower_red_t1);
            put("tower_red_t2.png",tower_red_t2);
            put("tower_red_t3.png",tower_red_t3);
            put("tower_green_t1.png",tower_green_t1);
            put("tower_green_t2.png",tower_green_t2);
            put("tower_green_t3.png",tower_green_t3);
        }};
    }

    public void towerAssets(){

        towerSlotImg = loadImage(assetPath + "stdTowerSlot.png");
        tower_red_t1 =  loadImage(assetPath + "tower_red_t1.png");
        tower_red_t2 =  loadImage(assetPath + "tower_red_t2.png");
        tower_red_t3 =  loadImage(assetPath + "tower_red_t3.png");
        tower_green_t1 =  loadImage(assetPath + "tower_green_t1.png");
        tower_green_t2 =  loadImage(assetPath + "tower_green_t2.png");
        tower_green_t3 = loadImage(assetPath + "tower_green_t3.png");
    }

    public void loadEnemys(int waveCount){
        enemyArrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            enemy = new Enemy(destination, 0 + (-i * 90), 0,12, this);
            enemyArrayList.add(enemy);

        }
        wave ++;
    }
    public void loadObjects() {

        for (int i = 0; i < 3; i++) {
            towerSlot = new TowerSlot(imageMap.get("stdTowerSlot.png"), 240* i, 100,300,2, 1000, this, imageMap);
            towerHashMap.put("slot" + i, towerSlot);
        }

    }
    @Override
    public void mouseReleased(){
        if(toogleMenu) {
            menu.setCanPress(true);
        }
    }


    public void enemyMovements() {
        for (Enemy enemy : enemyArrayList) {
            enemy.enemyMovePattern();
        }
    }

    public void drawTower(){
        towerSlot.draw(towerHashMap);

    }

    public void drawEnemy() {
        ArrayList<Enemy> removeEnemy = new ArrayList<>();
        for (Enemy enemy : enemyArrayList) {
            if (enemy.life > 0)
                image(enemy.getImg(), enemy.getCordX(), enemy.getCordY());
            else {
                removeEnemy.add(enemy);
            }
        }
        for (Enemy deleteEnemy : removeEnemy) {
            enemyArrayList.remove(deleteEnemy);
        }


        //towerHashMap.forEach((key,value) -> image(value.img,value.posX,value.posY));


    }

    public void checkCollisions(){
        checkCollisionTower();
    }
// checks collision with the tower/towerslots
    public void checkCollisionTower() {
        for (Map.Entry<String, Tower> entry : towerHashMap.entrySet()) {
            if((mouseX - entry.getValue().posX < 180 || mouseX - entry.getValue().posX < -50 )&&
                    (mouseY - entry.getValue().posY < 85 || mouseY - entry.getValue().posY < -50) && mousePressed
            ) {

                entry.getValue().collisionCheck(entry.getValue(), mouseX, mouseY);
            }
        }
    }

    public void keyPressed(){
       // if(keyCode == ESC){

        if(key==27) {
            key = 0;
            loadEnemys(1);
        }

       // }
    }
    public void keyReleased(){
        if(key==27) {

            //menu.displayMenu(testArrayList);
           // menu.setCanPress(true);
            toogleMenu = true;
        }
    }

    public void enemyMain(){

        drawEnemy();
        enemyMovements();


    }

    public void towerMain(){
        drawTower();
        checkCollisions();
        towerShoot();


    }


    public void towerShoot(){
        for(Map.Entry<String, Tower> tower : towerHashMap.entrySet()){
            for(Enemy enemy : enemyArrayList){

                tower.getValue().shoot(enemy);
            }
        }
    }
}
