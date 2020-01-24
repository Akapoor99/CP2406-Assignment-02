package cp2406_a2.Simulator;

import cp2406_a2.Simulator.Road.Segment;

import javax.swing.*;
import java.awt.*;

public class Intersection extends JPanel {private Segment[] segments;
    private int height;
    private int width;
    private int posX;
    private int posY;
    private int posX_end;
    private int posY_end;

    private boolean horizontal;

    private int numOfIntersection;

    public Intersection(int numOfIntersections){
        super();
        this.numOfIntersection = numOfIntersections;
        posX = 0;
        posY = 0;
        setLocation(posX,posY);
        addMouseListener(Simulator.editor);
        addMouseMotionListener(Simulator.editor);
        int num = (2*Simulator.LEN_BUS)+(4*Simulator.LEN)+(Simulator.LEN/5);
        this.width = num;
        this.height = num;
        setSize(this.width, this.height);
    }

    /*
    public Intersection (int numOfintersections, boolean horizontal){
        super();
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
        posX = 0;
        posY = 0;
        setBackground(Color.RED);
        setLocation(posX,posY);
        addMouseListener(Simulator.editor);
        addMouseMotionListener(Simulator.editor);
    }*/

    public void paintComponentFourWay(Graphics g){
        super.paintComponent(g);
        int x,y,len,len_bus;
        len = Simulator.LEN;
        len_bus = Simulator.LEN_BUS;

        x = posX+(2*len_bus);
        y = posY;


        // VERTCIAL NORTH
        g.setColor(Color.BLACK);
        g.fillRect(x, y, (len*2)+(len/10), len_bus);
        g.setColor(Color.WHITE);
        g.fillRect(x+len, y+(len/10), len/10, len_bus-(len_bus/5));

        y += (2*len_bus);

        // VERTICAL SOUTH
        g.setColor(Color.BLACK);
        g.fillRect(x, y, (len*2)+(len/10), len_bus);
        g.setColor(Color.WHITE);
        g.fillRect(x+(2*len), y+(len/10), len/10, len_bus-(len_bus/5));

        // HORIZONTAL WEST
        g.setColor(Color.BLACK);
        g.fillRect(posX,posY, width, (height*2)+(height/10));
        g.setColor(Color.WHITE);
        g.fillRect(posX+(width/10), posY+height, width-(width/5), height/10);

        // HORIZONTAL EAST
        g.setColor(Color.BLACK);
        g.fillRect(posX,posY, width, (height*2)+(height/10));
        g.setColor(Color.WHITE);
        g.fillRect(posX+(width/10), posY+height, width-(width/5), height/10);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosX_end() {
        return posX_end;
    }

    public int getPosY_end() {
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
}