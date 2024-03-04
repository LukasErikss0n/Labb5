import java.awt.event.ActionEvent;

public class EqualsButton extends CalculatorButton{
    public EqualsButton(String symbol, Situation situation) {
        super(symbol, situation);
    }

    @Override
    public void transition() {
        switch (this.situation.state) {
            case Input2:
                int input2 = Integer.parseInt(this.situation.display.getText());
                // this.situation.binaryOperator.getBinOperation().applyAsInt()
                break;

            case OpReady:
                break;
        }
    }


}
