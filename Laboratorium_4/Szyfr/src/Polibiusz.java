/**
 * Created by Tomek on 2016-11-08.
 */
public class Polibiusz implements Algorithm {
    private static char tab[][] = {{'A','B','C','D','E'},{'F','G','H','I','K'},{'L','M','N','O','P'},{'Q','R','S','T','U'},{'V','W','X','Y','Z'}};
    public String cryptWord(String word) {
        String output = "";
        boolean dodano = false;
        for (int i = 0; i < word.length(); i++) {
            dodano = false;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (tab[j][k] == word.charAt(i) ||  Character.toLowerCase(tab[j][k]) == word.charAt(i)){
                        output = output + (j+1) + (k+1);
                        dodano = true;
                        break;
                    }
                }
            }
            if(word.charAt(i) == 'J' || word.charAt(i) == 'j'){
                output = output + "24";
                dodano = true;
            }

            if (!dodano){
                output = output + word.charAt(i);
            }
        }
        return output;
    }

    public String decryptWord(String word){
        String output = "";
        int tmp1,tmp2,i=0;
        for(; i+1<word.length(); i+=2){
            tmp1 = (int) word.charAt(i);
            tmp2 = (int) word.charAt(i + 1);
            if(tmp1 < 49 || tmp1 >53){
                output = output + word.charAt(i);
                i--;
            }
            else{
                output = output + tab[tmp1-49][tmp2-49];
            }
        }

        for(;i<word.length();i++) output = output + word.charAt(i);

        return output;
    }
}
