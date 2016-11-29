import javax.swing.*;
import java.awt.*;

/**
 * Created by Tomek on 27.11.2016.
 */
public class MyFrame extends JFrame {

    public MyFrame() {
        super("Shape");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(250,960);
        setLocation(0,0);
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

        JScrollBar vbar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 300);
        JPanel panel = new MyPanel();

        //panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));

        add(panel);
    }
}
