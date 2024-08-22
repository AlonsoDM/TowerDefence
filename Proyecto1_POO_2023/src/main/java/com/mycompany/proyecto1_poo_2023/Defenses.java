
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
    public boolean defAttack(Zombie zom){
        if (zom.getType() == Zombie.ZombieType.AIRTYPE && this.getType() != Defenses.DefenseType.AIRTYPE){
            System.out.println("No puede probrecito");
            return false; // Ground def can't attack an air defense.
        }
        if (this.getType() == Defenses.DefenseType.KAMIKAZE && zom != null)
            zom.setHealth(0); // Kills inmediately
        
        int damage = this.getDamage();                                      
        int dps = this.getDps();
        int finalDamage = damage * dps; // falata poner el multiplicador por nivel 
        
        if (zom != null){
            int newHealth = zom.getHealth() - finalDamage;
            
            if (newHealth <= 0)
                newHealth = 0;
            
            zom.setHealth(newHealth);
            return true;
        }
        return false;
    }
    
    public Zombie inRangeZombie(ArrayList<Zombie> zom) {
        int row = this.getRow();
        int col = this.getCol();

        int[][] adjacentCells = {
        { -1, 0 }, // Arriba
        { 1, 0 },  // Abajo
        { 0, -1 }, // Izquierda
        { 0, 1 }   // Derecha
        };

        for (int[] offset : adjacentCells){
            int newRow = row + offset[0];
            int newCol = col + offset[1];

            Zombie zombi = ZombieBtn(newRow, newCol, zom);
            if (isValidCell(newRow, newCol) && zom != null)
                return zombi; 
        }

        return null; // No hay 
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

    public Zombie inMediumRangeZombie(ArrayList<Zombie> zombie) {
        int row = this.getRow();
        int col = this.getCol();

        for (int distance = 1; distance <= 3; distance++) {
            for (int i = -distance; i <= distance; i++) {
                for (int j = -distance; j <= distance; j++) {
                    int newRow = row + i;
                    int newCol = col + j;

                    if (isValidCell(newRow, newCol)) {
                        Zombie zom = ZombieBtn(newRow, newCol, zombie);
                        if (zom != null) {
                            return zom; // Encontramos una Defenses dentro del rango
                        }
                    }
                }
            }
        }
        return null; // No hay zombies dentro del rango especificado.
    }
    
    // retorna un boton, si el boton es de un zombie
    private Zombie ZombieBtn(int row, int col, ArrayList<Zombie> zombie) {
        for (Zombie zom : zombie){
            if(zom.getRow() == row && zom.getCol() == col){
                return zom;
            }
        }
        return null;
    }
    
    public DefenseType getType() {
        return type;
    }

    public void initActivity(){
        String str = "DefenseID: "+this.getId()+"\n"+
                     "Type: "+ this.getType()+"\n\n\n";
        this.addActivity(str);
    }

}
