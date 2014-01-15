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
public class Item 
{
    
    protected String name, statAffected;
    protected boolean isEquipable, isConsumable;
    
    public Item()
    {
        name = "God Powers";
        statAffected = null;
        isEquipable = false;
        isConsumable = false;
    }
    
    public Item(String name, String statAffected,
            boolean isEquipable, boolean isConsumable)
    {
        this.name = name;
        this.statAffected = statAffected;
        this.isEquipable = isEquipable;
        this.isConsumable = isConsumable;
    }
    
    //Mutators
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setStatAffected(String statAffected)
    {
        this.statAffected = statAffected;
    }
    
    public void isEquipable(boolean isEquipable)
    {
        this.isEquipable = isEquipable;
    }
    
    public void isConsumable(boolean isConsumable)
    {
        this.isConsumable = isConsumable;
    }
    
    //Accessors
    public String getName()
    {
        return name;
    }
    
    public String getStatAffected()
    {
        return statAffected;
    }
    
    public boolean isEquipable()
    {
        return isEquipable;
    }
    
    public boolean isConsumable()
    {
        return isConsumable;
    }
    
}
