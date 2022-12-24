/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import view.PaintApp;

/**
 *
 * @author Mariem
 */
public abstract class Shape  implements Cloneable{

    /**
     * @param args the command line arguments
     */
    
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private int thickness;
    private Color color;
    private view.Draw board;
    private boolean filled; 
    public Shape()
    {
        
    }
    
    public Shape(int x1,int y1,int x2, int y2,Color color, int thickness)
    {
        this.color=color;
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;   
        this.thickness=thickness;
    }

    public Shape(int x1, int y1, int x2, int y2, Color color, boolean filled,int thickness) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.filled = filled;
        this.thickness=thickness;
    }
    
    public Shape(int x1,int y1)
    {
        this.x1=x1;
        this.y1=y1;
    }
    
    public Shape(int x1,int y1,Color color)
    {
        this.color=color;
        this.x1=x1;
        this.y1=y1;
    }

    public Shape(int x1, int y1, Color color, boolean filled, int thickness) {
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
        this.filled = filled;
        this.thickness=thickness;
    }
    
     public Shape(Color color) {
        this.color = color;
    }
      public int checkquad(model.Shape s) {
        if (s.getX2() > s.getX1() && s.getY2() > s.getY1()) {
            return 4;
        } else if (s.getX2() > s.getX1() && s.getY2() < s.getY1()) {
            return 1;
        } else if (s.getX2() < s.getX1() && s.getY2() > s.getY1()) {
            return 3;
        } else if (s.getX2() < s.getX1() && s.getY2() < s.getY1()) {
            return 2;
        } else {
            return 0;
        }
    }
      
      public abstract void  Draw(Graphics g);
        
      public abstract void  Resize(int p1,int p2,int p3,int p4);
      
    public  void Delete(int i) {
        PaintApp.getGUI().getDraw1().getElements().remove(i);
    }
       
	public  void  Copy(int x1,int y1,int x2, int y2,int x3,int y3){
                    this.setX1(x1);
                    this.setY1(y1);
                    this.setX2(x2);
                    this.setY2(y2);
                    this.setX3(x3);
                    this.setY3(y3);
            
        }
        
	public  void  Move(int x1,int y1,int x2, int y2,int x3,int y3){
             this.setX1(x1);
                    this.setY1(y1);
                    this.setX2(x2);
                    this.setY2(y2);
                    this.setX3(x3);
                    this.setY3(y3);
        }
        public abstract void  Set(int p1,int p2,int p3,int p4,int p5,int p6);
      
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * @return the board
     */
    public view.Draw getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(view.Draw board) {
        this.board = board;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
          public abstract boolean contains(int x1, int y1);

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    /**
     * @return the x3
     */
    public int getX3() {
        return x3;
    }

    /**
     * @param x3 the x3 to set
     */
    public void setX3(int x3) {
        this.x3 = x3;
    }

    /**
     * @return the y3
     */
    public int getY3() {
        return y3;
    }

    /**
     * @param y3 the y3 to set
     */
    public void setY3(int y3) {
        this.y3 = y3;
    }
    
    
}
