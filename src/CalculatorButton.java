/**
 * @author Lukas Eriksson
 * @author Vincent Gustafsson
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class CalculatorButton extends JButton implements ActionListener {

    protected Situation situation;
    protected String symbol;
    public CalculatorButton(String symbol,  Situation situation){
        super(symbol); //calls the Jbutton constructor
        this.setPreferredSize(new Dimension(50, 50));

        this.setBackground(Color.WHITE);
        this.setFont(new Font("Comic Sans MS", Font.BOLD, 22));

        this.situation = situation;
        this.addActionListener(this);
    }


    public abstract void transition();

    @Override
    public void actionPerformed(ActionEvent e) {
        transition();
    }
    //HiglightsBorder
    public static void highlightBtnBorder(CalculatorButton btn) {
        btn.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
    }
    //resetsborder
    public static void resetBtnBorder(CalculatorButton btn) {
        btn.setBorder(UIManager.getBorder("Button.border"));
    }
}
