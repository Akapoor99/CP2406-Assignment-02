package cp2406_a2;

import cp2406_a2.Simulator.Road.Road;
import cp2406_a2.Simulator.Simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LeftPanel2 extends JPanel{
    private boolean running;
    public LeftPanel2() {
        super();
        setPreferredSize(new Dimension(160, 140));
        buildButtons();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBorder(BorderFactory.createTitledBorder("Editing"));
        System.out.println(getPreferredSize());
    }

    public void buildButtons(){
        JButton save_layout = new JButton("Save Layout");
        JButton load_layout = new JButton("Load Layout");
        JButton clear_layout = new JButton("Clear Layout");
        JButton create_road = new JButton("Create Road");
        JButton create_junction = new JButton("Create Junction");
        System.out.println(create_junction.getPreferredSize());

        save_layout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String file_name = JOptionPane.showInputDialog("Please enter your file name :");
                Main.simulation.saveLayout(file_name);
            }
        });

        load_layout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser j = new JFileChooser(Main.LOAD_RES_PATH);
                j.showSaveDialog(null);
                File file = j.getSelectedFile();
                Main.simulation.loadLayout(file);
            }
        });

        clear_layout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.simulation.clearLayout();
            }
        });

        create_road.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] possibilities_s = {"1", "2", "3", "4", "5"};
                String s = (String)JOptionPane.showInputDialog(Main.frame,
                        "Number of Segments",
                        "Road Settings 1",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        possibilities_s,
                        "1");
                Object[] possibilities_o = {"Horizontal", "Vertical"};
                String o = (String)JOptionPane.showInputDialog(
                        Main.frame,
                        "Orientation",
                        "Road Settings 2",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        possibilities_o,
                        "horizontal");
                if(!s.isBlank() && !o.isBlank()) {
                    int numOfSeg = Integer.parseInt(s);
                    boolean horizontal;
                    if (o.equalsIgnoreCase("Horizontal")) {
                        horizontal = true;
                    } else {
                        horizontal = false;
                    }
                    Main.simulation.addRoad(new Road(numOfSeg, horizontal));
                    Main.frame.repaint();
                }
            }
        });

        create_junction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TO DO
            }
        });

        this.add(save_layout);
        this.add(load_layout);
        this.add(clear_layout);
        this.add(create_road);
        this.add(create_junction);
    }
}
