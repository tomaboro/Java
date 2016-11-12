/**
 * Created by Tomek on 2016-11-08.
 */
public class ROT11 implements Algorithm {
    private static final String Aplhabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int rot = 11;

    public String cryptWord(String word){
        String output="";
        for(int i=0; i<word.length(); i++){
            for(int j=0; j<Aplhabet.length();j++){
                if(word.charAt(i) == Aplhabet.charAt(j)){
                    //Obsługujemy małe litery
                    if(j<Aplhabet.length()/2){
                        if(j+rot<Aplhabet.length()/2) output = output + Aplhabet.charAt(j+rot);
                        else output = output + Aplhabet.charAt(rot - Aplhabet.length()/2 + j);
                    }
                    //Obsługujemy duże litery
                    else{
                        if(j+rot<Aplhabet.length()) output = output + Aplhabet.charAt(j+rot);
                        else output = output + Aplhabet.charAt(rot + j - Aplhabet.length()/2);
                    }
                }
            }
            if (output.length()-1 != i) output = output + word.charAt(i);
        }
        return output;
    }

    public String decryptWord(String word){
        String output="";
        for(int i=0; i<word.length(); i++) {
            for (int j = 0; j < Aplhabet.length(); j++) {
                if(word.charAt(i) == Aplhabet.charAt(j)){
                    if(j<Aplhabet.length()/2){
                        if(j-rot >= 0) output = output + Aplhabet.charAt(j-rot);
                        else output = output + Aplhabet.charAt(Aplhabet.length()/2 + j - rot);
                    }
                    else{
                        if(j-rot >= Aplhabet.length()/2) output = output + Aplhabet.charAt(j-rot);
                        else output = output + Aplhabet.charAt(Aplhabet.length() + j - rot - Aplhabet.length()/2);
                    }
                }
            }
            if (output.length()-1 != i) output = output + word.charAt(i);
        }
        return output;
    }
}
