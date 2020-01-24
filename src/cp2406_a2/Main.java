package cp2406_a2;

import cp2406_a2.Simulator.Editor;
import cp2406_a2.Simulator.Road.Road;
import cp2406_a2.Simulator.Simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    private static int MAX_WIDTH=800, MAX_HEIGHT=800;

    public static JFrame frame = new JFrame("Programming III - Assignment 02");
    public static String LOAD_RES_PATH = "./res/layout/";
    public static boolean running;
    public static Simulator simulation = new Simulator();
    JPanel ls = new JPanel();
    JPanel top_option = new JPanel();
    LeftPanel1 lp1 = new LeftPanel1();
    LeftPanel2 lp2 = new LeftPanel2();
    Editor editor;

    public Main(){
        //frame.add(new Graphic());
        running = false;
        frame.setSize(MAX_WIDTH, MAX_HEIGHT);
        frame.setLayout(new BorderLayout());

        //createSettingPanel();
        topMenuBar();
        //simulation.addRoad(new Road(5, true));
        frame.add(top_option, BorderLayout.NORTH);
        frame.add(lp1, BorderLayout.WEST);
        frame.add(simulation, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void topMenuBar(){
        top_option.setLayout(new FlowLayout());
        top_option.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        JButton top_option1 = new JButton("Simulator Tools");
        JButton top_option2 = new JButton("Editor Tools");

        top_option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(lp2);
                frame.add(lp1, BorderLayout.WEST);
                top_option1.setSelected(true);
                top_option2.setSelected(false);
                simulation.setEDIT_MODE(false);
                frame.revalidate();
                frame.repaint();
            }
        });

        top_option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(running == true){
                    running = false;
                }
                frame.remove(lp1);
                frame.add(lp2, BorderLayout.WEST);
                top_option2.setSelected(true);
                top_option1.setSelected(false);
                simulation.setEDIT_MODE(true);
                frame.revalidate();
                frame.repaint();
            }
        });
        top_option1.setSelected(true);
        top_option.add(top_option1);
        top_option.add(top_option2);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }

}
