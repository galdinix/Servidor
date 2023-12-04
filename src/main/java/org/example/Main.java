package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

import static spark.Spark.get;
import static spark.Spark.port;

public class Main {
    static int cont = 0;
    public static void main(String[] args) {
        port(8080);
        JFrame frame = new JFrame("calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,  400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        JTextField inputField1 = new JTextField();
        inputField1.setFont((new Font("Arial", Font.PLAIN, 30)));

        JTextField inputField2 = new JTextField();
        inputField2.setFont((new Font("Arial", Font.PLAIN, 30)));

        JLabel label1 = new JLabel("nome:");
        label1.setFont((new Font("Arial", Font.BOLD, 30)));

        JLabel label2 = new JLabel("acesso:");
        label2.setFont((new Font("Arial", Font.BOLD, 30)));

        JButton botao = new JButton("enviar");


        get("/nome/:p", (request, response) -> {
            cont++;
            String nome = request.params("p");
            inputField1.setText(nome);
            inputField2.setText(String.valueOf(cont));
            return "acesso: " + cont;
        });


        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });




        panel.add(label1);
        panel.add(inputField1);
        panel.add(label2);
        panel.add(inputField2);
        panel.add(botao);
        frame.add(panel);
        frame.setVisible(true);

    }
}