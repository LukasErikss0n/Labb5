/**
 * @author Lukas Eriksson
 * @author Vincent Gustafsson
 */
import java.awt.*;
import java.awt.event.ActionEvent;

public class DigitButton extends CalculatorButton{

    private String symbol;
    public DigitButton(String symbol, Situation situation) {
        super(symbol, situation);
        this.symbol = symbol;
        this.situation = situation;
    }

    @Override
    public void transition() {
        switch (this.situation.state) {
            case Input1: case Input2:
                String currentInfo = this.situation.display.getText();
                if("0".equals(currentInfo)){
                    this.situation.display.setText(symbol);
                    return;
                }
                this.situation.display.setText(currentInfo + symbol); //Adds symbol to the display

                break;

            case HasResult:
                //If you have gotten the result and press symbol it replaces result
                this.situation.display.setText(symbol);
                this.situation.state = State.Input1;
                break;

            case OpReady:
                //Clears display and changes state and calls on transition() to execute case when Input2
                this.situation.display.setText("");
                this.situation.state = State.Input2;
                this.transition();
                break;
        }
    }


}
