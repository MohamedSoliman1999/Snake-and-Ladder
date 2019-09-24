/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameGui;
import DiceDecleration.DiceImageProcessing;
import Dice_Prediction.Dice_Roll;
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import my.NewOrContinueForm.NewOrContinue;

/**
 *
 * @author abdul
 */
abstract public class Player{
    protected Circle Player;
    protected int playerXpos;
    protected int playerYpos;
    protected static int Num_of_Rolls;
    public boolean winner;
    protected static boolean playerturn;
    protected static boolean chooseColor;
    protected static  Dice_Roll [] dice;
    ////////////////////////////////////////////////////////////////////////////
    private int row_pos;     
    public int sqr_num;
    private int score;
    private int dice_num;
    
    private boolean start;  
    
    private static String line,x;
    
    public Player(boolean chooseColor){
        Player = new Circle(35);
        row_pos=1;
        sqr_num=1;
        score = 0;
        dice_num = 0;
        Num_of_Rolls = 0;
        start=true;
        winner = false;
        this.playerXpos = 35;
        this.playerYpos = 665;
        this.chooseColor = chooseColor;
        
        
        dice = new Dice_Roll[6];
        for(int i = 0; i < 6; i++)
        {
            dice[i] = new Dice_Roll();
        }
      
       
      
    }
    
