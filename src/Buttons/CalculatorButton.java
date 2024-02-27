package Buttons;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class CalculatorButton extends JButton implements ActionListener {

    public CalculatorButton(String symbol,  Situation situation){

    }

    public abstract void transition();
}
