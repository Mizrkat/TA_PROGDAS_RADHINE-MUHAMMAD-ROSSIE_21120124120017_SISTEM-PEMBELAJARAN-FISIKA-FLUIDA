package com.company;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Skor extends JFrame{
    private JPanel Skor;
    private JButton buttonKembali;
    private JButton buttonExit;
    private JLabel labelSkor;

    Skor(String nama, int skor, int totalPertanyaan){
        setContentPane(Skor);
        setSize(900,720);
        setLocation(100,25);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        labelSkor.setText(nama + " Mendapatkan skor: " + skor + " dari " + totalPertanyaan + " pertanyaan");
        labelSkor.setFont(new Font("Gill Sans MT", 1, 25));
        labelSkor.setForeground(new Color(153, 51, 255));

        buttonKembali.setText("Kembali ke Main Menu");
        buttonKembali.setBackground(new Color(153, 51, 255));
        buttonKembali.setForeground(Color.WHITE);

        buttonExit.setText("Exit Program");
        buttonExit.setBackground(new Color(153, 51, 255));
        buttonExit.setForeground(Color.WHITE);
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
        buttonKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Mainmenu(nama);
            }
        });
    }

}
