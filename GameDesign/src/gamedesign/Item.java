/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamedesign;

/**
 *
 * @author David Pellegrini
 * Class to ensure all items have the same attributes
 * Incomplete
 */
public class Item 
{
    
    protected String name, statAffected;
    protected String description;
    protected boolean isEquipable, isEquipped, isConsumable, isThrowable;
    protected int statChange;
    
    /**
     * Default constructor
     * Creates an empty item of no use
     */
    public Item()
    {
        name = "Power of God";
        description = "You can't use this";
        statAffected = null;
        isEquipable = false;
        isConsumable = false;
        isThrowable = true;
        statChange = 0;
        isEquipped = false;
    }
    
    /**
     * Creates custom items available to players throughout the game
     * @param name The name of the item
     * @param statAffected The stat affected by the item (possibly array)
     * @param isEquipable If the item can be worn
     * @param isConsumable If the item can be consumed
     * @param isThrowable If the item can be thrown (possibly always true)
     * @param sChange the value the item effect will change the stat by
     * @param equipped is a boolean of if the item is equipped
     */
    public Item(String name, String statAffected, boolean isEquipable,
            boolean isConsumable, boolean isThrowable, int sChange,
            boolean equipped)
    {
        this.name = name;
        this.statAffected = statAffected;
        this.isEquipable = isEquipable;
        this.isConsumable = isConsumable;
        this.isThrowable = isThrowable;
        this.statChange = sChange;
        this.isEquipped = equipped;
    }
    
     /**
     * Creates custom items available to players throughout the game
     * @param name The name of the item
     * @param statAffected The stat affected by the item (possibly array)
     * @param isEquipable If the item can be worn
     * @param isConsumable If the item can be consumed
     * @param sChange the value the item effect will change the stat by
     * @param equipped is a boolean of if the item is equipped
     */
    public Item(String name, String statAffected, boolean isEquipable,
            boolean isConsumable, int sChange, boolean equipped)
    {
        this.name = name;
        this.statAffected = statAffected;
        this.isEquipable = isEquipable;
        this.isConsumable = isConsumable;
        this.isThrowable = true;
        this.statChange = sChange;
        this.isEquipped = equipped;
    }
    //Mutators
    /**
     * Sets item name
     * @param name The name of the item
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * Sets which stat is affected
     * @param statAffected The stat affected by the item (possibly array)
     */
    public void setStatAffected(String statAffected)
    {
        this.statAffected = statAffected;
    }
    /**
     * Sets if the item can be worn
     * @param isEquipable if the item can be worn
     */
    public void setIsEquipable(boolean isEquipable)
    {
        this.isEquipable = isEquipable;
    }
    /**
     * Sets if the item can be consumed
     * @param isConsumable If the item can be consumed
     */
    public void setIsConsumable(boolean isConsumable)
    {
        this.isConsumable = isConsumable;
    }
    /**
     * Sets if the item can be thrown (possibly always)
     * @param isThrowable If the item can be thrown
     */
    public void setIsThrowable(boolean isThrowable)
    {
        this.isThrowable = isThrowable;
    }
    
    /**
     * Sets if the item is currently equipped
     * @param equipped 
     */
    public void setIsEquipped(boolean equipped){
        this.isEquipped = equipped;
    }
    
    /**
     * Sets the value the affected stat will be changed by
     * @param sChange is the new value of change
     */
    public void setStatChange(int sChange){
        this.statChange = sChange;
    }
    
    //Accessors
    /**
     * Returns the name of the item
     * @return A string for the name
     */
    public String getName()
    {
        return name;
    }
    /**
     * Returns the stat affected
     * @return A string for the stat affected
     */
    public String getStatAffected()
    {
        return statAffected;
    }
    /**
     * Returns if the item is wearable
     * @return A boolean value for wearability
     */
    public boolean isEquipable()
    {
        return isEquipable;
    }
    /**
     * Returns if the item is consumable
     * @return A boolean value for consumability
     */
    public boolean isConsumable()
    {
        return isConsumable;
    }
    /**
     * Returns if the item can be thrown
     * @return A boolean value for throwability
     */
    public boolean isThrowable()
    {
        return isThrowable;
    }
    
    /**
     * Returns if the item is equipped
     * @return  A boolean value for equipped status
     */
    public boolean isEquipped(){
        return isEquipped;
    }
    
    /**
     * Returns the value of the stat change
     * @return the value of the stat change
     */
    public int getStatChange(){
        return statChange;
    }
    
}
