/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceDecleration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abdul
 */
public class DiceImageProcessing {
    //PythonInterpreter interpreter = null;  


   public void startDecleration()
   {  
     try{
         
         String s = null;
         String cwd = new File("").getAbsolutePath();
         Process P  = Runtime.getRuntime().exec(cwd+"\\DiceImageProcessing\\dist\\DiceImageProcessing\\DiceImageProcessing.exe");
     }
     catch(IOException ie){
         ie.printStackTrace();
     }
   }  
   
}
class test{
    public static void main(String[] args) {
        DiceImageProcessing r = new DiceImageProcessing();
        r.startDecleration();
    }
}