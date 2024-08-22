
package com.mycompany.proyecto1_poo_2023;

import java.io.Serializable;
import javax.swing.JButton;



public abstract class GameEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    ///////////////
    // Atributes //
    ///////////////
    private String id; // Identificador de la entidad
    private int row; // Posicion en x
    private int col; // Posicion en y
    private int unlockLevel; // Nivel donde aparece
    private int health = 100; 
    private int damage; // Dano que hace por cada golpe
    private int space; // Cuantos golpes hace cada vez que ataca
    private int dps; // Cuantas veces ataca por segundo
    private String activityLog; // Actividad de la entidad durante el juego
    private String imagePath;
    JButton btn;
    
    /////////////////
    // Contructors //
    /////////////////
    public GameEntity(String id, int row, int col, int unlockLevel, int damage, int space, 
                     int dps, String activityLog, String imagePath) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.unlockLevel = unlockLevel;
        this.damage = damage;
        this.space = space;
        this.dps = dps;
        this.activityLog = activityLog;
        this.imagePath = imagePath;
    }    
    
    /////////////
    // Methods //
    /////////////
    
    // Verifica si una celda está dentro de los límites del tablero   
    public boolean isValidCell(int row, int col) {
        return row >= 0 && row < 25 && col >= 0 && col < 25;
    }
    
    public void death(){
        this.health = 0;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
    


    public JButton getButton() {
        return btn; 
    }

    public String getActivityLog() {
        return activityLog;
    }
    
    public void setButton(JButton btn){
        this.btn = btn;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getId() {
        return id;
    }

    public int getUnlockLevel() {
        return unlockLevel;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpace() {
        return space;
    }

    public int getDps() {
        return dps;
    }

    public String getImagePath() {
        return imagePath;
    }

    public JButton getBtn() {
        return btn;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUnlockLevel(int unlockLevel) {
        this.unlockLevel = unlockLevel;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    public void setActivityLog(String activityLog) {
        this.activityLog = activityLog;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setBtn(JButton btn) {
        this.btn = btn;
    }
    
    
}
