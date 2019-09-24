/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameGui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIP
 */
public class SaveScore {
    public static String player1 ;
    public static String player2 ;
    private static String FileName = "Scores.txt";
    public int    Score1  ;
    public int    Score2  ;
    /////////////////////////////////////////////////
    public SaveScore (String player1, String player2)
    {
        this.player1 = player1 ;
        this.player2 = player2 ;
        this.Score1  = 0 ;
        this.Score2  = 0 ;
    }
    public static String PlayBefore(String player1 , String player2 , String name )
    {
        try 
        {
            BufferedReader br;
            br = new BufferedReader(new FileReader(name));
        
    String line;
            try {
                while ((line = br.readLine()) != null) {
                    // process the line.
                    if (line.contains(player1)&&line.contains(player2) )
                    {
                        return line ;
                    }
                }       } catch (IOException ex) {
                Logger.getLogger(SaveScore.class.getName()).log(Level.SEVERE, null, ex);
            }
}       catch (FileNotFoundException ex) {
            Logger.getLogger(SaveScore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Not Found";
    }
    public  static int GetScorePlayer1 (String Player1 , String Player2)
    {
       
        String [] detailes;
        if (PlayBefore(Player1, Player2 , FileName).equals("Not Found"))
            return 0;
        else {
            
            detailes = PlayBefore(Player1, Player2, FileName).split("#");
        }
        if (Player1.equals(detailes[0]))
            return Integer.valueOf(detailes[1]);
        else if (Player1.equals(detailes[2])) {
            return Integer.valueOf(detailes[3]);
        }
        return 0;
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    public  static int GetScorePlayer2 (String Player1 , String Player2)
    {
        
        String [] detailes;
        if (PlayBefore(Player1, Player2,FileName).equals("Not Found"))
            return 0;
        else {
            
            detailes = PlayBefore(Player1, Player2,FileName).split("#");
        }
         if (Player2.equals(detailes[0]))
            return Integer.valueOf(detailes[1]);
        else if (Player2.equals(detailes[2])) {
            return Integer.valueOf(detailes[3]);
        }
        return 0;
    }
    //*********************************************************************************************
    public static void Save (String Player1 , String Player2 , int Winner)
    {
        try {
            String line = "";
            if (PlayBefore(Player1, Player2 , FileName).equals("Not Found"))
            {
                if (Winner == 1)
                    line = Player1 + "#" + "1"+ "#" + Player2 +"#"+ "0";
                else if (Winner == 2)
                    line = Player1 + "#" + "0"+ "#" + Player2 +"#"+ "1";
            }
            else {
                int S1 = GetScorePlayer1(Player1, Player2);
                int S2 = GetScorePlayer2(Player1, Player2);
                ////////////////////////////////////////////////////////////////////////////////////////
                if (Winner == 1)
                {
                    S1= S1 + 1;
                    line = Player1 + "#" + String.valueOf(S1) +"#"+Player2 +"#" + String.valueOf(S2);
                }
                else if (Winner == 2)
                {
                    S2= S2 + 1;
                    line = Player1 + "#" + String.valueOf(S1) +"#"+Player2 +"#" + String.valueOf(S2);
                }
                Delete(Player1 , Player2);
                
            }
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(FileName, true));
            
                writer.append("\n");
                writer.append(line);
                
               
                  writer.close();
            } catch (IOException ex) {
            Logger.getLogger(SaveScore.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
        
        
    }
    public static ArrayList<String> BeforeDelete (String Player1 , String Player2 , String FileName)
    {
         ArrayList<String> files = new ArrayList<String>();
        PrintWriter pw = null;
	try {

           
            BufferedReader br = null;
            try {
                
                br = new BufferedReader(new FileReader(FileName));
                
                String line2;
                while ((line2 = br.readLine()) != null) {
                    if (line2.equals( PlayBefore( Player1 , Player2,FileName)) || line2.equals(""))
                        continue;
                    else
                        files.add(line2);
                }
                br.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            ///////////////////////////////////////////////////////////////////////////////////
            pw = new PrintWriter(FileName);
            pw.close();
            return files ;

	} catch (FileNotFoundException ex) {
		Logger.getLogger(SaveScore.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
        return files;
    }


    public static void Delete(String Player1 , String Player2)
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
          
}

