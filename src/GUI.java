import javax.swing.*;
import java.awt.*;
import java.util.PriorityQueue;
import java.util.function.IntBinaryOperator;

public class GUI extends JFrame {

    private JPanel canvas;

    public GUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new JPanel(new GridBagLayout());

        var c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 5;
        c.weighty = 1;
        canvas.add(new JLabel("DISPLAY"), c);


        canvas.setBackground(Color.GRAY);

        var defaultSituation = new Situation(new JLabel()) ;

        /*
            7 8 9 /
            4 5 6 *
            1 2 3 -
            0 = C +
        */

        canvas.add(new DigitButton("7", defaultSituation));
        canvas.add(new DigitButton("8", defaultSituation));
        canvas.add(new DigitButton("9", defaultSituation));
        canvas.add(new BinOpButton("/", defaultSituation, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return 0;
            }
        }));

        canvas.add(new DigitButton("4", defaultSituation));
        canvas.add(new DigitButton("5", defaultSituation));
        canvas.add(new DigitButton("6", defaultSituation));
        canvas.add(new BinOpButton("*", defaultSituation, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return 0;
            }
        }));

        canvas.add(new DigitButton("1", defaultSituation));
        canvas.add(new DigitButton("2", defaultSituation));
        canvas.add(new DigitButton("3", defaultSituation));
        canvas.add(new DigitButton("-", defaultSituation));

        canvas.add(new DigitButton("0", defaultSituation));
        canvas.add(new EqualsButton("=", defaultSituation));
        canvas.add(new CancelButton("C", defaultSituation));
        canvas.add(new BinOpButton("+", defaultSituation, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return 0;
            }
        }));

        canvas.setPreferredSize(new Dimension(500, 500));
        getContentPane().add(canvas);

        pack();
        setVisible(true);
    }


}
