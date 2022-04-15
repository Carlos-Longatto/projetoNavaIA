package com.fatec;

import com.fatec.view.poker;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {
        JFrame empregadoFrame = new JFrame();
        empregadoFrame.setContentPane(new poker().getPokerPanel());
        empregadoFrame.setSize(700, 700);
        empregadoFrame.setLocationRelativeTo(null);
        empregadoFrame.setTitle("POKER");
        empregadoFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        empregadoFrame.setVisible(true);
    }
}