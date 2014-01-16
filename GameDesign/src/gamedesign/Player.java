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
    protected int[] base_stats; //starting/level up stats of player
    protected int[] working_stats; //stats after item/perk bonuses
    protected ArrayList<Item> inventory;
    protected Skills[] skills;
    protected ArrayList<Perk> perks;
    public static final int STR=0, INTL=1, LUCK=2, PERC=3, AGIL=4, ATK=5, DEF=6;
    
    
    public Player()
    {
        maxHealth = 10;
        currHealth = maxHealth;
        maxAP = 1;
        currAP = 1;
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
    
    //Mutators
    public void setMaxHP(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }
    public void setHP(int currHealth)
    {
        this.currHealth = currHealth;
    }
    public void healing(int health)
    {
        this.currHealth+= health;
    }
    
    //Accessors
    public int getMaxHP()
    {
        return maxHealth;
    }
    public int getHP()
    {
        return currHealth;
    }
    public int getMaxAP()
    {
        return maxAP;
    }
    public int getAP()
    {
        return currAP;
    }
    public int getID()
    {
        return id;
    }
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
}

