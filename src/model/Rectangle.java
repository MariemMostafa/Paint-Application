/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mariem
 */
public class Rectangle extends Shape implements Cloneable {

    private int length;
    private int width;
    private int x, y;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Rectangle() {

    }

    public Rectangle(int x1, int y1, int length, int width) {
        super(x1, y1);
        this.length = length;
        this.width = width;
    }

    public Rectangle(int x1, int y1, int length, int width, Color color, boolean filled, int thickness) {
        super(x1, y1, color, filled, thickness);
        this.length = length;
        this.width = width;
    }

    @Override
    public boolean contains(int x1, int y1) {
        java.awt.Rectangle r = new java.awt.Rectangle(this.getX1(), this.getY1(), this.length, this.width);
        if (r.contains(x1, y1)) {
            return true;
        } else {
            return false;
        }
    }
  
    @Override
    public void Draw(Graphics g) {
        switch (checkquad(this)) {
            case 2:
                if (isFilled()) {
                    g.fillRect(getX2(), getY2(), getLength(), getWidth());
                } else {
                    g.drawRect(getX2(), getY2(), getLength(), getWidth());
                }
                break;
            case 4:
                if (isFilled()) {
                    g.fillRect(getX1(), getY1(), getLength(), getWidth());
                } else {
                    g.drawRect(getX1(), getY1(), getLength(), getWidth());
                }
                break;
            case 1:
                if (isFilled()) {
                    g.fillRect(getX1(), getY2(), getLength(), getWidth());
                } else {
                    g.drawRect(getX1(), getY2(), getLength(), getWidth());
                }
                break;
            case 3:
                if (isFilled()) {
                    g.fillRect(getX2(), getY1(), getLength(), getWidth());
                } else {
                    g.drawRect(getX2(), getY1(), getLength(), getWidth());
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void Delete(int i) {
        super.Delete(i); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Copy(int x1, int y1, int x2, int y2, int x3, int y3) {
        super.Copy(x1, y1, x2, y2, x3, y3); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public void Move(int x1, int y1, int x2, int y2, int x3, int y3) {
        super.Move(x1, y1, x2, y2, x3, y3); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }


    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void Resize(int p1, int p2, int p3, int p4) {
this.setX2(p1);
this.setY2(p2);
this.setLength(p3);
this.setWidth(p4);
    }

    @Override
    public void Set(int p1, int p2, int p3, int p4, int p5, int p6) {
this.setX2(p1);
this.setY2(p2);
this.setLength(p3);
this.setWidth(p4);


    }

}
