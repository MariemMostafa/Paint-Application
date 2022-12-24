/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.Shape;
import view.Draw;

/**
 *
 * @author Mariem
 */
public class Services {

    private static Stack<ArrayList<model.Shape>> undo = new Stack<>();
    private static Stack<ArrayList<model.Shape>> redo = new Stack<>();
    private Draw board;

    public Services(Draw board) {
        undo.push(new ArrayList<model.Shape>());
        this.board = board;
    }

    public void undoTransaction() {
        try {
            System.out.println(undo.size());
            if (undo.size() > 1) {
                getRedo().push(cloneArrayList(getUndo().pop()));
                board.setElements(cloneArrayList(getUndo().peek()));
                board.repaint();
            }
        } catch (EmptyStackException e) {
            System.out.println("STACK IS EMPTY");
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void redoTransaction() throws CloneNotSupportedException {
        try {
            if (!redo.empty()) {
                getUndo().push(cloneArrayList(getRedo().pop()));
                board.setElements(cloneArrayList(getUndo().peek()));
                board.repaint();
            }
        } catch (EmptyStackException e) {
            System.out.println("STACK IS EMPTY");
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public  void pushUndo(ArrayList<model.Shape> x) {
        getUndo().push(x);
    }

    public ArrayList<model.Shape> cloneArrayList(ArrayList<model.Shape> x) throws CloneNotSupportedException {
        ArrayList<model.Shape> y = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            y.add((Shape) x.get(i).clone());
        }
        return y;
    }

    /**
     * @return the undo
     */
    public static Stack<ArrayList<model.Shape>> getUndo() {
        return undo;
    }

    /**
     * @param aUndo the undo to set
     */
    public static void setUndo(Stack<ArrayList<model.Shape>> aUndo) {
        undo = aUndo;
    }

    /**
     * @return the redo
     */
    public static Stack<ArrayList<model.Shape>> getRedo() {
        return redo;
    }

    /**
     * @param aRedo the redo to set
     */
    public static void setRedo(Stack<ArrayList<model.Shape>> aRedo) {
        redo = aRedo;
    }

}
