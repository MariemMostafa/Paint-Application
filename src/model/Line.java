/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Mariem
 */
public class Line extends Shape {

    private double length;
    static final int BOX = 2;
    private int xcoordinate;
    private int ycoordinate;

    public Line() {

    }

    public Line(int x1, int y1, int x2, int y2, Color color, int thickness) {
        super(x1, y1, x2, y2, color, thickness);
    }

    @Override
    public void Draw(Graphics g) {
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }

    @Override
    public boolean contains(int x1, int y1) {
        Line2D clicked;
        int boxX = x1 - BOX / 2;
        int boxY = y1 - BOX / 2;
        int width = BOX;
        int height = BOX;
        java.awt.geom.Line2D selected = new Line2D.Double(this.getX1(), this.getY1(), this.getX2(), this.getY2());

        if (selected.intersects(boxX, boxY, width, height)) {
            return true;
        } else {
            return false;
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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    /**
     * @return the xcoordinate
     */
    public int getXcoordinate() {
        return xcoordinate;
    }

    /**
     * @param xcoordinate the xcoordinate to set
     */
    public void setXcoordinate(int xcoordinate) {
        this.xcoordinate = xcoordinate;
    }

    /**
     * @return the ycoordinate
     */
    public int getYcoordinate() {
        return ycoordinate;
    }

    /**
     * @param ycoordinate the ycoordinate to set
     */
    public void setYcoordinate(int ycoordinate) {
        this.ycoordinate = ycoordinate;
    }

    @Override
    public void Move(int x1, int y1, int x2, int y2, int x3, int y3) {
        super.Move(x1, y1, x2, y2, x3, y3); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Resize(int p1, int p2, int p3, int p4) {
        this.setX2(p1);
        this.setY2(p2);

    }

    @Override
    public void Set(int p1, int p2, int p3, int p4, int p5, int p6) {
        this.setX2(p1);
        this.setY2(p2);
    }
}
