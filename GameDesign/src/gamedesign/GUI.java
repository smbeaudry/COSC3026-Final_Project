/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamedesign;

import java.util.Random;

/**
 *
 * @author The team
 */
public class GUI extends javax.swing.JFrame {
    
    public static Room[][] map;
    public static Random randNumber;
    public static long seed;
    
    /**
     * Creates new form GUI
     * 
     * Place code for managing the board here.
     */
    public GUI() {
        initComponents();
        
        //<label>.setIcon(new javax.swing.ImageIcon(getClass().getResource("./gamedesign/assets/dun_wall_0.png")));
        shuffleMap(1, "test");
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] != null){
                    System.out.print(map[i][j] + "\t");
                } else {
                    System.out.print("   \t");
                }
            }
            System.out.println();
        }
    }

    /**
     * This method creates a randomly generated map based on the seed given.
     * The seed is normally generated using the following code:
     * java.util.Date test = new java.util.Date();
     * long seed = test.getTime());
     * 
     * @author Luc Breault
     * @param seed The seed which will determine the map to be used
     * @param roomType The type of rooms to create for this map
     * 
     */
    public static void shuffleMap(long seed, String roomType){
        //seed to allow replay of same map and multiplayer game synchronizing
        randNumber.setSeed(seed);
        //Map maximum size
        int maxHeight = 10;
        int maxWidth = 10;
        map = new Room[maxWidth][maxHeight];
        
        int maxRooms = randNumber.nextInt((maxWidth * maxHeight)/2) + 
                            (maxWidth * maxHeight)/2;
        
        ///DEPRECATED
        //int centerX = map.length / 2;
        //int centerY = map[0].length / 2;
        //(length [10] / 2) == 5 therefore position 6,6
        
        //NEW
        //find the location for the first room
        int firstX = randNumber.nextInt(maxWidth - 2) + 1;
        int firstY = randNumber.nextInt(maxHeight - 2) + 1;
        
        //create and place first room
        Room room = new Room();
        room.setVisited(true);
        map[firstX][firstY] = room;
        
        //Create and place the four rooms connecting to the center room
        int x = firstX, y = firstY;
        ArrayBag<Room> availableRooms = new ArrayBag<>(10, randNumber);
        
        room.setNeighbour(Room.NORTH, new Room(map[x][y], Room.SOUTH, x, y - 1));
        map[x][y - 1] = room.getNeighbour(Room.NORTH);
        availableRooms.add(room.getNeighbour(Room.NORTH));
        
        room.setNeighbour(Room.WEST, new Room(map[x][y], Room.EAST, x - 1, y));
        map[x - 1][y] = room.getNeighbour(Room.WEST);
        availableRooms.add(room.getNeighbour(Room.WEST));
        
        room.setNeighbour(Room.SOUTH, new Room(map[x][y], Room.NORTH, x, y + 1));
        map[x][y + 1] = room.getNeighbour(Room.SOUTH);
        availableRooms.add(room.getNeighbour(Room.SOUTH));
        
        room.setNeighbour(Room.EAST, new Room(map[x][y], Room.WEST, x + 1, y));
        map[x + 1][y] = room.getNeighbour(Room.EAST);
        availableRooms.add(room.getNeighbour(Room.EAST));
        
        //5 rooms were already created
        int dir1, dir2;
        for(int i = 4; i < maxRooms; i++){
            int rand = randNumber.nextInt(4);
            Room tempRoom = availableRooms.grab();
            int[] tempInt = tempRoom.getLocation();
            x = tempInt[0];
            y = tempInt[1];
            while(map[x][y].getNeighbour(rand) != null){
                rand = randNumber.nextInt(4);
            }
            if(rand % 4 == Room.NORTH){
                dir1 = Room.NORTH;
                dir2 = Room.SOUTH;
                if(map[x][y - 1] == null){
                    map[x][y].setNeighbour(dir1, new Room(map[x][y], dir2, x, y - 1));
                    map[x][y - 1] = map[x][y].getNeighbour(dir1);
                    availableRooms.add(map[x][y].getNeighbour(dir1));
                } else {
                    map[x][y].setNeighbour(dir1, map[x][y - 1]);
                }
            } else if (rand % 4 == Room.SOUTH){
                dir1 = Room.SOUTH;
                dir2 = Room.NORTH;
                if(map[x][y + 1] == null){
                    map[x][y].setNeighbour(dir1, new Room(map[x][y], dir2, x, y + 1));
                    map[x][y + 1] = map[x][y].getNeighbour(dir1);
                    availableRooms.add(map[x][y].getNeighbour(dir1));
                } else {
                    map[x][y].setNeighbour(dir1, map[x][y + 1]);
                }
            } else if (rand % 4 == Room.EAST){
                dir1 = Room.EAST;
                dir2 = Room.WEST;
                if(map[x + 1][y] == null){
                    map[x][y].setNeighbour(dir1, new Room(map[x][y], dir2, x + 1, y));
                    map[x + 1][y] = map[x][y].getNeighbour(dir1);
                    availableRooms.add(map[x][y].getNeighbour(dir1));
                } else {
                    map[x][y].setNeighbour(dir1, map[x + 1][y]);
                }
            } else {
                dir1 = Room.WEST;
                dir2 = Room.EAST;
                if(map[x - 1][y] == null){
                    map[x][y].setNeighbour(dir1, new Room(map[x][y], dir2, x - 1, y));
                    map[x - 1][y] = map[x][y].getNeighbour(dir1);
                    availableRooms.add(map[x][y].getNeighbour(dir1));
                } else {
                    map[x][y].setNeighbour(dir1, map[x - 1][y]);
                }
            }
            if(tempRoom.hasEmptyNeighbour() > -1){
                availableRooms.add(tempRoom);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game");
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1108, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
