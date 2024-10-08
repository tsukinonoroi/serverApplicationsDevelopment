package org.example;

public class ThreadCooker2 extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (Main.lock) {
                    while (Main.pot > 0) {
                        Main.lock.wait(); // Ожидаем, пока кастрюля опустеет
                    }

                    // Повар наполняет кастрюлю
                    System.out.println("Повар наполняет кастрюлю.");
                    Main.pot = Main.potFull;
                    System.out.println("Кастрюля полная. Дикари могут есть.");
                    Main.lock.notifyAll(); // Уведомляем дикарей, что кастрюля полна
                }
                Thread.sleep(500); // Время на приготовление еды
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
