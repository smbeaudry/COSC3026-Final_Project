/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamedesign;

/**
 *
 * @author The team
 * 
 */
public class GameDesign {

    public static Room[][] map;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
    public static void shuffleMap(){
        int maxRooms = (int)((Math.random() * 60) + 1);
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
        map[centerX][centerY] = new Room();
        
        
    }
    
}
