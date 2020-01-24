package cp2406_a2.Simulator.Vehicle;

import cp2406_a2.Simulator.Road.Road;
import cp2406_a2.Simulator.Simulator;

import java.awt.*;

public class Motorbike extends Vehicle{

    public Motorbike(Road road) {
        super(Simulator.LEN, Simulator.LEN_MB, Color.RED, "Motorbike");
        this.respawn = road;
        if(road.isHorizontal()) {
            this.setWidth(Simulator.LEN_MB);
            this.setHeight(Simulator.LEN);
            setPos_X(road.getSegment(segNum).getX() + ((Simulator.LEN_BUS / 2) + getWidth() / 2));
            setPos_Y(road.getSegment(segNum).getY() + (getHeight() / 2));
        }else{
            this.setWidth(Simulator.LEN);
            this.setHeight(Simulator.LEN_MB);
            setPos_X(road.getSegment(segNum).getX() + (getWidth() / 2));
            setPos_Y(road.getSegment(segNum).getY() + ((Simulator.LEN_BUS / 2) + (getHeight() / 2)));
        }
    }

    public void paintMe(Graphics g){
        g.setColor(getColor());
        g.fillRect(getPos_X(),getPos_Y(),getWidth(),getHeight());
    }
}
