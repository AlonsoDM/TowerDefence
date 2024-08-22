
package com.mycompany.proyecto1_poo_2023;


import java.io.Serializable;
import java.util.ArrayList;


public class Zombie extends GameEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    public enum ZombieType { // Tipos de zombies
        MELEE,
        AIRTYPE,
        MEDIUMRANGE,
        KAMIKAZE
    }
    
    ///////////////
    // Atributes //
    ///////////////
    private ZombieType type;
    
    /////////////////
    // Contructors //
    /////////////////
    public Zombie(ZombieType type, String id, int row, int col, int unlockLevel,
                  int damage,int space, int dps, String activityLog, String imagePath) {
                  super(id, row, col, unlockLevel, damage,space, dps, activityLog, imagePath);
                  this.type = type;
    }
    
    /////////////
    // Methods //
    /////////////
    public boolean zomAttack(Defenses def){ // Recibe coords de a quien quiere atacar
        
        if (def.getType() == Defenses.DefenseType.AIRTYPE && this.getType() != Zombie.ZombieType.AIRTYPE){
            return false; // Ground zombie can't attack an air defense.
        }
        if (this.getType() == Zombie.ZombieType.KAMIKAZE && def != null)
            def.setHealth(0); // Kills inmediately
        
        int damage = this.getDamage();                                      
        int dps = this.getDps();
        int finalDamage = damage * dps; // falata poner el multiplicador por nivel 
        
        if (def != null){
            int newHealth = def.getHealth() - finalDamage;
            
            if (newHealth <= 0)
                newHealth = 0;
            
            def.setHealth(newHealth);
            return true;
        }
        return false;
    }
    
    public Defenses inRangeDefense(ArrayList<Defenses> defenses) {
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

            Defenses def = DefenseBtn(newRow, newCol, defenses);
            if (isValidCell(newRow, newCol) && def != null)
                return def; 
        }

        return null; // No hay 
    }

    public Defenses inMediumRangeDefense(ArrayList<Defenses> defenses) {
        int row = this.getRow();
        int col = this.getCol();

        for (int distance = 1; distance <= 3; distance++) {
            for (int i = -distance; i <= distance; i++) {
                for (int j = -distance; j <= distance; j++) {
                    int newRow = row + i;
                    int newCol = col + j;

                    if (isValidCell(newRow, newCol)) {
                        Defenses def = DefenseBtn(newRow, newCol, defenses);
                        if (def != null) {
                            return def; // Encontramos una Defenses dentro del rango
                        }
                    }
                }
            }
        }

    return null; // No hay Defenses dentro del rango especificado.
}

    // retorna un boton, si el boton es de una defensa
    private Defenses DefenseBtn(int row, int col, ArrayList<Defenses> defenses) {
        for (Defenses defense : defenses){
            if(defense.getRow() == row && defense.getCol() == col){
                return defense;
            }
        }
        return null;
    }
    
    public Defenses ClosestDef(ArrayList<Defenses> defenseArray) { // Obtiene la defensa mas cercana de un zombie
        Defenses closestDefence = null;
        double closestDistance = Double.MAX_VALUE;

        for (Defenses defense : defenseArray) {
            int dx = defense.getRow() - this.getRow();
            int dy = defense.getCol() - this.getCol();
            double distance = Math.sqrt(dx * dx + dy * dy);

            if (distance < closestDistance) {
                closestDefence = defense;
            }
        }

        return closestDefence; // null si no hay
    }
    
    
    
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    
    public Direction pathFindingZom(Defenses closestDefence){
        int dx = closestDefence.getRow() - this.getRow();
        int dy = closestDefence.getCol() - this.getCol();

        // Compara las diferencias en las coordenadas para determinar la dirección
        if (Math.abs(dx) > Math.abs(dy)){
            if (dx > 0) {
                return Direction.DOWN; // Si dx es positivo, mueve hacia abajo
            } else {
                return Direction.UP; // Si dx es negativo, mueve hacia arriba
        }
        } else {
            if (dy > 0) {
                return Direction.RIGHT; // Si dy es positivo, mueve hacia la derecha
            } else {
                return Direction.LEFT; // Si dy es negativo, mueve hacia la izquierda
            }
        }
    }

    public ZombieType getType() {
        return type;
    }
    
    public void initActivity(){
        String str = "ZombieID: "+this.getId()+"\n"+
                     "Type: "+ this.getType()+"\n\n\n";
        this.addActivity(str);
    }
}
    


