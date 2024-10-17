package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int TCP_PORT = 5000;
    private static final String UDP_GROUP = "233.0.0.1";
    private static final int UDP_PORT = 1502;

    private Socket tcpSocket;
    private PrintWriter tcpOut;
    private JTextArea messagesArea;
    private JTextField inputField;
    private InetAddress localAddress;

    public Client() {
        setupUI();
        setupTCPConnection();
        startUDPListener();
    }

    private void setupUI() {
        JFrame frame = new JFrame("Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        messagesArea = new JTextArea();
        messagesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messagesArea);

        inputField = new JTextField();
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener((ActionEvent e) -> {
            String message = inputField.getText();
            if (!message.isEmpty()) {
                sendMessage(message);
                inputField.setText("");
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void setupTCPConnection() {
        try {
            tcpSocket = new Socket(SERVER_IP, TCP_PORT);
            tcpOut = new PrintWriter(tcpSocket.getOutputStream(), true);
            localAddress = tcpSocket.getLocalAddress();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        if (tcpOut != null) {
            tcpOut.println(message);
        }
    }

    private void startUDPListener() {
        new Thread(() -> {
            try (MulticastSocket udpSocket = new MulticastSocket(UDP_PORT)) {
                InetAddress group = InetAddress.getByName(UDP_GROUP);
                udpSocket.joinGroup(group);

                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                while (true) {
                    udpSocket.receive(packet);
                    if (!packet.getAddress().equals(localAddress)) {
                        String receivedMessage = new String(packet.getData(), 0, packet.getLength());
                        displayMessage(receivedMessage);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void displayMessage(String message) {
        SwingUtilities.invokeLater(() -> messagesArea.append(message + "\n"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Client::new);
    }
}
