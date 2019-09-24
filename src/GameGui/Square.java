/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameGui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author abdul
 */
public class Square extends Rectangle {
    public Square(int x,int y){
        setWidth(DrawBoard.square_size);
        setHeight(DrawBoard.square_size);
        setFill(Color.CORNSILK);
        setStroke(Color.BLACK);
    }
    
}