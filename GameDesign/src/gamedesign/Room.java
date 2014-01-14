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
    protected String roomType; //used for room graphic
    public static final int NORTH = 0, WEST = 1, SOUTH = 2, EAST = 3;
    
    public Room(){
        visited = false;
        neighbours = new Room[4];
        doors = new boolean[4];
        roomType = null;
    }
    
    public Room(Room[] neighbours, boolean[] doors, String roomType)
    {
        visited = false;
        //the "this" keyword references the protected data fields
        this.neighbours = new Room[neighbours.length];
        //copies neighbours array param
        for(int i = 0; i <= neighbours.length; i++)
            this.neighbours[i] = neighbours[i];
        //copies doors array param
        this.doors = new boolean[doors.length];
        for(int i = 0; i <= doors.length; i++)
            this.doors[i] = doors[i];
        this.roomType = roomType;
    }
    
    public void setRoomType(String roomType)
    {
        this.roomType = roomType;
    }
    
    public String getRoomType()
    {
        return roomType;
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
