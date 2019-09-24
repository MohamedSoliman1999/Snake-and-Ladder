/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameGui;

import javafx.scene.image.ImageView;

/**
 *
 * @author abdul
 */
public class SetImage {
    ImageView displayImage;
    public SetImage(String photo,int x,int y,int z,int a){
        
        javafx.scene.image.Image diclarephoto = new javafx.scene.image.Image(getClass().getResource(photo).toExternalForm());
         displayImage = new ImageView();
         displayImage.setImage(diclarephoto);
         displayImage.setImage(diclarephoto);
         displayImage.setFitHeight(x);
         displayImage.setFitWidth(y);
         displayImage.setLayoutX(z);
         displayImage.setLayoutY(a);
    }

  /*public void hide() {
     displayImage.setVisible(false);
    }*/
  
    
}
