/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamedesign;

/**
 *
 * @author Ryan Trudeau
 */
public class Perk{
    
    private boolean enabled;
    private int statChange;
    private String variable;
    
    public Perk(){
        
        enabled = false;
        statChange = 0;
        variable = null;
  
    }
    
    public boolean getEnabled(){
        return enabled;
    }
    
    public int getStatChange(){
        return statChange;
    }
    
    public String getVariable(){
        return variable;
    }
    
    public void setEnabled(boolean newValue){
        enabled = newValue;
    }
    
    public void setVariable(String newValue){
        variable = newValue;
    }
    
    public void setStatChange(int newValue){
        statChange = newValue;
    }
}
