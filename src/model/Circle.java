/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Mariem
 */
public class Circle extends Shape implements Cloneable {

    private int radius;

   
    
    @Override
    public boolean contains(int x1, int y1) {
        Ellipse2D c = new Ellipse2D.Float(this.getX1(), this.getY1(), 2 * this.radius, 2 * this.radius);
        if (c.contains(x1, y1)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void Copy(int x1, int y1, int x2, int y2, int x3, int y3) {
        super.Copy(x1, y1, x2, y2, x3, y3); //To change body of generated methods, choose Tools | Templates.
    }
    

    public int getRadius() {

        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    

    @Override
    public void Draw(Graphics grphcs) {
//        int minX = Math.min(this.getX2(), this.getX1());
//        int minY = Math.min(this.getY2(), this.getY1());
//        int maxX = Math.max(this.getY2(), this.getY1());
//        int maxY = Math.max(this.getY2(), this.getY1());
//        int size = Math.min(maxX-minX,maxY-minY);
//        if(minX<this.getX1())
//minX= this.getX1()-size;
//   if(minY<this.getY1())
//minY= this.getY1()-size;
   // if (isFilled()) {
                  //  grphcs.drawOval(minX, minY, size, size);
//                } else {
//                    grphcs.drawOval(getX2(), getY2(), 2 * getRadius(), 2 * getRadius());
//                }
        switch (checkquad(this)) {
            case 2:
                if (isFilled()) {
                    grphcs.fillOval(getX2(), getY2(), 2 * getRadius(), 2 * getRadius());
                } else {
                    grphcs.drawOval(getX2(), getY2(), 2 * getRadius(), 2 * getRadius());
                }
                break;

            case 4:
                if (isFilled()) {
                    grphcs.fillOval(getX1(), getY1(), 2 * getRadius(), 2 * getRadius());
                } else {
                    grphcs.drawOval(getX1(), getY1(), 2 * getRadius(), 2 * getRadius());
                }
                break;
            case 1:
                if (isFilled()) {
                    grphcs.fillOval(getX1(), getY2(), 2 * getRadius(), 2 * getRadius());
                } else {
                    grphcs.drawOval(getX1(), getY2(), 2 * getRadius(), 2 * getRadius());
                }
                break;
            case 3:
                if (isFilled()) {
                    grphcs.fillOval(getX2(), getY1(), 2 * getRadius(), 2 * getRadius());
                } else {
                    grphcs.drawOval(getX2(), getY1(), 2 * getRadius(), 2 * getRadius());
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void Delete(int i) {
        super.Delete(i); 
    }


    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle(int x1, int y1, int x2, int y2, int radius, Color color, boolean filled, int thickness) {
        super(x1, y1, x2, y2, color, filled, thickness);
        this.radius = radius;
    }

    public Circle(int x1, int y1, int radius, Color color) {
        super(x1, y1, color);
        this.radius = radius;
    }

    public Circle() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

   

    
    @Override
    public void Move(int x1, int y1, int x2, int y2, int x3, int y3) {
        super.Move(x1, y1, x2, y2, x3, y3); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void Resize(int p1, int p2, int p3, int p4) {
this.setX2(p1);
this.setY2(p2);
this.setRadius(p3);
    }

    @Override
    public void Set(int p1, int p2, int p3, int p4, int p5, int p6) {
this.setX2(p1);
this.setY2(p2);
this.setRadius(p3);

    }

}
