package cp2406_a2.Simulator;

import cp2406_a2.Main;
import cp2406_a2.Simulator.Road.Road;
import cp2406_a2.Simulator.Vehicle.Bus;
import cp2406_a2.Simulator.Vehicle.Car;
import cp2406_a2.Simulator.Vehicle.Motorbike;
import cp2406_a2.Simulator.Vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Simulator extends JPanel implements Runnable{
    public static ArrayList<Road> roads = new ArrayList<>();
    public static ArrayList<Intersection> intersections = new ArrayList<>();
    public static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static int LEN;
    public static int LEN_BUS;
    public static int LEN_MB;
    public static Editor editor;
    public static int WIDTH;
    public static int HEIGHT;

    public static boolean isEDIT_MODE() {
        return EDIT_MODE;
    }

    public static void setEDIT_MODE(boolean edit) {
        EDIT_MODE = edit;
    }

    public static boolean EDIT_MODE;

    public Simulator() {
        super();
        this.LEN = 10;
        this.calcBusLen();
        this.calcMotorBikeLen();
        this.WIDTH=getWidth();
        this.HEIGHT=getHeight();
        System.out.println();
        setSize(getSize());
        setBackground(Color.YELLOW);
        setLayout(null);
        setLocation(0,0);
        editor = new Editor(this.getComponents());
        EDIT_MODE = false;
    }

    public void addRoad(Road r){
        roads.add(r);
        this.add(r);
        //System.out.println(roads.size());
        //addCar(new Car(r));
    }

    public void addCar(){
        System.out.println("Running now");
        Car car = new Car(roads.get(0));
        car.setCurr_road(car.getRespawn());
        vehicles.add(car);
    }
/*
    public static Road getNextRoad(Road cr){
        int a_x1,a_x2,a_y1,a_y2,b_x1,b_y1,b_x2,b_y2;
        if(cr.isHorizontal()) {
            a_x1 = (cr.getX() + ((cr.getLength() - 1) * LEN_BUS));
            a_y1 = cr.getY();
            b_x1 = a_x1+LEN_BUS;
            b_y1 = a_y1+(4*LEN)+(LEN/10);
        }else{
            a_x1 = cr.getX();
            a_y1 = cr.getY() + ((cr.getLength() - 1)*LEN_BUS);
            b_x1 = a_x1+(4*LEN)+(LEN/10);
            b_y1 = a_y1 + LEN_BUS;
        }
        for (Road r:roads) {
            if(r.isHorizontal()) {
                a_x2 = r.getX();//(r.getX() + ((r.getLength() - 1) * LEN_BUS));
                a_y2 = r.getY();
                b_x2 = a_x2+LEN_BUS;
                b_y2 = a_y2+(4*LEN)+(LEN/10);
            }else{
                a_x2 = r.getX();
                a_y2 = r.getY();// + ((r.getLength() - 1)*LEN_BUS);
                b_x2 = a_x2+(4*LEN)+(LEN/10);
                b_y2 = a_y2 + LEN_BUS;
            }
            if(doOverlap(a_x1,a_x2,b_x1,b_x2,a_y1,a_y2,b_y1,b_y2)){
                return r;
            }
        }
        for (Road r:roads) {

            System.out.println("OLD X: "+cr.getPosX_end(cr.getLength()));
            System.out.println("OLD Y: "+cr.getPosY_end(cr.getLength()));

            System.out.println("NEW X: "+r.getX());
            System.out.println("NEW Y: "+r.getY());
            if ((cr.getPosX_end(cr.getLength()-1) >= r.getX() && cr.getPosX_end(cr.getLength()) <= r.getX()) && ((cr.getPosY_end(cr.getLength()-1) <= r.getY()) && (cr.getPosY_end(cr.getLength()) >= r.getY())) ){
                return r;
            }
        }

        return null;*/

    public static Road getNextRoad(int x, int y, Road cr){
        for (Road r:roads) {
            if((x == r.getX() || x == r.getPosX_end(r.getLength())) && (y == r.getY() || y == r.getPosY_end(r.getLength()))){
                if(!r.equals(cr)) {
                    return r;
                }
            }
        }
        return null;
    }

    public static boolean doOverlap(int a_x1, int a_x2, int b_x1, int b_x2, int a_y1, int a_y2, int b_y1, int b_y2){

        if(a_x1 > b_x2 || a_x2 > b_x1){
            return false;
        }

        if(a_y1 < b_y2 || a_y2 < b_y1){
            return false;
        }

        return true;
    }

    public void addBus(){
        Bus bus = new Bus(roads.get(0));
        bus.setCurr_road(bus.getRespawn());
        vehicles.add(bus);
    }

    public void addMotorbike(){
        Motorbike motorbike = new Motorbike(roads.get(0));
        motorbike.setCurr_road(motorbike.getRespawn());
        vehicles.add(motorbike);
    }

    private void calcBusLen(){
        this.LEN_BUS = 2 * this.LEN;
    }

    private void calcMotorBikeLen(){
        this.LEN_MB = (int) 0.5 * this.LEN;
    }

    @Override
    public void run() {
        while (Main.running == true){
            for (Vehicle vehicle:vehicles){
                vehicle.moveForward();
            }
            try{
                Thread.sleep(500);
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }

    public void saveLayout(String f_name) {
        String path = Main.LOAD_RES_PATH+f_name+".txt";
        File file = new File(path);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file,false);
            BufferedWriter br = new BufferedWriter(fileWriter);
            br.write(""+roads.size());
            br.newLine();
            for (Road r:roads) {
                br.write(r.toString());
                br.newLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadLayout(File file) {
        this.clearLayout();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            int numOfRoads = Integer.parseInt(br.readLine());
            for(int i=0;i<numOfRoads;i++){
                String[] data = br.readLine().split(",");
                int x = Integer.parseInt(data[0]);
                int y = Integer.parseInt(data[1]);
                int s = Integer.parseInt(data[2]);
                boolean orientation = Boolean.parseBoolean(data[3]);
                this.addRoad(new Road(x,y,s,orientation));
            }
            Main.frame.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearLayout() {
        roads.clear();
        vehicles.clear();
        intersections.clear();

        Main.simulation.removeAll();
        Main.frame.repaint();
    }

    public void clearVehicles() {
        vehicles.clear();
        Main.frame.repaint();
    }
}
