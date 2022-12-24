/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mariem
 */
public class ShapeFactory extends AbstractFactory {

    public ShapeFactory() {


    }

    @Override
    public Shape CreateShape(String name) {
        if (name.equals("Line")) {
            return new Line();
        } else if (name.equals("Rectangle")) {
            return new Rectangle();
        } else if (name.equals("Square")) {
            return new Square();
        } else if (name.equals("Circle")) {
            return new Circle();
        } else if (name.equals("Triangle")) {
            return new Triangle();
        } else {
            return null;
        }
    }
}
