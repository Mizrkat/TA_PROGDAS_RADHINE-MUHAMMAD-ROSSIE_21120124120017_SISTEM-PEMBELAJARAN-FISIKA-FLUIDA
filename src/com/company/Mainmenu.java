package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainmenu {
    private JPanel Mainmenu;
    private JLabel labelHeader;
    private JLabel labelInstruksi;
    private JButton buttonPembelajaran;
    private JButton buttonQuiz;
    private JButton buttonBack;
    String nama;
    Mainmenu(String nama){
        JFrame frame = new JFrame();
        this.nama = nama;
        frame.setContentPane(Mainmenu);
        frame.setSize(900,720);
        frame.setLocation(100,25);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        labelHeader.setText("Selamat datang " + nama + " ke dalam Program!");
        labelHeader.setFont(new Font("Gill Sans MT", Font.BOLD, 24));
        labelHeader.setForeground(new Color(153, 51, 255));
        labelInstruksi.setText("Silahkan pilih antara Pembelajaran atau Quiz");
        labelInstruksi.setFont(new Font("Times New Roman", 1, 20));
        labelInstruksi.setForeground(new Color(153, 51, 255));
        buttonPembelajaran.setText("Pembelajaran");
        buttonPembelajaran.setBackground(new Color(153, 51, 255));
        buttonPembelajaran.setForeground(Color.WHITE);
        buttonQuiz.setText("Quiz");
        buttonQuiz.setBackground(new Color(153, 51, 255));
        buttonQuiz.setForeground(Color.WHITE);
        buttonBack.setText("Back");
        buttonBack.setBackground(new Color(153, 51, 255));
        buttonBack.setForeground(Color.WHITE);

        buttonPembelajaran.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Pembelajaran(nama);
            }
        });
        buttonQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Quiz(nama);
            }
        });
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Login();
            }
        });
    }

    public static void main(String[] args) {
        new Mainmenu("Pengguna");
    }
}
