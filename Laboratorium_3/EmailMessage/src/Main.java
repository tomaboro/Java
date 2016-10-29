import java.util.LinkedList;

/**
 * Created by Tomek on 2016-10-25.
 */
public class Main {
    public static void main(String[] args){
        /*LinkedList<String> to = new LinkedList<String>();
        to.add("tborowicz@vp.pl");
        to.add("lojgap@op.pl");*/
        try {
            EmailMessage wiadomosc = new EmailMessage.Builder()
                    .addFrom("funnymotek@gmail.com")
                    .addTo("sbobek@agh.edu.pl")
                    .addSubject("Mail na zadanie")
                    .addContent("111")
                    .build();

            wiadomosc.send();
        }
        catch(IllegalStateException e){ System.out.println(e); }
    }
}
