/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ScoresPage;

import GameGui.SaveScore;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIP
 */
public class Scores  {
    
   static ArrayList<String> ALLNames = new ArrayList<String> ();
   static ArrayList<String> Names = new ArrayList<String> ();
   static ArrayList<String> FinalScores = new ArrayList<String> ();
    static ArrayList<String> Single_Scores = new ArrayList<String> ();
     static ArrayList<String> Multi_Scores = new ArrayList<String> ();
    public static ArrayList<String> GetAll (){
     try 
        {
            BufferedReader br;
            br = new BufferedReader(new FileReader("Scores.txt"));
        
    String line;
            try {
                while ((line = br.readLine()) != null) {
                    // process the line.
                    if(line.equals(""))
                        continue;
                   ALLNames.add(line);
                }
            }
            catch (IOException ex) {
                Logger.getLogger(SaveScore.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        catch (FileNotFoundException ex) {
            Logger.getLogger(SaveScore.class.getName()).log(Level.SEVERE, null, ex);
        }
     return ALLNames;
    }
    public static ArrayList<String> GetSingle ()
    {
        GetAll();
        String [] New = null; 
        for (String ALLName : ALLNames) {
            if(ALLName.contains("Computer"))
            {
               New = ALLName.split("#");
               if (New[0].equals("Computer"))
                   Single_Scores.add(New[2]+"#"+New[3]);
               else
                   Single_Scores.add(New[0]+"#"+New[1]);
                   
            }
            else 
            {
                continue;
            }
                
                    }
        return Single_Scores;
        
    }
    
    public static ArrayList<String> GetMulti ()
    {
        GetAll();
        String [] AllNamesSplitted = null;
        String [] MultiScoresSplitted = null;
       
        boolean Found_first  = false;
        boolean Found_second = false;
        
        int score;
        
        for(int i = 0; i < ALLNames.size(); i++) //looping on the strings from file
        {
            if(ALLNames.get(i).contains("Computer"))
                continue;
            else 
            {
               AllNamesSplitted = ALLNames.get(i).split("#");
               Found_first = false;
                       Found_second= false;
               if (Multi_Scores.size()==0)
               {
               Multi_Scores.add(AllNamesSplitted[0]+"#"+ AllNamesSplitted[1]);
               Multi_Scores.add(AllNamesSplitted[2]+"#"+ AllNamesSplitted[3]);
               }
               else { 
                   
                   for (int j = 0; j < Multi_Scores.size(); j++) //looping on multi_scores
                   {
                       MultiScoresSplitted = Multi_Scores.get(j).split("#");
                       score = 0;
                      
                       if(AllNamesSplitted[0].equals(MultiScoresSplitted[0]))
                       {
                           score = Integer.valueOf(AllNamesSplitted[1]) +Integer.valueOf(MultiScoresSplitted[1]);
                           Multi_Scores.remove(j);
                           Multi_Scores.add(j, AllNamesSplitted[0] + "#" + String.valueOf(score));
                           Found_first = true;
                         
                       }
                       
                       else if(AllNamesSplitted[2].equals(MultiScoresSplitted[0]))
                       {
                           score = Integer.valueOf(AllNamesSplitted[3]) + Integer.valueOf(MultiScoresSplitted[1]);
                           Multi_Scores.remove(j);
                           Multi_Scores.add(j, AllNamesSplitted[2] + "#" + String.valueOf(score));
                           Found_second = true;
                          
                       }
                   }
                   
                  if(Found_first==false)
                   {
                       Multi_Scores.add(AllNamesSplitted[0] + "#" + AllNamesSplitted[1]);
                   }
                   
                   if(Found_second==false)
                       Multi_Scores.add(AllNamesSplitted[2] + "#" + AllNamesSplitted[3]); 
               }
             }
            }
        
        
        
        



        return Multi_Scores;
    } 
    
  
}
class Gamer implements Comparable<Gamer>
{
    public String name ;
    public int Score ;

  public Gamer (String name, int Score)
  {
      this.name = name;
      this.Score = Score;
  }
    public int compareTo(Gamer o) {
       if (Score == o.Score)
           return 0;
       else if (Score > o.Score)
           return 1;
       else 
           return -1;
    }
    
    
}
    
       

