import java.awt.EventQueue;
/**
 * Created by Tomek on 27.11.2016.
 */
public class Test {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();
            }
        });
    }
}