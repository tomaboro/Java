import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * Created by Tomek on 04.01.2017.
 */
public class Robot extends Obiekt {
    public Robot(int x, int y){
        super(x,y);
    }
    double []sygnaly = new double[3];

    public void zapytajSygnał(LinkedList<Stacja> stacje){
        for(int i = 0;i<stacje.size();++i){
            sygnaly[i] = stacje.get(i).zapytajSygnal(this.x,this.y);
        }
    }

    public void pytajGwizadki(LinkedList<Gwiazdka> listaG, LinkedList<Stacja> listaS){
        for(int i=0; i<listaG.size(); i++){
            for(int j=0; j<listaS.size(); j++)
            listaG.get(i).zapytajSygnał(listaS.get(j));
        }
    }

    public Gwiazdka znajdzNajblizszaGwiazdke(LinkedList<Gwiazdka> listaG){
        Gwiazdka tmp = listaG.get(0);
        Double min = Math.sqrt(Math.pow((this.sygnaly[0] - tmp.sygnaly[0]),2)
                + Math.pow((this.sygnaly[1] - tmp.sygnaly[1]),2)
                + Math.pow((this.sygnaly[2] - tmp.sygnaly[2]),2) );
        for(Gwiazdka gwiazdka: listaG){
            Double odl = Math.sqrt(Math.pow((this.sygnaly[0] - gwiazdka.sygnaly[0]),2)
                    + Math.pow((this.sygnaly[1] - gwiazdka.sygnaly[1]),2)
                    + Math.pow((this.sygnaly[2] - gwiazdka.sygnaly[2]),2) );
            if (odl < min){
                tmp = gwiazdka;
                min = odl;
            }
        }
        return tmp;
    }

    public LinkedList<Gwiazdka> znajdzGwiazdkiZNajmocniejszymSygnalem(LinkedList<Gwiazdka> listaG){
        double []max = new double[3];
        for(int i = 0;i<max.length;++i){
            max[i] = 0;
        }
        Gwiazdka [] najsilniejszeGwiazdki = new Gwiazdka[3];
        for(Gwiazdka gwiazdka : listaG){
            for(int i= 0;i<najsilniejszeGwiazdki.length;++i)
            if(gwiazdka.sygnaly[i] > max[i]){
                najsilniejszeGwiazdki[i] = gwiazdka;
                max[i] = gwiazdka.sygnaly[i];
            }
        }
        LinkedList gwiazdki = new LinkedList();
        for(int i=0;i<najsilniejszeGwiazdki.length;++i){
            gwiazdki.addLast(najsilniejszeGwiazdki[i]);
        }
        return gwiazdki;
    }

    public LinkedList<Gwiazdka> znajdzGwiazdkiZa1GwiazdkaZNajmocniejszymSygnalem(Gwiazdka najmocniejsza, LinkedList<Gwiazdka> wszystkie){
        LinkedList<Gwiazdka> listaGwiazdekZa1 = new LinkedList<>();
        for(Gwiazdka gwiazdka : wszystkie){
            if((najmocniejsza.sygnaly[0]> gwiazdka.sygnaly[0]) && (najmocniejsza.sygnaly[1] + najmocniejsza.sygnaly[2] < gwiazdka.sygnaly[1]+gwiazdka.sygnaly[2])){
                listaGwiazdekZa1.add(gwiazdka);
            }
        }
        return listaGwiazdekZa1;
    }
    public LinkedList<Gwiazdka> znajdzGwiazdkiZa2GwiazdkaZNajmocniejszymSygnalem(Gwiazdka najmocniejsza, LinkedList<Gwiazdka> wszystkie){
        LinkedList<Gwiazdka> listaGwiazdekZa2 = new LinkedList<>();
        for(Gwiazdka gwiazdka : wszystkie){
            if((najmocniejsza.sygnaly[1]> gwiazdka.sygnaly[1]) && (najmocniejsza.sygnaly[0] + najmocniejsza.sygnaly[2] < gwiazdka.sygnaly[0]+gwiazdka.sygnaly[2])){
                listaGwiazdekZa2.add(gwiazdka);
            }
        }
        return listaGwiazdekZa2;
    }
    public LinkedList<Gwiazdka> znajdzGwiazdkiZa3GwiazdkaZNajmocniejszymSygnalem(Gwiazdka najmocniejsza, LinkedList<Gwiazdka> wszystkie){
        LinkedList<Gwiazdka> listaGwiazdekZa3 = new LinkedList<>();
        for(Gwiazdka gwiazdka : wszystkie){
            if((najmocniejsza.sygnaly[2]> gwiazdka.sygnaly[2]) && (najmocniejsza.sygnaly[1] + najmocniejsza.sygnaly[0] < gwiazdka.sygnaly[1]+gwiazdka.sygnaly[0])){
                listaGwiazdekZa3.add(gwiazdka);
            }
        }
        return listaGwiazdekZa3;
    }
}
