package pl.polsl.zagorski.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import pl.polsl.zagorski.model.Derivative;
import pl.polsl.zagorski.controller.PolynominalController;
import pl.polsl.zagorski.model.MyException;
/**
 * The class responsible for displaying the graphical interface that allows the user to interact with the application.
 * @author Zagorski Wiktor
 */
public class DerativeGui {
    Derivative model = new Derivative();
    PolynominalController controller = new PolynominalController();;
    private JFrame frame;
    private JTextField inputField;
    private JTextArea outputArea;
    private JTable historyTable;
    private DefaultTableModel tableModel;
    private JScrollPane tableScrollPane;
    private JButton calculateButton;
    private JButton clearButton;
    private JPanel panel;
    /**
     * A method that invokes the necessary methods from the model to calculate the derivative. It is called upon pressing the calculate button.
     */
    private void calculatedButtonAction(){
        outputArea.setText("");
        String input = inputField.getText();  
        try {
            model.setCoefficients(controller.passInArguments(input));
            String result = model.answerBuilder();
            tableModel.addRow(new Object[]{input, result});
            outputArea.setText(result);
        } catch (MyException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Inside the constructor, there are definitions of all the components contained in the application.
     */
    public DerativeGui(){
        frame = new JFrame("Derivative Calculator");
        frame.setLayout(new GridLayout(3, 1));
        inputField = new JTextField(20);
        inputField.setToolTipText("Here type in coefficients");
        outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        outputArea.setToolTipText("Here answer will apear if you provide coefficients corectly and push calculate button.");
        
        calculateButton = new JButton("Calculate");
        calculateButton.setToolTipText("After pressing this button, the derivative of the polynomial will be calculated.  (ALT + C)");
        calculateButton.setMnemonic(KeyEvent.VK_C);
        clearButton = new JButton("Clear");
        clearButton.setToolTipText("After pressing this button, the input field for coefficients will be cleared. (ALT + L)");
        clearButton.setMnemonic(KeyEvent.VK_L);
        
        panel = new JPanel(new GridLayout(5, 1));
        panel.add(new JLabel("Provide the coefficients of the polynomial (separated by spaces): "));
        panel.add(inputField);
        panel.add(calculateButton);
        panel.add(clearButton);
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Input");
        tableModel.addColumn("Result");
        historyTable = new JTable(tableModel);
        tableScrollPane = new JScrollPane(historyTable);
        tableScrollPane.setToolTipText("In this table, the history of results will be contained.");
        Dimension preferredSize = new Dimension(400, 200);
        tableScrollPane.setPreferredSize(preferredSize);
        
        JPanel outputPanel = new JPanel(new GridLayout(1, 1));
        panel.add(new JLabel("Calculated derative:"));
        outputPanel.add(outputArea);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatedButtonAction();
            }
        });
        
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                outputArea.setText("");
            }
        });
        
        frame.add(panel);
        frame.add(outputPanel);
        frame.add(tableScrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
