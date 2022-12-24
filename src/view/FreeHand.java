package view;
import model.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Line;

/**
 *
 * @author HP
 */
public class FreeHand  extends JPanel implements MouseListener,MouseMotionListener{
   
   // private static  ArrayList<Point> Points = new ArrayList<>();
     Point pressed = new Point();
     private Graphics g = this.getGraphics();
     private Color color ;
     private int thickness;

      
   public FreeHand()
   {
       addMouseListener(this);
       addMouseMotionListener(this);
        this.g = this.getGraphics();

   }
    
    @Override
    public void mouseClicked(MouseEvent me) {


    }

    @Override
    public void mousePressed(MouseEvent me) {
       pressed.setX1(me.getX());
       pressed.setY1(me.getY());
      
    }

    @Override
    public void mouseReleased(MouseEvent me) {
           
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
       Graphics g = getGraphics();
       Graphics2D grphcs =  (Graphics2D) g;
        grphcs.setColor(color);
        grphcs.setStroke(new BasicStroke(thickness));       
        grphcs.drawLine(pressed.getX1(), pressed.getY1(), me.getX(),me.getY());
        pressed.setX1(me.getX());
        pressed.setY1(me.getY());

//Point C = new Point();
//C.setX1(pressed.getX1());
//C.setY1(pressed.getY1());
//        getPoints().add(C);
//Point D = new Point();
//D.setX1(me.getX());
//D.setY1(me.getY());
//        getPoints().add(D);
// pressed.setX1(me.getX());
// pressed.setY1(me.getY());
// this.repaint();
               
    }

    @Override
    public void mouseMoved(MouseEvent me) {
         
        
    }
//
//    @Override
//    protected void paintComponent(Graphics grphcs) {
//        Graphics g = getGraphics();
//        Graphics2D grphcs1 =  (Graphics2D) g;
//        grphcs1.setColor(color);
//        grphcs1.setStroke(new BasicStroke(thickness));   
//        for(int i = 0; i < getPoints().size()-1;i++)
//        {
//            
//            Point A  = new Point();
//            Point B = new Point();
//            
//            A.setX1(getPoints().get(i).getX1());
//            A.setY1(getPoints().get(i).getY1());
//            B.setX1(getPoints().get(i+1).getX1());
//            B.setY1(getPoints().get(i+1).getY1());
//            grphcs1.drawLine(A.getX1(), A.getY1(), B.getX1(), B.getY1());
//           
//            
//        }
//
//
//
//    }
    

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the thickness
     */
    public int getThickness() {
        return thickness;
    }

    /**
     * @param thickness the thickness to set
     */
    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    /**
     * @return the Points
     */
   
}