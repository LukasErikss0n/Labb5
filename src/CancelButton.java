import javax.swing.*;
import java.awt.event.ActionEvent;

public class CancelButton extends CalculatorButton{
    public CancelButton(String symbol, Situation situation) {
        super(symbol, situation);
    }

    @Override
    public void transition() {
        // The "C" transitions always goes back to state "Input1".
        this.situation.display.setText("0");
        this.situation.binaryOperator.setBorder(UIManager.getBorder("Button.border"));

        this.situation.state = State.Input1;
    }


}
