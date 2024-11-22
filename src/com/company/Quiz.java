package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class Quiz {
    private JPanel Quiz;
    private JLabel labelPertanyaan;
    private JButton buttonNext;
    private JButton buttonSkor;
    private JButton buttonMulai;
    private JTextField textJawab;
    private JLabel labelTimer;
    private JLabel labelPetunjuk;
    private final Queue<String> Pertanyaan;
    private final Queue<String> Jawaban;
    private int skor = 0;
    private final int totalPertanyaan;
    private Timer timer;
    private final int waktuPerSoal = 30;
    private int waktuTersisa;
    String nama;

    Quiz(String nama) {
        Pertanyaan = new LinkedList<>();
        Jawaban = new LinkedList<>();

        JFrame frame = new JFrame();
        this.nama = nama;
        frame.setContentPane(Quiz);
        frame.setSize(900, 480);
        frame.setLocation(100, 25);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        labelPetunjuk.setText("<html>Selamat datang " + nama + " ke dalam quiz.<br><br> Jika Anda siap, silakan tekan tombol mulai<html>");
        labelPetunjuk.setFont(new Font("Gill Sans MT", Font.BOLD, 25));
        labelPetunjuk.setForeground(new Color(153, 51, 255));

        labelTimer.setText("Waktu: 30 detik");
        labelTimer.setFont(new Font("Tahoma", Font.BOLD, 25));
        labelTimer.setForeground(Color.RED);
        labelTimer.setVisible(false);

        labelPertanyaan.setFont(new Font("Times New Roman", 1, 20));
        labelPertanyaan.setVisible(false);

        addPertanyaan("<html>Alex menyelam di kedalaman 150 cm di bawah permukaan air laut.<br><br> Jika massa jenis air 1,03 gr/cm3, tekanan hidrostatis yang dirasakan oleh Abel adalah...<html>", "15,45");
        addPertanyaan("<html>Tekanan pada zat cair terpengaruhi oleh kedalaman, massa jenis cairan<br><br> dan...<html> ", "gravitasi");
        addPertanyaan("<html>Pada suatu percobaan, Pak Budi memasukkan tabung secara vertikal ke dalam air,<br><br>sehingga dihasilkan sudut kontak 60 derajat. Akibatnya, terjadi kenaikan air pada tabung setinggi 4 cm.<br><br>Jika jari-jari tabung 0,1 cm dan massa jenis air 1.000 kg/m3, tegangan permukaan yang dialami oleh air adalah...<html>","0,4");
        totalPertanyaan = Pertanyaan.size();

        buttonSkor.setText("Skor");
        buttonSkor.setBackground(new Color(153, 51, 255));
        buttonSkor.setForeground(Color.WHITE);
        buttonSkor.setEnabled(false);
        buttonSkor.setVisible(false);

        buttonMulai.setText("Mulai");
        buttonMulai.setVisible(true);
        buttonMulai.setBackground(new Color(153, 51, 255));
        buttonMulai.setForeground(Color.WHITE);

        buttonNext.setText("Lanjut");
        buttonNext.setBackground(new Color(153, 51, 255));
        buttonNext.setForeground(Color.WHITE);
        buttonNext.setVisible(false);
        buttonNext.setEnabled(false);

        textJawab.setFont(new Font("Times New Roman", Font.BOLD, 20));
        textJawab.setVisible(false);

        buttonMulai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setSize(1200,720);
                buttonMulai.setEnabled(false);
                buttonMulai.setVisible(false);
                buttonNext.setVisible(true);
                buttonNext.setEnabled(true);
                textJawab.setVisible(true);
                labelTimer.setVisible(true);
                labelPertanyaan.setVisible(true);
                labelPetunjuk.setText("");
                loadPertanyaanberikutnya();
            }
        });

        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer != null) {
                    timer.stop();
                }
                periksaJawaban();
                loadPertanyaanberikutnya();
            }
        });

        buttonSkor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.setVisible(false);
               new Skor(nama, skor, totalPertanyaan);
            }
        });

    }

    private void addPertanyaan(String pertanyaan, String jawaban) {
        Pertanyaan.add(pertanyaan);
        Jawaban.add(jawaban);
    }

    private void loadPertanyaanberikutnya() {
        if (!Pertanyaan.isEmpty()) {
            String pertanyaanBerikutnya = Pertanyaan.poll();
            labelPertanyaan.setText(pertanyaanBerikutnya);
            textJawab.setText("");
            waktuTersisa = waktuPerSoal;
            mulaiTimer();
        } else {
            labelPetunjuk.setText("Quiz selesai!");
            labelPertanyaan.setVisible(false);
            labelTimer.setVisible(false);
            textJawab.setEnabled(false);
            textJawab.setVisible(false);
            buttonNext.setEnabled(false);
            buttonNext.setVisible(false);
            buttonSkor.setVisible(true);
            buttonSkor.setEnabled(true);
        }
    }

    private void periksaJawaban() {
        String jawabanUser = textJawab.getText().trim().toLowerCase();
        if (!jawabanUser.isEmpty()) {
            String jawabanBenar = Jawaban.poll();
            if (jawabanUser.equals(jawabanBenar)) {
                skor++;
                JOptionPane.showMessageDialog(null, "Jawaban benar!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Jawaban salah! Jawaban benar: " + jawabanBenar, "Info", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Harap masukkan jawaban!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mulaiTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                waktuTersisa--;
                labelTimer.setText("Waktu: " + waktuTersisa + " detik");

                if (waktuTersisa <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Waktu habis untuk soal ini!", "Info", JOptionPane.WARNING_MESSAGE);
                    loadPertanyaanberikutnya();
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new Quiz("Pengguna");
    }
}
