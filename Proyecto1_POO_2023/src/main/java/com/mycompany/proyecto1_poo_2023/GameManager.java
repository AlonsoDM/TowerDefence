
package com.mycompany.proyecto1_poo_2023;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class GameManager {
    
    ///////////////
    // Atributes //
    ///////////////
    private String userName;
    private int currentLevel;
    private int totalZomSpaces; 
    private int totalDefSpaces;
    private String allActivityLog;
    private MainWindow gameWindow;
    
    /////////////////
    // Contructors //
    /////////////////
    public GameManager(String userName, int currentLevel, String allActivityLog, MainWindow boardWindow) {
        this.userName = userName;
        this.currentLevel = currentLevel;
        this.totalZomSpaces = 15 + 5 * currentLevel; // +7 espacios por nivel
        this.totalDefSpaces = 15 + 5 * currentLevel; // +5 espacios por nivel
        this.allActivityLog = allActivityLog;
        this.gameWindow = boardWindow;
    }
    public GameManager(){
        this.userName = "";
        this.currentLevel = 1;
        this.totalZomSpaces = 15 + 5 * currentLevel; // +5 espacios por nivel
        this.totalDefSpaces = 15 + 5 * currentLevel; // +5 espacios por nivel
        this.allActivityLog = "";
    }
    
    /////////////
    // Methods //
    /////////////   
    

     
    
    // Verifica si el boton es de un zombie
    private boolean  isZomBtn(int row, int col, ArrayList<Zombie> zombies) {
        for (Zombie zom : zombies){
            if(zom.getRow() == row && zom.getCol() == col){
                return true;
            }
        }
        return false;
    }

    public String getAllActivityLog() {
        return allActivityLog;
    }
    
    
    public String getUserName() {
        return userName;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }
    
    public int getTotalZomSpaces() {
        return totalZomSpaces;
    }
    
    public int getTotalDefSpaces() {
        return totalDefSpaces;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void addActivity(String activity) {
        if (allActivityLog == null) {
            allActivityLog = activity;
        } else {
            allActivityLog += "\n" + activity;
        }
    }

    public void setTotalDefSpaces(int totalDefSpaces) {
        this.totalDefSpaces = totalDefSpaces;
    }
    
    public void updateSpaces(int currentLevel){
        totalZomSpaces= 15 + 5*currentLevel;
        totalDefSpaces= 15 + 5 * currentLevel;
    }
    
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;

    }
    
    public void aLzomMoved(Zombie zom, int i, int j){
        String str = zom.getId()+": Moved to Row " + i + ", Column " + j;
        zom.addActivity(str);
        this.addActivity(str);
    }
    
    public void aLZomAttack(Defenses def, Zombie zom, int health, int newHealth){
        String str = def.getId()+": got hit by " + zom.getId() + " went from " + health + " to "+ newHealth;
        String str2 = zom.getId()+ ": attacked " + def.getId();
        
        zom.addActivity(str2);
        this.addActivity(str2);        
        def.addActivity(str);
        this.addActivity(str);
    }

    public void aLDefAttack(Defenses def, Zombie zom, int health, int newHealth){
        String str = def.getId()+": attacked " + zom.getId();
        String str2 = zom.getId() + ": got hit by " + def.getId() + "went from " + health + " to "+ newHealth;
        
        def.addActivity(str);
        this.addActivity(str);
        zom.addActivity(str2);
        this.addActivity(str2);
    }
    
    public void aLDefenseDeath(Defenses def, Zombie zom){
        String str = def.getId()+": Was killed by " + zom.getId();
        String str2 = zom.getId()+ ": killed " + def.getId();
        
        def.addActivity(str);
        this.addActivity(str);
        zom.addActivity(str2);
        this.addActivity(str2);
    }

    public void aLZomDeath(Defenses def, Zombie zom){
        String str = zom.getId()+": Was killed by " + def.getId();
        String str2 = def.getId()+ ": killed " + zom.getId();
        
        zom.addActivity(str2);
        this.addActivity(str2);        
        def.addActivity(str);
        this.addActivity(str);
    }    

        public void gameWin() {
        ContinueGameWin nextlvl = new ContinueGameWin(gameWindow,this);
        nextlvl.setVisible(true);
        gameWindow.setVisible(false);
    }
        
    public void gameLoss() {
        //gameWindow.stopThreads();
        gameWindow.dispose();
        ContinueGameLoss continuar= new ContinueGameLoss(gameWindow,this);
        continuar.setVisible(true);
//        gameWindow.setVisible(false);

    }
    public void levelUp(){
        
        for (int i = 0; i < this.currentLevel; i++) {
            updateZombieAttributes();
            updateDefenseAttributes();
        }
        updateSpaces(this.currentLevel);
    }
    
    public void updateZombieAttributes() {
        
        for (int i = 0; i < gameWindow.getGenericZom().size() ; i++){
            gameWindow.getGenericZom().get(i);
            Zombie zom = gameWindow.getGenericZom().get(i);
        
        int newHealth = zom.getHealth();
        int newDamage = zom.getDamage();

        // Randomly increase health and damage between 5% and 20%
        Random random = new Random();
        double healthIncreasePercentage = 0.05 + (0.15 * random.nextDouble()); // 5% to 20%
        double damageIncreasePercentage = 0.05 + (0.15 * random.nextDouble()); // 5% to 20%

        newHealth = (int) Math.ceil(newHealth * (1 + healthIncreasePercentage));
        newDamage = (int) Math.ceil(newDamage * (1 + damageIncreasePercentage));

        // Update zombie attributes
        zom.setHealth(newHealth);
        zom.setDamage(newDamage);
    }
    }
    
    
    
    public void updateDefenseAttributes() {
        for (int i = 0; i < gameWindow.getGenericDef().size() ; i++){
            gameWindow.getGenericDef().get(i);
            Defenses def = gameWindow.getGenericDef().get(i);
        
        int newHealth = def.getHealth();
        int newDamage = def.getDamage();

        // Randomly increase health and damage between 5% and 20%
        Random random = new Random();
        double healthIncreasePercentage = 0.05 + (0.15 * random.nextDouble()); // 5% to 20%
        double damageIncreasePercentage = 0.05 + (0.15 * random.nextDouble()); // 5% to 20%

        newHealth = (int) Math.ceil(newHealth * (1 + healthIncreasePercentage));
        newDamage = (int) Math.ceil(newDamage * (1 + damageIncreasePercentage));

        // Update zombie attributes
        def.setHealth(newHealth);
        def.setDamage(newDamage);
    }
    }
}
