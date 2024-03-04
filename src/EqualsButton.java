/**
 * @author Lukas Eriksson
 * @author Vincent Gustafsson
 */
import java.awt.event.ActionEvent;
import java.io.Console;

public class EqualsButton extends CalculatorButton {
    public EqualsButton(String symbol, Situation situation) {
        super(symbol, situation);
    }

    @Override
    public void transition() {
        switch (this.situation.state) {
            case Input2:
                int input2 = Integer.parseInt(this.situation.display.getText()); //grabbs the second Input

                try {
                    int result = this.situation.binaryOperator //Executes calculation
                            .getBinOperation()
                            .applyAsInt(this.situation.leftOperand, input2);

                    this.situation.display.setText(String.valueOf(result));
                    CalculatorButton.resetBtnBorder(this.situation.binaryOperator); //removes border around BinOp

                    this.situation.state = State.HasResult;
                    break;

                } catch (ArithmeticException e) {
                    this.situation.display.setText("undefined");
                }

            case OpReady:
                break;
        }
    }


}
