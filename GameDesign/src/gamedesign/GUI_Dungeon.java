/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamedesign;

import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author The team
 */
public class GUI_Dungeon extends javax.swing.JFrame {
    
    public static Room[][] map;
    public static Random randNumber;
    public static long seed;
    
    //window elements
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel jLabel1;
        
    /**
     * Creates new form GUI
     * 
     * Place code for managing the board here.
     */
    public GUI_Dungeon() {
        //window elements
        jLayeredPane1 = new JLayeredPane();
        jLabel1 = new JLabel();

        
        //other elements
        randNumber = new Random();
        java.util.Date date = new java.util.Date();
        seed = date.getTime();
        //seed = 1;
        //<label>.setIcon(new javax.swing.ImageIcon(getClass().getResource("./gamedesign/assets/dun_wall_0.png")));
        shuffleMap(seed, "test");
        for(Room[] rooms : map){
            for(Room room : rooms){
                if(room != null){
                    System.out.print(room + "\t");
                } else {
                    System.out.print("   \t");
                }
            }
            System.out.println();
        }
        draw();
    }
    
    /**
     * Method that will draw the base map
     */
    private void draw(){
        for(Room[] rooms : map){
            for(Room room : rooms){
                if(room != null){
                    if(room.isVisited()){
                        //draw room
                    } else {
                        //Black label
                    }
                } else {
                    //we could draw something or nothing here, this is debatable
                }
            }
            
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
    private void shuffleMap(long seed, String roomType){
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
        room.setLocation(firstX, firstY);
        room.setAsFirst(true);
        map[firstX][firstY] = room;
        
        //Create and place the four rooms connecting to the center room
        int x = firstX, y = firstY;
        ArrayBag<Room> availableRooms = new ArrayBag<>(10, randNumber);
        
        int[] tempInt;
        Room addedRoom;
        
        //adds first room north of the spawn room
        addedRoom = new Room(map[x][y], Room.SOUTH, x, y - 1);
        room.setNeighbour(Room.NORTH, addedRoom);
        map[x][y - 1] = room.getNeighbour(Room.NORTH);
        availableRooms.add(room.getNeighbour(Room.NORTH));
        checkForBorder(addedRoom, addedRoom.getLocation());
        
        //adds first room west of the spawn room
        addedRoom = new Room(map[x][y], Room.EAST, x - 1, y);
        room.setNeighbour(Room.WEST, addedRoom);
        map[x - 1][y] = room.getNeighbour(Room.WEST);
        availableRooms.add(room.getNeighbour(Room.WEST));
        checkForBorder(addedRoom, addedRoom.getLocation());
        
        //adds first room south of the spawn room
        addedRoom = new Room(map[x][y], Room.EAST, x , y + 1);
        room.setNeighbour(Room.SOUTH, addedRoom);
        map[x][y + 1] = room.getNeighbour(Room.SOUTH);
        availableRooms.add(room.getNeighbour(Room.SOUTH));
        checkForBorder(addedRoom, addedRoom.getLocation());
        
        //adds first room east of the spawn room
        addedRoom = new Room(map[x][y], Room.WEST, x + 1, y);
        room.setNeighbour(Room.EAST, addedRoom);
        map[x + 1][y] = room.getNeighbour(Room.EAST);
        availableRooms.add(room.getNeighbour(Room.EAST));
        checkForBorder(addedRoom, addedRoom.getLocation());
        
        //randomises the placement of rooms in the dungeon based on seed
        int dir1, dir2, rand;
        Room tempRoom;
        for(int i = 4; i < maxRooms; ++i){
            addedRoom = null;
            rand = randNumber.nextInt(4);
            tempRoom = availableRooms.grab();
            tempInt = tempRoom.getLocation();
            x = tempInt[0];
            y = tempInt[1];
            while(map[x][y].getNeighbour(rand) != null){
                rand = randNumber.nextInt(4);
            }
            //checks if "door" exists on a room
            if(rand == Room.NORTH){
                dir1 = Room.NORTH;
                dir2 = Room.SOUTH;
                //checks if room doesn't exist in North position
                if(map[x][y - 1] == null){
                    //adds room is north position with "door" in correct location
                    addedRoom = new Room(map[x][y], dir2, x, y - 1);
                    map[x][y].setNeighbour(dir1, addedRoom);
                    //sets the room in the curent room's North position to newly created room
                    map[x][y - 1] = map[x][y].getNeighbour(dir1);
                    //adds the newly created room to the list of available rooms to build from
                    availableRooms.add(map[x][y].getNeighbour(dir1));
                } else {
                    //if a room exists in north position, add as neighbour room
                    map[x][y].setNeighbour(dir1, map[x][y - 1]);
                    map[x][y - 1] = map[x][y].getNeighbour(dir1);
                    //reduces the wall count
                    --i;
                }
            } else if (rand == Room.SOUTH){
                dir1 = Room.SOUTH;
                dir2 = Room.NORTH;
                if(map[x][y + 1] == null){
                    addedRoom = new Room(map[x][y], dir2, x, y + 1);
                    map[x][y].setNeighbour(dir1, addedRoom);
                    map[x][y + 1] = map[x][y].getNeighbour(dir1);
                    availableRooms.add(map[x][y].getNeighbour(dir1));
                } else {
                    map[x][y].setNeighbour(dir1, map[x][y + 1]);
                    map[x][y + 1] = map[x][y].getNeighbour(dir1);
                    --i;
                }
            } else if (rand == Room.EAST){
                dir1 = Room.EAST;
                dir2 = Room.WEST;
                if(map[x + 1][y] == null){
                    addedRoom = new Room(map[x][y], dir2, x + 1, y);
                    map[x][y].setNeighbour(dir1, addedRoom);
                    map[x + 1][y] = map[x][y].getNeighbour(dir1);
                    availableRooms.add(map[x][y].getNeighbour(dir1));
                } else {
                    map[x][y].setNeighbour(dir1, map[x + 1][y]);
                    map[x + 1][y] = map[x][y].getNeighbour(dir1);
                    --i;
                }
            } else {
                dir1 = Room.WEST;
                dir2 = Room.EAST;
                if(map[x - 1][y] == null){
                    addedRoom = new Room(map[x][y], dir2, x - 1, y);
                    map[x][y].setNeighbour(dir1, addedRoom);
                    map[x - 1][y] = map[x][y].getNeighbour(dir1);
                    availableRooms.add(map[x][y].getNeighbour(dir1));
                } else {
                    map[x][y].setNeighbour(dir1, map[x - 1][y]);
                    map[x - 1][y] = map[x][y].getNeighbour(dir1);
                    --i;
                }
            }
            if(addedRoom != null){
                checkForBorder(addedRoom, addedRoom.getLocation());
            }
            if(tempRoom.hasEmptyNeighbour() > -1){
                availableRooms.add(tempRoom);
            }
        }
        createDoors();
    }
    
    /**
     * Check the specified room to add a blank room if it is near the edges
     * 
     * @param roomToCheck The room that should be checked
     * @param tempInt The rooms location
     */
    public void checkForBorder(Room roomToCheck, int[] tempInt){
        if(tempInt[0] == 0){
            roomToCheck.setNeighbour(Room.WEST, new Room());
        }
        if(tempInt[1] == 0){
            roomToCheck.setNeighbour(Room.NORTH, new Room());
        }
        if(tempInt[0] == map.length - 1){
            roomToCheck.setNeighbour(Room.EAST, new Room());
        }
        if(tempInt[1] == map[0].length - 1){
            roomToCheck.setNeighbour(Room.SOUTH, new Room());
        }
    }
    
    /**
     * Loops through the map and creates the doors for every room
     */
    public void createDoors(){
        for(int i = 0; i < map.length; ++i){
            for(int j = 0; j < map[i].length; ++j){
                if(map[i][j] != null){
                    map[i][j].createDoors();
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Dungeon().setVisible(true);
            }
        });
        
    }
}