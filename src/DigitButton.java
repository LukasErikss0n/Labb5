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
                this.situation.display.setText(currentInfo + symbol);

                break;

            case OpReady:
                this.situation.display.setText("");
                this.situation.state = State.Input2;
                this.transition();
                break;
        }
    }


}
