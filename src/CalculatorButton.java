import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class CalculatorButton extends JButton implements ActionListener {

    protected Situation situation;
    public CalculatorButton(String symbol,  Situation situation){
        super(symbol);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(50, 50));
        this.situation = situation;
        addActionListener(this);
    }


    public abstract void transition();

    @Override
    public void actionPerformed(ActionEvent e) {
        transition();
    }
}
