package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tekanan {
    private JPanel Tekanan;
    private JLabel labelHeader;
    private JLabel labelGambar1;
    private JButton buttonBack;
    private JLabel labelDeskripsi;
    private JLabel labelGambar2;
    private JButton buttonExit;
    String nama;

    Tekanan(String nama){
        this.nama = nama;
        JFrame frame = new JFrame();
        frame.setContentPane(Tekanan);
        frame.setSize(1200,720);
        frame.setLocation(100,25);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        labelHeader.setText("Selamat datang " + nama + " halaman Tekanan");
        labelHeader.setFont(new Font("Gill Sans MT", 1, 40));
        labelHeader.setForeground(new Color(153, 51, 255));
        labelDeskripsi.setText("<html>Suatu benda yang mengalami tekanan yang sama pada bidang A maka persamaannya P=F/A<br><br>Tekanan pada suatu zat cair dipengaruhi oleh Gravitasi, Massa jenis Air, dan ketinggian atau kedalaman.");
        labelDeskripsi.setFont(new Font("Times New Roman",1,25));
        labelGambar1.setVisible(true);
        labelGambar2.setVisible(true);
        buttonBack.setText("Back");
        buttonBack.setFont(new Font("Times New Roman",1,20));
        buttonBack.setBackground(new Color(153, 51, 255));
        buttonBack.setForeground(Color.WHITE);
        buttonExit.setText("Exit");
        buttonExit.setFont(new Font("Times New Roman",1,20));
        buttonExit.setBackground(new Color(153, 51, 255));
        buttonExit.setForeground(Color.WHITE);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Pembelajaran(nama);
            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
