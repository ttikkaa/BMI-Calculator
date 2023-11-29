/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author axioo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BMICalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BMICalculator::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel weightLabel = new JLabel("Berat Badan (kg):");
        JTextField weightText = new JTextField(20);

        JLabel heightLabel = new JLabel("Tinggi Badan (cm):");
        JTextField heightText = new JTextField(20);

        JButton calculateButton = new JButton("Hitung BMI");

        JLabel resultLabel = new JLabel("BMI Anda: ");
        JLabel categoryLabel = new JLabel("Kategori BMI: ");

        // Grouping related components in a separate method for clarity
        addComponents(panel, weightLabel, weightText, heightLabel, heightText, calculateButton, resultLabel, categoryLabel);

        calculateButton.addActionListener((ActionEvent e) -> {
            try {
                float weight = Float.parseFloat(weightText.getText());
                float height = Float.parseFloat(heightText.getText());

                if (weight <= 0 || height <= 0) {
                    throw new NumberFormatException();
                }

                float bmi = calculateBMI(weight, height);
                resultLabel.setText("BMI Anda: " + bmi);
                categoryLabel.setText("Kategori BMI: " + interpretBMI(bmi));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Masukkan berat dan tinggi yang valid (harus lebih dari 0).");
                categoryLabel.setText("Kategori BMI: ");
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    // Grouping related components for better readability
    private static void addComponents(JPanel panel, JComponent... components) {
        for (JComponent component : components) {
            panel.add(component);
        }
    }

    private static float calculateBMI(float weight, float height) {
        // Multiplication by 100 for cm to m conversion
        return (100 * 100 * weight) / (height * height);
    }

    private static String interpretBMI(float bmi) {
        if (bmi < 18.5) {
            return "Kekurangan berat badan";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Kelebihan berat badan";
        } else {
            return "Obesitas";
        }
    }
}