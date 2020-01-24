package cp2406_a2.Simulator;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Editor implements MouseListener, MouseMotionListener {

    private int X,Y;
    private Component selected_componenet;

    public Editor(Component... components){
        for(Component component : components){
            component.addMouseListener(this);
            component.addMouseMotionListener( this);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(Simulator.isEDIT_MODE()) {
            X = e.getX();
            Y = e.getY();
            selected_componenet = e.getComponent();
            System.out.println("Pressed");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(Simulator.isEDIT_MODE()) {
            int x = (e.getX() + selected_componenet.getX()) - X;
            int y = (e.getY() + selected_componenet.getY()) - Y;
            selected_componenet.setLocation(x, y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
