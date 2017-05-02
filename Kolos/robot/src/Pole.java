/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Krzysiek
 */
public class Pole {
    private int rozmiar;
    public LinkedList<Stacja> stacje = new LinkedList();
    public LinkedList<Gwiazdka> gwiazdki = new LinkedList();
    public Robot robot;
    public LinkedList<Gwiazdka> najsilniejsze = new LinkedList<>();
    public LinkedList<Gwiazdka> za1 = new LinkedList<>();
    public LinkedList<Gwiazdka> za2 = new LinkedList<>();
    public LinkedList<Gwiazdka> za3 = new LinkedList<>();
    public LinkedList<Gwiazdka> za1i2 = new LinkedList<>();
    public LinkedList<Gwiazdka> wspolne = new LinkedList<>();
    Random generator = new Random();
    public Pole(int rozmiar) {
        this.rozmiar = rozmiar;
        robot = new Robot(generator.nextInt(rozmiar),generator.nextInt(rozmiar));
        //tworzenie stacji
        int x;
        int y;
        for(int i = 0; i<3; ++i){
            do {
                x = generator.nextInt(rozmiar);
                y = generator.nextInt(rozmiar);
            } while(!sprawdzCzyWolne(x,y));
            stacje.add(new Stacja(x,y));
        }
        //losowanie gwiazdek
        for(int i = 0; i < rozmiar; ++i){
            for(int j = 0; j < rozmiar; ++j){              
                int wylosowana = generator.nextInt(9);
                if(wylosowana < 4){ 
                    if(sprawdzCzyWolne(i,j)) {
                        gwiazdki.add(new Gwiazdka(i,j,stacje));
                    }
                }
            }               
        }

        najsilniejsze = robot.znajdzGwiazdkiZNajmocniejszymSygnalem(gwiazdki);
        robot.zapytajSygnał(stacje);
        za1 = robot.znajdzGwiazdkiZa1GwiazdkaZNajmocniejszymSygnalem(najsilniejsze.get(0),gwiazdki);
        za2 = robot.znajdzGwiazdkiZa2GwiazdkaZNajmocniejszymSygnalem(najsilniejsze.get(1),gwiazdki);
        za3 = robot.znajdzGwiazdkiZa3GwiazdkaZNajmocniejszymSygnalem(najsilniejsze.get(2),gwiazdki);

        for(Gwiazdka gwiazdka1 : za1){
            for (Gwiazdka gwiazdka2: za2){
                if(gwiazdka1.equals(gwiazdka2)){
                    za1i2.add(gwiazdka1);
                }
            }
        }
        for(Gwiazdka gwiazdka1 : za1i2){
            for (Gwiazdka gwiazdka2: za3){
                if(gwiazdka1.equals(gwiazdka2)){
                    wspolne.add(gwiazdka1);
                }
            }
        }

    }

    public boolean czyRobotWTrojkacie(double plsmin){
        for(Gwiazdka gw: wspolne){
            if((Math.abs(gw.sygnaly[0] - robot.sygnaly[0]) < plsmin) && (Math.abs(gw.sygnaly[1] - robot.sygnaly[1]) < plsmin)
            && (Math.abs(gw.sygnaly[2] - robot.sygnaly[2]) < plsmin)) return true;
        }
        return false;
    }

    public boolean czyRobotWTrojkacieAPIT(){
        Gwiazdka gw = this.robot.znajdzNajblizszaGwiazdke(this.gwiazdki);
        if(gw.sygnaly[0] > this.robot.sygnaly[0]){
            if((gw.sygnaly[1] < this.robot.sygnaly[1]) && (gw.sygnaly[2] > this.robot.sygnaly[2])) return true;
        }
        else if(gw.sygnaly[1] > this.robot.sygnaly[1]){
            if((gw.sygnaly[2] < this.robot.sygnaly[2]) && (gw.sygnaly[0] > this.robot.sygnaly[0])) return true;
        }
        else if(gw.sygnaly[2] > this.robot.sygnaly[2]){
            if((gw.sygnaly[0] < this.robot.sygnaly[0]) && (gw.sygnaly[1] > this.robot.sygnaly[1])) return true;
        }
        return false;
    }
    
    boolean sprawdzCzyWolne(int x, int y){
        if((x == robot.getX()) && (y == robot.getY())) {
            return false;                       
        }
        for(Stacja stacja : stacje){
            if((x == stacja.getX()) && (y == stacja.getY())){
                return false;
            }
        }
        return true;
    } 
    
}
