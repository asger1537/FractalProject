package FractalProject;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;
 
public final class Fractals extends PApplet{
    public static Fractals m;
    public static float H = sqrt(0.75f);
    float radius;
    int direction;

    public static void main(String[] args) {
        PApplet.main("FractalProject.Fractals");
    }

    public void settings() {
        size(800, 800);
        m = this;
    }

    public void setup() {
        circleFractal(width/2, height/2, 400);
        //sierpinski(0, height, width);
        //ArrayList <PVector> startLines = new ArrayList();
        //startLines.add(new PVector(10, 0));
        //fractal(new PVector(width/2, height/2), startLines);

        //connectingLine(new PVector(width/2, height/2), new PVector(100, 200));
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
            //stroke(r/2, r/2, 0f);
            float newRadius = r/2;
            //circleFractal(x-newRadius, y, newRadius);
            circleFractal(x+newRadius, y, newRadius);
            circleFractal(x, y-newRadius, newRadius);
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
            //sierpinski(x-newSideLength, y+newSideLength*H, newSideLength);       
        }
    }

    public void connectingLine(PVector p1, PVector p2){
        line(p1.x, p1.y, p2.x, p2.y);
    }

    public void fractal(PVector startPosition, ArrayList<PVector> lineVectors){
        PVector p = lineVectors.get(0).get();
        connectingLine(startPosition, PVector.add(startPosition, p));
        for (int i = 1; i < lineVectors.size()-1; i++){
            p.add(lineVectors.get(i));
            connectingLine(PVector.add(startPosition, lineVectors.get(i)),
            PVector.add(startPosition, lineVectors.get(i+1)));
        }
        p.add(lineVectors.get(lineVectors.size()-1));
        
        ArrayList<PVector> newLines = new ArrayList();
        for (PVector pv : lineVectors){
            pv.rotate(PI/2);
            newLines.add(pv);
        }
        if (newLines.size() < 100){
            fractal(PVector.add(startPosition, p), newLines);  
        }    
    } 

    public void minFunction(float x){
        noFill();
        ellipse(width/2, height/2, x, x);
        if (x < 400){
            minFunction(x*1.1f);
        }
    }


    

    
}
    
