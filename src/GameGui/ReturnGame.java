/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameGui;


import static GameGui.SaveScore.BeforeDelete;
import static GameGui.SaveScore.PlayBefore;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIP
 */
public class ReturnGame {
    public String Player1;
    public  String Player2;
    private static final String FileName = "Games.txt";
    public  int Pos1;
    public int Pos2;
    public ReturnGame (String player1, String player2)
    {
        this.Player1 = player1 ;
        this.Player2 = player2 ;
        this.Pos1  = 0 ;
        this.Pos2  = 0 ;
    }
    public static String HavePuase(String player1 , String player2)
    {
       String line = SaveScore.PlayBefore(player1, player2 , FileName);
       return line ;
    }
    
    public  static int GetPosPlayer1 (String Player1 , String Player2)
    {
         String [] detailes;
        if (HavePuase(Player1, Player2).equals("Not Found"))
            return 0;
        else {
            
            detailes = HavePuase(Player1, Player2).split("#");
        }
        if (Player1.equals(detailes[0]))
            return Integer.valueOf(detailes[1]);
        else if (Player1.equals(detailes[2])) {
            return Integer.valueOf(detailes[3]);
        }
        return 0;
    }
     public  static int GetPosPlayer2 (String Player1 , String Player2)
    {
        
        String [] detailes;
        if (HavePuase(Player1, Player2).equals("Not Found"))
            return 0;
        else {
            
            detailes = HavePuase(Player1, Player2).split("#");
        }
         if (Player2.equals(detailes[0]))
            return Integer.valueOf(detailes[1]);
        else if (Player2.equals(detailes[2])) {
            return Integer.valueOf(detailes[3]);
        }
        return 0;
    }
     public static void Delete (String Player1 , String Player2 )
    {
      try {
            BufferedWriter writer ;
            writer = new BufferedWriter(new FileWriter(FileName, true));
            for (String i : BeforeDelete(Player1, Player2, FileName))
            {
                
                writer.append(i);
                writer.newLine();
            }
            
            
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveScore.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       }
                 
    
      public static void Save (String Player1 , String Player2 , int P1pos , int P2pos)
    {
        try {
            String line = "";
            
                      line = Player1 + "#" + String.valueOf(P1pos)+ "#" + Player2 +"#"+String.valueOf(P2pos);
                      Delete(Player1 , Player2);
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("Games.txt", true));
            writer.append("\n");
            writer.append(line);
            writer.close();
            } catch (IOException ex) {
            Logger.getLogger(SaveScore.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
        
        
    }
}
