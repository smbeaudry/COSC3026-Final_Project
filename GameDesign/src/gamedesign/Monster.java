/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamedesign;

/**
 *
 * @author Scott Beaudry
 */
import java.util.ArrayList;
public class Monster{
    
    protected int maxHealth, currHealth, maxAP, currAP, id, dmg;
    protected int monsterX, monsterY; // XandY coordinates of monster
    protected int[] base_stats; //starting/level up stats of monster
    protected int[] working_stats; //stats after item/perk bonuses
    protected ArrayList<Item> inventory;

    /**
     * Default monster constructor
     */
    public Monster()
    {
        maxHealth = 10;
        currHealth = maxHealth;
        maxAP = 1;
        currAP = maxAP;

        //inventory = createInventory();
        //inventory[0] = rulebook
        
        //may need more work
    }
    
    /**
     * monster constructor with parameters
     * Have to add all the other parameters
     * @param monsterX The X value of the monster's position on the board
     * @param monsterY The Y value of the monster's position on the board
     * @param base_stats The base stats of the monster during creation
     */
    public Monster(int _monsterX, int _monsterY, int hp)
    {
        maxHealth = hp;
        currHealth = maxHealth;

        monsterX = _monsterX;
        monsterY = _monsterY;
    }
    
    //Mutators
    /**
     * Mutator to move the monster along the Xaxis
     * @param monsterX Player's new X coordinate
     */
    public void moveX(int _monsterX)
    {
        monsterX = _monsterX;
    }
    /**
     * Mutator to move the monster along the Yaxis
     * @param monsterY The monster's new Y coordinate
     */
    public void moveY(int _monsterY)
    {
        monsterY = _monsterY;
    }
    /**
     * Mutator for adjusting a monster's maximum health
     * @param maxHealth The new value for the monster's max health
     */
    public void setMaxHP(int _maxHealth)
    {
        maxHealth = _maxHealth;
    }
    /**
     * Mutator for bringing a monster's health back up to a certain point
     * @param currHealth The new value of the monster's current health
     */
    public void setHP(int _currHealth)
    {
        currHealth = _currHealth;
    }
    
    //Accessors
    /**
     * Accessor for monster's X coordinate
     * @return monster's X coordinate
     */
    public int getX()
    {
        return monsterX;
    }
    /**
     * Accessor for monster's Y coordinate
     * @return monster's Y coordinate
     */
    public int getY()
    {
        return monsterY;
    }
    /**
     * Accessor for monster's max health
     * @return monster's max health
     */
    public int getMaxHP()
    {
        return maxHealth;
    }
    /**
     * Accessor for monster's current health
     * @return monster's current health
     */
    public int getHP()
    {
        return currHealth;
    }

    /**
     * Accessor for player ID
     * @return Player ID
     */
    public int getID()
    {
        return id;
    }
    /**
     * Accessor for DMG
     * @return monster DMG stat
     */
    public int getDMG()
    {
        return dmg;
    }
    
    /**
     * This method creates the default inventory for the monster. This method 
     * will be run in the monster's constructor
     * @return An ArrayBag<Item> of the monster's default items
     */
    public ArrayList<Item> createInventory(Item[] items){
        ArrayList<Item> default_inventory = new ArrayList<Item>();
        
        for(int i = 0; i < items.length; i++)
        {
            default_inventory.add(items[i]);
        }
        return default_inventory;
    }    
             
    public void throwItem(Item item){
        
    }
}

