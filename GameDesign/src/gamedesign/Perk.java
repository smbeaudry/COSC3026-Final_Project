/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamedesign;

/**
 * This class sets the basic datafields, and methods required for each
 * 'perk' object to be used by the Player class.
 * @author Ryan Trudeau
 */
public class Perk{
    
    private boolean enabled;
    private int statChange;
    private String attribute;
    private String name;
    
    public Perk(){
        
        enabled = false;
        statChange = 0;
        attribute = null;
        name = null;
  
    }
    
    public Perk(boolean status, int sChange, String att, String perkName){
        enabled = status;
        statChange = sChange;
        attribute = att;
        name = perkName;
    }
    
    public boolean getEnabled(){
        return enabled;
    }
    
    public int getStatChange(){
        return statChange;
    }
    
    public String getAttribute(){
        return attribute;
    }
    
    public String getName(){
        return name;
    }
    
    public void setEnabled(boolean newValue){
        enabled = newValue;
    }
    
    public void setAttribute(String newValue){
        attribute = newValue;
    }
    
    public void setStatChange(int newValue){
        statChange = newValue;
    }
    
    public void setName(String newName){
        name = newName;
    }
}
