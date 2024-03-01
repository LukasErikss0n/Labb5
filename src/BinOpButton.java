import javax.swing.*;
import java.awt.*;
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
        switch (this.situation.state) {
            case Input1: case HasResult:
                this.situation.leftOperand = Integer.parseInt(this.situation.display.getText());
                this.situation.binaryOperator = this;
                this.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
                break;

            case OpReady:
                this.situation.binaryOperator = this;
                this.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
                this.setBackground(Color.LIGHT_GRAY);
                break;
                
            default:
                break;
        }
    }


}
