import Buttons.BinOpButton;

public class Situation {
    State state = State.Input1;
    JLabel display;
    BinOpButton binaryOperator;
    int leftOperand;
    Situation(JLabel display){
        this.display = display;
    }
}
