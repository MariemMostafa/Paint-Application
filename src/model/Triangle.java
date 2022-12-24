/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import view.Draw;
import view.PaintApp;

/**
 *
 * @author Mariem
 */
public class Triangle extends Shape {

    private int base, height;
    
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color, boolean filled, int thickness) {
        super(x1, y1, x2, y2, color, filled, thickness);
        this.setX3(x3);
        this.setY3(y3) ;
    }

    public Triangle() {
    }

    @Override
    public boolean contains(int x, int y) {
        int s[] = {getX1(), getX2(), this.getX3()};
        int s2[] = {getY1(), getY2(), this.getY3()};
        Polygon t = new Polygon(s, s2, 3);

        if (t.contains(x, y)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void Draw(Graphics grphcs) {
        if (isFilled()) {
            grphcs.fillPolygon(new int[]{getX1(), getX2(), getX3()}, new int[]{getY1(), getY2(), getY3()}, 3);
        } else {
            grphcs.drawPolygon(new int[]{getX1(), getX2(), getX3()}, new int[]{getY1(), getY2(), getY3()}, 3);

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

    /**
     * @return the base
     */
    public int getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(int base) {
        this.base = base;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    
    @Override
    public void Move(int x1, int y1, int x2, int y2, int x3, int y3) {
        super.Move(x1, y1, x2, y2, x3, y3); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void Resize(int p1, int p2 , int p3 , int p4 ) {
        this.setX2(p1);
        this.setY2(p2);
        this.setX3(p3);
        this.setY3(p4);

    }

    @Override
    public void Set(int p1, int p2, int p3, int p4, int p5, int p6) {
this.setX2(p1);
        this.setY2(p2);
        this.setX3(p3);
        this.setY3(p4);
        this.setBase(p5);
        this.setHeight(p6);


    }

}
