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
 * 
 */
public class GameDesign {

    public static Room[][] map;
    public static Random randNumber;
    public static long seed;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        randNumber = new Random();
        
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
        
        room.setNeighbour(Room.NORTH, new Room(map[x][y], Room.SOUTH));
        map[x][y - 1] = room.getNeighbour(Room.NORTH);
        
        room.setNeighbour(Room.WEST, new Room(map[x][y], Room.EAST));
        map[x - 1][y] = room.getNeighbour(Room.WEST);
        
        room.setNeighbour(Room.SOUTH, new Room(map[x][y], Room.NORTH));
        map[x][y + 1] = room.getNeighbour(Room.SOUTH);
        
        room.setNeighbour(Room.EAST, new Room(map[x][y], Room.WEST));
        map[x + 1][y] = room.getNeighbour(Room.EAST);
        
        //5 rooms were already created
        int dir1, dir2;
        for(int i = 4; i < maxRooms; i++){
            int rand = randNumber.nextInt(4);
            if(map[x][y].hasEmptyNeighbour() > -1){
                while(map[x][y].getNeighbour(rand) != null){
                    rand = randNumber.nextInt(4);
                }
                if(rand % 4 == Room.NORTH){
                    dir1 = Room.NORTH;
                    dir2 = Room.SOUTH;
                    map[x][y].setNeighbour(dir1, new Room(map[x][y], dir2));
                    map[x][y - 1] = map[x][y].getNeighbour(dir1);
                } else if (rand % 4 == Room.SOUTH){
                    dir1 = Room.SOUTH;
                    dir2 = Room.NORTH;
                    map[x][y].setNeighbour(dir1, new Room(map[x][y], dir2));
                    map[x][y + 1] = map[x][y].getNeighbour(dir1);
                } else if (rand % 4 == Room.EAST){
                    dir1 = Room.EAST;
                    dir2 = Room.WEST;
                    map[x][y].setNeighbour(dir1, new Room(map[x][y], dir2));
                    map[x + 1][y] = map[x][y].getNeighbour(dir1);
                } else {
                    dir1 = Room.WEST;
                    dir2 = Room.EAST;
                    map[x][y].setNeighbour(dir1, new Room(map[x][y], dir2));
                    map[x - 1][y] = map[x][y].getNeighbour(dir1);
                }
            }
        }
    }
}
