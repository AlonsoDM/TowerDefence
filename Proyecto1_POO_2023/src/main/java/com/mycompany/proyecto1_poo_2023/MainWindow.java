
package com.mycompany.proyecto1_poo_2023;


import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MainWindow extends javax.swing.JFrame {
    
    ///////////////
    // Atributes //
    ///////////////      
    private ArrayList<ThreadEntity> zomThreadArray; // thread array de zombies
    private ArrayList<Zombie> genericZom; // array de zombies
    private ArrayList<Zombie> zomArray; // array de componentes zombies 
    
    private ArrayList<ThreadEntity> defThreadArray; // thread array de defenzas
    private ArrayList<Defenses> genericDef; // array de defenzas
    private ArrayList<Defenses> defenseArray; // array de componentes de defensas  
    
    private JPanel[][] boardCells = new JPanel[25][25]; // matriz
    private int level;
    GameManager manager;
    
    private int defCounter;
    
    /////////////////
    // Contructors //
    /////////////////    
    public MainWindow(int level){
        zomThreadArray = new ArrayList<ThreadEntity>();
        zomArray = new ArrayList<Zombie>();
        genericZom = new ArrayList<Zombie>();   
        defThreadArray = new ArrayList<ThreadEntity>();
        defenseArray = new ArrayList<Defenses>();
        genericDef = new ArrayList<Defenses>();
        defCounter = 1;
        this.level = level;
        
        manager = new GameManager("Alonso", level,
                                        "GAME ACTIVITY: \n\n", this); 
        manager.levelUp();
        System.out.println(""+ manager.getTotalZomSpaces());
        
        initComponents();
        board(); // Inicializa el tablero de juego
        mainPanel.setPreferredSize(new Dimension(625, 625));
        pack();
        
        // Llama a un método para cargar los objetos Zombie y Defenses desde la carpeta "Zombies" y "Defenses".
        loadZombiesFromFolder("Zombies");
        loadDefensesFromFolder("Defenses");
        loadDefComponents();
        lblLevel.setText(""+ manager.getCurrentLevel());
    }

    /////////////
    // Methods //
    ///////////// 
    
    public ArrayList<Defenses> getDefenseArray() { 
        return defenseArray;
    }

    public ArrayList<Zombie> getZomArray() {
        return zomArray;
    }

    private void loadZombiesFromFolder(String folderPath) {
        File folder = new File(folderPath);
        
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".ser")) {
                        // Llama a tu método para deserializar el objeto desde el archivo.
                        Zombie zombie = (Zombie) FileManager.readObject(file.getAbsolutePath());
                        
                        if (zombie != null) {
                            // Agrega el objeto Zombie a tu ArrayList.
                            genericZom.add(zombie);
                        }                       
                    }
                }
            }
        }
    }
    
    private void loadDefensesFromFolder(String folderPath) {
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".ser")) {
                        // Llama a tu método para deserializar el objeto desde el archivo.
                        Defenses defense = (Defenses) FileManager.readObject(file.getAbsolutePath());
                        if (defense != null) {
                            // Agrega el objeto Zombie a tu ArrayList.
                            genericDef.add(defense);
                        }                       
                    }
                }
            }
        }
    }
    
    private void loadDefComponents(){
        // Recorre el ArrayList y agrega los IDs al JComboBox
        for (Defenses defense : genericDef) {
            defTypeComboBox.addItem(defense.getId());
        }
    }
    
    public ArrayList<Zombie> getGenericZom() {
        return genericZom;
    }

    public ArrayList<Defenses> getGenericDef() {
        return genericDef;
    }
    
    public JPanel[][] getBoardCells() {
        return boardCells;
    }

    private void board(){  // Genera el tablero
        mainPanel.setLayout(new GridLayout(25, 25)); // Crear grid
        
        for(int i = 0; i < 25; i++){ // Matriz 25x25
            for(int j = 0; j<25; j++){
                JPanel cell = new JPanel();
                cell.setLayout(new GridLayout(1,1));
                
                // Establecer el relleno rojo para las celdas en el borde del tablero
                if ((i >= 0 && i <= 2) || (i >= 22 && i <= 24) || (j >= 0 && j <= 2) || (j >= 22 && j <= 24)) 
                    cell.setBackground(Color.PINK);
                            
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                boardCells[i][j] = cell;
                mainPanel.add(cell);
            }
        }
    }
    
    public void stopThreads(){
        for (int i = 0; i < zomThreadArray.size(); i++) {
            ThreadEntity zt = zomThreadArray.get(i);
            zt.stopthread();            
        }
        for (int i = 0; i < defThreadArray.size(); i++) {
            ThreadEntity dt = defThreadArray.get(i);
            dt.stopthread();            
        }
    }
    
