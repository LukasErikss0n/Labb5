import java.awt.event.ActionEvent;
import java.util.function.IntBinaryOperator;

public class BinOpButton extends CalculatorButton {
    private IntBinaryOperator intBinaryOperator;
    public BinOpButton(String symbol, Situation situation, IntBinaryOperator intBinaryOperator) {
        super(symbol, situation);
        this.intBinaryOperator = intBinaryOperator;

    }

    @Override
    public void transition() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
