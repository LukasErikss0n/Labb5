import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private JPanel canvas;


    protected void makebutton(String name, JPanel canvas, GridBagConstraints c) {
        JButton button = new JButton(name);
        canvas.add(button, c);
    }
    public GUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        canvas = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        makebutton("Button1", canvas, constraints);
        makebutton("Button2", canvas, constraints);
        makebutton("Button3", canvas, constraints);

        constraints.gridwidth = GridBagConstraints.REMAINDER;
        makebutton("Button3", canvas, constraints);



        add(canvas);
        JLabel display = new JLabel("Display");
        display.setFont(new Font("Arial", Font.BOLD, 60));







        pack();
        setVisible(true);
    }


}
