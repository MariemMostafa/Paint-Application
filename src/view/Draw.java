/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Services;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.Circle;
import model.Line;
import model.Rectangle;
import model.Shape;
import model.ShapeFactory;
import model.Square;
import model.Triangle;

/**
 *
 * @author Mariem
 */
//12345
public class Draw extends JPanel implements MouseListener, MouseMotionListener {

    private static ArrayList<model.Shape> elements;
    private static int mode = -1;
    private static Color color;
    private static boolean filled;
    private static model.Shape selected = null;
    private Graphics g = this.getGraphics();
    private Services S;
    private boolean first = false;
    private  int xpaste, ypaste, min, xdragged, ydragged;
    private static int thickness;
     model.ShapeFactory fl = new ShapeFactory();
     Shape  ls= fl.CreateShape("Line");
     Line l = (Line) ls;
     model.ShapeFactory fc = new ShapeFactory();
     Shape  cs = fc.CreateShape("Circle");
     Circle c = (Circle) cs;
     model.ShapeFactory fs = new ShapeFactory();
     Shape  ss = fs.CreateShape("Square");
     Square s = (Square) ss;
     model.ShapeFactory fr = new ShapeFactory();
     Shape  rs = fr.CreateShape("Rectangle");
     Rectangle r = (Rectangle) rs;
     model.ShapeFactory ft = new ShapeFactory();
     Shape  ts= ft.CreateShape("Triangle");
     Triangle t = (Triangle) ts;
     


    public static boolean isFilled() {
        return filled;
    }


    public static void setFilled(boolean aFilled) {
        filled = aFilled;
    }

    public Draw() {
        this.g = this.getGraphics();
        elements = new ArrayList<>();
        addMouseListener(this);
        addMouseMotionListener(this);
        S = new Services(this);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }
    model.Point pressedpoint = new model.Point();

