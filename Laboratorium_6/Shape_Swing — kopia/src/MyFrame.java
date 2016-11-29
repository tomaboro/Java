import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Tomek on 27.11.2016.
 */
public class MyFrame extends JFrame {

    public MyFrame(LinkedList<Shape> lista) {
        super("Shape");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,400);
        setResizable(false);
        setLocation(0,0);
        setLayout(new BorderLayout());

        JPanel panel = new MyPanel(lista);
        add(panel);

        JScrollPane jScrollPane2 = new javax.swing.JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(jScrollPane2);

        setVisible(true);
    }
}
