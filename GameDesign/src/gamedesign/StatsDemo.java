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
public class StatsDemo {
    
    /*
    * This class will start with the base attributes of the player.
    */
    
    /*
    * The strength stat will measure the base attack strength of the player
    * /monster
    */
    private int strength;
    
    
    /*
    * The intelligence stat will success with levelling from books
    */
    private int intelligence;
    
    
    /*
    * Luck determines the player's likelyhood of finding treasure, and 
    * the likelyhood of enemy dropping items
    */
    private int luck;
    
    
    /*
    * Perception affects the player's ability to identify monsters on the other
    * side of the doors. The higher the perception, the better description of 
    * the monster on the other side of the door.
    */
    private int perception;

    
    /*
    * Agility will affect the player's defense stat (in that they can evade 
    * easier). It will affect the likelyhood of the player to run away 
    * successfully. It may also allow the player to move another tile
    * if the stat is high enough?
    */
    private int agility;

    
    /*
    * The attack stat will be the primary calculating variable for damage 
    * giving damage to enemies. This will be influenced the multiplying factor 
    * for each base stat, item bonuses, and perk upgrades.
    */
    private int attack;
   
    
    /*
    * The defense stat will be the primary calculating variable for taking 
    * damage from enemies.
    */
    private int defense;
}
