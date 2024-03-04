import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.IntBinaryOperator;

public class BinOpButton extends CalculatorButton {
    private IntBinaryOperator binOperation;
    public BinOpButton(String symbol, Situation situation, IntBinaryOperator intBinaryOperator) {
        super(symbol, situation);
        this.binOperation = intBinaryOperator;

    }

    public IntBinaryOperator getBinOperation() { return this.binOperation; }

    @Override
    public void transition() {
        switch (this.situation.state) {
            case Input1: case HasResult:
                this.situation.leftOperand = Integer.parseInt(this.situation.display.getText());

                this.situation.binaryOperator = this;
                this.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
                this.situation.state = State.OpReady;
                break;

            case OpReady:
                this.situation.binaryOperator.setBorder(UIManager.getBorder("Button.border"));
                this.situation.binaryOperator = this;
                this.setBorder(BorderFactory.createLineBorder(Color.RED, 4));

                this.situation.state = State.Input2;
                break;

            case Input2:
                break;

            default:
                break;
        }
    }


}
