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
     * 
     */
    public static void shuffleMap(long seed){
        //seed to allow replay of same map and multiplayer game synchronizing
        randNumber.setSeed(seed);
        int maxRooms = randNumber.nextInt(60) + 1;
        //Map maximum size
        map = new Room[10][10];
        /*
        We could have the start room spawn anywhere except the edges
        Code would look like:
            centerX = (int)((Math.random() * 59) + 1);
            centerY = (int)((Math.random() * 59) + 1);
        */
        int centerX = map.length / 2;
        int centerY = map[0].length / 2;
        //create and place center room
        Room room = new Room();
        room.setVisited(true);
        //(length [10] / 2) == 5 therefore position 6,6
        map[centerX][centerY] = room;
        
        int x = centerX, y = centerY;
                
        room.setNeighbour(Room.NORTH, new Room(map[x][y], Room.SOUTH));
        map[x][y + 1] = room.getNeighbour(Room.NORTH);
        
        room.setNeighbour(Room.WEST, new Room(map[x][y], Room.EAST));
        map[x - 1][y] = room.getNeighbour(Room.WEST);
        
        room.setNeighbour(Room.SOUTH, new Room(map[x][y], Room.NORTH));
        map[x][y - 1] = room.getNeighbour(Room.SOUTH);
        
        room.setNeighbour(Room.EAST, new Room(map[x][y], Room.WEST));
        map[x + 1][y] = room.getNeighbour(Room.EAST);
        
        int dir1, dir2;
        for(int i = 0; i < maxRooms; i++){
            int rand = randNumber.nextInt(4);
            if(map[x][y].hasEmptyNeighbour() > -1){
                while(map[x][y].getNeighbour(rand) != null){
                    randNumber.nextInt(4);
                }
                if(rand % 4 == Room.NORTH){
                    dir1 = Room.NORTH;
                    dir2 = Room.SOUTH;
                } else if (rand % 4 == Room.SOUTH){
                    dir1 = Room.SOUTH;
                    dir2 = Room.NORTH;
                } else if (rand % 4 == Room.EAST){
                    dir1 = Room.EAST;
                    dir2 = Room.WEST;
                } else {
                    dir1 = Room.WEST;
                    dir2 = Room.EAST;
                }
                map[x][y].setNeighbour(dir1, new Room(map[x][y], dir2));
                map[x][y] = map[x][y].getNeighbour(dir1);
            }
        }
        
    }
    
}