    ////////////////////////////////////////////////////////////////////////////
   public static boolean getTurn(){
        try{
        FileReader file = new FileReader("turn.txt");
                BufferedReader bufferedReader = new BufferedReader(file);
                
                while ((line = bufferedReader.readLine()) != null) {
                    x = line;
                }
                bufferedReader.close();
                file.close();
                
    }
        catch(IOException e){
         e.getMessage();
        }
         return Boolean.valueOf(x);
         
    }
    public static void saveTurn(){
        try {FileWriter writer = new FileWriter("turn.txt");
             BufferedWriter bw = new BufferedWriter(writer); {

            bw.write(String.valueOf(!getTurn()));
            bw.close();
            writer.close();
        }
        } catch (IOException l) {
            System.err.format("IOException: %s%n", l);
        }
    }
     public static boolean getBeforeclose(){
        try{
        FileReader file = new FileReader("before.txt");
                BufferedReader bufferedReader = new BufferedReader(file);
                
                while ((line = bufferedReader.readLine()) != null) {
                    x = line;
                }
                bufferedReader.close();
                file.close();
                
    }
        catch(IOException e){
         e.getMessage();
        }
         return Boolean.valueOf(x);
         
    }
    public static void saveBeforeclose(){
        try {FileWriter writer = new FileWriter("before.txt");
             BufferedWriter bw = new BufferedWriter(writer); {

            bw.write(String.valueOf(!getTurn()));
            bw.close();
            writer.close();
        }
        } catch (IOException l) {
            System.err.format("IOException: %s%n", l);
        }
    }
    public void DrawPlayer(){
       // PlayerNum = X;
        if(chooseColor){
        Player.setFill(Color.RED);
        }
        else{
           Player.setFill(Color.BLUE);
        }
        Player.setTranslateX(playerXpos);
        Player.setTranslateY(playerYpos); 
    }
    public void Translation(int x,int y,Circle c)
    {
        TranslateTransition animation=new TranslateTransition(Duration.millis(500),c); 
        animation.setToX(x);
        animation.setToY(y);
        animation.setAutoReverse(false);
        animation.play();
        playerXpos=x;
        playerYpos=y;
   }
    abstract public int CallDice();          ////////// abtract class
 public void Move(int dice_num){
       //here write code to move player
       if(this.winner==false&&100-sqr_num>=dice_num )
       {
       if(start&&dice_num==1){this.up_ladders();this.playerturn=false;start=false;}
       else{
       if(start&& dice_num!=1){dice_num--;start=false;}
        for(int i=0;i<dice_num;i++)
        {
            if(row_pos%2==1){playerXpos+=70;}
            if(row_pos%2==0){playerXpos-=70;}
            if(playerXpos>665) {
            playerYpos-=70;
            playerXpos-=70;
            row_pos++; 
            
            }
            if(playerXpos<35){
            playerYpos-=70;
            playerXpos+=70;
            row_pos++;
            
            }
            if(playerXpos<35||playerYpos<35){
            playerXpos=35;
            playerYpos=35;
            this.winner=true; 
            }sqr_num++;
            
        }
        
       this.Translation( playerXpos,  playerYpos,Player);
        
       } 
       this.drop_snakes();
        this.up_ladders();
        this.Translation( playerXpos,  playerYpos,Player);
        
        this.playerturn=false;
        //System.out.println(sqr_num);
    }
    } //done
    public void drop_snakes()   //done 
   {
       if(this.playerXpos==245&&this.playerYpos==595){this.Translation(455, 665,Player);sqr_num=7;row_pos=1;}
       else if(this.playerXpos==105&&this.playerYpos==245){this.Translation(105,595,Player);sqr_num=19;row_pos=2;}
       else if(this.playerXpos==245&&this.playerYpos==245){this.Translation(35,315,Player);sqr_num=60;row_pos=6;}
       else if(this.playerXpos==455&&this.playerYpos==105){this.Translation(245,525,Player);sqr_num=24;row_pos=3;}
       else if(this.playerXpos==455&&this.playerYpos==315){this.Translation(455,455,Player);sqr_num=34;row_pos=4;}
       else if(this.playerXpos==175&&this.playerYpos==35){this.Translation(105,175,Player);sqr_num=79;row_pos=8;}
       else if(this.playerXpos==525&&this.playerYpos==35){this.Translation(525,175,Player);sqr_num=73;row_pos=8;}
       else if(this.playerXpos==385&&this.playerYpos==35){this.Translation(385,175,Player);sqr_num=75;row_pos=8;}
       
   }
    public void up_ladders() //done
    {
       if(this.playerXpos==35&&this.playerYpos==665){this.Translation(175, 455,Player);sqr_num=38;row_pos=4;}//
       else if(this.playerXpos==35&&this.playerYpos==525){this.Translation(105,385,Player);sqr_num=42;row_pos=5;}//
       else if(this.playerXpos==35&&this.playerYpos==175){this.Translation(35,35,Player);sqr_num=100;row_pos=10;winner=true;}//
       else if(this.playerXpos==525&&this.playerYpos==525){this.Translation(245,105,Player);sqr_num=84;row_pos=9;}//
       else if(this.playerXpos==665&&this.playerYpos==315){this.Translation(455,245,Player);sqr_num=67;row_pos=7;}//
       else if(this.playerXpos==595&&this.playerYpos==665){this.Translation(665,455,Player);sqr_num=31;row_pos=4;}//
       else if(this.playerXpos==665&&this.playerYpos==175){this.Translation(665,35,Player);sqr_num=91;row_pos=10;}
       else if(this.playerXpos==245&&this.playerYpos==665){this.Translation(455,595,Player);sqr_num=14;row_pos=2;} 
    }
    public void resumTurn(){
        if (DrawBoard.resumeORcontinue && DrawBoard.Single)
        {
            if (!playerturn)
            {
               Move(ReturnGame.GetPosPlayer1(DrawBoard.Name,"Computer"));
               playerturn = !playerturn;
               
            }
            else if (playerturn)
            {
                 Move(ReturnGame.GetPosPlayer2(DrawBoard.Name,"Computer"));
                 playerturn = !playerturn;
            }
            
        }
        else if (NewOrContinue.Resume && DrawBoard.multi)
        {
            if (!playerturn)
            {
                Move(ReturnGame.GetPosPlayer1(DrawBoard.Name1,DrawBoard.Name2));
                playerturn = !playerturn;
            }
            else if (playerturn)
            {
                 Move(ReturnGame.GetPosPlayer2(DrawBoard.Name1,DrawBoard.Name2));
                 playerturn = !playerturn;
            }
            
        }
        
        
      // System.out.println(PlayerNum1 + " " + PlayerNum2);
       // System.out.println(ReturnGame.GetPosPlayer2(DrawBoard.Name1,DrawBoard.Name2));
         
    }
}
class Pearson extends Player{
   int number;
    public Pearson(boolean chooseColor) {
        super(chooseColor);
        number = 0;
    }
    public int CallDice(){
        DiceImageProcessing StartRoll = new DiceImageProcessing();
         try{
                    
                StartRoll.startDecleration();
                    Thread.sleep(4000);
                }
                catch(Exception a){
                    a.getMessage();
                }
        try{
            FileReader in= new FileReader("imageprocess.txt");
            BufferedReader br=new BufferedReader(in);
            String i="";
            while ((i=br.readLine())!= null)
            {
                number = Integer.valueOf(i);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return number;
    }
}
class Computer extends Player{
     Dice getNumber;
    
    public Computer(boolean chooseColor) {
        super(chooseColor);
        getNumber = new Dice();
    }
    public int CallDice(){
        return getNumber.random_int();
    }
}
//////////////////////end of class computer/////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////