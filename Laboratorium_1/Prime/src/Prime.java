/**
 * Created by Tomek on 2016-10-12.
 */

public class Prime {

    public int tab [] = null;

    public Prime(int i){

        tab  = new int[i];

        for(int j=0; j<i; j++){
            tab[j] = 0;
        }


        for(int j=1; j<i; j++){
            if (tab[j]==0){
                for(int k=j+j+1; k<i; k=k+j+1 ){
                    tab[k] = 1;
                }
            }
        }

    }

    public Prime(){
        tab  = new int[1000];
    }

    public void printPrime(){

        for(int j=0; j<tab.length; j++){
            if(tab[j] == 0) System.out.print(j+1 + " ");
        }

    }
}
