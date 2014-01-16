/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamedesign;

/**
 *
 * @author Ryan Trudeau
 * Class to create perks to add bonuses for players
 */
public class Perk{
    
    private boolean enabled;
    private int statChange;
    private String attribute;
    private String name;
    
    /**
     * Default constructor
     * Creates a useless perk
     */
    public Perk(){
        
        enabled = false;
        statChange = 0;
        attribute = null;
        name = null;
  
    }
    
    /**
     * Creates a Perk based on arguments provided
     * @param status Sets if the perk is in use by a player
     * @param sChange Sets which stat is affected by the perk
     * @param att Sets which attribute is affected by the perk
     * @param perkName Sets the name of the perk
     */
    public Perk(boolean status, int sChange, String att, String perkName){
        enabled = status;
        statChange = sChange;
        attribute = att;
        name = perkName;
    }
    //Accessors
    /**
     * Accessor for if the perk is enabled
     * @return If the perk is enabled
     */
    public boolean getEnabled(){
        return enabled;
    }
    /**
     * Accessor for the stat changed
     * @return Which stat is changed
     */
    public int getStatChange(){
        return statChange;
    }
    /**
     * Accessor for the attribute changed
     * @return Which attribute is affected
     */
    public String getAttribute(){
        return attribute;
    }
    /**
     * Accessor for the name of the perk
     * @return The name of the perk
     */
    public String getName(){
        return name;
    }
    /**
     * Sets if the player is using the stat
     * @param newValue True if the player is using the perk
     */
    public void setEnabled(boolean newValue){
        enabled = newValue;
    }
    /**
     * Sets which attribute the perk will affect
     * @param newValue The attribute being affected
     */
    public void setAttribute(String newValue){
        attribute = newValue;
    }
    /**
     * Sets which stat will be affected
     * @param newValue The stat being affected
     */
    public void setStatChange(int newValue){
        statChange = newValue;
    }
    /**
     * Sets the name of the perk
     * @param newName The name of the perk
     */
    public void setName(String newName){
        name = newName;
    }
}
