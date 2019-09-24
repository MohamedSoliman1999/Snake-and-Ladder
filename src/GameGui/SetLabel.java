/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameGui;

import javafx.scene.control.Label;

/**
 *
 * @author abdul
 */
public class SetLabel {
    private Label lblname;
    private String Name;
    private int x;
    private int y;
    private double z;
    private double a;
    private int b;
    private int c;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
     public Label getLblname() {
        
          lblname = new Label(this.Name);
        lblname.setStyle("-fx-text-fill: white;\n" +
"    -fx-border-color: (#f0ff35, #a9ff00);\n" +
"    -fx-background-color: (#f0ff35, #a9ff00);\n" +
"    -fx-alignment: center;\n" +
"    -fx-font-size: 30px;\n" +
"    -fx-font-weight: bold;");
        lblname.setMinWidth(x);
        lblname.setMinHeight(y);
        lblname.setScaleX(z);
        lblname.setScaleY(a);
        lblname.setLayoutX(b);
        lblname.setLayoutY(c);
        return lblname;
    }
    private SetLabel()
    {
       lblname = new Label(this.Name);
        lblname.setStyle("-fx-text-fill: white;\n" +
"    -fx-border-color: (#f0ff35, #a9ff00);\n" +
"    -fx-background-color: (#f0ff35, #a9ff00);\n" +
"    -fx-alignment: center;\n" +
"    -fx-font-size: 30px;\n" +
"    -fx-font-weight: bold;");
        lblname.setMinWidth(x);
        lblname.setMinHeight(y);
        lblname.setScaleX(z);
        lblname.setScaleY(a);
        lblname.setLayoutX(b);
        lblname.setLayoutY(c);
    }
    public static class  Builder 
    {
        private String Name;
        private int x;
        private int y;
        private double z;
        private double a;
        private int b;
        private int c;
        public Builder (String name )
        {
            this.Name = name ;
        }
        public Builder WithX (int x)
        {
            this.x= x;
            return this;
        }
         public Builder WithY (int y)
        {
            this.y= y;
            return this;
        }
         public Builder WithZ (double z)
        {
            this.z= z;
            return this;
        }
          public Builder WithA (double a)
        {
            this.a= a;
            return this;
        }
           public Builder WithB (int b)
        {
            this.b= b;
            return this;
        }
            public Builder WithC (int c)
        {
            this.c= c;
            return this;
        }
            public SetLabel build ()
            {
            SetLabel lb = new SetLabel();
            lb.Name = this.Name;
            lb.x = this.x;
            lb.y = this.y;
            lb.z = this.z ;
            lb.a = this.a;
            lb.b = this.b;
            lb.c = this.c ;
            return lb; 
            }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public double getZ() {
            return z;
        }

        public void setZ(double z) {
            this.z = z;
        }

        public double getA() {
            return a;
        }

        public void setA(double a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
            
    }
}
