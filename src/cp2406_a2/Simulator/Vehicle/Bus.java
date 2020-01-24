package cp2406_a2.Simulator.Vehicle;

import cp2406_a2.Simulator.Road.Road;
import cp2406_a2.Simulator.Simulator;

import java.awt.*;

public class Bus extends Vehicle {

    public Bus(Road road) {
        super(Simulator.LEN, Simulator.LEN_BUS, Color.GREEN, "Bus");
        this.respawn = road;
    }

    public void paintMe(Graphics g){
        if(curr_road.isHorizontal()) {
            this.setWidth(Simulator.LEN_BUS);
            this.setHeight(Simulator.LEN);
            setPos_X(curr_road.getSegment(segNum).getX() + (Simulator.LEN_BUS - getWidth() / 2));
            setPos_Y(curr_road.getSegment(segNum).getY() + (getHeight() / 2));
        }else{
            this.setWidth(Simulator.LEN);
            this.setHeight(Simulator.LEN_BUS);
            setPos_X(curr_road.getSegment(segNum).getX() + (getWidth() / 2));
            setPos_Y(curr_road.getSegment(segNum).getY() + (Simulator.LEN_BUS - getHeight() / 2));
        }
        g.setColor(getColor());
        g.fillRect(getPos_X(),getPos_Y(),getWidth(),getHeight());
    }
}
