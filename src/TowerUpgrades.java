    enum TowerUpgrades {
        Level0("stdTowerSlot.png"),
        Level1("tower_red_t1.png"),
        Level2("tower_red_t2.png"),
        Level3("tower_red_t3.png"),
        Level4("tower_green_t1.png"),
        Level5("tower_green_t2.png"),
        Level6("tower_green_t3.png");

private String action;

public String getAction(){
    return this.action;
}

    TowerUpgrades(String action){
    this.action = action;

    }

}

