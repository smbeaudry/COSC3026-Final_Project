/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamedesign;

/**
 *
 * @author David Pellegrini
 */
import java.util.ArrayList;
public class Player extends Perk{
    
    protected int maxHealth, currHealth, maxAP, currAP, id, dmg;
    protected int playerX, playerY; // XandY coordinates of player
    protected int[] base_stats; //starting/level up stats of player
    protected int[] working_stats; //stats after item/perk bonuses
    protected ArrayList<Item> inventory;
    //protected Skills[] skills;
    protected ArrayList<Perk> perks;
    public static final int STR=0, INTL=1, LUCK=2, PERC=3, AGIL=4, ATK=5, DEF=6;
    
    /**
     * Default player constructor
     */
    public Player()
    {
        maxHealth = 10;
        currHealth = maxHealth;
        maxAP = 1;
        currAP = maxAP;
        base_stats = new int[7];
        working_stats = new int[7];
        for(int i = 0; i <= base_stats.length; i++)
        {
            base_stats[i] = 1;
        }
        //System.arraycopy(src, start_indx_from, des, start_indx_to, cp_length);
        System.arraycopy(base_stats, 0, working_stats, 0, base_stats.length);
        
        perks = createPerks();
        inventory = createInventory();
        //inventory[0] = rulebook
        
        //may need more work
    }
    
    /**
     * Player constructor with parameters
     * Have to add all the other parameters
     * @param playerX The X value of the player's position on the board
     * @param playerY The Y value of the player's position on the board
     * @param base_stats The base stats of the player during creation
     */
    public Player(int playerX, int playerY, int[] base_stats)
    {
        maxHealth = 10;
        currHealth = maxHealth;
        
        for(int i = 0; i<=base_stats.length; i++)
        {
            this.base_stats[i] = base_stats[i];
            working_stats[i] = base_stats[i];
            //working stats are the same as base stats to begin
        }
        this.playerX = playerX;
        this.playerY = playerY;
    }
    
    //Mutators
    /**
     * Mutator to move the player along the Xaxis
     * @param playerX Player's new X coordinate
     */
    public void moveX(int playerX)
    {
        this.playerX = playerX;
    }
    /**
     * Mutator to move the player along the Yaxis
     * @param playerY The player's new Y coordinate
     */
    public void moveY(int playerY)
    {
        this.playerY = playerY;
    }
    /**
     * Mutator for adjusting a player's maximum health
     * @param maxHealth The new value for the player's max health
     */
    public void setMaxHP(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }
    /**
     * Mutator for bringing a player's health back up to a certain point
     * @param currHealth The new value of the player's current health
     */
    public void setHP(int currHealth)
    {
        this.currHealth = currHealth;
    }
    /**
     * Mutator for when a player heals 
     * @param health How much the player healed by
     */
    public void healing(int health)
    {
        this.currHealth+= health;
    }
    
    //Accessors
    /**
     * Accessor for player's X coordinate
     * @return Player's X coordinate
     */
    public int getX()
    {
        return playerX;
    }
    /**
     * Accessor for player's Y coordinate
     * @return Player's Y coordinate
     */
    public int getY()
    {
        return playerY;
    }
    /**
     * Accessor for player's max health
     * @return Player's max health
     */
    public int getMaxHP()
    {
        return maxHealth;
    }
    /**
     * Accessor for player's current health
     * @return Player's current health
     */
    public int getHP()
    {
        return currHealth;
    }
    /**
     * Accessor for player's max AP
     * @return Player's max AP
     */
    public int getMaxAP()
    {
        return maxAP;
    }
    /**
     * Accessor for player's current AP
     * @return Player's current AP
     */
    public int getAP()
    {
        return currAP;
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
     * @return Player DMG stat
     */
    public int getDMG()
    {
        return dmg;
    }
    
    /**
     * This method creates the default Perks for the player. This method will
     * be run in the player's constructor
     * @return An ArrayBag<Perk> of the player's default perks
     */
    public ArrayList<Perk> createPerks(){
       
        ArrayList<Perk> default_perks = new ArrayList<Perk>();
        Perk testPerk = new Perk(false, 5, "strength", "Heavy Lifter");
        default_perks.add(testPerk);
        
        
        return default_perks;
    }
    
    /**
     * This method creates the default inventory for the player. This method 
     * will be run in the player's constructor
     * @return An ArrayBag<Item> of the player's default items
     */
    public ArrayList<Item> createInventory(){
        ArrayList<Item> default_inventory = new ArrayList<Item>();
        Item testItem = new Item();
        default_inventory.add(testItem);
        
        return default_inventory;
    }
    
    public void recalculateStats(){
        int old_strength = base_stats[STR];
        int new_strength = old_strength;
        
        int old_intelligence = base_stats[INTL];
        int new_intelligence = old_intelligence;
        
        int old_luck = base_stats[LUCK];
        int new_luck = old_luck;
        
        int old_perception = base_stats[PERC];
        int new_perception = old_perception;
        
        int old_agility = base_stats[AGIL];
        int new_agility = old_agility;
        
        //strength loop check
        for(int i = 0; i < perks.size(); ++i){
            if(perks.get(i).getAttribute().equals("strength") && 
               perks.get(i).getEnabled()){
                
               new_strength += perks.get(i).getStatChange();
            }
        }
        
        //intelligence loop check
        for(int i = 0; i < perks.size(); ++i){
            if(perks.get(i).getAttribute().equals("intelligence") && 
               perks.get(i).getEnabled()){
                
               new_intelligence += perks.get(i).getStatChange();
            }
        }
        
        //luck loop check
        for(int i = 0; i < perks.size(); ++i){
            if(perks.get(i).getAttribute().equals("luck") && 
               perks.get(i).getEnabled()){
                
               new_luck += perks.get(i).getStatChange();
            }
        }
        
        //perception loop check
        for(int i = 0; i < perks.size(); ++i){
            if(perks.get(i).getAttribute().equals("perception") && 
               perks.get(i).getEnabled()){
                
               new_perception += perks.get(i).getStatChange();
            }
        }
        
        //agility loop check
        for(int i = 0; i < perks.size(); ++i){
            if(perks.get(i).getAttribute().equals("agility") && 
               perks.get(i).getEnabled()){
                
               new_agility += perks.get(i).getStatChange();
            }
        }
        
        working_stats[STR] = new_strength;
        working_stats[INTL] = new_intelligence;
        working_stats[LUCK] = new_luck;
        working_stats[PERC] = new_perception;
        working_stats[AGIL] = new_agility;
        
        //ATTACK and DEFENSE will be recalculated here based on the new stats
    }
    
    public void consumeItem(Item item){
        if(item.isConsumable()){
            
        }
    }
    
    public void throwItem(Item item){
        
    }
}

