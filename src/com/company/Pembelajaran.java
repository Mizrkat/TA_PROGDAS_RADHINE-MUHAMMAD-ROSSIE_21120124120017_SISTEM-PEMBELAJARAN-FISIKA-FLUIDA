package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pembelajaran {
    private JPanel Pembelajaran;
    private JButton buttonTekanan;
    private JButton buttonPascal;
    private JButton buttonArchimedes;
    private JLabel labelHeader;
    private JLabel labelDeskripsi;
    private JButton buttonBack;
    private JButton buttonExit;
    String nama;

    Pembelajaran(String nama){
        this.nama = nama;
        JFrame frame = new JFrame();
        frame.setContentPane(Pembelajaran);
        frame.setSize(1200,720);
        frame.setLocation(100,25);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        labelHeader.setText("PROGRAM PEMBELAJARAN FISIKA FLUIDA");
        labelHeader.setFont(new Font("Gill Sans MT", 1, 50));
        labelHeader.setForeground(new Color(153, 51, 255));
        labelDeskripsi.setText("Silahkan pilih materi");
        labelDeskripsi.setFont(new Font("Times New Roman",1,35));
        labelDeskripsi.setForeground(new Color(153, 51, 255));
        buttonArchimedes.setText("Hukum Archimedes");
        buttonArchimedes.setFont(new Font("Times New Roman",1,20));
        buttonArchimedes.setBackground(new Color(153, 51, 255));
        buttonArchimedes.setForeground(Color.WHITE);
        buttonTekanan.setText("Tekanan Zat Cair");
        buttonTekanan.setFont(new Font("Times New Roman",1,20));
        buttonTekanan.setBackground(new Color(153, 51, 255));
        buttonTekanan.setForeground(Color.WHITE);
        buttonPascal.setText("Hukum Pascal");
        buttonPascal.setFont(new Font("Times New Roman",1,20));
        buttonPascal.setBackground(new Color(153, 51, 255));
        buttonPascal.setForeground(Color.WHITE);
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
                new Mainmenu(nama);
            }
        });
        buttonTekanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Tekanan(nama);
            }
        });
        buttonPascal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Pascal(nama);
            }
        });
        buttonArchimedes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Archimedes(nama);
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
