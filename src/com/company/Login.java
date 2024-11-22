package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JPanel Login;
    private JLabel labelHeader;
    private JLabel labelNama;
    private JTextField textNama;
    private JButton buttonLanjut;
    private JButton buttonExit;

    Login(){
        JFrame frame = new JFrame();
        frame.setContentPane(Login);
        frame.setTitle("PROGRAM PEMBELAJARAN FISIKA FLUIDA");
        frame.setSize(1200,720);
        frame.setLocation(100,25);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        labelHeader.setText("PROGRAM PEMBELAJARAN FISIKA FLUIDA");
        labelHeader.setFont(new Font("Gill Sans MT", 1, 25));
        labelHeader.setForeground(new Color(153, 51, 255));
        labelNama.setText("Silahkan Masukkan Nama!");
        labelNama.setFont(new Font("Times New Roman", 1, 20));
        labelNama.setForeground(new Color(153, 51, 255));
        textNama.setFont(new Font("Times New Roman", 1, 20));
        buttonLanjut.setText("Lanjut");
        buttonLanjut.setBackground(new Color(153, 51, 255));
        buttonLanjut.setForeground(Color.WHITE);
        buttonExit.setText("Exit");
        buttonExit.setBackground(new Color(153, 51, 255));
        buttonExit.setForeground(Color.WHITE);



        buttonLanjut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textNama.getText();
                if (nama == null || nama.trim().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Nama harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    frame.setVisible(false);
                    new Mainmenu(nama);
                }

            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }
}
