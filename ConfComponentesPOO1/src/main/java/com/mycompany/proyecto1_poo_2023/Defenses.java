
package com.mycompany.proyecto1_poo_2023;

import java.io.Serializable;
import java.util.ArrayList;


public class Defenses extends GameEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    public enum DefenseType {
        MELEE,
        AIRTYPE,
        MEDIUMRANGE,
        KAMIKAZE,
        WALL,
        NEXUS
    }
    
    ///////////////
    // Atributes //
    ///////////////
    private DefenseType type; // Tipo de defenza
    
    /////////////////
    // Contructors //
    /////////////////
    public Defenses(DefenseType type, String id, int row, int col, int unlockLevel,
        int damage,int space, int dps, String activityLog, String imagePath) {
        
        super(id, row, col, unlockLevel, damage, space, dps, activityLog, imagePath);       
        this.type = type;
    }
    
    /////////////
    // Methods //
    /////////////    
    public void defAttack(int row, int col, ArrayList<Zombie> zombies){
        int damage = this.getDamage();
        int dps = this.getDps();
        int finalDamage = damage * dps;
        
        Zombie zombie = null;
        
        for (Zombie zom : zombies) {
            if (zom.getRow() == row && zom.getCol() == col){
                zombie = zom;
                break;
            }
        }
        if (zombie != null){
            int newHealth = zombie.getHealth();
            newHealth -= finalDamage;
            zombie.setHealth(newHealth);        
        }
    }
    
    public int[] getNearbyZombie(Defenses def, ArrayList<Zombie> zombies) {
        int row = def.getRow();
        int col = def.getCol();
        
        int[][] adjacentCells = {
        { -1, 0 }, // Arriba
        { 1, 0 },  // Abajo
        { 0, -1 }, // Izquierda
        { 0, 1 }   // Derecha
        };
       
        for (int[] offset : adjacentCells){
            int newRow = row + offset[0];
            int newCol = col + offset[1];
            
            if (isValidCell(newRow, newCol) && isZomBtn(newRow, newCol, zombies))
                return new int[]{newRow, newCol}; 
        }
        
        return new int[]{-1,-1}; // No hay 
    }
    
    // Verifica si el boton es de un zombie
    private boolean  isZomBtn(int row, int col, ArrayList<Zombie> zombies) {
        for (Zombie zom : zombies){
            if(zom.getRow() == row && zom.getCol() == col){
                return true;
            }
        }
        return false;
    }
    
    public DefenseType getType() {
        return type;
    }

    

}
