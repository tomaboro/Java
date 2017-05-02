import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(Pole p) {
        super("Rysowanie");
        setResizable(false);
        setPreferredSize(new Dimension(650,680));
        JPanel panel = new Rysuj(p);
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
