/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameGui;

/**
 *
 * @author abdul
 */
public class Dice {
    private final int Min ;
    private final int Max;
    
    public Dice ()
    {
        this.Min = 1;
        this.Max = 7 ;
    }
     public int random_int()
    {
         return (int) (Math.random()*(Max-Min))+Min;
    }
}
