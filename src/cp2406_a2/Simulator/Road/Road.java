package cp2406_a2.Simulator.Road;

import cp2406_a2.Simulator.Simulator;
import cp2406_a2.Simulator.Vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;

public class Road extends JPanel {
    private Segment[] segments;
    private int height;
    private int width;
    private int posX;
    private int posY;
    private int posX_end;
    private int posY_end;

    private boolean horizontal;

    public Road (int numOfSeg, boolean horizontal){
        posX = 0;
        posY = 0;
        mainSetup(numOfSeg, horizontal);
    }

    public Road (int x, int y, int numOfSeg, boolean horizontal){
        posX = x;
        posY = y;
        mainSetup(numOfSeg, horizontal);
    }

    public void mainSetup(int numOfSeg, boolean horizontal){
        segments = new Segment[numOfSeg];
        this.horizontal = horizontal;
        if(horizontal) {
            this.width = 2 * Simulator.LEN_BUS;
            this.height = Simulator.LEN;
            setSize(this.width*numOfSeg, (this.height*4)+(this.height/10));
        }else{
            this.width = Simulator.LEN;
            this.height = 2 * Simulator.LEN_BUS;
            setSize((this.width*4)+(this.width/10), this.height*numOfSeg);
        }
        setBackground(Color.RED);
        setLocation(posX,posY);
        addMouseListener(Simulator.editor);
        addMouseMotionListener(Simulator.editor);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0;i<segments.length;i++){
            int x,y;
            if (i==0) {
                x = 0;
                y = 0;
            }else if(horizontal){
                x = segments[i-1].getX()+width;
                y = segments[i-1].getY();
            }else{
                x = segments[i-1].getX();
                y = segments[i-1].getY()+height;
            }
            segments[i] = new Segment(x, y, height, width);
            if(horizontal) {
                segments[i].paintMeHorizontal(g);
            }else{
                segments[i].paintMeVertical(g);
            }
        }
        this.posX_end = segments[segments.length-1].getPosX_end();
        this.posY_end = segments[segments.length-1].getPosY_end();
        for(Vehicle vehicle: Simulator.vehicles){
            if(vehicle.getCurr_road().equals(this)) {
                vehicle.paintMe(g);
            }
        }
    }

    public int getPosX_end(int n) {
        if(horizontal) {
            posX_end = getX()+(n*Simulator.LEN_BUS);
        }else{
            posX_end = getX()+(4*Simulator.LEN)+(Simulator.LEN/10);
        }
        return posX_end;
    }

    public int getPosY_end(int n) {
        if(horizontal) {
            posY_end = getY()+(4*Simulator.LEN)+(Simulator.LEN/10);
        }else{
            posY_end = getY()+(n*Simulator.LEN_BUS);
        }
        return posY_end;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public Segment getSegment(int i){
        return segments[i];
    }

    public int getLength(){
        return segments.length;
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void revalidate() {
        super.revalidate();
    }

    public String toString(){
        String str="";
        str+=getX()+",";
        str+=getY()+",";
        str+=this.getLength()+",";
        str+=horizontal;
        return str;
    }
}
