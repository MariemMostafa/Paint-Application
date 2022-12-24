package model;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape implements Cloneable {

    private int side;
    private int side1,side2;


    public Square(int x1, int y1, int side, Color color, boolean filled, int thickness) {
        super(x1, y1, color, filled, thickness);
        //this.side = side;
    }

    public Square() {
    }

    @Override
    public boolean contains(int x1, int y1) {
        java.awt.Rectangle r = new java.awt.Rectangle(this.getX1(), this.getY1(), this.side, this.side);
        if (r.contains(x1, y1)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void Draw(Graphics g) {
         
//        int minX = Math.min(this.getX2(), this.getX1());
//        int minY = Math.min(this.getY2(), this.getY1());
//        int maxX = Math.max(this.getX2(), this.getX1());
//        int maxY = Math.max(this.getY2(), this.getY1());
//        int size  = Math.min(maxX-minX, maxY-minY);
//        this.setSide(size);
        switch (checkquad(this)) {
            case 2:
                if (isFilled()) {
                    g.fillRect(getX2(), getY2(), getSide(), getSide());
                } else {
                    g.drawRect(getX2(), getY2(), getSide(), getSide());
                }
                break;
            case 4:
                if (isFilled()) {
                    g.fillRect(getX1(), getY1(), getSide(), getSide());
                } else {
                    g.drawRect(getX1(), getY1(), getSide(), getSide());
                }
                break;
            case 1:
                if (isFilled()) {
                    g.fillRect(getX1(), getY2(), getSide(), getSide());
                } else {
                    g.drawRect(getX1(), getY2(), getSide(), getSide());
                }
                break;
            case 3:
                if (isFilled()) {
                    g.fillRect(getX2(), getY1(), getSide(), getSide());
                } else {
                    g.drawRect(getX2(), getY1(), getSide(), getSide());
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

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void Resize(int p1, int p2, int p3, int p4) {
this.setX2(p1);
this.setY2(p2);
this.setSide(p3);


    }

    /**
     * @return the sid1
     */
    public int getSide1() {
        return side1;
    }

    /**
     * @param sid1 the sid1 to set
     */
    public void setSide1(int side1) {
        this.side1 = side1;
    }

    /**
     * @return the side2
     */
    public int getSide2() {
        return side2;
    }

    /**
     * @param side2 the side2 to set
     */
    public void setSide2(int side2) {
        this.side2 = side2;
    }

    @Override
    public void Set(int p1, int p2, int p3, int p4, int p5, int p6) {
this.setX2(p1);
this.setY2(p2);
this.setSide(p3);
    }

}
