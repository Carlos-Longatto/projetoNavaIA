package com.fatec.view;

import com.fatec.poker.Classifier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class poker {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JComboBox comboBox9;
    private JComboBox comboBox10;
    private JTextField resultado;
    private JButton button1;
    private JPanel teste;

    public poker() {

        Classifier classifier = new Classifier();
        double[] cartas = new double[10];

        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                cartas[0] = comboBox1.getSelectedIndex() + 1;
                cartas[1] = comboBox6.getSelectedIndex() + 1;

                cartas[2] = comboBox2.getSelectedIndex() + 1;
                cartas[3] = comboBox7.getSelectedIndex() + 1;

                cartas[4] = comboBox3.getSelectedIndex() + 1;
                cartas[5] = comboBox8.getSelectedIndex() + 1;

                cartas[6] = comboBox4.getSelectedIndex() + 1;
                cartas[7] = comboBox9.getSelectedIndex() + 1;

                cartas[8] = comboBox5.getSelectedIndex() + 1;
                cartas[9] = comboBox10.getSelectedIndex() + 1;
                System.out.println(Arrays.toString(cartas));
                try {
                    switch (classifier.classify(cartas)) {
                        case "1":
                            resultado.setText("Resultado: um par de cartas dentro de 5 cartas");
                            break;
                        case "2":
                            resultado.setText("Resultado: dois pares de cartas dentro de 5 cartas");
                            break;
                        case "3":
                            resultado.setText("Resultado: tres cartas iguais dentro de 5 cartas");
                            break;
                        case "4":
                            resultado.setText("Resultado: Straight - 5 cartas sequenciais mas de naipes diferentes");
                            break;
                        case "5":
                            resultado.setText("Resultado: Flush - 5 cartas do mesmo naipe mas de diferentes valores");
                            break;
                        case "6":
                            resultado.setText("Resultado: Full House - um par + 3 crtas do mesmo naipe");
                            break;
                        case "7":
                            resultado.setText("Resultado: Quatro cartas de valores iguais dentro de 5 cartas");
                            break;
                        case "8":
                            resultado.setText("Resultado: Straight Flush");
                            break;
                        case "9":
                            resultado.setText("Resultado: Royal Flush");
                            break;
                    }
                    resultado.setForeground(Color.BLACK);
                } catch (Exception exception) {
                    resultado.setText("Não foi possível classificar");
                    resultado.setForeground(Color.RED);
                    System.out.println(exception.getLocalizedMessage());
                }
            }
        });
    }

    public JPanel getPokerPanel() {
        return teste;
    }
}
