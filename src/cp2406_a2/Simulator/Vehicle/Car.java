package cp2406_a2.Simulator.Vehicle;

import cp2406_a2.Simulator.Road.Road;
import cp2406_a2.Simulator.Simulator;

import java.awt.*;

public class Car extends Vehicle{

    public Car(Road road) {
        super(Simulator.LEN, Simulator.LEN, Color.BLUE, "Car");
        this.respawn = road;

        this.segNum = 0;
        if(road.isHorizontal()) {
            setPos_X(road.getSegment(segNum).getX() + (Simulator.LEN_BUS - getWidth() / 2));
            setPos_Y(road.getSegment(segNum).getY() + (getHeight() / 2));
        }else{
            setPos_X(road.getSegment(segNum).getX() + (getWidth() / 2));
            setPos_Y(road.getSegment(segNum).getY() + (Simulator.LEN_BUS- (getHeight() / 2)));
        }
    }

    public void paintMe(Graphics g){
        g.setColor(getColor());
        g.fillRect( getPos_X(), getPos_Y(), getWidth(), getHeight());
    }
}
