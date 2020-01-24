package cp2406_a2.Simulator.Vehicle;

import cp2406_a2.Main;
import cp2406_a2.Simulator.Road.Road;
import cp2406_a2.Simulator.Road.Segment;
import cp2406_a2.Simulator.Simulator;

import java.awt.*;

public class Vehicle {//extends {
    private int width;
    private int height;
    private int pos_X;
    private int pos_Y;
    private Color color;
    private String type;
    protected Road curr_road;
    protected Road respawn;
    protected int segNum;

    Vehicle(int width, int height, Color color, String type) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.type = type;
    }

    public void moveForward(){
        //lookLeft();
        //lookRight();
        //lookForward();

        if(segNum == curr_road.getLength()-1){
            int width = curr_road.getSegment(segNum).getPosX_end();
            int height = curr_road.getSegment(segNum).getPosY_end();
            curr_road = Simulator.getNextRoad(width, height, curr_road);
            if(curr_road == null){
                curr_road = respawn;
            }
            segNum = 0;
        }else {
            segNum++;
        }
        step();
        Main.frame.repaint();
    }

    public void step(){
        Segment s = curr_road.getSegment(segNum);
        if (curr_road.isHorizontal()) {
            setPos_X(s.getX() + ((Simulator.LEN_BUS / 2) + getWidth() / 2));
            setPos_Y(s.getY() + (getHeight() / 2));
        } else {
            setPos_X(s.getX() + (getWidth() / 2));
            setPos_Y(s.getY() + ((Simulator.LEN_BUS / 2) + getHeight() / 2));
        }
    }
/*
    public int getSegNum() {
        return segNum;
    }

    public void setSegNum(int segNum) {
        this.segNum = segNum;
    }
*/
    public Road getRespawn() {
        return respawn;
    }

    public int getPos_X() {
        return pos_X;
    }

    public void setPos_X(int pos_X) {
        this.pos_X = pos_X;
    }

    public int getPos_Y() {
        return pos_Y;
    }

    public void setPos_Y(int pos_Y) {
        this.pos_Y = pos_Y;
    }

    public void paintMe(Graphics g){
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public Road getCurr_road() {
        return curr_road;
    }

    public void setCurr_road(Road road) {
        this.curr_road = road;
    }
}