//    public void resetBoard(){
//        stopThreads();
//        
//        // Clear existing state
//        zomArray.clear();
//        defenseArray.clear();
//        zomThreadArray.clear();
//        defThreadArray.clear();
//
//        for (int i = 0; i < 25; i++) {
//            for (int j = 0; j < 25; j++) {
//                boardCells[i][j].removeAll();
//            }
//        }
//
//        for (int i = 0; i < 25; i++) {
//            for (int j = 0; j < 25; j++) {
//                boardCells[i][j].revalidate();
//                boardCells[i][j].repaint();
//            }
//        }
//
//        // Create a new GameManager with an incremented level
//        manager = new GameManager("Alonso", manager.getCurrentLevel(), "GAME ACTIVITY: \n\n", this);
//
//        loadZombiesFromFolder("Zombies");
//        loadDefensesFromFolder("Defenses");
//
//        // Reset combo boxes or other UI elements
//        rowComboBox.setSelectedIndex(0);
//        colComboBox.setSelectedIndex(0);
//        defTypeComboBox.setSelectedIndex(0);
//
//        // Clear any error messages
//        errorLbl.setText(" ");
//        errorLbl.setVisible(false);
//        int currentLevel = manager.getCurrentLevel();
//        lblLevel.setText(String.valueOf(currentLevel));
//        btnStart.setEnabled(true);
//        addDefBtn.setEnabled(true);
//    }
    
    public void changeIcon(String path, JButton btn){ //Coloca la imagen que se necesita
        ImageIcon image = new ImageIcon(path);
        Image ogImage = image.getImage();
        Image scaledImage = ogImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        btn.setIcon(scaledIcon);
    }
    
    public boolean isCellOcupied(int row, int col){ //Pregunta si la celda esta ocupada
        Component[] components = boardCells[row][col].getComponents();
        
        for (Component component : components) {
            if (component instanceof JButton) {
                return true; // Cell is occupied by a button
            }
        }
        
        return false; // Cell is not occupied    
    }
    
    public int[] getSpawnCoords(){ // Coordenadas de spawn para zombies
        int colOrRow = (new Random()).nextInt(2);//0: col  1: filas
        int dir = (new Random()).nextInt(2);//0: primera  1: segunda
        int row, col;
            if (colOrRow == 0){
                if (dir == 0){
                    do{ // Asegura que no hay overlap de zombies
                        row = (new Random()).nextInt(25);
                        col = (new Random()).nextInt(3);
                    }while (isCellOcupied(row, col));     
                }else{
                    do{ // Asegura que no hay overlap de zombies
                        row = (new Random()).nextInt(25);
                        col = (new Random()).nextInt(22, 25);
                    }while (isCellOcupied(row, col));                      

                }
            }else{
                if (dir == 0){
                    do{ // Asegura que no hay overlap de zombies
                    row = col = (new Random()).nextInt(3);
                    col = (new Random()).nextInt(25);
                    }while (isCellOcupied(row, col));                       
                }else{   
                    do{ // Asegura que no hay overlap de zombies
                    row = (new Random()).nextInt(22, 25);
                    col = (new Random()).nextInt(25);
                    }while (isCellOcupied(row, col));                       
                }
            }

        int[] result = {row, col};
        return result;    
    }
    
    private Zombie findZombieByButton(JButton button) {
        for (Zombie zombie : zomArray) {
            if (zombie.getButton() == button) {
                return zombie;
            }
        }
        return null;
    }

    private Defenses findDefenseByButton(JButton button) {
        for (Defenses def : defenseArray) {
            if (def.getButton() == button) {
                return def;
            }
        }
        return null;
    }

    public Defenses buscarNexus(){
        for (Defenses defense : defenseArray) {          
            if (defense.getType() == Defenses.DefenseType.NEXUS){
               return defense; 
            }
        }
            return null;
    }    

    public int getZomEspaciosDisponibles(){
        return manager.getTotalZomSpaces();
    }
    
    public int getDefEspaciosDisponibles(){
        return manager.getTotalDefSpaces();
    }
    
    public int getEspacioOcupadoDefensas(){
        int resultado = 0;
        for (int i = 0; i < defenseArray.size();i++)
            resultado += defenseArray.get(i).getSpace();
        return resultado;
    }
        
    private void genZombies(){ // Genera zombies aleatoriamente
        int camposOcupados = 0;
        Random rand = new Random();
        int count = 1;
        
        while(camposOcupados < getZomEspaciosDisponibles()) {
            
            JButton btn = new JButton(); // Inicializa un btn
            
            Random random = new Random();
            int randomIndex = random.nextInt(genericZom.size());
            Zombie randGenericZombie = genericZom.get(randomIndex);
            
            if (manager.getCurrentLevel() >= randGenericZombie.getUnlockLevel()){
                int camposZombie = randGenericZombie.getSpace();
                
                if (camposOcupados + camposZombie <= getZomEspaciosDisponibles()){
                    int[] spawn = getSpawnCoords(); // Obtener coords con espacio libre
                    int row = spawn[0];
                    int col = spawn[1];
                    Zombie zombie = new Zombie(randGenericZombie.getType(), randGenericZombie.getId()+ String.valueOf(count), row, col,
                                      randGenericZombie.getUnlockLevel(), randGenericZombie.getDamage(), 
                                          randGenericZombie.getSpace(), randGenericZombie.getDps(), "", 
                                       randGenericZombie.getImagePath());

                    zombie.initActivity(); // Inicia el activitylog
                    changeIcon(zombie.getImagePath(), btn);
                    zomArray.add(zombie); // Lo agrega en el array de zombies
                    zombie.setButton(btn); // Enlaza el objeto al boton
            
                // Create thread
                ThreadEntity te = new ThreadEntity(zombie, this);
                zomThreadArray.add(te); // Se agrega el thread al array                 
            
                btn.setLayout(null);
                btn.setBounds(0, 0, boardCells[row][col].getWidth(), boardCells[row][col].getHeight());

                boardCells[row][col].add(btn); 

                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton clickedButton = (JButton) e.getSource();

                        // Zombie correspondiente al botón
                        Zombie clickedZombie = findZombieByButton(clickedButton);

                        if (clickedZombie != null) {
                            // activity log del Zombie se agrega al jTextArea1
                            String activityLog = clickedZombie.getActivityLog();
                            activityText.setText(activityLog);
                        }
                    }
                });
                camposOcupados += zombie.getSpace();
                count++;
            }            
            
        }
        }
    }
    
    private void genDefence(String defType, int row, int col){ // Genera defenza donde el usuario desea colocarla
        int espaciosocupados= getEspacioOcupadoDefensas();
        errorLbl.setVisible(false);  
        
        if (isCellOcupied(row, col)){
            errorLbl.setVisible(true);
            errorLbl.setText("Error: Defence can't be placed here");
            errorLbl.setForeground(Color.red);
            return;
        };  
        
        JButton btn = new JButton();  
        Defenses genericDefense = null; 
        
        for (Defenses genDefense : genericDef) {
            if (genDefense.getId() == defType){
                genericDefense = genDefense;
            }
        }
        
        
        if ((espaciosocupados + genericDefense.getSpace()<= getDefEspaciosDisponibles())
                && genericDefense.getUnlockLevel()<=manager.getCurrentLevel()){
            
            //genericDefense.getImagePath()
            Defenses defense = new Defenses(genericDefense.getType(), genericDefense.getId()+ String.valueOf(defCounter), 
                                            row, col, genericDefense.getUnlockLevel(), genericDefense.getDamage(), 
                                        genericDefense.getSpace(), genericDefense.getDps(), "", genericDefense.getImagePath());
            defense.initActivity();// Inicia el activitylog
            defenseArray.add(defense); // Lo agrega en el array de defensas
            defense.setButton(btn);
            changeIcon(defense.getImagePath(), btn);
            // Create thread
            ThreadEntity te = new ThreadEntity(defense, this);
            defThreadArray.add(te); // Se agrega el thread al array

            JPanel cell = boardCells[row][col];

            btn.setLayout(null);
            btn.setBounds(0, 0, boardCells[row][col].getWidth(), boardCells[row][col].getHeight());

            boardCells[row][col].add(btn);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();

                    // Zombie correspondiente al botón
                    Defenses clickedDefense = findDefenseByButton(clickedButton);

                    if (clickedDefense != null) {
                        // activity log del Zombie se agrega al jTextArea1
                        String activityLog = clickedDefense.getActivityLog();
                        activityText.setText(activityLog);
                    }
                }
            });
        
            cell.repaint();
        }
        else{
            JOptionPane.showMessageDialog(this, "This defense does not fit in the space provided for your army", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
             
    public int[] findPos(JButton btn){
        // Find the current position of the button in the boardCells array
        int[] position = {-1, -1};

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if (boardCells[i][j].getComponentCount() > 0) {
                    Component component = boardCells[i][j].getComponent(0);
                    if (component instanceof JButton && component.equals(btn)) {
                        position[0] = i;
                        position[1] = j;
                        return position;
                    }
                }
            }
        }    
        
        return position;
    }
    
    private boolean removeBtn(JButton btn){
        int[] pos = findPos(btn);
        
        if (!Arrays.equals(pos, new int[]{-1, -1})){
            boardCells[pos[0]][pos[1]].remove(btn);
            return true;
        }    
        return false;
    }
    
    private boolean removeDefense(Defenses defToRemove){
        int index = defenseArray.indexOf(defToRemove);

        if (index >= 0) {
            defenseArray.remove(index);
            return true;
        } 
        return false;
    }

    private boolean removeZombie(Zombie zomToRemove){
        int index = zomArray.indexOf(zomToRemove);

        if (index >= 0) {
            zomArray.remove(index);
            return true;
        } 
        return false;
    }
        
    private int[] newZomPos(int row, int col, Zombie.Direction dir, Zombie.ZombieType zomType){
           int newRow = row; 
           int newCol = col;
           
        switch (dir){ // Determina donde ir y valida overlap
            case UP:
                if (!isCellOcupied(row-1, col)){
                    newRow--;
                } 
                break;

            case DOWN:
                if (!isCellOcupied(row+1, col)){
                    newRow++;
                }                  
                break;

            case RIGHT:
                if (!isCellOcupied(row+1, col+1)){
                    newCol++;
                }                
                break; 

            case LEFT:
                if (!isCellOcupied(row, col-1));{
                    newCol--;
                }                
                break;
        }            

        return new int[]{newRow, newCol};
    }
    
    public void moveBtn (Zombie zom){ // Mueve el boton de forma aleatoria (solo deberia mover zombies)
        
        Defenses closestDef = zom.ClosestDef(defenseArray); // Objeto defensa mas cercano
        if (closestDef == null){
            stopThreads();
            return;
        }
        Zombie.Direction dir = zom.pathFindingZom(closestDef); // Donde ir        
        Zombie.ZombieType zomType = zom.getType(); //Obtiene el tipo de zombie
        JButton btn = zom.getButton(); // Obtiene el boton donde esta el objeto        
        int row = zom.getRow();
        int col = zom.getCol();
        
        int newRow, newCol;
        int[] newZomPos = newZomPos(row, col, dir, zomType);   
        newRow = newZomPos[0];
        newCol = newZomPos[1];
        
        if (newCol == col && newRow == row){ //Choco con otro zombie
            String str = zom.getId()+": Can't move, there's a fellow zombie ahead.";
            zom.addActivity(str);
            manager.addActivity(str);
            return;
        }
        
        if (isCellOcupied(newRow, newCol)) // Arregla los tiempos de thread NO TOCAR
            return;
        
        // actualiza las posiciones del zombie
        zom.setRow(newRow);
        zom.setCol(newCol);
        
        int[] pos = findPos(btn);
        removeBtn(btn);
        boardCells[newRow][newCol].add(btn); // Coloca en nueva posicion
        
       
        // Revalidate and repaint the container to update the UI
        boardCells[pos[0]][pos[1]].revalidate();
        boardCells[newRow][newCol].revalidate();
        boardCells[pos[0]][pos[1]].repaint();
        boardCells[newRow][newCol].repaint();
        
        manager.aLzomMoved(zom, newRow, newCol);
    }

    public void zomEvents(Zombie zom){
        //Hay defensas alrededor? - si es tipo de rango alrededor de 3 unidades
        Zombie.ZombieType zomType = zom.getType();
        Defenses defInRange;
        
        if (zomType == Zombie.ZombieType.MEDIUMRANGE){
            defInRange = zom.inMediumRangeDefense(defenseArray);
        }
        else
            defInRange = zom.inRangeDefense(defenseArray);
        
        if (defInRange != null){
            int hp = defInRange.getHealth();
            // Si hay, ataquela.
            boolean attack = zom.zomAttack(defInRange);
            
            if (attack == false)
                return;
            
            int newHp = defInRange.getHealth();
            manager.aLZomAttack(defInRange, zom, hp, newHp); //ActivityLog
            
            if (newHp <= 0){ // Murio?
                JButton btn = defInRange.getBtn();
                int[] pos = findPos(btn);
                removeBtn(btn);
                // Revalidate and repaint the container to update the UI
                boardCells[pos[0]][pos[1]].revalidate();
                boardCells[pos[0]][pos[1]].repaint();
                
                manager.aLDefenseDeath(defInRange, zom); //ActivityLog
                
                // Remove object from array
                removeDefense(defInRange);
            }
        }else{
            // Si no hay, llame al metodo moveBtn.
            moveBtn(zom);
        }
       
    }

    public void defEvents(Defenses def){
        //Hay defensas alrededor? - si es tipo de rango alrededor de 3 unidades
        Defenses.DefenseType defType = def.getType();
        Zombie zomInRange;
        
        if (defType == Defenses.DefenseType.MEDIUMRANGE){
            zomInRange = def.inMediumRangeZombie(zomArray);
        }
        else
            zomInRange = def.inRangeZombie(zomArray);
        
        if (zomInRange != null){
            int hp = zomInRange.getHealth();
            // Si hay, ataquela.
            boolean attack = def.defAttack(zomInRange);
            
            if (attack == false)
                return;
            
            int newHp = zomInRange.getHealth();
            manager.aLDefAttack(def, zomInRange, hp, newHp); //ActivityLog
            
            if (newHp <= 0){ // Murio?
                JButton btn = zomInRange.getBtn();
                int[] pos = findPos(btn);
                removeBtn(btn);
                // Revalidate and repaint the container to update the UI
                boardCells[pos[0]][pos[1]].revalidate();
                boardCells[pos[0]][pos[1]].repaint();
                
                manager.aLZomDeath(def, zomInRange); //ActivityLog
                
                // Remove object from array
                removeZombie(zomInRange);
            }
        } 
    }
    
    public boolean validacionNexus(){ // true si hay nexus vivo
        if (buscarNexus()==null)
           return false;
        else{
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        addDefBtn = new javax.swing.JButton();
        rowLbl = new javax.swing.JLabel();
        colLbl = new javax.swing.JLabel();
        rowComboBox = new javax.swing.JComboBox<>();
        colComboBox = new javax.swing.JComboBox<>();
        defTypeComboBox = new javax.swing.JComboBox<>();
        errorLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        activityText = new javax.swing.JTextArea();
        lblActivity = new javax.swing.JLabel();
        lblDefPicking = new javax.swing.JLabel();
        btnAllActivity = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        btnSaveGame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        addDefBtn.setText("Add");
        addDefBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDefBtnActionPerformed(evt);
            }
        });

        rowLbl.setText("Row:");

        colLbl.setText("Column:");

        rowComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));

        colComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));

        defTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defTypeComboBoxActionPerformed(evt);
            }
        });

        errorLbl.setText(" ");

        activityText.setEditable(false);
        activityText.setColumns(20);
        activityText.setRows(5);
        jScrollPane1.setViewportView(activityText);

        lblActivity.setText("Activity:");

        lblDefPicking.setText("Choose a defense:");

        btnAllActivity.setText("All activity");
        btnAllActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActivityActionPerformed(evt);
            }
        });

        jLabel1.setText("Level:");

        btnSaveGame.setText("Save Game");
        btnSaveGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addComponent(errorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDefPicking)
                                    .addComponent(colLbl)
                                    .addComponent(rowLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rowComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(colComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53)
                                                .addComponent(addDefBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(defTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(69, 69, 69)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblLevel)))
                                .addGap(31, 31, 31)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSaveGame, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblActivity)
                            .addGap(122, 122, 122)
                            .addComponent(btnAllActivity))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(defTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDefPicking)
                            .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(lblLevel)
                            .addComponent(btnSaveGame, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rowLbl)
                            .addComponent(rowComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(colLbl)
                            .addComponent(colComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblActivity)
                            .addComponent(btnAllActivity)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addDefBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(errorLbl)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private CountDownLatch startSignal = new CountDownLatch(1);   
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed

        
        if (validacionNexus() == false){
           JOptionPane.showMessageDialog(this, "Cannot start the game without a Nexus. Please place a Nexus first.", "Error", JOptionPane.ERROR_MESSAGE);
           return;
        }
        
        btnStart.setEnabled(false);
        addDefBtn.setEnabled(false);
        
        genZombies(); // Spawn de zombies
        ThreadGameManager gamewin = new ThreadGameManager(this,manager);
        gamewin.start();
        
        // Iniciar todos los hilos de zombies
        for (ThreadEntity zombieThread : zomThreadArray) {
            zombieThread.setStartSignal(startSignal);
            zombieThread.start();
        }
        // Iniciar todos los hilos de defensa
        for (ThreadEntity defensaThread : defThreadArray) {
            defensaThread.setStartSignal(startSignal);
            defensaThread.start();
        }  
        
        // Desbloquear todos los hilos al mismo tiempo
        startSignal.countDown();
    }//GEN-LAST:event_btnStartActionPerformed

    private void addDefBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDefBtnActionPerformed
        int row = Integer.valueOf(rowComboBox.getSelectedItem().toString());
        int col = Integer.valueOf(colComboBox.getSelectedItem().toString());
        
        String strDefType = defTypeComboBox.getSelectedItem().toString();
        genDefence(strDefType, row, col);       
    }//GEN-LAST:event_addDefBtnActionPerformed

    private void defTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defTypeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_defTypeComboBoxActionPerformed

    private void btnAllActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActivityActionPerformed
        String activityLog = manager.getAllActivityLog();
        activityText.setText(activityLog);
    }//GEN-LAST:event_btnAllActivityActionPerformed

    private void btnSaveGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveGameActionPerformed
        JFileChooser file = new JFileChooser();
        int returnValue = file.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = file.getSelectedFile();            
            int level = manager.getCurrentLevel(); // Obten el nivel como un entero

            FileManager.saveIntToFile(level, selectedFile.getAbsolutePath());
        }
    }//GEN-LAST:event_btnSaveGameActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea activityText;
    private javax.swing.JButton addDefBtn;
    private javax.swing.JButton btnAllActivity;
    private javax.swing.JButton btnSaveGame;
    private javax.swing.JButton btnStart;
    private javax.swing.JComboBox<String> colComboBox;
    private javax.swing.JLabel colLbl;
    private javax.swing.JComboBox<String> defTypeComboBox;
    private javax.swing.JLabel errorLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblActivity;
    private javax.swing.JLabel lblDefPicking;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JPanel mainPanel;
    public static javax.swing.JComboBox<String> rowComboBox;
    private javax.swing.JLabel rowLbl;
    // End of variables declaration//GEN-END:variables
}
