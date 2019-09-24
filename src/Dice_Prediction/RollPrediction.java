/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dice_Prediction;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author abdul
 */


public class RollPrediction extends JFrame{
    
    public void readFile(String fileName, Dice_Roll [] arr) throws IOException
    {
        try
        {
            FileReader reader = new FileReader(fileName);
            BufferedReader BFreader = new BufferedReader(reader);
            String temp;
            int i = 0;
            
            while((temp = BFreader.readLine())!= null && i < 6)
            {
                arr[i].counter = Integer.valueOf(temp);
                i++;
            }
            BFreader.close();
            reader.close();
        }
        catch (IOException e)
        {

            FileReader reader1 = new FileReader("Dice Rolls(default).txt");
            BufferedReader BFreader1 = new BufferedReader(reader1);
            String temp;
            int i = 0;
            
            while((temp = BFreader1.readLine())!= null && i < 6)
            {
                arr[i].counter = Integer.valueOf(temp);
                i++;
            }
            BFreader1.close();
            reader1.close();
        }
    } 
    
    public void writeFile(String fileName, Dice_Roll [] arr)
    {
        try
        {
            FileWriter writer = new FileWriter(fileName);
            PrintWriter pwriter = new PrintWriter(writer);
            
            for(int i = 0; i < 6; i++)
            {
             pwriter.println(arr[i].counter);
            }
            
            pwriter.close();
            writer.close();
        }
        catch(IOException e)
        {
           System.out.println("There's an error writing the file!");
        }
    }
    
    public void predict(Dice_Roll [] arr ,String name,int total)
    {
       //////////////////////////////////////calculations for linear regression
       int n = 6;
       int SUMx = 21;
       
       int SUMy = 0;
         for(int i = 0; i < n; i++)
        {
            SUMy += arr[i].counter; 
        }
       
        int SUMxy = 0;
        for(int i = 0; i < n; i++)
        {
            SUMxy = SUMxy + ((i+1) * arr[i].counter);
        }
        
        int SUMxAllSquare = 441;
        int SUMxSquare = 91;
        
        int in1 = n*SUMxy - SUMx*SUMy;
        int in2 = n*SUMxSquare - SUMxAllSquare;
        float b1 = (float)in1/(float)in2;
        b1 = b1*100;
        b1 = Math.round(b1);
        b1 = b1/100;
        
       
        float b0 = (float)(SUMy - b1*SUMx)/(float)n;
        b0 = b0*100;
        b0 = Math.round(b0);
        b0 = b0/100;
        
        int probable_roll = 0;
        float percentage = 0;
        float max_probability = 0.0f;
        float yHat;
        for(int i = 0; i < 6; i++)
        {
        yHat = b0 + b1*(i+1);
        yHat = yHat*100;
        yHat = Math.round(yHat);
        yHat = yHat/100;
        arr[i].probability = yHat;
        
        if(arr[i].probability > max_probability)
        {
                probable_roll = i+1;
                max_probability = yHat;
                percentage = ((float)arr[i].counter/(float)total)*100;
        percentage = percentage*100;
        percentage = Math.round(percentage);
        percentage = percentage/100;
        }
        }
       
        //////////////////////////////////////////////////end of calculations
        
        //Pie Chart for predictions 
        
        PauseTransition delay = new PauseTransition(Duration.millis(1500));
        
        DefaultPieDataset Pset = new DefaultPieDataset();
        
        for(int i = 0; i < 6; i++)
        {
            Pset.setValue(String.valueOf(i+1), (double)arr[i].probability);     
        }
        JFreeChart f = ChartFactory.createPieChart("Expectations for " + name + "'s next roll\n (next roll could possibly be " + probable_roll + " in " + percentage +  "%)", Pset, true, true, true);
        PiePlot p = (PiePlot)f.getPlot();
        ChartFrame PFrame = new ChartFrame("Expectations for the next roll", f);
        PFrame.setUndecorated(true);
        PFrame.setVisible(true);
        PFrame.setSize(450,500);
        PFrame.setAlwaysOnTop(true);
     
        delay.setOnFinished(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent t) {
                    PFrame.setVisible(false);
                }
            });
         delay.play();     
    }
    
    public void drawMainAppearanceCharts(Dice_Roll [] arr, String name) //Represents appearance in the entire game
    {
        // PauseTransition delay = new PauseTransition(Duration.millis(5000));
        
        //Bar Chart
        DefaultCategoryDataset Dset = new DefaultCategoryDataset(); 
        for(int i = 0; i < 6; i++)
        {
            Dset.setValue(arr[i].counter, "Apperance Num.", String.valueOf(i+1));
        }
        JFreeChart c = ChartFactory.createBarChart("Dice appearance for " + name, "Roll result", "Apperance Num.", Dset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = c.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartFrame CFrame = new ChartFrame("Bar Chart for Rolls' Results", c);
        CFrame.setVisible(true);
        CFrame.setLocation(0, 0);
        CFrame.setSize(450, 350);
        
        //Pie chart
        DefaultPieDataset Pset = new DefaultPieDataset();
        for(int i = 0; i < 6; i++)
        {
            Pset.setValue(String.valueOf(i+1), arr[i].counter);
        }
        JFreeChart f = ChartFactory.createPieChart("Dice appearance for " + name, Pset, true, true, true);
        PiePlot p = (PiePlot)f.getPlot();
        ChartFrame PFrame = new ChartFrame("Pie Chart", f);
        PFrame.setVisible(true);
        PFrame.setLocation(460, 0);
        PFrame.setSize(450,500);
        
    }
}
    

