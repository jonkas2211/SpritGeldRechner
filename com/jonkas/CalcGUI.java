package com.jonkas;
//SpritGeldRechner
//User: JonKAS
//Datum: 20.05.2016

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcGUI extends JFrame{
    private JTextField verbrauchTextField;
    private JTextField kmTextField;
    private JTextField spritPreisTextField;
    private JButton rechnenButton;
    private JPanel panel;
    private JLabel costLable;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Spritgeld-Rechner");
        frame.setContentPane(new CalcGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        //ToDo: beim exportieren wird Icon nicht angezeigt!
        try {
            java.net.URL path = CalcGUI.class.getResource("/car.png");
            Image icon = new ImageIcon(path).getImage();
            frame.setIconImage(icon);
        } catch (NullPointerException e) {}

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception e) {

        }
    }

    public CalcGUI() {

        rechnenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!verbrauchTextField.getText().equals("") && !spritPreisTextField.getText().equals("") && !kmTextField.getText().equals("")) {
                    double verbrauch = Double.parseDouble(verbrauchTextField.getText());
                    double km = Double.parseDouble(kmTextField.getText());
                    double spritPreis = Double.parseDouble(spritPreisTextField.getText());
                    double result = ((verbrauch / 100) * km) * spritPreis;
                    costLable.setText("" + round(result, 2) + "€");
                }
            }
        });
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
