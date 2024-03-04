/**
 * @author Lukas Eriksson
 * @author Vincent Gustafsson
 */
import javax.swing.*;
import java.awt.*;
import java.util.function.IntBinaryOperator;

public class GUI extends JFrame {
    private JPanel canvas;
    private Situation situation;

    // The grid of buttons represented as a 2d-array where the elements are the symbols.
    // Enforces the layout "programmatically" and shows clearly what the intended GUI is.
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
        // Right-aligned JLabel, starting with "0" (like most calculators do)
        JLabel display = new JLabel("0", JLabel.RIGHT);

        display.setPreferredSize(new Dimension(300, 40));
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        display.setBackground(Color.LIGHT_GRAY);
        // The MOST readable font, comic sans <3
        display.setFont(new Font("Comic Sans MS", Font.BOLD, 24));

        return display;
    }

    private JPanel createButtonPanel() {
        // Grid layout (4x4) with 10px gaps between elements.
        // Empty / "invisible" border for the margin.
        var gridLayout = new GridLayout(4, 4);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        JPanel btnPanel = new JPanel(gridLayout);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnPanel.setBackground(Color.LIGHT_GRAY);

        // Nested for loop that loops through the "btnSymbols" 2d-array.
        // The array includes the text (symbol) that the button is supposed to have.
        for (String[] row: GUI.btnSymbols) {
            for (String sym: row) {
                switch (sym) {
                    case ("C"):
                        btnPanel.add(new CancelButton("C", this.situation));
                        break;

                    case ("="):
                        btnPanel.add(new EqualsButton("=", this.situation));
                        break;

                    case ("/"): case ("*"):
                    case ("-"): case ("+"):
                        // Switch expression that creates a lambda with the operation.
                        IntBinaryOperator operation = switch (sym) {
                            case "*" -> (l, r) -> l * r;
                            case "/" -> (l, r) -> l / r;
                            case "+" -> (l, r) -> l + r;
                            case "-" -> (l, r) -> l - r;
                            // Unreachable
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