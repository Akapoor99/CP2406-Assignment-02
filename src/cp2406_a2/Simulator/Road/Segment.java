package cp2406_a2.Simulator.Road;

import java.awt.*;

public class Segment{
    private int height;
    private int width;
    private int posX;
    private int posY;
    private int posX_end;
    private int posY_end;
    private boolean vehicle;

    private boolean traffic_light;

    public Segment(int x, int y, int height, int width) {
        this.posX = x;
        this.posY = y;
        this.height = height;
        this.width = width;
        this.vehicle = false;
        this.traffic_light = false;
    }


    public void paintMeHorizontal(Graphics g){
        this.height = this.height * 2;
        this.posX_end = posX+width;
        this.posY_end = posY;//+((height*2)+(height/10));
        g.setColor(Color.BLACK);
        g.fillRect(posX,posY, width, (height*2)+(height/10));
        g.setColor(Color.WHITE);
        g.fillRect(posX+(width/10), posY+height, width-(width/5), height/10);
    }

    public void paintMeVertical(Graphics g){
        this.width = this.width * 2;
        this.posX_end = posX;//+((width*2)+(width/10));
        this.posY_end = posY+(height);
        g.setColor(Color.BLACK);
        g.fillRect(posX,posY, (width*2)+(width/10), height);
        g.setColor(Color.WHITE);
        g.fillRect(posX+width, posY+(height/10), width/10, height-(height/5));
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public int getPosX_end() {
        return posX_end;
    }

    public int getPosY_end() {
        return posY_end;
    }

    public boolean isVehicle() {
        return vehicle;
    }

    public void setVehicle(boolean vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isTraffic_light() {
        return traffic_light;
    }

    public void setTraffic_light(boolean traffic_light) {
        this.traffic_light = traffic_light;
    }

}
