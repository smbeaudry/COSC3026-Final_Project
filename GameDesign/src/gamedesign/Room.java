/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamedesign;

/**
 *
 * @author Luc Breault
 */
public class Room {
    protected boolean visited;
    protected Room[] neighbours;
    protected boolean[] doors;
    public static final int NORTH = 0, WEST = 1, SOUTH = 2, EAST = 3;
    
    public Room(){
        visited = false;
        neighbours = new Room[4];
        doors = new boolean[4];
    }
    
    public void setVisited(boolean isVisited){
        visited = isVisited;
    }
    
    public boolean isVisited(){
        return visited;
    }
    
    public void setNeighbour(int index, Room neighbour){
        neighbours[index] = neighbour;
    }
    
    public Room getNeighbour(int index){
        return neighbours[index];
    }
    
    public boolean hasDoor(int index){
        return doors[index];
    }
}
