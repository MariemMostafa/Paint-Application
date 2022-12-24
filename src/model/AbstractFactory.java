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
public abstract class AbstractFactory implements Cloneable{
    
    public abstract model.Shape CreateShape(String name);    
    
    @Override
    protected Object clone() throws CloneNotSupportedException{
            return super.clone();
            }
}
