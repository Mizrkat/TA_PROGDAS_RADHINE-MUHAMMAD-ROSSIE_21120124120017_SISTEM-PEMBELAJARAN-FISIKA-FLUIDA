package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pascal {
    private JPanel Pascal;
    private JLabel labelHeader;
    private JLabel labelGIF;
    private JLabel labelGambar;
    private JLabel labelDeskripsi;
    private JButton buttonBack;
    private JButton buttonExit;
    String nama;

    Pascal(String nama){
        this.nama = nama;
        JFrame frame = new JFrame();
        frame.setContentPane(Pascal);
        frame.setSize(1200,720);
        frame.setLocation(100,25);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        labelHeader.setText("Selamat datang " + nama + " halaman Pascal");
        labelHeader.setFont(new Font("Gill Sans MT", 1, 40));
        labelHeader.setForeground(new Color(153, 51, 255));
        labelDeskripsi.setText("<html>Tekanan yang diberikan pada zat cair dalam ruang tertutup akan diteruskan kesegala arah dengan sama besar<br><br>ini adalah prinsip dari hukum Pascal. Dalam penerapan kehidupan sehari-hari salah satunya yaitu mesin pengangkat mobil hidraulik<html>");
        labelDeskripsi.setFont(new Font("Times New Roman",1,20));
        labelGIF.setVisible(true);
        labelGambar.setVisible(true);
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
