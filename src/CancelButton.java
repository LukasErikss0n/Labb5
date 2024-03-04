/**
 * @author Lukas Eriksson
 * @author Vincent Gustafsson
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.invoke.VarHandle;

public class CancelButton extends CalculatorButton{
    public CancelButton(String symbol, Situation situation) {
        super(symbol, situation);
    }

    @Override
    public void transition() {
        // The "C" transitions always goes back to state "Input1".
        //Clears the panel
        this.situation.display.setText("0");

        if (this.situation.binaryOperator != null)
            CalculatorButton.resetBtnBorder(this.situation.binaryOperator);
        //changes state
        this.situation.state = State.Input1;
    }


}
