
package com.mycompany.proyecto1_poo_2023;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadEntity extends Thread{
    
    ///////////////
    // Atributes //
    ///////////////
    private GameEntity entity;
    private MainWindow refWindow;
    private CountDownLatch startSignal;

    boolean isRunning = true;
    
    /////////////////
    // Contructors //
    /////////////////
    
    public ThreadEntity(GameEntity entity, MainWindow refWindow){
        this.entity = entity;
        this.refWindow = refWindow;
        this.startSignal = startSignal;
    }
    
    public GameEntity getEntity(){
        return entity;
    }
    
    /////////////
    // Methods //
    /////////////  
    public void stopthread(){
        isRunning=false;
    }
    
    public void setStartSignal(CountDownLatch startSignal) {
        this.startSignal = startSignal;
    }
        
    @Override
    public void run(){
        
        while(isRunning){
            
            try{
                //determina x y y entity.move()
                // distance [row, col]
                startSignal.await();
                
                if (entity instanceof Zombie)
                refWindow.zomEvents((Zombie) entity);
                else
                refWindow.defEvents((Defenses) entity);
                
                sleep(2000);
            } catch(InterruptedException ex){
            }catch(ArrayIndexOutOfBoundsException ex2){
              
            }
        }
    }
}
