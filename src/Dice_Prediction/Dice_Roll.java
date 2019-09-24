/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dice_Prediction;

/**
 *
 * @author abdul
 */
public class Dice_Roll {
    public int counter;
    public float probability; //probability predicted for the next roll
    
    public Dice_Roll()
    { 
        counter = 0;
        probability = 0.0f;
    }
    
    public void AddRoll()
    {
        counter++;
    }
}
