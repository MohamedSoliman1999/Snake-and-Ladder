/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameGui;
import Dice_Prediction.RollPrediction;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import javax.swing.JFrame;
import my.CongratulationsPage.Congratulating;
import my.NewOrContinueForm.NewOrContinue;
import my.PausePage.Pause;
import my.SingleModePage.SingleMode;
import my.StartPage.StartPage;
import my.TurnPage.Turn;
import my.TwoPlayersModePage.TwoPlayersMode;


/**
 *
 * @author abdul
 */
public class DrawBoard extends JFrame{
        protected static final int square_size = 70; 
        protected static int diceNumber;
        
        public static String  Name = SingleMode.name;
        public static String Name1 = TwoPlayersMode.name1;
        public static String Name2 = TwoPlayersMode.name2;
        
        public static boolean Single = SingleMode.singleMode;
        public static boolean multi = TwoPlayersMode.twoPlayersMode;
        
        public static Group titleGroup = new Group();
        
        protected static SetImage photo, photo1 ,photo2;
        protected static SetImage IntialDicePhoto;
        
        public static Player Player_single, Multi_player2;
        public static Player single_computer;
        
        public static Turn initiatepage;
        
        protected static Button btn2_roll;
       /////////////////////////////////////////////////////////////////////////
        private final int width = 10; 
        private final int height = 10;
        
        private boolean WhichColor = SingleMode.whichColor;
        private boolean whichColor = TwoPlayersMode.whichColor;
     
        private SetLabel lblname, lblname2, lblScore_1 , lblScore_2 ;
         
        private Repeated_actions repeat_operation;
        
        Congratulating winner;
        public static boolean resumeORcontinue = NewOrContinue.Resume;
        public static JFXPanel fxPanel;
        
        public static Pane root;
        
        private SetImage gameboard;
        
        private Button btn1_paus;
        public static AudioClip audio2;
        
    public DrawBoard(){
            CreateBoardFrame();   //creating suitable frame for the gameboard 
        
            setMainAudio();    //playing the main music of the game mode
         if(!resumeORcontinue){
            Player.playerturn = Player.getTurn();  // turn random to select random players
            Player.saveTurn();  
         }
         else if(resumeORcontinue){
              Player.playerturn = Player.getBeforeclose();
              System.out.println(resumeORcontinue); 
         }
            
            setPreviousRolls();  //setting previous rolls for each player before starting the game
        
            CheckFirstPlayer();  //Checking which player will play first
    }
    
    ////////////////////////////////////////////////////////////////////////////
    private void CreateBoardFrame()
    {
        
        this.setAlwaysOnTop(true);
            JFXPanel fxPanel = new JFXPanel();  
            add(fxPanel);
            
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            int width1 = gd.getDisplayMode().getWidth();
            int height1 = gd.getDisplayMode().getHeight();
            
            fxPanel.setScene(getScene());
            fxPanel.setVisible(true);
            
            setSize(width1,height1);
            setVisible(true);
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            
            repeat_operation = new Repeated_actions();
            diceNumber = 0;
            setAlwaysOnTop(false);
            this.setSize(1400,750);
            this.setLocationRelativeTo(null);
            StartPage.audio.stop();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    private void setMainAudio()
    {
         AudioClip audio1 = new AudioClip(this.getClass().getResource("LetGame.wav").toString());
            audio1.play();
            PauseTransition delay18 = new PauseTransition(Duration.millis(450));
            delay18.setOnFinished(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent t) {
                audio2 = new AudioClip(this.getClass().getResource("RunSong.wav").toString());
                audio2.play();

                }
            });
            delay18.play();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    private void setPreviousRolls()
    {
        try{
                //player
            new RollPrediction().readFile(Name + ".txt", Player.dice);
            for(int i = 0; i < 6; i++)
            {
                Player.Num_of_Rolls += Player.dice[i].counter;
            }
            
            //computer
            new RollPrediction().readFile("computer.txt", single_computer.dice);
            for(int i = 0; i < 6; i++)
            {
                single_computer.Num_of_Rolls += single_computer.dice[i].counter;
                
            }
               
            }
           
            catch(IOException EX){
                EX.getMessage();
            } 
    }
    
