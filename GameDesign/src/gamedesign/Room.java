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
    protected int[] location; //used for map creation
    public static final int NORTH = 0, WEST = 1, SOUTH = 2, EAST = 3;
    
    public Room(){
        visited = false;
        neighbours = new Room[4];
        doors = new boolean[4];
        roomType = null;
        location = null;
    }
    
    public Room(Room neighbour, int direction, int x, int y){
        visited = false;
        neighbours = new Room[4];
        neighbours[direction] = neighbour;
        doors = new boolean[4];
        roomType = null;
        location = new int[2];
        location[0] = x;
        location[1] = y;
    }
    
    /**
     * Overloaded Room constructor. Called when rooms are generated after the 
     * program's initialization.
     * 
     * @param neighbours The cells that are adjacent to this room
     * @param doors Whether or not there are doors in the NWSE directions
     * @param roomType A friendly name for the room
     */
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
        this.location = new int[2];
    }
    
    /**
     * Set the friendly name of the room
     * @param roomType String value for the room
     */
    public void setRoomType(String roomType)
    {
        this.roomType = roomType;
    }
    
    /*
        Return the friendly name of the room
    */
    public String getRoomType()
    {
        return roomType;
    }
    
    /**
     * Sets whether or not the room has been visited
     * @param isVisited boolean for the visit flag
     */
    public void setVisited(boolean isVisited){
        visited = isVisited;
    }
    
    /**
     * Returns the value of the visit flag
     * @return boolean for the visit flag
     */
    public boolean isVisited(){
        return this.visited;
    }
    
    /** 
     * Sets the value of the location in the map array
     * @param x x axis location
     * @param y y axis location
     */
    public void setLocation(int x, int y){
        location = new int[2];
        location[0] = x;
        location[1] = y;
    }
    
    /**
     * Gets the location of the current room on the map
     * @return array containing the location
     */
    public int[] getLocation(){
        return location;
    }
    
    /**
     * Sets the room adjacent to this one with an index for its direction
     * @param index The NWSE index of the room
     * @param neighbour The Room that is adjacent
     */
    public void setNeighbour(int index, Room neighbour){
        neighbours[index] = neighbour;
    }
    
    /**
     * Returns the adjacent Room at given index
     * @param index Index for NWSE of adjacent room
     * @return The Room that is adjacent
     */
    public Room getNeighbour(int index){
        return neighbours[index];
    }
    
    /**
     * checks the Room for empty neighbouring spaces, if some are found the
     * direction of the last empty space found is returned.
     * 
     * @return the direction of the last empty space. -1 if not found.
     */
    public int hasEmptyNeighbour(){
        int result = -1;
        for(int i = 0; i < 4; ++i){
            if(neighbours[i] == null){
                result = i;
            }
        }
        return result;
    }
    
    /**
     * Returns boolean of whether the Room has a door at given index
     * @param index The NWSE index to be checked
     * @return boolean of hasDoor flag
     */
    public boolean hasDoor(int index){
        return doors[index];
    }
    
    /**
     * Checks neighbours to see if a door should be added or not
     */
    public void createDoors(){
        for(int i = 0; i < neighbours.length; ++i){
            if(neighbours[i] != null){
                if(neighbours[i].getLocation() != null){
                    doors[i] = true;
                }
            }
        }
    }
    
    /**
     * String representation of a Room
     * 
     * @return String to represent room
     */
    public String toString(){
        return location[0] + "," + location[1];
    }
}
