/**
 * @author Lukas Eriksson
 * @author Vincent Gustafsson
 */
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
                CalculatorButton.highlightBtnBorder(this);
                this.situation.state = State.OpReady;
                break;

            case OpReady:
                CalculatorButton.resetBtnBorder(this.situation.binaryOperator);

                this.situation.binaryOperator = this;
                CalculatorButton.highlightBtnBorder(this);

                this.situation.state = State.OpReady;
                break;

            case Input2:
                break;

            default:
                break;
        }
    }


}
