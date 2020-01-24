package cp2406_a2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel1 extends JPanel {
    public LeftPanel1() {
        super();
        setPreferredSize(new Dimension(160, 140));
        Main.running = false;
        buildButtons();
        System.out.println(getSize());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(100, getHeight());
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBorder(BorderFactory.createTitledBorder("Simulation"));
    }

    public void buildButtons(){
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton clear = new JButton("Clear");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Main.running == false){
                    Main.running = true;
                    Thread t = new Thread(Main.simulation);
                    t.start();
                }
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Main.running == true){
                    Main.running = false;
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Main.running == true){
                    Main.running = false;
                }
                Main.simulation.clearVehicles();
            }
        });

        JButton addCar =new JButton("Add Car");
        addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.simulation.addCar();
                Main.frame.repaint();
            }
        });
        this.add(addCar);
        JButton addBus =new JButton("Add Bus");
        addBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.simulation.addBus();
                Main.frame.repaint();
            }
        });
        this.add(addBus);
        JButton addMotorbike =new JButton("Add Motorbike");
        addMotorbike.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.simulation.addMotorbike();
                Main.frame.repaint();
            }
        });
        this.add(addMotorbike);


        this.add(start);
        this.add(stop);
        this.add(clear);
    }
}
