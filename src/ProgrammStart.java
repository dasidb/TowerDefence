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
    Enemy enemy;
    TowerSlot towerSlot;
    Menu menu;
    String assetPath = "\\Assets\\";
    boolean toogleMenu = true;
    ArrayList<MenuOptions> testArrayList;
    boolean canPress = true;
    int wave = 1;

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
        towerSlotImg = loadImage(assetPath + "stdTowerSlot.png");
        destination = createImage(enemyImage.width, enemyImage.height, ARGB);

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

    }

    public void loadEnemys(int waveCount){
        enemyArrayList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            enemy = new Enemy(destination, 0 + (-i * 90), 0,waveCount);
            enemyArrayList.add(enemy);

        }
        wave ++;
    }
    public void loadObjects() {

        for (int i = 0; i < 3; i++) {
            towerSlot = new TowerSlot(towerSlotImg, 240* i, 100);
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

    public void drawEnemy() {
        for (Enemy enemy : enemyArrayList) {
            if(enemy.life != 0 )
            image(enemy.getImg(), enemy.getCordX(), enemy.getCordY());
        }

        //towerHashMap.forEach((key,value) -> image(value.img,value.posX,value.posY));
        for (Map.Entry<String, Tower> entry : towerHashMap.entrySet()) {



            image(entry.getValue().img, entry.getValue().posX, entry.getValue().posY);
        }

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
        checkCollisions();
    }
}