    ////////////////////////////////////////////////////////////////////////////
    private void CheckFirstPlayer()
    {
        if(Single){             /////////////////////////////////////////////////////////////////////////// player turn
            if(!Player.playerturn){           //// check player1 turn at first of game 
                repeat_operation.playerOperarion(Name);                
            }
            else if(single_computer.playerturn){
                repeat_operation.computer_Operation();
    }
        }
        if(multi){              ////////////case 2 players
                
            if(!Player.playerturn){
                repeat_operation.playerOperarion(Name1);
            }
            else if(Multi_player2.playerturn){
                repeat_operation.playerOperarion(Name2);
            }
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    private void setBackground()
    {
        root = new Pane();
        root.getChildren().addAll(titleGroup);
        
        for(int i = 0;i<height;i++){
            for(int j = 0;j<width;j++){
                Square title = new Square(square_size, square_size);
                
                title.setTranslateX(j*square_size);
                title.setTranslateY(i*square_size);
                
                titleGroup.getChildren().add(title);
            }
        }
        
        gameboard = new SetImage("GameBoard.png",700, 700,0, 0);
        SetImage IntialbackPhoto = new SetImage("pic1.png", 1100, 700,700, -200);
        titleGroup.getChildren().addAll(IntialbackPhoto.displayImage);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    private void PutPlayersInfoInLabels()
    {
        if(Single){
           
            Player_single = new Pearson(WhichColor);
           
            Player_single.DrawPlayer();
            if(resumeORcontinue){
                Player_single.resumTurn();
            }
           
            lblname = new SetLabel.Builder(Name).WithX(60).WithY(60).WithZ(1.5).WithA(1.5).WithB(870).WithC(95).build();
            
            single_computer = new Computer(!WhichColor);
           
            single_computer.DrawPlayer();
            if(resumeORcontinue){
                single_computer.resumTurn();
            }
            
            lblname2 = new SetLabel.Builder("Computer").WithX(60).WithY(60).WithZ(1.5).WithA(1.5).WithB(870).WithC(190).build();
            
            int ScorePlayer1 = SaveScore.GetScorePlayer1(Name,"Computer");
            int ScorePlayer2 = SaveScore.GetScorePlayer2(Name,"Computer");
            
            lblScore_1 = new SetLabel.Builder(String.valueOf(ScorePlayer1)).WithX(60).WithY(55).WithZ(1.5).WithA(1.5).WithB(1150).WithC(95).build();
            lblScore_2 = new SetLabel.Builder(String.valueOf(ScorePlayer2)).WithX(60).WithY(55).WithZ(1.5).WithA(1.5).WithB(1150).WithC(190).build();
            
          //   lblPos_1 = new SetLabel.Builder(String.valueOf(ReturnGame.GetPosPlayer1(Name,"Computer"))).WithX(60).WithY(55).WithZ(1.5).WithA(1.5).WithB(1150).WithC(295).build();
         //   lblpos_2 = new SetLabel.Builder(String.valueOf(ReturnGame.GetPosPlayer2(Name,"Computer"))).WithX(60).WithY(55).WithZ(1.5).WithA(1.5).WithB(1150).WithC(390).build();
            if (Player.chooseColor){
            photo1 = new SetImage("Blue Figure.png",70,70,750,95);
            photo2 = new SetImage("Red Figure.png",70,70,750,190);
            }
            
            else if (!Player.chooseColor)
            {
              photo1 = new SetImage("Red Figure.png",70,70,750,95);
              photo2 = new SetImage("Blue Figure.png",70,70,750,190);
            }
              
        } //end of (single) case
        
        else if(multi){
             
            Player_single = new Pearson(whichColor);
          
            Player_single.DrawPlayer();
            if(resumeORcontinue){
                Player_single.resumTurn();
            }
            lblname = new SetLabel.Builder(Name1).WithX(60).WithY(60).WithZ(1.5).WithA(1.5).WithB(870).WithC(95).build();
            
            Multi_player2 = new Pearson(!whichColor);
            
            Multi_player2.DrawPlayer();
            if(resumeORcontinue){
                Multi_player2.resumTurn();
            }
            lblname2 = new SetLabel.Builder(Name2).WithX(60).WithY(60).WithZ(1.5).WithA(1.5).WithB(870).WithC(190).build();
            
            int ScorePlayer1 = SaveScore.GetScorePlayer1(Name1,Name2);
            int ScorePlayer2 = SaveScore.GetScorePlayer2(Name1,Name2);
            
            lblScore_1 = new SetLabel.Builder(String.valueOf(ScorePlayer1)).WithX(60).WithY(55).WithZ(1.5).WithA(1.5).WithB(1170).WithC(95).build();
            lblScore_2 = new SetLabel.Builder(String.valueOf(ScorePlayer2)).WithX(60).WithY(55).WithZ(1.5).WithA(1.5).WithB(1170).WithC(190).build();
            
            if (Player.chooseColor){
                photo1 = new SetImage("Blue Figure.png",70,70,750,95);
                photo2 = new SetImage("Red Figure.png",70,70,750,190);
            }
            
            else if (!Player.chooseColor)
            {
                photo1 = new SetImage("Red Figure.png",70,70,750,95);
                photo2 = new SetImage("Blue Figure.png",70,70,750,190);
            }
        } //end of (multi) case
    }        
    
    ////////////////////////////////////////////////////////////////////////////
    private void HandlePlayerOneWinning()
    {
          AudioClip audio7 = new AudioClip(this.getClass().getResource("win.wav").toString());
                audio7.play();
                PauseTransition delay16 = new PauseTransition(Duration.millis(450));
                    delay16.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent t) {
                        SaveScore.Save(Name,"Computer",1);
                        String score = String.valueOf(SaveScore.GetScorePlayer1(Name,"Computer"));
                        new RollPrediction().writeFile(Name + ".txt", Player_single.dice);
                        new RollPrediction().writeFile("computer.txt", single_computer.dice);
                        new RollPrediction().drawMainAppearanceCharts(Player.dice, Name);
                        new RollPrediction().drawMainAppearanceCharts(single_computer.dice, "computer");
                         winner = new Congratulating(Name,score);
                         winner.setVisible(true);
                         setVisible(false);
                        initiatepage.setVisible(false);
                        audio2.stop();
                        
                            
                        }
        });
        delay16.play();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    private void HandlePlayerOneWinningMulti(){
            AudioClip audio7 = new AudioClip(this.getClass().getResource("win.wav").toString());
                audio7.play();
                PauseTransition delay16 = new PauseTransition(Duration.millis(450));
                    delay16.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent t) {
                       SaveScore.Save(Name1,Name2,1);
                        String score = String.valueOf(SaveScore.GetScorePlayer1(Name1,Name2));
                        new RollPrediction().writeFile(Name1 + ".txt", Player_single.dice);
                        new RollPrediction().writeFile(Name2+".txt", Multi_player2.dice);
                        new RollPrediction().drawMainAppearanceCharts(Player_single.dice, Name1);
                        new RollPrediction().drawMainAppearanceCharts(Multi_player2.dice, Name2);
                         winner = new Congratulating(Name1,score);
                         winner.setVisible(true);
                         setVisible(false);
                        initiatepage.setVisible(false);
                            //repeat_operation.playerOperarion(Name1);
                            audio2.stop();
                        }
        });
        delay16.play();
    }
    private void HandlePlayerTwoWinning()
    {
        AudioClip audio7 = new AudioClip(this.getClass().getResource("win.wav").toString());
                audio7.play();
                PauseTransition delay16 = new PauseTransition(Duration.millis(450));
                    delay16.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent t) {
                        SaveScore.Save(Name1,Name2,2);
                        String score = String.valueOf(SaveScore.GetScorePlayer1(Name1,Name2));
                        new RollPrediction().writeFile(Name1 + ".txt", Player_single.dice);
                        new RollPrediction().writeFile(Name2+".txt", Multi_player2.dice);
                        new RollPrediction().drawMainAppearanceCharts(Player_single.dice, Name1);
                        new RollPrediction().drawMainAppearanceCharts(Multi_player2.dice, Name2);
                         winner = new Congratulating(Name2,score);
                         winner.setVisible(true);
                            setVisible(false);
                            initiatepage.setVisible(false);
                            //repeat_operation.playerOperarion(Name1);
                            audio2.stop();
                        }
        });
        delay16.play();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    private void CreateButtons()
    {
        //create Pause button
        SetImage pause = new SetImage("pause.png", 20, 20, 1250, 45);
        btn1_paus=new Button();
        
        btn1_paus.setGraphic(pause.displayImage);
        
        btn1_paus.setStyle("-fx-background-color:\n" +
        "        linear-gradient(#f0ff35, #a9ff00),\n" +
        "        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" +
        "    -fx-background-radius: 6, 5;\n" +
        "    -fx-background-insets: 0, 1;\n" +
        "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
        "    -fx-text-fill: #395306;");
        
        btn1_paus.setLayoutX(1250);
        btn1_paus.setLayoutY(45);
        btn1_paus.setScaleX(3.5);
        btn1_paus.setScaleY(1.5);
        
        btn1_paus.setOnAction(e-> {
            Pause p = new Pause();
            p.setVisible(true);
            try {
                Thread.sleep(5000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(DrawBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        ////////////////////////////////////////////////////////////////////////
        //////////////////end of creating pause button//////////////////////////
        
        
       IntialDicePhoto = new SetImage("1.png", 80, 80, 940, 310);
        SetImage rollBtn = new SetImage("Run.png",50,50,960,500);
        
        btn2_roll = new Button();
        btn2_roll.setGraphic(rollBtn.displayImage);
        
        btn2_roll.setStyle("-fx-background-color:\n" +
        "        linear-gradient(#f0ff35, #a9ff00),\n" +
        "        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" +
        "    -fx-background-radius: 6, 5;\n" +
        "    -fx-background-insets: 0, 1;\n" +
        "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
        "    -fx-text-fill: #395306;");
        
        btn2_roll.setLayoutX(960);
        btn2_roll.setLayoutY(500);
        btn2_roll.setScaleX(3.5);
        btn2_roll.setScaleY(1.5);
        
        btn2_roll.setOnAction(e-> { 
            DrawBoard.titleGroup.getChildren().removeAll(DrawBoard.btn2_roll);
            
            AudioClip audio4 = new AudioClip(this.getClass().getResource("DiceSound.wav").toString());
            audio4.play();
            
            repeat_operation.Player_computer_op();
            
            PauseTransition delay8 = new PauseTransition(Duration.millis(4500));  //////////////////// Main delay
            
            delay8.setOnFinished(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent t) {
                    
                    if(!Player_single.playerturn&&Single){
                        if(resumeORcontinue){
                        Player.saveBeforeclose();
                        }
                        Player_single.Move(diceNumber);
                        
                        PauseTransition delay23 = new PauseTransition(Duration.millis(3500)); ///inner delay
                        
                        delay23.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override public void handle(ActionEvent t) {
                                
                                if(Player_single.winner&&Single){  /////// put delay code here
                                   HandlePlayerOneWinning();
                                }
                            }
                        }); //end of inner delay
                        
                        delay23.play();
                 
                        Player.playerturn = true;
                        
                        
                        single_computer.playerturn = true;
                        repeat_operation.computer_Operation();
                        
                        
                        
                    } //end of (Player 1 turn case)
               else if(multi&&!Player_single.playerturn){
                   if(resumeORcontinue){
                        Player.saveBeforeclose();
                        }
                Player_single.Move(diceNumber);
                //**********************************************************************
                PauseTransition delay23 = new PauseTransition(Duration.millis(3500));
                    delay23.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent t) {
                 if(Player_single.winner&&multi){  /////// put delay code here
                     HandlePlayerOneWinningMulti();   
         }
                  }
        });
        delay23.play();
                
                //*********************************************************************************************************
                    Player.playerturn = true;
                    repeat_operation.playerOperarion(Name2);
                
                 
            }
                    
                    else if(Multi_player2.playerturn&&multi){
                         if(resumeORcontinue){
                        Player.saveBeforeclose();
                        }
                        Multi_player2.Move(diceNumber);
                
                        PauseTransition delay23 = new PauseTransition(Duration.millis(3500));
                        
                        delay23.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override public void handle(ActionEvent t) {
                                
                                if(Multi_player2.winner&&multi){  /////// put delay code here
                                    HandlePlayerTwoWinning();
                                }
                            }
                        });
                        
                        delay23.play();
                
                         Player.playerturn = false;
                        Multi_player2.playerturn = false;
                        repeat_operation.playerOperarion(Name1);
                 
                    } //end of (player 2 turn) case
                
                }   
            }); //end of main delay
        
            delay8.play();
            
            try {       ///////////////// for image processing don't remove
                    photo.displayImage.setVisible(false);
            } 
            catch (Exception a) {
                a.getMessage();
            }
        }); //end of button's action
         
        ////////////////////////////////////////////////////////////////////////
        ////////////////////end of creating Roll button/////////////////////////  
         
         
        if(multi){
            titleGroup.getChildren().addAll(gameboard.displayImage,IntialDicePhoto.displayImage,Player_single.Player,Multi_player2.Player,btn1_paus,lblname.getLblname(),lblname2.getLblname() , lblScore_1.getLblname(),lblScore_2.getLblname(),photo1.displayImage,photo2.displayImage);
        }
        else if(Single){
            titleGroup.getChildren().addAll(gameboard.displayImage,IntialDicePhoto.displayImage,Player_single.Player,single_computer.Player,btn1_paus,lblname.getLblname(),lblname2.getLblname(),lblScore_1.getLblname(),lblScore_2.getLblname(),photo1.displayImage,photo2.displayImage);
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////  
    
    private Parent createContent(){
  
        setBackground();    //Drawing squares and setting background
        
        PutPlayersInfoInLabels();  //Drawing players and set their info in labels
           
        CreateButtons();
        
        return root;    
    }    
    public Scene getScene() { // main form to call all values
        return new Scene(createContent()); // define form
    }
}
