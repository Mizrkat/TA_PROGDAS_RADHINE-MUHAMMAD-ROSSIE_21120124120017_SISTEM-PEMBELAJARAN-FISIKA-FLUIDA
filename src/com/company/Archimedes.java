package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Archimedes {
    private JPanel Archimedes;
    private JLabel labelHeader;
    private JLabel labelGambar1;
    private JLabel labelDeskripsi;
    private JButton buttonBack;
    private JLabel labelGambar2;
    private JButton buttonExit;
    String nama;

    Archimedes(String nama){
        this.nama = nama;
        JFrame frame = new JFrame();
        frame.setContentPane(Archimedes);
        frame.setSize(1200,720);
        frame.setLocation(100,25);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        labelHeader.setText("Selamat datang " + nama + " halaman Hukum Archimedes");
        labelHeader.setFont(new Font("Gill Sans MT", 1, 30));
        labelHeader.setForeground(new Color(153, 51, 255));
        labelDeskripsi.setText("<html>Suatu benda yang dicelupkan ke dalam zat cair akan mendapat gaya angkat<br><br> yang sebanding dengan volume zat cair yang dipindahkan benda itu.<br><br>Sebuah benda yang dicelupkan sebagian atau seluruhnyua<br><br> akan mendapat gaya angkat oleh zat cair sebesar berat zat cair yang dipindahkan, hal ini merupakan bunyi dari hukum Archimedes.");
        labelDeskripsi.setFont(new Font("Times New Roman",1,20));
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
