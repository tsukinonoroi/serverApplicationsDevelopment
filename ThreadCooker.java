package org.example;

class ThreadCooker extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (Main.lock) {
                    while (Main.pot > 0) {
                        Main.lock.wait();
                    }

                    System.out.println("Повар наполняет кастрюлю.");
                    Main.pot = Main.potFull;
                    System.out.println("Кастрюля полная. Дикари могут есть.");
                    Main.lock.notifyAll();

                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}