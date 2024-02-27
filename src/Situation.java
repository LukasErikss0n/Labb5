import javax.swing.*;

public class Situation extends JLabel {
    State state = State.Input1;
    JLabel display;
    BinOpButton binaryOperator;
    int leftOperand;
    Situation(JLabel display){
        this.display = display;
    }
}
