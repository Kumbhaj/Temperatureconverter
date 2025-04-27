import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame implements ActionListener {
    private JTextField tempInputField;
    private JComboBox<String> unitSelector;
    private JLabel resultLabel;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        panel.add(new JLabel("Enter Temperature:"));
        tempInputField = new JTextField();
        panel.add(tempInputField);

        unitSelector = new JComboBox<>(new String[]{"Celsius to Fahrenheit", "Fahrenheit to Celsius"});
        panel.add(unitSelector);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        panel.add(convertButton);

        resultLabel = new JLabel("Result: ");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(panel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double inputTemp = Double.parseDouble(tempInputField.getText());
            String selectedConversion = (String) unitSelector.getSelectedItem();

            double result;
            String unit;
            if ("Celsius to Fahrenheit".equals(selectedConversion)) {
                result = (inputTemp * 9 / 5) + 32;
                unit = "°F";
            } else {
                result = (inputTemp - 32) * 5 / 9;
                unit = "°C";
            }

            resultLabel.setText(String.format("Result: %.2f %s", result, unit));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperatureConverter converter = new TemperatureConverter();
            converter.setVisible(true);
        });
    }
}
