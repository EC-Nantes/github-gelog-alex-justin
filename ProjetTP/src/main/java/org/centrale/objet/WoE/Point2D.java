/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.lang.Math;
/**
 * Définition des positions
 * @author Alexandre
 * @version 1.1
 */
public class Point2D {
    private int x = 0;
    private int y = 0;
    
    public Point2D() {
        //
    }
    
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }
    
    public void setX(int v) {
        x = v;
    }
    
    public int getX() {
        return x;
    }
    
    public void setY(int v) {
        y = v;
    }
    
    public int getY() {
        return y;
    }
    
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }
    
    public void affiche() {
        System.out.print("[" + x + ", " + y + "]");
    }
    
    public float distance(Point2D p) {
        float val = (x-p.x)*(x-p.x) + (y-p.y)*(y-p.y);
        return (float)Math.sqrt(val);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.x;
        hash = 37 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point2D other = (Point2D) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }
    
    
}
