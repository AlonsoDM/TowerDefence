
package com.mycompany.proyecto1_poo_2023;

/**
 *
 * @author pavel
 */
public class ThreadGameManager extends Thread{
    ///////////////
    // Atributes //
    ///////////////
    
    MainWindow refWindow;
    GameManager manager;

    boolean isRunning = true;
    
    /////////////////
    // Contructors //
    /////////////////
    
    public ThreadGameManager(MainWindow refWindow, GameManager manager){
        
        this.refWindow = refWindow;
        this.manager = manager;
    }
    
    @Override
     public void run(){
        while (isRunning){
            
            if ((refWindow.buscarNexus() == null) || (refWindow.buscarNexus().getHealth()<= 0)){
                manager.gameLoss();
                isRunning = !isRunning;
            }
            boolean zombiesMuertos = true;
            for (int i = 0; i < refWindow.getZomArray().size(); i++) 
                if (refWindow.getZomArray().get(i).getHealth() > 0) 
                    zombiesMuertos = false;
                
            if (zombiesMuertos){
                manager.gameWin();
                isRunning = !isRunning;
            }
            try {
                sleep(100);
            } catch (InterruptedException ex){
                
            }
            
        }
    }
}