    @Override
    public void mousePressed(MouseEvent me) {
        xpaste = me.getX();
        ypaste = me.getY();
        
         if (getMode() == 0) {
            l = new model.Line(xpaste, ypaste, xpaste, ypaste, color, getThickness());
            elements.add(l);
            repaint();
        } else if (getMode() == 2) {
           s = new model.Square(xpaste, ypaste, 0, getColor(), isFilled(), getThickness());
           elements.add(s);
            repaint();
        } else if (getMode() == 1) {
            r= new model.Rectangle(xpaste, ypaste, 0, 0, getColor(), isFilled(), getThickness());
            elements.add(r);
            repaint();
        } else if (getMode() == 3) {
            c= new model.Circle(xpaste, ypaste, 0, 0, 0, getColor(), isFilled(), getThickness());
            getElements().add(c);
            repaint();
        } else if (getMode() == 4) {
             t = new model.Triangle(xpaste, ypaste, xpaste, ypaste, xpaste, ypaste, getColor(), isFilled(), getThickness());
            getElements().add(t);
            repaint();
        } else if (mode == 6) {
            select();
        } else if (mode == 8) {
            if (getSelected() != null) {
                if (getSelected() instanceof model.Line) {
                    l = (model.Line) getSelected();
                    l.Move((l.getX1() + me.getX() - xpaste), (l.getY1() + me.getY() - ypaste), (l.getX2() + me.getX() - xpaste), (l.getY2() + me.getY() - ypaste), 0, 0);
                    repaint();
                }
                if (getSelected() instanceof model.Rectangle) {
                    r= (model.Rectangle) getSelected();
                    r.Move(xpaste, ypaste, (r.getX1() + r.getLength()), (r.getY1() + r.getWidth()), 0, 0);
                    repaint();
                } else if (getSelected() instanceof model.Triangle) {
                    t = (model.Triangle) getSelected();
                    t.Move(xpaste, ypaste, (xpaste + (t.getBase() / 2)), (ypaste + t.getHeight()), (xpaste - (t.getBase() / 2)), (ypaste + t.getHeight()));

                    repaint();
                } else if (getSelected() instanceof model.Circle) {
                    c = (model.Circle) getSelected();
                    c.Move(xpaste - c.getRadius(), ypaste - c.getRadius(), (c.getX1() + c.getRadius()), (c.getY1() + c.getRadius()), 0, 0);
                    repaint();
                } else if (getSelected() instanceof model.Square) {
                    s = (model.Square) getSelected();
                    s.Move(xpaste, ypaste, (s.getX1() + s.getSide()), (s.getY1() + s.getSide()), 0, 0);
                    repaint();
                }
            }
        } else if (mode == 9) {
            if (getSelected() != null) {
                copy();
                repaint();
            }
            repaint();
            setMode(-1);
        } else if (mode == 12) {

        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        try {
            if (mode != 6) {
                ArrayList<model.Shape> cloneArray = getS().cloneArrayList(getElements());
                getS().pushUndo(cloneArray);
            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Draw.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        xdragged = me.getX();
        ydragged = me.getY();
       
          if (getMode() == 0 && getElements().size() > 0) {
            model.Shape s1 = getElements().get(getElements().size() - 1);
            if (s1 instanceof Line) {
                l = (Line) s1;
                l.Set(xdragged, ydragged, 0, 0, 0, 0);
            }
            repaint();
            setFirst(false);
        } else if (getMode() == 1 && getElements().size() > 0) {
            model.Shape s1 = getElements().get(getElements().size() - 1);
            if (s1 instanceof model.Rectangle) {
                r = (model.Rectangle) s1;
                r.Set(xdragged, ydragged, (Math.abs(xdragged - r.getX1())), (Math.abs(ydragged - r.getY1())), 0, 0);
            }
            repaint();
            setFirst(false);
        } else if (mode == 2 && getElements().size() > 0) {
            model.Shape s1 = getElements().get(getElements().size() - 1);
            if (s1 instanceof model.Square) {
                s = (model.Square) s1;
               s.Set(xdragged, ydragged, (Math.abs(s.getX2() - s.getX1())), 0, 0, 0);  
            }
            repaint();
        } else if (getMode() == 3 && getElements().size() > 0) {
            model.Shape s1 = getElements().get(getElements().size() - 1);
            if (s1 instanceof model.Circle) {
                c = (model.Circle) s1;
                c.Set(xdragged, ydragged, (Math.abs(c.getX2() - c.getX1())), 0, 0, 0);
            }
            repaint();
        } else if (mode == 4 && getElements().size() > 0) {
            model.Shape s1 = getElements().get(getElements().size() - 1);
            if (s1 instanceof model.Triangle) {
                t= (model.Triangle) s1;
                t.Set((2 * t.getX1() - xdragged), ydragged, xdragged, ydragged, (Math.abs(t.getX2() - t.getX3())), (Math.abs(t.getY1() - t.getY2())));
            }
            repaint();
        } else if (mode == 7) {
            if (getSelected() != null) {
                {
                    if (getSelected() instanceof model.Line) {
                        l = (Line) getSelected();
                        l.Resize(xdragged, ydragged, 0, 0);
                        repaint();
                    } else if (getSelected() instanceof model.Rectangle) {
                        r= (Rectangle) getSelected();
                        r.Resize(xdragged, ydragged, (Math.abs(xdragged - r.getX1())), (Math.abs(ydragged - r.getY1())));
                        repaint();
                    } else if (getSelected() instanceof model.Square) {
                        s = (Square) getSelected();
                        s.Resize(xdragged, ydragged, (Math.abs(xdragged - s.getX1())), 0);
                        repaint();
                    } else if (getSelected() instanceof model.Circle) {
                        c= (Circle) getSelected();
                        c.Resize(xdragged, ydragged, (Math.abs(xdragged - c.getX1())), 0);
                        repaint();
                    } else if (getSelected() instanceof model.Triangle) {
                        t = (Triangle) getSelected();
                        t.Resize(xdragged, ydragged, (2 * t.getX1() - xdragged), ydragged);
                        repaint();
                    }
                }
            }

        } else if (mode == 8) {
            if (getSelected() != null) {
                if (getSelected() instanceof model.Line) {
                    l = (model.Line) getSelected();
                    l.Move((l.getX1() + me.getX() - xpaste), (l.getY1() + me.getY() - ypaste), (l.getX2() + me.getX() - xpaste), (l.getY2() + me.getY() - ypaste), 0, 0);
                    xpaste = xdragged;
                    ypaste = ydragged;
                    repaint();
                } else if (getSelected() instanceof model.Rectangle) {
                    model.Rectangle r = (model.Rectangle) getSelected();
                    r.Move(xdragged, ydragged, (r.getX1() + r.getLength()), (r.getY1() + r.getWidth()), 0, 0);
                    repaint();
                } else if (getSelected() instanceof model.Triangle) {
                    t.Move(xdragged, ydragged, (xdragged + (t.getBase() / 2)), (ydragged + t.getHeight()), (xdragged - (t.getBase() / 2)), (ydragged + t.getHeight()));
                    repaint();
                } else if (getSelected() instanceof model.Circle) {
                    c.Move(xdragged - c.getRadius(), ydragged - c.getRadius(), (c.getX1() + c.getRadius()), (c.getY1() + c.getRadius()), 0, 0);
                    repaint();
                } else if (getSelected() instanceof model.Square) {
                    s.Move(xdragged, ydragged, (s.getX1() + s.getSide()), (s.getY1() + s.getSide()), 0, 0);
                    repaint();
                }
            }
        }
    }

    public void copy() {
        if (getSelected() instanceof model.Rectangle) {
            r = (model.Rectangle) getSelected();
            try {
                model.Rectangle r2 = (Rectangle) r.clone();
                r2.Copy(xpaste, ypaste, (xpaste + r2.getLength()), (ypaste + r2.getWidth()), 0, 0);
                getElements().add(r2);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Draw.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (getSelected() instanceof model.Line) {
             l = ( model.Line) getSelected();
            try {
                model.Line l2 = (Line) l.clone();
                l2.Copy(xpaste, ypaste, (xpaste + l.getX2() - l.getX1()), (ypaste + l.getY2() - l.getY1()), 0, 0);
                getElements().add(l2);
                repaint();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Draw.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (getSelected() instanceof model.Circle) {
            c = (model.Circle) getSelected();
            try {
                model.Circle c2 = (model.Circle) c.clone();
                c2.Copy(xpaste - c2.getRadius(), ypaste - c2.getRadius(), (c2.getX1() + c.getRadius()), (c2.getY1() + c.getRadius()), 0, 0);
                getElements().add(c2);

            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Draw.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (getSelected() instanceof model.Square) {
            s = (Square) getSelected();
            try {
                model.Square s2 = (Square) s.clone();
                s2.Copy(xpaste, ypaste, (xpaste + s2.getSide()), (ypaste + s2.getSide()), 0, 0);
                getElements().add(s2);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Draw.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (getSelected() instanceof model.Triangle) {
            t = (Triangle) getSelected();
            try {
                model.Triangle t2 = (Triangle) t.clone();
                t2.Copy(xpaste, ypaste, xpaste + (t2.getBase() / 2), ypaste + t.getHeight(), xpaste - (t.getBase() / 2), ypaste + t.getHeight());
                getElements().add(t2);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Draw.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("nope");
            }
        }
    }

    public void select() {
        for (int i = elements.size() - 1; i >= 0; i--) {
            if (elements.get(i).contains(xpaste, ypaste)) {
                setSelected(elements.get(i));
                System.out.println("Found!" + i);
                break;
            } else {
                System.out.println("Not Found!");
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    enum Eshapes {
        Line, Square, Rectangle, Circle, Triangle
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D grphcs = (Graphics2D) g;
        super.paintComponent(g);
        switch (mode) {
            case 10:
                getS().undoTransaction();
                repaint();
                break;
            case 11: {
                try {
                    getS().redoTransaction();
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Draw.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 12:
                fillShape();
                break;
        }

        Iterator<Shape> x = elements.iterator();

        while (x.hasNext()) {
            Shape s = x.next();
            grphcs.setStroke(new BasicStroke(s.getThickness()));
            grphcs.setColor(s.getColor());
            s.Draw(grphcs);
        }
    }

    public void Delete() {
        for (int i = 0; i < this.getElements().size(); i++) {
            if (this.getElements().get(i) == getSelected()) {
                this.getElements().get(i).Delete(i);
            }
        }
        setMode(-1);
        repaint();
    }

    public void fillShape() {
        model.Shape S = getSelected();
        Graphics g = null;
        if (getSelected() != null) {
            for (int i = 0; i < this.getElements().size(); i++) {
                if (this.getElements().get(i) == S) {
                    if (S instanceof Rectangle) {
                        r = (Rectangle) this.getElements().get(i);
                        r.setFilled(true);
                        repaint();
                        setMode(-1);
                    }
                    if (S instanceof Square) {
                        s = (Square) this.getElements().get(i);
                        s.setFilled(true);
                        repaint();
                        setMode(-1);
                    }
                    if (S instanceof Circle) {
                        c= (Circle) this.getElements().get(i);
                        c.setFilled(true);
                        repaint();
                        setMode(-1);
                    }
                    if (S instanceof Triangle) {
                        t = (Triangle) this.getElements().get(i);
                        t.setFilled(true);
                        repaint();
                        setMode(-1);
                    }
                    ArrayList<model.Shape> cloneArray = null;
                    try {
                        cloneArray = getS().cloneArrayList(getElements());
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Draw.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    getS().pushUndo(cloneArray);
                }
            }
        }
    }

    /**
     * @return the mode
     */
    public int getMode() {
        return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(int mode) {
        this.mode = mode;
    }

    /**
     * @return the elements
     */
    public ArrayList<model.Shape> getElements() {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
    public void setElements(ArrayList<model.Shape> elements) {
        this.elements = elements;
    }

    /**
     * @return the selected
     */
    public static model.Shape getSelected() {
        return selected;
    }

    /**
     * @param aSelected the selected to set
     */
    public static void setSelected(model.Shape aSelected) {
        selected = aSelected;
    }

    /**
     * @return the iterator
     */
  

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    /**
     * @return the S
     */
    public Services getS() {
        return S;
    }

    /**
     * @param S the S to set
     */
    public void setS(Services S) {
        this.S = S;
    }

    /**
     * @return the first
     */
    public boolean isFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(boolean first) {
        this.first = first;
    }



}
