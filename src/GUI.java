import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.PriorityQueue;
import java.util.function.IntBinaryOperator;

public class GUI extends JFrame {
    private JPanel canvas;
    private Situation situation;

    static private String[][] btnSymbols = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", "=", "C", "+"},
    };

    public GUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel display = this.createDisplay();

        this.situation = new Situation(display);
        JPanel btnPanel = this.createButtonPanel();

        canvas = new JPanel(new BorderLayout());
        canvas.add(display, BorderLayout.PAGE_START);
        canvas.add(btnPanel, BorderLayout.CENTER);

        this.getContentPane().add(canvas);

        pack();
        setVisible(true);

    }

    private JLabel createDisplay() {
        JLabel display = new JLabel("", JLabel.RIGHT);
        display.setPreferredSize(new Dimension(300, 40));
        return display;
    }

    private JPanel createButtonPanel() {
        JPanel btnPanel = new JPanel(new GridLayout(4, 4));
        for (String[] row: GUI.btnSymbols) {
            for (var sym: row) {
                switch (sym) {
                    case ("C"):
                        btnPanel.add(new CancelButton("C", this.situation));
                        break;

                    case ("="):
                        btnPanel.add(new EqualsButton("=", this.situation));
                        break;

                    case ("/"): case ("*"):
                    case ("-"): case ("+"):
                        IntBinaryOperator operation = switch (sym) {
                            case "*" -> (l, r) -> l * r;
                            case "/" -> (l, r) -> l / r;
                            case "+" -> (l, r) -> l + r;
                            case "-" -> (l, r) -> l - r;
                            default -> throw new IllegalStateException("Unexpected value: " + sym);
                        };

                        btnPanel.add(new BinOpButton(sym, this.situation, operation));
                        break;

                    case("0"): case ("1"): case ("2"): case ("3"):
                    case ("4"): case ("5"): case ("6"):
                    case ("7"): case ("8"): case ("9"):
                        btnPanel.add(new DigitButton(sym, this.situation));
                        break;
                }
            }
        }

        return btnPanel;
    }
}