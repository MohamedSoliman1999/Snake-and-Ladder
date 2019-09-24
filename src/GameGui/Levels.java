/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameGui;


/**
 *
 * @author Abeer
 */
public abstract class Levels {
    Dice dice_num ;
    
    int num ;
    int posX  , posY ;
    int row_num;
    int RandomLimit ;
    
    static int count ; 
    
    boolean start , winner;
    
   public Levels (){
     dice_num = new Dice ();
     num =0;
     start = true ;
     winner = false;
     row_num = 1;
     count =1;
     RandomLimit = (int)(Math.random()*4)+1;
   }
   
   public void getPositions (int num){  
        posX= DrawBoard.Player_single.playerXpos;
        posY = DrawBoard.Player_single.playerYpos;
     
        if(start==true)
        {
            num--;start=false;
        }
        
        for(int i=0;i<num;i++)
        {
            if(winner==false){
                
                if(row_num%2==1)
                    {
                        posX+=70;
                    }
                
                if(row_num%2==0)
                {
                    posX-=70;
                }
                
                if(posX>665) {
                    posY-=70;
                    posX-=70;
                    row_num++; 
                }
                
                if(posX<35){
                    posY-=70;
                    posX+=70;
                    row_num++;
                }
                
                if(posX<35||posY<35)
                {
                posX=35;
                posY=35;
                winner=true;
                }
            } //end of if condition
        } //end of for loop
   }
   
   public abstract int random_num ();
}

////////////////////////////////////////////////////////////////////////////////
class Easy extends Levels {
    boolean  foundsnake ;
    static int countsnake ;
    int MinEasy , MaxEasy ;
    
    public Easy(){
        super();
        foundsnake = false;
        countsnake = 0;
        MinEasy = 5;
        MaxEasy =7;
    }
    
    public boolean checkPositionS (){ 
        this.getPositions(num);
       
        if(this.posX==245&&this.posY==595) 
            foundsnake = true;
       
        else if(this.posX==105&&this.posY==245) 
            foundsnake = true;
       
        else if(this.posX==245&&this.posY==245) 
            foundsnake = true;
       
        else if(this.posX==455&&this.posY==105) 
            foundsnake = true;
       
        else if(this.posX==455&&this.posY==315) 
            foundsnake = true;
       
        else if(this.posX==175&&this.posY==35) 
            foundsnake = true;
       
        else if(this.posX==525&&this.posY==35) 
            foundsnake = true;
       
        else if(this.posX==385&&this.posY==35) 
            foundsnake = true;
        else 
            foundsnake = false ;
 
        return foundsnake ;
}
    
    public int random_num (){
        if (Easy.count == RandomLimit ){
            this.num = (int) (Math.random()*(MaxEasy-MinEasy))+MinEasy;
            Easy.count =0;
            RandomLimit =(int) (Math.random()*4)+1;
        }
    
        else{
            this.num = dice_num.random_int();
            Easy.count++;   
        }
    
        if (countsnake <3){
            if (checkPositionS()){
                System.out.println(" S " + num +"  "+posX+"  "+posY);
                
                if (num >1)
                    num--; 
                else if (num==1) 
                    num++;
                
                countsnake++;
            }
        }
        
        return this.num ;
    }
 
} //end of class Easy

////////////////////////////////////////////////////////////////////////////////
class Hard extends Levels {
    boolean foundladder;
    static int countladder ;
    int MaxHard , MinHard;
    
    public Hard (){
        super();
        foundladder = false;
        countladder = 0;
        MaxHard = 4;
        MinHard =1;
    }

    public boolean checkPositionl(){
        this.getPositions(num);
        
        if(this.posX==35&&this.posY==665) 
            foundladder = true;
        
        else if(this.posX==35&&this.posY==525) 
            foundladder = true;
        
        else if(this.posX==35&&this.posY==175) 
            foundladder = true;
        
        else if(this.posX==525&&this.posY==525) 
            foundladder = true;
        
        else if(this.posX==665&&this.posY==315) 
            foundladder = true;
        
        else if(this.posX==595&&this.posY==665) 
            foundladder = true;
        
        else if(this.posX==665&&this.posY==175) 
            foundladder = true;
        
        else if(this.posX==245&&this.posY==665) 
            foundladder = true;
        
        else 
            foundladder = false;
     
        return foundladder ;
    }
    
public int random_num (){
    if (Hard.count == RandomLimit ){
        this.num = (int) (Math.random()*(MaxHard-MinHard))+MinHard;
        Hard.count =0;
        RandomLimit =(int) (Math.random()*4)+1;
        }
    
    else{
        this.num = dice_num.random_int();
        Hard.count++;   
    }
    
    if (countladder <3){
        if (checkPositionl()){
            System.out.println("  L  " + num +"  "+posX+"  "+posY);
            
        if (num >1) {
            num--;
        }
        else if (num==1){
            num++;
        }
        countladder++;
        }
    }
    
    return this.num ;

 }

} //end of class hard