/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameGui;

import Dice_Prediction.RollPrediction;
import static GameGui.DrawBoard.Name;
import static GameGui.DrawBoard.Player_single;
import static GameGui.DrawBoard.single_computer;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import my.CongratulationsPage.Congratulating;
import my.LevelsPage.Level;
import my.TurnPage.Turn;

/**
 *
 * @author abdul
 */
public class Repeated_actions {
     Levels easy , hard;
    Dice getNumber;
    
  public  Repeated_actions() {
    easy = new Easy();
    hard = new Hard();
    getNumber = new Dice();
}
    public void computer_Operation(){
           /////////////////////////////////////////////////////////////////////////////////////////////////// start
           if(!DrawBoard.Player_single.winner){
                DrawBoard.initiatepage = new Turn("computer");
                DrawBoard.initiatepage.setVisible(true);
                DrawBoard.initiatepage.setAlwaysOnTop(true);
               // DrawBoard.diceNumber = DrawBoard.single_computer.CallDice();
               if ( DrawBoard.Single &&Level.choice == 1){
               DrawBoard.diceNumber = easy.random_num();
           }
           else if (DrawBoard.Single && Level.choice ==2){
             DrawBoard.diceNumber =getNumber.random_int();
           }
           else if (DrawBoard.Single &&Level.choice == 3){
               DrawBoard.diceNumber = hard.random_num();
           }
                PauseTransition delay2 = new PauseTransition(Duration.millis(1500));
            delay2.setOnFinished(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent t) {
                    DrawBoard.initiatepage.setVisible(false);
                    
                    new RollPrediction().predict(single_computer.dice ,"computer",single_computer.Num_of_Rolls);
                    
                    PauseTransition delay22 = new PauseTransition(Duration.millis(1500));
                    delay22.setOnFinished(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent t) {                    
                    AudioClip audio3 = new AudioClip(this.getClass().getResource("DiceSound.wav").toString());
                audio3.play();
                
            DrawBoard.IntialDicePhoto.displayImage.setImage(null);
            try{
            DrawBoard.titleGroup.getChildren().removeAll(DrawBoard.photo.displayImage);
            }
            catch(Exception e){
                e.getMessage();
            }
            SetImage RollingDice = new SetImage("roll.gif", 100, 100,940, 310);
            DrawBoard.titleGroup.getChildren().addAll(RollingDice.displayImage);
             
            PauseTransition delay3 = new PauseTransition(Duration.millis(2000));
        delay3.setOnFinished(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent t) {
                RollingDice.displayImage.setImage(null);
        if(DrawBoard.diceNumber == 1){
            DrawBoard.photo = new SetImage("1.png", 100, 100,940, 310);
            DrawBoard.titleGroup.getChildren().addAll(DrawBoard.photo.displayImage);
            
            single_computer.dice[0].AddRoll();
            single_computer.Num_of_Rolls++;
        }
        else if(DrawBoard.diceNumber == 2){
            DrawBoard.photo = new SetImage("2.png", 100, 100,940, 310);

            DrawBoard.titleGroup.getChildren().addAll(DrawBoard.photo.displayImage);
            
            single_computer.dice[1].AddRoll();
            single_computer.Num_of_Rolls++;
        }
        else if(DrawBoard.diceNumber == 3){
           DrawBoard. photo = new SetImage("3.png", 100, 100,940, 310);

            DrawBoard.titleGroup.getChildren().addAll(DrawBoard.photo.displayImage);
            
            single_computer.dice[2].AddRoll();
            single_computer.Num_of_Rolls++;
        }
        else if(DrawBoard.diceNumber == 4){
            DrawBoard.photo = new SetImage("4.png", 100, 100,940, 310);

            DrawBoard.titleGroup.getChildren().addAll(DrawBoard.photo.displayImage);
            
            single_computer.dice[3].AddRoll();
            single_computer.Num_of_Rolls++;
        }
        else if(DrawBoard.diceNumber == 5){
            DrawBoard.photo = new SetImage("5.png", 100, 100,940, 310);

            DrawBoard.titleGroup.getChildren().addAll(DrawBoard.photo.displayImage);
            
            single_computer.dice[4].AddRoll();
            single_computer.Num_of_Rolls++;
        }
        else if(DrawBoard.diceNumber == 6){
           DrawBoard.photo = new SetImage("6.png", 100, 100,940, 310);

            DrawBoard.titleGroup.getChildren().addAll(DrawBoard.photo.displayImage);
            
            single_computer.dice[5].AddRoll();
            single_computer.Num_of_Rolls++;
            
        }
            }
        });
        delay3.play();

        PauseTransition delay4 = new PauseTransition(Duration.millis(2500));  //////////// main delay
        delay4.setOnFinished(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent t) {
             if(DrawBoard.single_computer.playerturn){
                 if(DrawBoard.resumeORcontinue){
                        Player.saveBeforeclose();
                        }
                 
                DrawBoard.single_computer.Move(DrawBoard.diceNumber);
                PauseTransition delay23 = new PauseTransition(Duration.millis(3500));
                    delay23.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent t) {
                 if(DrawBoard.single_computer.winner){  /////// put delay code here
                 AudioClip audio7 = new AudioClip(this.getClass().getResource("lose.wav").toString());
                audio7.play();
                PauseTransition delay16 = new PauseTransition(Duration.millis(450));
                    delay16.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent t) {
                            
                           
                            
                         SaveScore.Save(DrawBoard.Name,"Computer",2);
                          Level.Pass.setVisible(false);
                        String score = String.valueOf(SaveScore.GetScorePlayer1(DrawBoard.Name,"Computer"));
                        
                        
                        //writing game rolls in files
                        new RollPrediction().writeFile(DrawBoard.Name + ".txt", Player_single.dice);
                        new RollPrediction().writeFile("computer.txt", single_computer.dice);
                        
                        new RollPrediction().drawMainAppearanceCharts(Player_single.dice, Name);
                        new RollPrediction().drawMainAppearanceCharts(single_computer.dice, "computer");
                        Congratulating winner = new Congratulating("Computer",score);
                        winner.setVisible(true);
                        Level.Pass.setVisible(false);
                        DrawBoard.initiatepage.setVisible(false);
                        
                        }
        });
        delay16.play();
             
         }
                  }
        });
        delay23.play();
                
                
                //////////////////////////////////////////////////////// here
                Player.playerturn = false;
                DrawBoard.single_computer.playerturn = false;
                 playerOperarion(DrawBoard.Name);
            }   
            }
        });
        delay4.play();
          }
            });
            delay22.play();
                 }
            });
            delay2.play();
            
            }
    }
    public void playerOperarion(String name){
                DrawBoard.initiatepage = new Turn(name);
                DrawBoard.initiatepage.setVisible(true);
                PauseTransition delay1 = new PauseTransition(Duration.millis(2500));
            delay1.setOnFinished(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent t) {
                   DrawBoard.initiatepage.setVisible(false);
                   if(DrawBoard.Single&&!DrawBoard.Player_single.playerturn){
                    new RollPrediction().predict(DrawBoard.Player_single.dice, Name,DrawBoard.Player_single.Num_of_Rolls);
                   }
                   else if(DrawBoard.multi&&!DrawBoard.Player_single.playerturn){
                       new RollPrediction().predict(DrawBoard.Player_single.dice, DrawBoard.Name1,DrawBoard.Player_single.Num_of_Rolls);
                   }
                   else if(DrawBoard.multi&&DrawBoard.Multi_player2.playerturn){
                       new RollPrediction().predict(DrawBoard.Multi_player2.dice, DrawBoard.Name2,DrawBoard.Multi_player2.Num_of_Rolls);
                   }
                    PauseTransition delay21 = new PauseTransition(Duration.millis(1500)); // edit it in case low timer
            delay21.setOnFinished(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent t) {
                   DrawBoard.titleGroup.getChildren().addAll(DrawBoard.btn2_roll);  
                    }
            });
            delay21.play();
                 }
            });
            delay1.play();
            
    }
    public void Player_computer_op(){
            DrawBoard.IntialDicePhoto.displayImage.setImage(null);
            SetImage RollingDice = new SetImage("roll.gif", 100, 100,940, 310);
            DrawBoard.titleGroup.getChildren().addAll(RollingDice.displayImage);
             DrawBoard.diceNumber =/* DrawBoard.Player_single.CallDice();*/(int) ((Math.random()*(7-1))+1);
            
           
            PauseTransition delay7 = new PauseTransition(Duration.millis(2000));
        delay7.setOnFinished(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent t) {
                RollingDice.displayImage.setImage(null);
        if(DrawBoard.diceNumber == 1){
            DrawBoard.photo = new SetImage("1.png", 100, 100,940, 310);
            DrawBoard.titleGroup.getChildren().addAll(DrawBoard.photo.displayImage);
            if(!DrawBoard.Player_single.playerturn){
                 DrawBoard.Player_single.dice[0].AddRoll();
                 DrawBoard.Player_single.Num_of_Rolls++;
            }
             else if(DrawBoard.Multi_player2.playerturn&&DrawBoard.multi){
                 DrawBoard.Multi_player2.dice[0].AddRoll();
                 DrawBoard.Multi_player2.Num_of_Rolls++;
             }
           
        }
        else if(DrawBoard.diceNumber == 2){
            DrawBoard.photo = new SetImage("2.png", 100, 100,940, 310);

            DrawBoard.titleGroup.getChildren().addAll(DrawBoard.photo.displayImage);
            
            if(!DrawBoard.Player_single.playerturn){
                 DrawBoard.Player_single.dice[1].AddRoll();
                 DrawBoard.Player_single.Num_of_Rolls++;
            }
             else if(DrawBoard.Multi_player2.playerturn&&DrawBoard.multi){
                 DrawBoard.Multi_player2.dice[1].AddRoll();
                 DrawBoard.Multi_player2.Num_of_Rolls++;
             }
        }
        else if(DrawBoard.diceNumber == 3){
            DrawBoard.photo = new SetImage("3.png", 100, 100,940, 310);

            DrawBoard.titleGroup.getChildren().addAll(DrawBoard.photo.displayImage);
            
            if(!DrawBoard.Player_single.playerturn){
                 DrawBoard.Player_single.dice[2].AddRoll();
                 DrawBoard.Player_single.Num_of_Rolls++;
            }
             else if(DrawBoard.Multi_player2.playerturn&&DrawBoard.multi){
                 DrawBoard.Multi_player2.dice[2].AddRoll();
                 DrawBoard.Multi_player2.Num_of_Rolls++;
             }
        }
        else if(DrawBoard.diceNumber == 4){
           DrawBoard.photo = new SetImage("4.png", 100, 100,940, 310);

            DrawBoard.titleGroup.getChildren().addAll(DrawBoard.photo.displayImage);
            
            if(!DrawBoard.Player_single.playerturn){
                 DrawBoard.Player_single.dice[3].AddRoll();
                 DrawBoard.Player_single.Num_of_Rolls++;
            }
             else if(DrawBoard.Multi_player2.playerturn&&DrawBoard.multi){
                 DrawBoard.Multi_player2.dice[3].AddRoll();
                 DrawBoard.Multi_player2.Num_of_Rolls++;
             }
        }
        else if(DrawBoard.diceNumber == 5){
            DrawBoard.photo = new SetImage("5.png", 100, 100,940, 310);

            DrawBoard.titleGroup.getChildren().addAll(DrawBoard.photo.displayImage);
            
            if(!DrawBoard.Player_single.playerturn){
                 DrawBoard.Player_single.dice[4].AddRoll();
                 DrawBoard.Player_single.Num_of_Rolls++;
            }
             else if(DrawBoard.Multi_player2.playerturn&&DrawBoard.multi){
                 DrawBoard.Multi_player2.dice[4].AddRoll();
                 DrawBoard.Multi_player2.Num_of_Rolls++;
             }
        }
        else if(DrawBoard.diceNumber == 6){
           DrawBoard.photo = new SetImage("6.png", 100, 100,940, 310);

            DrawBoard.titleGroup.getChildren().addAll(DrawBoard.photo.displayImage);
            
            if(!DrawBoard.Player_single.playerturn){
                 DrawBoard.Player_single.dice[5].AddRoll();
                 DrawBoard.Player_single.Num_of_Rolls++;
            }
             else if(DrawBoard.Multi_player2.playerturn&&DrawBoard.multi){
                 DrawBoard.Multi_player2.dice[5].AddRoll();
                 DrawBoard.Multi_player2.Num_of_Rolls++;
             }
            
        }
            }
        });
        delay7.play();
}
}
