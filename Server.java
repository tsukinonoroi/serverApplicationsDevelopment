package org.example;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Server {
    private static final int TCP_PORT = 5000;
    private static final String UDP_GROUP = "233.0.0.1";
    private static final int UDP_PORT = 1502;

    private static List<String> messageQueue = new ArrayList<>();
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(Server::startTcpServer).start();
        new Thread(Server::startUdpBroadcaster).start();
    }

    private static void startTcpServer() {
        try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {
            System.out.println("TCP сервер запущен на порту " + TCP_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String message;
            while ((message = in.readLine()) != null) {
                lock.lock();
                try {
                    messageQueue.add(message);
                } finally {
                    lock.unlock();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startUdpBroadcaster() {
        try {
            InetAddress group = InetAddress.getByName(UDP_GROUP);
            DatagramSocket udpSocket = new DatagramSocket();

            while (true) {
                Thread.sleep(10000);

                lock.lock();
                try {
                    if (!messageQueue.isEmpty()) {
                        String messagesToSend = String.join("\n", messageQueue);
                        byte[] buffer = messagesToSend.getBytes();

                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, UDP_PORT);
                        udpSocket.send(packet);
                        messageQueue.clear();

                        System.out.println("Сообщения отправлены через UDP");
                    }
                } finally {
                    lock.unlock();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
