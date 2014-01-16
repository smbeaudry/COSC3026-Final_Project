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
public class Player extends Perk{
    
    protected int maxHealth, currHealth, maxAP, currAP, id, dmg;
    protected int[] stats;
    protected ArrayBag<Item> inventory;
    protected Skills[] skills;
    protected ArrayBag<Perk> perks;
    public static final int STR=0, INTL=1, LUCK=2, PERC=3, AGIL=4, ATK=5, DEF=6;
    
    
    public Player()
    {
        maxHealth = 10;
        currHealth = maxHealth;
        maxAP = 1;
        currAP = 1;
        stats = new int[7];
        for(int i = 0; i <= stats.length; i++)
        {
            stats[i] = 1;
        }
        
        perks = createPerks();
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
    
    public ArrayBag<Perk> createPerks(){
       
        ArrayBag<Perk> default_perks = new ArrayBag<Perk>();
        Perk testPerk = new Perk(false, 5, "strength", "Heavy Lifter");
        default_perks.add(testPerk);
        
        
        return default_perks;
    }
}
