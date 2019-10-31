package FractalPackage;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;
 
public final class Fractals extends PApplet{
    public static Fractals m;
    public static float H = sqrt(0.75f);
    float radius;
    int direction;

    public static void main(String[] args) {
        PApplet.main("FractalPackage.Fractals");
    }

    public void settings() {
        size(800, 800);
        m = this;
    }

    public void setup() {
        sierpinski(0, height, 200);
        circleFractal(width/2, height/2, 100);
        
    }
    
    public void draw() {
        

    }

    public void circle(float x, float y, float r){
        ellipse(x, y, r*2, r*2);
    }

    public void circleFractal(float x, float y, float r){
        //noFill();
        fill(0, 255, 0, 128);
        circle(x, y, r*2);
        if (r > 2){
            stroke(r/2, r/2, 0f);
            float newRadius = r/2;
            circleFractal(x-newRadius, y, newRadius);
            circleFractal(x+newRadius, y, newRadius);
            //circleFractal(x, y-newRadius, newRadius);
            //circleFractal(x, y+newRadius, newRadius);
        }
    }

    public void equilateralTriangle(float x, float y, float s){
        triangle(x, y, x+s/2, y-s*H, x+s, y);
    }

    public void sierpinski(float x, float y, float s){
        //noFill();
        fill(255, 0, 0, 15);
        equilateralTriangle(x, y, s);
        if (s > 8){
            float newSideLength = s/2f;
            sierpinski(x, y, newSideLength);
            sierpinski(x+newSideLength/2, y-newSideLength*H, newSideLength);
            sierpinski(x+newSideLength, y, newSideLength);    
        }
    }

    
}
    
