package oopd_gu_chalmers;

/* This is now all we (can) use from the sub-package */
//import oopd_gu_chalmers.polygonModel.polygon.Polygon;
//import oopd_gu_chalmers.polygonModel.polygon.PolygonFactory;

/* By commenting out the imports above, and instead importing the adapter package,
 * we effectively switch to using the DIT953.model.shapes package.
 */
import oopd_gu_chalmers.polygonModel.adapter.*;

import javax.swing.*;
import java.awt.Graphics;
import java.util.*;

public class DrawPolygons extends JComponent{
    public ArrayList<Polygon> polygons;
    public boolean direction = true;
    public int ticker = 0;
    public JFrame frame;

    public DrawPolygons(){ //Arraylist<Polygon> polygons){
        // this.polygons = polygons
        polygons = new ArrayList<>(10);

        polygons.add(PolygonFactory.createSquare(50,50));
        polygons.add(PolygonFactory.createTriangle(100,100));
        polygons.add(PolygonFactory.createRectangle(50,150));

    }//constructor

    public void update(){
        ticker++;
        int value = direction ? 10 : -10;
        for (Polygon p: polygons){
            p.updateCenter(p.getCenterX()+value, p.getCenterY()+value);
        }
        if (ticker > 10) {
            direction = !direction;
            ticker = 0;
        } //Model function until here

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        for (Polygon currentPolygon : polygons) {
            currentPolygon.paint(g);
        }
    }//paint

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawPolygons polygons = new DrawPolygons();
        polygons.frame = frame;

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(30,30,300,300);
        frame.getContentPane().add(polygons);
        frame.setVisible(true);


        try {
            while (true) {
                Thread.sleep(500);
                polygons.update(); //model.polygon.update();
                //View.Update.repaint();
            }
        } catch (InterruptedException e) {}

    }//main

}//DIT953.DrawPolygons